/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "cdcs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdcs.findAll", query = "SELECT c FROM Cdcs c"),
    @NamedQuery(name = "Cdcs.findByIdCdcs", query = "SELECT c FROM Cdcs c WHERE c.idCdcs = :idCdcs"),
    @NamedQuery(name = "Cdcs.findByNombreCdc", query = "SELECT c FROM Cdcs c WHERE c.nombreCdc = :nombreCdc")})
public class Cdcs implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdc")
    private List<TrabajadorCurso> trabajadorCursoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cdcs")
    private Integer idCdcs;
    @Basic(optional = false)
    @Column(name = "nombre_cdc")
    private String nombreCdc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdc")
    private List<Trabajador> trabajadorList;

    public Cdcs() {
    }

    public Cdcs(Integer idCdcs) {
        this.idCdcs = idCdcs;
    }

    public Cdcs(Integer idCdcs, String nombreCdc) {
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

    @XmlTransient
    @JsonIgnore
    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }

    public void setTrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCdcs != null ? idCdcs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdcs)) {
            return false;
        }
        Cdcs other = (Cdcs) object;
        if ((this.idCdcs == null && other.idCdcs != null) || (this.idCdcs != null && !this.idCdcs.equals(other.idCdcs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.Cdcs[ idCdcs=" + idCdcs + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public List<TrabajadorCurso> getTrabajadorCursoList() {
        return trabajadorCursoList;
    }

    public void setTrabajadorCursoList(List<TrabajadorCurso> trabajadorCursoList) {
        this.trabajadorCursoList = trabajadorCursoList;
    }
    
}
