
package com.agremiados.setec.dao;

import com.agremiados.setec.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cursodao extends JpaRepository<Curso, Integer>{
        
}
