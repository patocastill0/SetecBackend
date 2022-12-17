/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Instructordao;
import com.agremiados.setec.dto.InstructorDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Instructor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class InstructorServicioImpl implements Crud<InstructorDTO>{
    @Autowired
    private Instructordao instructordao;
    
    @Override
    public InstructorDTO findById(String id) {
        Instructor instructor = instructordao.findById(Integer.parseInt(id)).orElse(null);
        InstructorDTO instructordto = new InstructorDTO(instructor.getIdcursoInstructor(),instructor.getNombre(),instructor.getApellidoPaterno(),instructor.getApellidoMaterno());
        return instructordto;
    }

    @Override
    public InstructorDTO save(InstructorDTO instructordto) {
        Instructor instructor = mapearInstructor(instructordto);
        Instructor nuevoinstructor = instructordao.save(instructor);
        InstructorDTO tipoinstructor = mapearInstructorDTO(nuevoinstructor);
        return tipoinstructor;
    }
    
    @Override
    public entidadRespuesta<InstructorDTO> findAll(int numeroDePagina, int medidaDePagina) {
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);
        Page<Instructor> instructorPage = instructordao.findAll(pageable);
        List<Instructor> listaInstructor = instructorPage.getContent();
        List<InstructorDTO> listaInstructorDTO= new ArrayList<>();
        
        for(Instructor instructor : listaInstructor){
            listaInstructorDTO.add(new InstructorDTO(
                    instructor.getIdcursoInstructor(),instructor.getNombre(),instructor.getApellidoPaterno(),instructor.getApellidoMaterno()
            ));
        }
        entidadRespuesta entidadrespuesta = new entidadRespuesta();
        entidadrespuesta.setContenido(listaInstructorDTO);
        entidadrespuesta.setNumeroPagina(instructorPage.getNumber());
        entidadrespuesta.setMedidaPagina(instructorPage.getSize());
        entidadrespuesta.setTotalElementos(instructorPage.getTotalElements());
        entidadrespuesta.setTotalPaginas(instructorPage.getTotalPages());
        entidadrespuesta.setUltima(instructorPage.isLast());
        entidadrespuesta.setPrimera(instructorPage.isFirst());
        return entidadrespuesta;
    }

    @Override
    public InstructorDTO update(InstructorDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<InstructorDTO> findAll(){
        List<Instructor> listarInstructor = instructordao.findAll();
        List<InstructorDTO> listarDTO = new ArrayList<>();
        for(Instructor instructor:listarInstructor)
            listarDTO.add(new InstructorDTO(instructor.getIdcursoInstructor(),instructor.getNombre(),instructor.getApellidoPaterno(),instructor.getApellidoMaterno()));
        return listarDTO;
    }
    
    private InstructorDTO mapearInstructorDTO(Instructor instructor){
        InstructorDTO instructordto = new InstructorDTO();
        instructordto.setIdInstructor(instructor.getIdcursoInstructor());
        instructordto.setNombre(instructor.getNombre());
        instructordto.setApPaterno(instructor.getApellidoPaterno());
        instructordto.setApMaterno(instructor.getApellidoMaterno());
        return instructordto;
    }
    
    private Instructor mapearInstructor(InstructorDTO instructordto){
        Instructor instructor = new Instructor();
        
        instructor.setIdcursoInstructor(instructordto.getIdInstructor());
        instructor.setNombre(instructordto.getNombre());
        instructor.setApellidoPaterno(instructordto.getApPaterno());
        instructor.setApellidoMaterno(instructordto.getApMaterno());
        return instructor;
    }
    
}
