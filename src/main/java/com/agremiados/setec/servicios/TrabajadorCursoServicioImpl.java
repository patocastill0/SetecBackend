/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Cdcsdao;
import com.agremiados.setec.dao.Cursodao;
import com.agremiados.setec.dao.Instructordao;
import com.agremiados.setec.dao.TrabajadorCursodao;
import com.agremiados.setec.dao.Trabajadordao;
import com.agremiados.setec.dto.TrabajadorCursoDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Cdcs;
import com.agremiados.setec.modelo.Curso;
import com.agremiados.setec.modelo.Instructor;
import com.agremiados.setec.modelo.Trabajador;
import com.agremiados.setec.modelo.TrabajadorCurso;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrabajadorCursoServicioImpl implements Crud<TrabajadorCursoDTO>{
    @Autowired
    private TrabajadorCursodao trabajadorcursodao;
    @Autowired
    private Trabajadordao trabajadordao;
    @Autowired
    private Cursodao cursodao;
    @Autowired  
    private Cdcsdao cdcdao;
    @Autowired
    private Instructordao instructordao;
    
    @Override   
    public TrabajadorCursoDTO findById(String id) {
        TrabajadorCurso trabajadorcurso= trabajadorcursodao.findById(Integer.parseInt(id)).orElse(null);
        TrabajadorCursoDTO trabajadorcursodto=  
                new TrabajadorCursoDTO(trabajadorcurso.getIdtrabajadorCurso(), trabajadorcurso.getAnio(), trabajadorcurso.getCodigocurso(),
                trabajadorcurso.getHoraFin(), trabajadorcurso.getHoraInicio(), trabajadorcurso.getPeriodo(), trabajadorcurso.getIdcurso().getIdcurso(),
                trabajadorcurso.getIdcurso().getNombreCurso(),trabajadorcurso.getIdtrabajador().getIdtrabajador(),
                        trabajadorcurso.getIdtrabajador().getPersona().getNombre()+
                        " "+trabajadorcurso.getIdtrabajador().getPersona().getApPaterno()+" "+
                                trabajadorcurso.getIdtrabajador().getPersona().getApMaterno(),trabajadorcurso.getCdc().getIdCdcs(),trabajadorcurso.getIdinstructor().getIdcursoInstructor());
        return trabajadorcursodto;
    }       

    @Override
    public TrabajadorCursoDTO save(TrabajadorCursoDTO trabajadorcursodto) {
        TrabajadorCurso trabajadorcurso = mapearEntidad(trabajadorcursodto);
        TrabajadorCurso nuevotrabacurso = trabajadorcursodao.save(trabajadorcurso);
        //Trabajador trabajador=trabajadordao.findById(trabajadorcursodto.getIdtrabajador()).orElse(null);
        //trabajador.setTrabajadorCursoList((List<TrabajadorCurso>) trabajadorcurso);
        //trabajadordao.save(trabajador);
        TrabajadorCursoDTO trabadto = mapearTrabajadorCursoDTO(nuevotrabacurso);
        
        return trabadto;
    }
    
    public Object crear(TrabajadorCursoDTO trabajadorcursodto){
        //if((trabajadorcursodao.existsById(trabajadorcursodto.getIdtrabajadorCurso())))
           // return 0;
        //if(!trabajadorcursodao.existsById(trabajadorcursodto.getIdtrabajadorCurso())){
            TrabajadorCurso trabajadorcurso = mapearEntidad(trabajadorcursodto);
            TrabajadorCurso nuevotrabajadorcurso = trabajadorcursodao.save(trabajadorcurso);
            TrabajadorCursoDTO tipocurso = mapearTrabajadorCursoDTO(nuevotrabajadorcurso);
            return tipocurso;
        //}   
       
    }

    @Override
    public entidadRespuesta<TrabajadorCursoDTO> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TrabajadorCursoDTO update(TrabajadorCursoDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private TrabajadorCursoDTO mapearTrabajadorCursoDTO(TrabajadorCurso trabajadorcurso){
        TrabajadorCursoDTO trabajacursoDTO = new TrabajadorCursoDTO();
        
        trabajacursoDTO.setIdtrabajadorCurso(trabajadorcurso.getIdtrabajadorCurso());
        trabajacursoDTO.setAnio(trabajadorcurso.getAnio());
        trabajacursoDTO.setCodigocurso(trabajadorcurso.getCodigocurso());
        trabajacursoDTO.setHoraFin(trabajadorcurso.getHoraFin());
        trabajacursoDTO.setHoraInicio(trabajadorcurso.getHoraInicio());
        trabajacursoDTO.setPeriodo(trabajadorcurso.getPeriodo());
        trabajacursoDTO.setIdcurso(trabajadorcurso.getIdcurso().getIdcurso());
        //trabajacursoDTO.setNombrecurso(trabajadorcurso.getIdcurso().getNombreCurso());
        trabajacursoDTO.setIdtrabajador(trabajadorcurso.getIdtrabajador().getIdtrabajador());
        //trabajacursoDTO.setIdinstructor(trabajadorcurso.getIdinstructor().getIdcursoInstructor());
        return trabajacursoDTO;
    }
    
    private TrabajadorCurso mapearEntidad(TrabajadorCursoDTO trabajadorcursodto){
        //se mapean los datos de la tabla de la base de datos
        TrabajadorCurso trabajadorcurso = new TrabajadorCurso();
                     
        //trabajadorcurso.setIdtrabajadorCurso(trabajadorcursodto.getIdtrabajadorCurso());
        
        trabajadorcurso.setAnio(trabajadorcursodto.getAnio());
        trabajadorcurso.setCodigocurso(trabajadorcursodto.getCodigocurso());
        trabajadorcurso.setHoraFin(trabajadorcursodto.getHoraFin());
        trabajadorcurso.setHoraInicio(trabajadorcursodto.getHoraInicio());
        trabajadorcurso.setPeriodo(trabajadorcursodto.getPeriodo()); 
        
        Curso cursos = cursodao.findById(trabajadorcursodto.getIdurso()).orElse(null);
        trabajadorcurso.setIdcurso(cursos); 
        
        Trabajador trabajador= trabajadordao.findById(trabajadorcursodto.getIdtrabajador()).orElse(null);
        trabajadorcurso.setIdtrabajador(trabajador);
        
        Cdcs cdc = cdcdao.findById(trabajadorcursodto.getCdc()).orElse(null);
        trabajadorcurso.setCdc(cdc);
        
        Instructor instructor = instructordao.findById(trabajadorcursodto.getIdinstructor()).orElse(null);
        trabajadorcurso.setIdinstructor(instructor);
        
        return trabajadorcurso;
    }
    
    public entidadRespuesta<TrabajadorCursoDTO>findAllcursos(int numeroDePagina, int medidaDePagina){
        Integer curso;
       Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);
       Page<TrabajadorCurso> trabajadorPage = trabajadorcursodao.findAll(pageable);
       List<TrabajadorCurso> listaCursos = trabajadorPage.getContent();
       List<TrabajadorCursoDTO> listaCursosDTO= new ArrayList<>();
       
       for(TrabajadorCurso trabajadorcurso : listaCursos){
           if(trabajadorcurso.getCodigocurso()!=null){
               curso=trabajadorcurso.getIdcurso().getIdcurso();
               
               listaCursosDTO.add(new TrabajadorCursoDTO(
               trabajadorcurso.getIdtrabajadorCurso(),
               trabajadorcurso.getAnio(),
               trabajadorcurso.getCodigocurso(),
               trabajadorcurso.getHoraFin(),
               trabajadorcurso.getHoraInicio(),
               trabajadorcurso.getPeriodo(),
               trabajadorcurso.getIdcurso().getIdcurso(),
               trabajadorcurso.getIdcurso().getNombreCurso(),
               trabajadorcurso.getIdtrabajador().getIdtrabajador(),
                       trabajadorcurso.getIdtrabajador().getPersona().getNombre()+
                               " "+trabajadorcurso.getIdtrabajador().getPersona().getApPaterno()+" "+
                               trabajadorcurso.getIdtrabajador().getPersona().getApMaterno(),
                       trabajadorcurso.getCdc().getIdCdcs(),
                       trabajadorcurso.getIdinstructor().getIdcursoInstructor()
               ));
           }
       }
       entidadRespuesta entidadrespuesta= new entidadRespuesta();
       entidadrespuesta.setContenido(listaCursosDTO);
       entidadrespuesta.setNumeroPagina(trabajadorPage.getNumber());
       entidadrespuesta.setMedidaPagina(trabajadorPage.getSize());
       entidadrespuesta.setTotalElementos(trabajadorPage.getTotalElements());
       entidadrespuesta.setTotalPaginas(trabajadorPage.getTotalPages());
       entidadrespuesta.setUltima(trabajadorPage.isLast());
       entidadrespuesta.setPrimera(trabajadorPage.isFirst());
       
       
       return entidadrespuesta;
    }

    public List<TrabajadorCursoDTO>findCusosByTrabajador(String curp){
        Integer curso;
        List<TrabajadorCurso> listaCursos = trabajadorcursodao.findCusosByTrabajador(curp);
        List<TrabajadorCursoDTO> listaCursosDTO= new ArrayList<>();

        for(TrabajadorCurso trabajadorcurso : listaCursos){
            if(trabajadorcurso.getCodigocurso()!=null){
                curso=trabajadorcurso.getIdcurso().getIdcurso();

                listaCursosDTO.add(new TrabajadorCursoDTO(
                        trabajadorcurso.getIdtrabajadorCurso(),
                        trabajadorcurso.getAnio(),
                        trabajadorcurso.getCodigocurso(),
                        trabajadorcurso.getHoraFin(),
                        trabajadorcurso.getHoraInicio(),
                        trabajadorcurso.getPeriodo(),
                        trabajadorcurso.getIdcurso().getIdcurso(),
                        trabajadorcurso.getIdcurso().getNombreCurso(),
                        trabajadorcurso.getIdtrabajador().getIdtrabajador(),
                        trabajadorcurso.getIdtrabajador().getPersona().getNombre()+
                                " "+trabajadorcurso.getIdtrabajador().getPersona().getApPaterno()+" "+
                                trabajadorcurso.getIdtrabajador().getPersona().getApMaterno(),
                        trabajadorcurso.getCdc().getIdCdcs(),
                        trabajadorcurso.getIdinstructor().getIdcursoInstructor()
                ));
            }
        }

        return listaCursosDTO;
    }
    
    public List<TrabajadorCursoDTO>findTallerByInstructor(int cursos, int nominstructor, String mesperiodo){
        Integer curso;
        List<TrabajadorCurso> listaCursos = trabajadorcursodao.findTallerByInstructor(cursos,nominstructor,mesperiodo);
        List<TrabajadorCursoDTO> listaCursosDTO= new ArrayList<>();

        for(TrabajadorCurso trabajadorcurso : listaCursos){
            if(trabajadorcurso.getCodigocurso()!=null){
                curso=trabajadorcurso.getIdcurso().getIdcurso();

                listaCursosDTO.add(new TrabajadorCursoDTO(
                        trabajadorcurso.getIdtrabajadorCurso(),
                        trabajadorcurso.getAnio(),
                        trabajadorcurso.getCodigocurso(),
                        trabajadorcurso.getHoraFin(),
                        trabajadorcurso.getHoraInicio(),
                        trabajadorcurso.getPeriodo(),
                        trabajadorcurso.getIdcurso().getIdcurso(),
                        trabajadorcurso.getIdcurso().getNombreCurso(),
                        trabajadorcurso.getIdtrabajador().getIdtrabajador(),
                        trabajadorcurso.getIdtrabajador().getPersona().getNombre()+
                                " "+trabajadorcurso.getIdtrabajador().getPersona().getApPaterno()+" "+
                                trabajadorcurso.getIdtrabajador().getPersona().getApMaterno(),
                        trabajadorcurso.getCdc().getIdCdcs(),
                        trabajadorcurso.getIdinstructor().getIdcursoInstructor()
                ));
            }
        }

        return listaCursosDTO;
    }
}
