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
public class RegionDTO {
    private String claveRegion;
    private String nombreRegion;

    public RegionDTO() {
    }

    public RegionDTO(String claveRegion, String nombreRegion) {
        this.claveRegion = claveRegion;
        this.nombreRegion = nombreRegion;
    }

    public String getClaveRegion() {
        return claveRegion;
    }

    public void setClaveRegion(String claveRegion) {
        this.claveRegion = claveRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

}
