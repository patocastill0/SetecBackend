
package com.agremiados.setec.dto;



public class TrabajadorCursoDTO {
    private Integer idtrabajadorCurso;
    private String anio;
    private String codigocurso;
    private String horaFin;
    private String horaInicio;
    private String periodo;
    private Integer curso;
    private String nombrecurso;
    private String idtrabajador;
    
    public TrabajadorCursoDTO() {
        
    }

    public TrabajadorCursoDTO(Integer idtrabajadorCurso, String anio, String codigocurso, String horaFin, String horaInicio, String periodo, Integer curso, String nombrecurso, String idtrabajador) {
        this.idtrabajadorCurso = idtrabajadorCurso;
        this.anio = anio;
        this.codigocurso = codigocurso;
        this.horaFin = horaFin;
        this.horaInicio = horaInicio;
        this.periodo = periodo;
        this.curso = curso;
        this.nombrecurso = nombrecurso;
        this.idtrabajador = idtrabajador;
        
    }

    
    
    
    public Integer getIdtrabajadorCurso() {
        return idtrabajadorCurso;
    }

    public void setIdtrabajadorCurso(Integer idtrabajadorCurso) {
        this.idtrabajadorCurso = idtrabajadorCurso;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCodigocurso() {
        return codigocurso;
    }

    public void setCodigocurso(String codigocurso) {
        this.codigocurso = codigocurso;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public String getIdtrabajador() {
        return idtrabajador;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }
    
    public void setIdtrabajador(String idtrabajador) {
        this.idtrabajador = idtrabajador;
    }      
    
}
