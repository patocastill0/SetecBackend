/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Cursodao;
import com.agremiados.setec.dao.InstructorCursodao;
import com.agremiados.setec.dao.Instructordao;
import com.agremiados.setec.dto.InstructorCursoDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Curso;
import com.agremiados.setec.modelo.Instructor;
import com.agremiados.setec.modelo.InstructorCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InstructorCursoServicioImpl implements Crud<InstructorCursoDTO>{
    @Autowired
    private InstructorCursodao instructorcursodao;
    @Autowired
    private Cursodao cursodao;
    @Autowired
    private Instructordao instructordao;
    
    
    @Override
    public InstructorCursoDTO findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InstructorCursoDTO save(InstructorCursoDTO tipo) {
        InstructorCurso instructorcurso = mapearInstructor(tipo);
        InstructorCurso nuevoinstructorcurso = instructorcursodao.save(instructorcurso);
        return mapearInstructorDTO(nuevoinstructorcurso);
        
    }

    @Override
    public entidadRespuesta<InstructorCursoDTO> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InstructorCursoDTO update(InstructorCursoDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private InstructorCursoDTO mapearInstructorDTO(InstructorCurso instructorcurso){
        InstructorCursoDTO instructorcursodto = new InstructorCursoDTO();
        instructorcursodto.setIdcurso(instructorcurso.getIdcurso().getIdcurso());
        instructorcursodto.setIdinstructor(instructorcurso.getIdinstructor().getIdcursoInstructor());
        
        return instructorcursodto;
    }
    
    private InstructorCurso mapearInstructor(InstructorCursoDTO instructorcursodto){
        InstructorCurso instructorcurso = new InstructorCurso();
        Curso curso = cursodao.findById(instructorcursodto.getIdcurso()).orElse(null);
        Instructor instructor = instructordao.findById(instructorcursodto.getIdinstructor()).orElse(null);
        //instructorcurso.setIdinstructorCurso(instructorcursodto.getIdinstructorcurso());
        instructorcurso.setIdcurso(curso);
        instructorcurso.setIdinstructor(instructor);
       
        return instructorcurso;
    }
}
