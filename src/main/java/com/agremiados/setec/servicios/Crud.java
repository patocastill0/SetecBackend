/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public interface Crud <T>{
    public T findById(String id);
    public T save(T tipo);
    public entidadRespuesta<T> findAll(int numeroDePagina, int medidaDePagina);
    public T update(T tipo, String id);
    public void delete(String id);
    
}
