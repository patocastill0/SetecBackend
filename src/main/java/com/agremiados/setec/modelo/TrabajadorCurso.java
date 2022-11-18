/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "trabajador_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajadorCurso.findAll", query = "SELECT t FROM TrabajadorCurso t"),
    @NamedQuery(name = "TrabajadorCurso.findByIdtrabajadorCurso", query = "SELECT t FROM TrabajadorCurso t WHERE t.idtrabajadorCurso = :idtrabajadorCurso"),
    @NamedQuery(name = "TrabajadorCurso.findByAnio", query = "SELECT t FROM TrabajadorCurso t WHERE t.anio = :anio"),
    @NamedQuery(name = "TrabajadorCurso.findByCodigocurso", query = "SELECT t FROM TrabajadorCurso t WHERE t.codigocurso = :codigocurso"),
    @NamedQuery(name = "TrabajadorCurso.findByHoraFin", query = "SELECT t FROM TrabajadorCurso t WHERE t.horaFin = :horaFin"),
    @NamedQuery(name = "TrabajadorCurso.findByHoraInicio", query = "SELECT t FROM TrabajadorCurso t WHERE t.horaInicio = :horaInicio"),
    @NamedQuery(name = "TrabajadorCurso.findByPeriodo", query = "SELECT t FROM TrabajadorCurso t WHERE t.periodo = :periodo")})
public class TrabajadorCurso implements Serializable {

    @JoinColumn(name = "cdc", referencedColumnName = "id_cdcs")
    @ManyToOne(optional = false)
    private Cdcs cdc;
    
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtrabajador_curso")
    private Integer idtrabajadorCurso;
    @Basic(optional = false)
    @Column(name = "anio")
    private String anio;
    @Basic(optional = false)
    @Column(name = "codigocurso")
    private String codigocurso;
    @Basic(optional = false)
    @Column(name = "hora_fin")
    private String horaFin;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Basic(optional = false)
    @Column(name = "periodo")
    private String periodo;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Curso idcurso;
    @JoinColumn(name = "idtrabajador", referencedColumnName = "idtrabajador")
    @ManyToOne(optional = false)
    private Trabajador idtrabajador;

    public TrabajadorCurso() {
    }

    public TrabajadorCurso(Integer idtrabajadorCurso) {
        this.idtrabajadorCurso = idtrabajadorCurso;
    }

    public TrabajadorCurso(Integer idtrabajadorCurso, String anio, String codigocurso, String horaFin, String horaInicio, String periodo) {
        this.idtrabajadorCurso = idtrabajadorCurso;
        this.anio = anio;
        this.codigocurso = codigocurso;
        this.horaFin = horaFin;
        this.horaInicio = horaInicio;
        this.periodo = periodo;
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


    public Trabajador getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(Trabajador idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrabajadorCurso != null ? idtrabajadorCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorCurso)) {
            return false;
        }
        TrabajadorCurso other = (TrabajadorCurso) object;
        if ((this.idtrabajadorCurso == null && other.idtrabajadorCurso != null) || (this.idtrabajadorCurso != null && !this.idtrabajadorCurso.equals(other.idtrabajadorCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.TrabajadorCurso[ idtrabajadorCurso=" + idtrabajadorCurso + " ]";
    }

    public Cdcs getCdc() {
        return cdc;
    }

    public void setCdc(Cdcs cdc) {
        this.cdc = cdc;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }
    
}
