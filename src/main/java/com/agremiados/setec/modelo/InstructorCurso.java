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
@Table(name = "instructor_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstructorCurso.findAll", query = "SELECT i FROM InstructorCurso i"),
    @NamedQuery(name = "InstructorCurso.findByIdinstructorCurso", query = "SELECT i FROM InstructorCurso i WHERE i.idinstructorCurso = :idinstructorCurso")})
public class InstructorCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinstructor_curso")
    private Integer idinstructorCurso;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Curso idcurso;
    @JoinColumn(name = "idinstructor", referencedColumnName = "idcurso_instructor")
    @ManyToOne(optional = false)
    private Instructor idinstructor;

    public InstructorCurso() {
    }

    public InstructorCurso(Integer idinstructorCurso) {
        this.idinstructorCurso = idinstructorCurso;
    }

    public Integer getIdinstructorCurso() {
        return idinstructorCurso;
    }

    public void setIdinstructorCurso(Integer idinstructorCurso) {
        this.idinstructorCurso = idinstructorCurso;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    public Instructor getIdinstructor() {
        return idinstructor;
    }

    public void setIdinstructor(Instructor idinstructor) {
        this.idinstructor = idinstructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstructorCurso != null ? idinstructorCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorCurso)) {
            return false;
        }
        InstructorCurso other = (InstructorCurso) object;
        if ((this.idinstructorCurso == null && other.idinstructorCurso != null) || (this.idinstructorCurso != null && !this.idinstructorCurso.equals(other.idinstructorCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agremiados.setec.modelo.InstructorCurso[ idinstructorCurso=" + idinstructorCurso + " ]";
    }
    
}
