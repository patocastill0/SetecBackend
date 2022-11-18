
package com.agremiados.setec.dto;

import java.util.Date;

public class TrabajadorDTO extends PersonaDTO{

    
    private String idtrabajador;
    private String sector;
    private String cargo;
    private String region;
    private String clua;
    private Integer cdc;
    private String folio;
    
    public TrabajadorDTO() {
        
    }

    public TrabajadorDTO(String idtrabajador, String sector, String cargo, String region, String clua, Integer cdc, String folio, String curp, String apPaterno, String apMaterno, String calle, String celular, String claveElector, String colonia, String correoElectronico, String cp, Integer estadoCivil, String facebook, Date fechaNacimiento, char genero, String instagram, String localidad, String nombre, String numero, String seccion, String telCasa, String tipoSanguineo, String twitter, String municipio) {
        super(curp, apPaterno, apMaterno, calle, celular, claveElector, colonia, correoElectronico, cp, estadoCivil, facebook, fechaNacimiento, genero, instagram, localidad, nombre, numero, seccion, telCasa, tipoSanguineo, twitter, municipio);
        this.idtrabajador = idtrabajador;
        this.sector = sector;
        this.cargo = cargo;
        this.region = region;
        this.clua = clua;
        this.cdc = cdc;
        this.folio = folio;
    }

   

    public String getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(String idtrabajador) {
        this.idtrabajador = idtrabajador;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getClua() {
        return clua;
    }

    public void setClua(String clua) {
        this.clua = clua;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Integer getCdc() {
        return cdc;
    }

    public void setCdc(Integer cdc) {
        this.cdc = cdc;
    }
    
}
