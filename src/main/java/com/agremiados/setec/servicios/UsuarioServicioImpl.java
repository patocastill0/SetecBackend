/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Usuariodao;
import com.agremiados.setec.dto.UsuarioDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Usuario;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServicioImpl implements UserDetailsService, Crud<UsuarioDTO> {
    
    private Logger loger = LoggerFactory.getLogger(UsuarioServicioImpl.class);
    
    @Autowired
    private Usuariodao usuariodao;
   
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Usuario usuario = usuariodao.findByUserName(username);
        if(usuario==null){
        loger.error("Error de login: usuario "+ username + " no existe");
        throw new UsernameNotFoundException("Error de login: usuario "+ username + " no existe");
        }
        //Stream recibe flujos de datos
        List<GrantedAuthority> authorities = usuario.getRolesList()
                .stream()
                .map(role-> new SimpleGrantedAuthority(role.getDescripcion()))
                .collect(Collectors.toList());
        return new User(usuario.getUserName(), usuario.getPassword(), usuario.getEstado(), true, true, true, authorities);
    }
    
    @Override
    public UsuarioDTO findById(String id) {
         Usuario usuario=usuariodao.findById(id).orElse(null);
         
         UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getIdusuario(),usuario.getEstado(),"",usuario.getTokenPassword(),
         usuario.getTrabajadorId().getIdtrabajador(),usuario.getTrabajadorId().getPersona().getNombre(),usuario.getUserName());
         return usuarioDTO;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public entidadRespuesta<UsuarioDTO> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDTO update(UsuarioDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
   
    
}
