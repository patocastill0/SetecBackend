/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.dto;


public class InstructorCursoDTO {
    
    private Integer idinstructorcurso;
    private Integer idcurso;
    private Integer idinstructor;

    public InstructorCursoDTO() {
    }

    public InstructorCursoDTO(Integer idinstructorcurso, Integer idcurso, Integer idinstructor) {
        this.idinstructorcurso = idinstructorcurso;
        this.idcurso = idcurso;
        this.idinstructor = idinstructor;
    }

    public Integer getIdinstructorcurso() {
        return idinstructorcurso;
    }

    public void setIdinstructorcurso(Integer idinstructorcurso) {
        this.idinstructorcurso = idinstructorcurso;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public Integer getIdinstructor() {
        return idinstructor;
    }

    public void setIdinstructor(Integer idinstructor) {
        this.idinstructor = idinstructor;
    }
    
    
    
}
