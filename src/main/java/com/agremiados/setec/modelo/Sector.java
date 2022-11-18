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
@Table(name = "sector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s"),
    @NamedQuery(name = "Sector.findByIdsector", query = "SELECT s FROM Sector s WHERE s.idsector = :idsector"),
    @NamedQuery(name = "Sector.findByNombresector", query = "SELECT s FROM Sector s WHERE s.nombresector = :nombresector")})
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsector")
    private String idsector;
    @Basic(optional = false)
    @Column(name = "nombresector")
    private String nombresector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sector")
    private List<Trabajador> trabajadorList;

    public Sector() {
    }

    public Sector(String idsector) {
        this.idsector = idsector;
    }

    public Sector(String idsector, String nombresector) {
        this.idsector = idsector;
        this.nombresector = nombresector;
    }

    public String getIdsector() {
        return idsector;
    }

    public void setIdsector(String idsector) {
        this.idsector = idsector;
    }

    public String getNombresector() {
        return nombresector;
    }

    public void setNombresector(String nombresector) {
        this.nombresector = nombresector;
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
        hash += (idsector != null ? idsector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.idsector == null && other.idsector != null) || (this.idsector != null && !this.idsector.equals(other.idsector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.Sector[ idsector=" + idsector + " ]";
    }
    
}
