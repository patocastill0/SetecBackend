
package com.agremiados.setec.dto;



public class TrabajadorCursoDTO {
    private Integer idtrabajadorCurso;
    private String anio;
    private String codigocurso;
    private String horaFin;
    private String horaInicio;
    private String periodo;
    private Integer idcurso;
    private String nombrecurso;
    private String idtrabajador;   
    private String nombreTrabajador;
    private Integer cdc;
    public TrabajadorCursoDTO() {
        
    }

    public TrabajadorCursoDTO(Integer idtrabajadorCurso, String anio, String codigocurso, String horaFin, String horaInicio, String periodo, Integer idcurso, String nombrecurso, String idtrabajador,
                              String nombreTrabajador, Integer cdc) {
        this.idtrabajadorCurso = idtrabajadorCurso;
        this.anio = anio;
        this.codigocurso = codigocurso;
        this.horaFin = horaFin;
        this.horaInicio = horaInicio;
        this.periodo = periodo;
        this.idcurso = idcurso;
        this.nombrecurso = nombrecurso;
        this.idtrabajador = idtrabajador;
        this.nombreTrabajador=nombreTrabajador;
        this.cdc=cdc;
        
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

    public Integer getIdurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getIdtrabajador() {
        return idtrabajador;
    }
    public void setIdtrabajador(String idtrabajador) {
        this.idtrabajador = idtrabajador;
    }
    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }
    
    

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public Integer getCdc() {
        return cdc;
    }

    public void setCdc(Integer cdc) {
        this.cdc = cdc;
    }
    
}
