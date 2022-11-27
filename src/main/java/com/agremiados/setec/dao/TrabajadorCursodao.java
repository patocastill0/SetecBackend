
package com.agremiados.setec.dao;

import com.agremiados.setec.modelo.TrabajadorCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabajadorCursodao extends JpaRepository<TrabajadorCurso, Integer>{
        List<TrabajadorCurso> findCusosByTrabajador(@Param("curp")String curp);
}
