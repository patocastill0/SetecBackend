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
public class CargoDTO {
    private String idcargo;
    private String nombreCargo;

    public CargoDTO() {
        
    }

    public CargoDTO(String idcargo, String nombreCargo) {
        this.idcargo = idcargo;
        this.nombreCargo = nombreCargo;
    }

    public String getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
          
}
