package com.agremiados.setec.dto;


public class CdcsDTO {
    private Integer idCdcs;
    private String nombreCdc;

    public CdcsDTO() {
    }

    public CdcsDTO(Integer idCdcs, String nombreCdc) {
        this.idCdcs = idCdcs;
        this.nombreCdc = nombreCdc;
    }

    public Integer getIdCdcs() {
        return idCdcs;
    }

    public void setIdCdcs(Integer idCdcs) {
        this.idCdcs = idCdcs;
    }

    public String getNombreCdc() {
        return nombreCdc;
    }

    public void setNombreCdc(String nombreCdc) {
        this.nombreCdc = nombreCdc;
    }
    
    
}
