/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.dto;

import java.util.Date;


public class TrabajadorCluaDTO {
    //usar los datos del ngfor
    private int numAfiliacion;
    private String numanioafiliacion;
    private String sector;
    private String cargo;
    private String claveMunicipio;
    private String region;
    private Date fecharegistro;
    private String estado;
    private Integer vigencia;
    

    public TrabajadorCluaDTO() {
    }

    public TrabajadorCluaDTO(int numAfiliacion, String numanioafiliacion, String sector, String cargo, String claveMunicipio, String region, Date fecharegistro, String estado, Integer vigencia) {
        this.numAfiliacion = numAfiliacion;
        this.numanioafiliacion = numanioafiliacion;
        this.sector = sector;
        this.cargo = cargo;
        this.claveMunicipio = claveMunicipio;
        this.region = region;
        this.fecharegistro = fecharegistro;
        this.estado = estado;
        this.vigencia = vigencia;
    }

    public int getNumAfiliacion() {
        return numAfiliacion;
    }

    public void setNumAfiliacion(int numAfiliacion) {
        this.numAfiliacion = numAfiliacion;
    }

    public String getNumanioafiliacion() {
        return numanioafiliacion;
    }

    public void setNumanioafiliacion(String numanioafiliacion) {
        this.numanioafiliacion = numanioafiliacion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getClaveMunicipio() {
        return claveMunicipio;
    }

    public void setClaveMunicipio(String claveMunicipio) {
        this.claveMunicipio = claveMunicipio;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    
    
    
}
    