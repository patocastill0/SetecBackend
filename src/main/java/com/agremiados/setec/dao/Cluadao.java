
package com.agremiados.setec.dao;

import com.agremiados.setec.modelo.Clua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cluadao extends JpaRepository<Clua, String>{
     
}
