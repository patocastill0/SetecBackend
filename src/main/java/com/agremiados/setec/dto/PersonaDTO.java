/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.dto;

import java.util.Date;


public class PersonaDTO {
    private String curp;
    private String apPaterno;
    private String apMaterno;
    private String calle;
    private String celular;
    private String claveElector;
    private String colonia;
    private String correoElectronico;
    private String cp;
    private Integer estadoCivil;
    private String facebook;
    private Date fechaNacimiento;
    private char genero;
    private String instagram;
    private String localidad;
    private String nombre;
    private String numero;
    private String seccion;
    private String telCasa;
    private String tipoSanguineo;
    private String twitter;
    private String municipio;

    public PersonaDTO() {
    }

    public PersonaDTO(String curp, String apPaterno, String apMaterno, String calle, String celular, String claveElector, String colonia, String correoElectronico, String cp, Integer estadoCivil, String facebook, Date fechaNacimiento, char genero, String instagram, String localidad, String nombre, String numero, String seccion, String telCasa, String tipoSanguineo, String twitter, String municipio) {
        this.curp = curp;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.calle = calle;
        this.celular = celular;
        this.claveElector = claveElector;
        this.colonia = colonia;
        this.correoElectronico = correoElectronico;
        this.cp = cp;
        this.estadoCivil = estadoCivil;//foranea
        this.facebook = facebook;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.instagram = instagram;
        this.localidad = localidad;
        this.nombre = nombre;
        this.numero = numero;
        this.seccion = seccion;
        this.telCasa = telCasa;
        this.tipoSanguineo = tipoSanguineo;
        this.twitter = twitter;
        this.municipio = municipio;//forean
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
    
    
    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getClaveElector() {
        return claveElector;
    }

    public void setClaveElector(String claveElector) {
        this.claveElector = claveElector;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Integer getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
}
