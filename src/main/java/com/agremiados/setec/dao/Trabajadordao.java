/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.dao;

import com.agremiados.setec.modelo.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Trabajadordao extends JpaRepository<Trabajador, String>{
    List<Trabajador> findByTerm(
            @Param("curp")String curp,
            @Param("amaterno")String amaterno,
            @Param("apaterno")String apaterno,
            @Param("nombre")String nombre,
            @Param("nombreC")String nombreC
    );
        
}
