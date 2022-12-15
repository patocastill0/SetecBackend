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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByIdcursoInstructor", query = "SELECT i FROM Instructor i WHERE i.idcursoInstructor = :idcursoInstructor"),
    @NamedQuery(name = "Instructor.findByNombre", query = "SELECT i FROM Instructor i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Instructor.findByApellidoPaterno", query = "SELECT i FROM Instructor i WHERE i.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Instructor.findByApellidoMaterno", query = "SELECT i FROM Instructor i WHERE i.apellidoMaterno = :apellidoMaterno")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcurso_instructor")
    private Integer idcursoInstructor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinstructor")
    private List<TrabajadorCurso> trabajadorCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinstructor")
    private List<InstructorCurso> instructorCursoList;

    public Instructor() {
    }

    public Instructor(Integer idcursoInstructor) {
        this.idcursoInstructor = idcursoInstructor;
    }

    public Instructor(Integer idcursoInstructor, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.idcursoInstructor = idcursoInstructor;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public Integer getIdcursoInstructor() {
        return idcursoInstructor;
    }

    public void setIdcursoInstructor(Integer idcursoInstructor) {
        this.idcursoInstructor = idcursoInstructor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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
    public List<InstructorCurso> getInstructorCursoList() {
        return instructorCursoList;
    }

    public void setInstructorCursoList(List<InstructorCurso> instructorCursoList) {
        this.instructorCursoList = instructorCursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcursoInstructor != null ? idcursoInstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.idcursoInstructor == null && other.idcursoInstructor != null) || (this.idcursoInstructor != null && !this.idcursoInstructor.equals(other.idcursoInstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.Instructor[ idcursoInstructor=" + idcursoInstructor + " ]";
    }
    
}
