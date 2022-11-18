
package com.agremiados.setec.dto;


public class CursoDTO {
   private Integer idcurso;
   private String nombreCurso;
   
    public CursoDTO() {
    }

    public CursoDTO(Integer idcurso, String nombreCurso) {
        this.idcurso = idcurso;
        this.nombreCurso = nombreCurso;
       
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
}
