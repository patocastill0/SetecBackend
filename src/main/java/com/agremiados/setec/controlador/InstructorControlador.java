/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.controlador;

import com.agremiados.setec.dto.InstructorDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.servicios.InstructorServicioImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructor")
public class InstructorControlador {
    @Autowired
    private InstructorServicioImpl instructorservicio;
    
    @GetMapping("{id}")
    public ResponseEntity<InstructorDTO> findByid(@PathVariable(name="id")String id){
        return ResponseEntity.ok(instructorservicio.findById((id)));
    }
    @GetMapping("/listinstructor")
    public List<InstructorDTO> listainstructor(){
        return instructorservicio.findAll();
    }
    @PostMapping()
    public ResponseEntity<InstructorDTO> agregarInstructor(@RequestBody InstructorDTO instructordto){
        
        InstructorDTO instructorDto = instructorservicio.save(instructordto); 
        if( instructorDto==null)
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);       
        else 
            return new ResponseEntity<>(instructorDto,HttpStatus.OK);
    }
    
    @GetMapping("/page/{page}")
    public entidadRespuesta<InstructorDTO> listar (@PathVariable Integer page, @RequestParam(value = "pageSize", 
            defaultValue = "70", required = false)int cantidadPagina){
        return instructorservicio.findAll(page,cantidadPagina);
    }
}
