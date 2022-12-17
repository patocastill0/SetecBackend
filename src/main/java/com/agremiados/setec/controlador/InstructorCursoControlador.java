/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.controlador;

import com.agremiados.setec.dto.InstructorCursoDTO;
import com.agremiados.setec.servicios.InstructorCursoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/instructorcurso")
public class InstructorCursoControlador {
    @Autowired
    private InstructorCursoServicioImpl instructorcursoservicio;
    
    @PostMapping()
    public ResponseEntity <InstructorCursoDTO> añadirInstructorCurso(@RequestBody InstructorCursoDTO instructorcursodto){
        InstructorCursoDTO instructorcursoDTO = instructorcursoservicio.save(instructorcursodto);
        if(instructorcursoDTO == null)
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(instructorcursoDTO,HttpStatus.OK);
    }
    
}
