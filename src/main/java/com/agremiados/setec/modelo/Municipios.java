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
@Table(name = "municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByClavemunicipio", query = "SELECT m FROM Municipios m WHERE m.clavemunicipio = :clavemunicipio"),
    @NamedQuery(name = "Municipios.findByCabeceraMunicipal", query = "SELECT m FROM Municipios m WHERE m.cabeceraMunicipal = :cabeceraMunicipal"),
    @NamedQuery(name = "Municipios.findByNombreMunicipio", query = "SELECT m FROM Municipios m WHERE m.nombreMunicipio = :nombreMunicipio"),
    @NamedQuery(name = "Municipios.findByTerminoMunicipio", query = "SELECT m FROM Municipios m WHERE UPPER(m.nombreMunicipio) like CONCAT(UPPER(:nombremunicipio),'%') or UPPER(m.clavemunicipio) like CONCAT(UPPER(:clavemunicipio),'%')")})
        
public class Municipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clavemunicipio")
    private String clavemunicipio;
    @Basic(optional = false)
    @Column(name = "cabecera_municipal")
    private String cabeceraMunicipal;
    @Basic(optional = false)
    @Column(name = "nombre_municipio")
    private String nombreMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipio")
    private List<Persona> personaList;

    public Municipios() {
    }

    public Municipios(String clavemunicipio) {
        this.clavemunicipio = clavemunicipio;
    }

    public Municipios(String clavemunicipio, String cabeceraMunicipal, String nombreMunicipio) {
        this.clavemunicipio = clavemunicipio;
        this.cabeceraMunicipal = cabeceraMunicipal;
        this.nombreMunicipio = nombreMunicipio;
    }

    public String getClavemunicipio() {
        return clavemunicipio;
    }

    public void setClavemunicipio(String clavemunicipio) {
        this.clavemunicipio = clavemunicipio;
    }

    public String getCabeceraMunicipal() {
        return cabeceraMunicipal;
    }

    public void setCabeceraMunicipal(String cabeceraMunicipal) {
        this.cabeceraMunicipal = cabeceraMunicipal;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    @XmlTransient
    @JsonIgnore
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clavemunicipio != null ? clavemunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.clavemunicipio == null && other.clavemunicipio != null) || (this.clavemunicipio != null && !this.clavemunicipio.equals(other.clavemunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.Municipios[ clavemunicipio=" + clavemunicipio + " ]";
    }
    
}
