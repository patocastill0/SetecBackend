
package com.agremiados.setec.dto;


public class SectorDTO {
    private String idSector;
    private String nombreSector;

    public SectorDTO() {
    }

    public SectorDTO(String idSector, String nombreSector) {
        this.idSector = idSector;
        this.nombreSector = nombreSector;
    }

    public String getIdSector() {
        return idSector;
    }

    public void setIdSector(String idSector) {
        this.idSector = idSector;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }
    
    
            
}
