/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.controlador;

import com.agremiados.setec.dto.MunicipiosDTO;
import com.agremiados.setec.servicios.MunicipioServicioImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/municipio")
public class MunicipioControlador {
    @Autowired
    private MunicipioServicioImpl serviciomunicipio;
    
    @GetMapping("/municipios")
    public List<MunicipiosDTO> listarmunicipios(){
        return serviciomunicipio.findAll();
    }
    
    @GetMapping("/term/{term}")
    public List<MunicipiosDTO> findByTerm(@PathVariable(name="term")String term){
        return serviciomunicipio.findByTerm(term);
    }
}
