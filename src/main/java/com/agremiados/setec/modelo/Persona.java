/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByCurp", query = "SELECT p FROM Persona p WHERE p.curp = :curp"),
    @NamedQuery(name = "Persona.findByApMaterno", query = "SELECT p FROM Persona p WHERE p.apMaterno = :apMaterno"),
    @NamedQuery(name = "Persona.findByApPaterno", query = "SELECT p FROM Persona p WHERE p.apPaterno = :apPaterno"),
    @NamedQuery(name = "Persona.findByCalle", query = "SELECT p FROM Persona p WHERE p.calle = :calle"),
    @NamedQuery(name = "Persona.findByCelular", query = "SELECT p FROM Persona p WHERE p.celular = :celular"),
    @NamedQuery(name = "Persona.findByClaveElector", query = "SELECT p FROM Persona p WHERE p.claveElector = :claveElector"),
    @NamedQuery(name = "Persona.findByColonia", query = "SELECT p FROM Persona p WHERE p.colonia = :colonia"),
    @NamedQuery(name = "Persona.findByCorreoElectronico", query = "SELECT p FROM Persona p WHERE p.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Persona.findByCp", query = "SELECT p FROM Persona p WHERE p.cp = :cp"),
    @NamedQuery(name = "Persona.findByEstadoCivil", query = "SELECT p FROM Persona p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Persona.findByFacebook", query = "SELECT p FROM Persona p WHERE p.facebook = :facebook"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findByGenero", query = "SELECT p FROM Persona p WHERE p.genero = :genero"),
    @NamedQuery(name = "Persona.findByInstagram", query = "SELECT p FROM Persona p WHERE p.instagram = :instagram"),
    @NamedQuery(name = "Persona.findByLocalidad", query = "SELECT p FROM Persona p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByNumero", query = "SELECT p FROM Persona p WHERE p.numero = :numero"),
    @NamedQuery(name = "Persona.findBySeccion", query = "SELECT p FROM Persona p WHERE p.seccion = :seccion"),
    @NamedQuery(name = "Persona.findByTelCasa", query = "SELECT p FROM Persona p WHERE p.telCasa = :telCasa"),
    @NamedQuery(name = "Persona.findByTipoSanguineo", query = "SELECT p FROM Persona p WHERE p.tipoSanguineo = :tipoSanguineo"),
    @NamedQuery(name = "Persona.findByTwitter", query = "SELECT p FROM Persona p WHERE p.twitter = :twitter")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "curp")
    private String curp;
    @Basic(optional = false)
    @Column(name = "ap_materno")
    private String apMaterno;
    @Basic(optional = false)
    @Column(name = "ap_paterno")
    private String apPaterno;
    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "clave_elector")
    private String claveElector;
    @Basic(optional = false)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @Column(name = "cp")
    private String cp;
    @Basic(optional = false)
    @Column(name = "estado_civil")
    private int estadoCivil;
    @Column(name = "facebook")
    private String facebook;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "genero")
    private Character genero;
    @Column(name = "instagram")
    private String instagram;
    @Basic(optional = false)
    @Column(name = "localidad")
    private String localidad;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "seccion")
    private String seccion;
    @Basic(optional = false)
    @Column(name = "tel_casa")
    private String telCasa;
    @Column(name = "tipo_sanguineo")
    private String tipoSanguineo;
    @Column(name = "twitter")
    private String twitter;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Trabajador trabajador;
    @JoinColumn(name = "municipio", referencedColumnName = "clavemunicipio")
    @ManyToOne(optional = false)
    private Municipios municipio;

    public Persona() {
    }

    public Persona(String curp) {
        this.curp = curp;
    }

    public Persona(String curp, String apMaterno, String apPaterno, String calle, String celular, String claveElector, String colonia, String correoElectronico, String cp, int estadoCivil, Date fechaNacimiento, Character genero, String localidad, String nombre, String seccion, String telCasa) {
        this.curp = curp;
        this.apMaterno = apMaterno;
        this.apPaterno = apPaterno;
        this.calle = calle;
        this.celular = celular;
        this.claveElector = claveElector;
        this.colonia = colonia;
        this.correoElectronico = correoElectronico;
        this.cp = cp;
        this.estadoCivil = estadoCivil;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.localidad = localidad;
        this.nombre = nombre;
        this.seccion = seccion;
        this.telCasa = telCasa;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getClaveElector() {
        return claveElector;
    }

    public void setClaveElector(String claveElector) {
        this.claveElector = claveElector;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Municipios getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipios municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curp != null ? curp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.curp == null && other.curp != null) || (this.curp != null && !this.curp.equals(other.curp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.Persona[ curp=" + curp + " ]";
    }
    
}
