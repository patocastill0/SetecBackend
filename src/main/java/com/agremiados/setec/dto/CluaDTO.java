/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.dto;

import com.agremiados.setec.modelo.Trabajador;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class CluaDTO {
    private String idclua;
    private String estado;
    private Date fechaCreacion;
    private Integer vigencia;
    private String anioafiliacion;
    private TrabajadorDTO trabajadordto;
    public CluaDTO() {
    }

    public CluaDTO(String idclua, String estado, Date fechaCreacion, Integer vigencia,String anioafiliacion, TrabajadorDTO trabajadordto) {
        this.idclua = idclua;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.vigencia = vigencia;
        this.anioafiliacion = anioafiliacion;
        this.trabajadordto = trabajadordto;
    }

    public String getIdclua() {
        return idclua;
    }

    public void setIdclua(String idclua) {
        this.idclua = idclua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public String getAnioafiliacion() {
        return anioafiliacion;
    }   

    public void setAnioafiliacion(String anioafiliacion) {
        this.anioafiliacion = anioafiliacion;
    }

    public TrabajadorDTO getTrabajadordto() {
        return trabajadordto;   
    }

    public void setTrabajadordto(TrabajadorDTO trabajadordto) {
        this.trabajadordto = trabajadordto;
    }
    
}
