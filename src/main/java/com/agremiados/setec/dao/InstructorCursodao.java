/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.dao;

import com.agremiados.setec.modelo.InstructorCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface InstructorCursodao extends JpaRepository<InstructorCurso, Integer>{
    
}
