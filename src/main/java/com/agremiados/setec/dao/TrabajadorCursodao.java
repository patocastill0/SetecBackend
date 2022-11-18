
package com.agremiados.setec.dao;

import com.agremiados.setec.modelo.TrabajadorCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorCursodao extends JpaRepository<TrabajadorCurso, Integer>{
        
}
