/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.controlador;

import com.agremiados.setec.dto.CursoDTO;
import com.agremiados.setec.dto.TrabajadorCursoDTO;
import com.agremiados.setec.servicios.CursoServicioImpl;
import com.agremiados.setec.servicios.TrabajadorCursoServicioImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/trabajadorcurso")
public class TrabajadorCursoControlador {
    
    @Autowired
    private TrabajadorCursoServicioImpl trabajadorcursoservicio;
    @Autowired
    private CursoServicioImpl cursoservicio;
    
    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorCursoDTO> findById(@PathVariable(name="id")String id){
        return ResponseEntity.ok(trabajadorcursoservicio.findById(id));
    } 
    
    @GetMapping("/curso")
    public List<CursoDTO> listarcurso(){
        return cursoservicio.findAll();
    }
    
    @PostMapping()
    public ResponseEntity<TrabajadorCursoDTO> crearCurso(@RequestBody TrabajadorCursoDTO trabajadorcursodto){
        System.out.println(trabajadorcursodto.getIdtrabajadorCurso());
        TrabajadorCursoDTO trabajacursoDTO = trabajadorcursoservicio.save(trabajadorcursodto);
        if(trabajacursoDTO ==null)
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(trabajacursoDTO, HttpStatus.OK);      
    } 
}
