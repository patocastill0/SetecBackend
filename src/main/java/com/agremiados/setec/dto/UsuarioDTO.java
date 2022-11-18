/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.dto;

/**
 *
 * @author LENOVO
 */
public class UsuarioDTO {
    
    private String idUsuario;
    private boolean estado; 
    private String password;
    private String tokenPassword;
    private String trabajadorId;
    private String nombreTrabajador;
    private String userName;

    public UsuarioDTO() {
        
    }

    public UsuarioDTO(String idUsuario, boolean estado, String password, String tokenPassword, String trabajadorId, String nombreTrabajador, String userName) {
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.password = password;
        this.tokenPassword = tokenPassword;
        this.trabajadorId = trabajadorId;
        this.nombreTrabajador = nombreTrabajador;
        this.userName = userName;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTokenPassword() {
        return tokenPassword;
    }

    public void setTokenPassword(String tokenPassword) {
        this.tokenPassword = tokenPassword;
    }

    public String getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(String trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
}
