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
public class MunicipiosDTO {
    private String clavemunicipio;
    private String cabeceraMunicipal;
    private String nombreMunicipio;

    public MunicipiosDTO() {
    }

    public MunicipiosDTO(String clavemunicipio, String cabeceraMunicipal, String nombreMunicipio) {
        this.clavemunicipio = clavemunicipio;
        this.cabeceraMunicipal = cabeceraMunicipal;
        this.nombreMunicipio = nombreMunicipio;
    }

    public String getClavemunicipio() {
        return clavemunicipio;
    }

    public void setClavemunicipio(String clavemunicipio) {
        this.clavemunicipio = clavemunicipio;
    }

    public String getCabeceraMunicipal() {
        return cabeceraMunicipal;
    }

    public void setCabeceraMunicipal(String cabeceraMunicipal) {
        this.cabeceraMunicipal = cabeceraMunicipal;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
    
    
}
