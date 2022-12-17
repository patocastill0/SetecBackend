/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Cursodao;
import com.agremiados.setec.dto.CursoDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Curso;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public CursoDTO save(CursoDTO cursodto) {
        Curso curso = mapearCurso(cursodto);
        Curso nuevocurso = cursodao.save(curso);
        CursoDTO tipocurso = mapearCursoDTO(nuevocurso);
        return tipocurso;
    }

    @Override
    public entidadRespuesta<CursoDTO> findAll(int numeroDePagina, int medidaDePagina) {
         Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);
         Page<Curso> cursoPage = cursodao.findAll(pageable);
         List<Curso> listaCurso = cursoPage.getContent();
         List<CursoDTO> listaCursoDTO = new ArrayList<>();
         
         for(Curso curso : listaCurso){
             listaCursoDTO.add(new CursoDTO(
             curso.getIdcurso(),curso.getNombreCurso()
             ));
         }
         entidadRespuesta entidadrespuesta = new entidadRespuesta();
          entidadrespuesta.setContenido(listaCursoDTO);
          entidadrespuesta.setNumeroPagina(cursoPage.getNumber());
          entidadrespuesta.setMedidaPagina(cursoPage.getSize());
          entidadrespuesta.setTotalElementos(cursoPage.getTotalElements());
          entidadrespuesta.setTotalPaginas(cursoPage.getTotalPages());
          entidadrespuesta.setUltima(cursoPage.isLast());
          entidadrespuesta.setPrimera(cursoPage.isFirst());
        return entidadrespuesta;
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
    
    private CursoDTO mapearCursoDTO(Curso curso){
        CursoDTO cursoDto = new CursoDTO();
        cursoDto.setIdcurso(curso.getIdcurso());
        cursoDto.setNombreCurso(curso.getNombreCurso());
        return cursoDto;
    }
    private Curso mapearCurso(CursoDTO cursodto){
        Curso curso = new Curso();
        curso.setIdcurso(cursodto.getIdcurso());
        curso.setNombreCurso(cursodto.getNombreCurso());
        return curso;
    }
}
