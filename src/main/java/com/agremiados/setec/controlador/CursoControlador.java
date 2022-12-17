/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.controlador;

import com.agremiados.setec.dto.CursoDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.servicios.CursoServicioImpl;
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
@RequestMapping("api/curso")
public class CursoControlador {
    @Autowired
    private CursoServicioImpl cursoservicio;
    
    @GetMapping("{id}")
    public ResponseEntity<CursoDTO> findById(@PathVariable(name="id")String id){
        return ResponseEntity.ok(cursoservicio.findById((id)));
    }
    
    @PostMapping()
    public ResponseEntity<CursoDTO> agregarCurso(@RequestBody CursoDTO cursodto){
        CursoDTO cursoDto = cursoservicio.save(cursodto);
        if(cursoDto == null)
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);       
        else 
            return new ResponseEntity<>(cursoDto,HttpStatus.OK);
    }
    
    @GetMapping("/page/{page}")
    public entidadRespuesta<CursoDTO> listarCurso(@PathVariable Integer page, @RequestParam(value = "pageSize", 
            defaultValue = "70", required = false)int cantidadPagina){
        return cursoservicio.findAll(page,cantidadPagina);
    }
    
}
