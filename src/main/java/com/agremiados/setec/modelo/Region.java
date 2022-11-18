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
@Table(name = "region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByClaveRegion", query = "SELECT r FROM Region r WHERE r.claveRegion = :claveRegion"),
    @NamedQuery(name = "Region.findByNombreRegion", query = "SELECT r FROM Region r WHERE r.nombreRegion = :nombreRegion")})
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clave_region")
    private String claveRegion;
    @Basic(optional = false)
    @Column(name = "nombre_region")
    private String nombreRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    private List<Trabajador> trabajadorList;

    public Region() {
    }

    public Region(String claveRegion) {
        this.claveRegion = claveRegion;
    }

    public Region(String claveRegion, String nombreRegion) {
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
        hash += (claveRegion != null ? claveRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.claveRegion == null && other.claveRegion != null) || (this.claveRegion != null && !this.claveRegion.equals(other.claveRegion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.Region[ claveRegion=" + claveRegion + " ]";
    }
    
}
