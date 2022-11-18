/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.auth;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;
    

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //scope: permisos del cliente
        clients.inMemory().withClient("angular")
                .secret(passwordEncoder.encode("12345"))
                .scopes("read","write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600);
        // tiempo de validez que dura el token
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //Se genera el token y despues se valida
        security.tokenKeyAccess("permiteAll()")
        .checkTokenAccess("isAuthenticated()");
    }

   @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter()));
        endpoints.authenticationManager(authenticationManager)
        .accessTokenConverter(accessTokenConverter())
        .tokenEnhancer(tokenEnhancerChain);
    }
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();        
        return jwtAccessTokenConverter;
    }
    
    
}
