/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "clua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clua.findAll", query = "SELECT c FROM Clua c"),
    @NamedQuery(name = "Clua.findByIdclua", query = "SELECT c FROM Clua c WHERE c.idclua = :idclua"),
    @NamedQuery(name = "Clua.findByEstado", query = "SELECT c FROM Clua c WHERE c.estado = :estado"),
    @NamedQuery(name = "Clua.findByFechaCreacion", query = "SELECT c FROM Clua c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Clua.findByVigencia", query = "SELECT c FROM Clua c WHERE c.vigencia = :vigencia")})
public class Clua implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idclua")
    private String idclua;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "vigencia")
    private int vigencia;
    @Column(name= "anio_afiliacion")
    private String anioAfiliacion;
    
    @OneToMany(mappedBy = "clua")
    private List<Trabajador> trabajadorList;

    public Clua() {
    }

    public Clua(String idclua) {
        this.idclua = idclua;
    }

    public Clua(String idclua, String estado, Date fechaCreacion, int vigencia) {
        this.idclua = idclua;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.vigencia = vigencia;
    }

    public String getIdclua() {
        return idclua;
    }

    public void setIdclua(String idclua) {
        this.idclua = idclua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public String getAnioAfiliacion() {
        return anioAfiliacion;
    }

    public void setAnioAfiliacion(String anioAfiliacion) {
        this.anioAfiliacion = anioAfiliacion;
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
        hash += (idclua != null ? idclua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clua)) {
            return false;
        }
        Clua other = (Clua) object;
        if ((this.idclua == null && other.idclua != null) || (this.idclua != null && !this.idclua.equals(other.idclua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.Clua[ idclua=" + idclua + " ]";
    }
    
}
