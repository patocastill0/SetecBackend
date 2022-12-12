/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t"),
    @NamedQuery(name = "Trabajador.findByIdtrabajador", query = "SELECT t FROM Trabajador t WHERE t.idtrabajador = :idtrabajador"),
    @NamedQuery(name = "Trabajador.findByFolio", query = "SELECT t FROM Trabajador t WHERE t.folio = :folio"),
    @NamedQuery(name = "Trabajador.findByTerm", query = "SELECT t FROM Trabajador t WHERE UPPER(t.persona.curp) like CONCAT(UPPER(:curp),'%') or UPPER(t.persona.apMaterno) like CONCAT(UPPER(:amaterno),'%') or UPPER(t.persona.apPaterno) like CONCAT(UPPER(:apaterno),'%') or UPPER(t.persona.nombre) like CONCAT(UPPER(:nombre),'%') or CONCAT(UPPER(t.persona.nombre),' ',UPPER(t.persona.apPaterno),' ',UPPER(t.persona.apMaterno)) like CONCAT(UPPER(:nombreC),'%')")})
public class Trabajador implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtrabajador")
    private String idtrabajador;
    
    @Column(name = "folio")
    private int folio;

    @Basic(optional = false)
    @Column(name = "hasactanacimiento")
    private boolean hasactanacimiento;

    @Basic(optional = false)
    @Column(name = "hascomprobante")
    private boolean hascomprobante;

    @Basic(optional = false)
    @Column(name = "hascurp")
    private boolean hascurp;

    @Basic(optional = false)
    @Column(name = "hasine")
    private boolean hasine;
    @JoinColumn(name = "cargo", referencedColumnName = "idcargo")
    @ManyToOne(optional = false)
    private Cargo cargo;
    @JoinColumn(name = "cdc", referencedColumnName = "id_cdcs")
    @ManyToOne(optional = false)
    private Cdcs cdc;
    @JoinColumn(name = "clua", referencedColumnName = "idclua")
    @ManyToOne
    private Clua clua;
    @JoinColumn(name = "idtrabajador", referencedColumnName = "curp", insertable = false, updatable = false)
    @OneToOne(optional = false,cascade = CascadeType.ALL)//
    private Persona persona;
    @JoinColumn(name = "region", referencedColumnName = "clave_region")
    @ManyToOne(optional = false)
    private Region region;
    @JoinColumn(name = "sector", referencedColumnName = "idsector")
    @ManyToOne(optional = false)
    private Sector sector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrabajador")
    private List<TrabajadorCurso> trabajadorCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajadorId")
    private List<Usuario> usuarioList;

    public Trabajador() {
    }

    public Trabajador(String idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public Trabajador(String idtrabajador, int folio) {
        this.idtrabajador = idtrabajador;
        this.folio = folio;
    }

    public boolean isHasactanacimiento() {
        return hasactanacimiento;
    }

    public void setHasactanacimiento(boolean hasactanacimiento) {
        this.hasactanacimiento = hasactanacimiento;
    }

    public boolean isHascomprobante() {
        return hascomprobante;
    }

    public void setHascomprobante(boolean hascomprobante) {
        this.hascomprobante = hascomprobante;
    }

    public boolean isHascurp() {
        return hascurp;
    }

    public void setHascurp(boolean hascurp) {
        this.hascurp = hascurp;
    }

    public boolean isHasine() {
        return hasine;
    }

    public void setHasine(boolean hasine) {
        this.hasine = hasine;
    }
        
    
    
    public String getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(String idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cdcs getCdc() {
        return cdc;
    }

    public void setCdc(Cdcs cdc) {
        this.cdc = cdc;
    }

    public Clua getClua() {
        return clua;
    }

    public void setClua(Clua clua) {
        this.clua = clua;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
   

    @XmlTransient
    @JsonIgnore
    public List<TrabajadorCurso> getTrabajadorCursoList() {
        return trabajadorCursoList;
    }

    public void setTrabajadorCursoList(List<TrabajadorCurso> trabajadorCursoList) {
        this.trabajadorCursoList = trabajadorCursoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrabajador != null ? idtrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.idtrabajador == null && other.idtrabajador != null) || (this.idtrabajador != null && !this.idtrabajador.equals(other.idtrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.Trabajador[ idtrabajador=" + idtrabajador + " ]";
    }
    
}
