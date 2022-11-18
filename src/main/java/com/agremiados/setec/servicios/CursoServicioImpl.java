/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Cursodao;
import com.agremiados.setec.dto.CursoDTO;
import com.agremiados.setec.dto.TrabajadorCursoDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Curso;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServicioImpl implements Crud<CursoDTO>{
    @Autowired
    private Cursodao cursodao;

    @Override
    public CursoDTO findById(String id) {
        Curso curso = cursodao.findById(Integer.parseInt(id)).orElse(null);
        CursoDTO cursodto = new CursoDTO(curso.getIdcurso(), curso.getNombreCurso());
        return cursodto;
    }

    @Override
    public CursoDTO save(CursoDTO tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public entidadRespuesta<CursoDTO> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CursoDTO update(CursoDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<CursoDTO> findAll(){
        List<Curso> listarCurso = cursodao.findAll();
        List<CursoDTO> listarDTO = new ArrayList<>();
        for(Curso curso:listarCurso)
            listarDTO.add(new CursoDTO(curso.getIdcurso(), curso.getNombreCurso()));
        return listarDTO;
    }
}
