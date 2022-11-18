/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Cluadao;
import com.agremiados.setec.dao.Trabajadordao;
import com.agremiados.setec.dto.CluaDTO;
import com.agremiados.setec.dto.TrabajadorCluaDTO;
import com.agremiados.setec.dto.TrabajadorDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Clua;
import com.agremiados.setec.modelo.Trabajador;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
@Service
public class CluaServicioImpl implements Crud<CluaDTO>{
    
    @Autowired
    private Cluadao cluadao;
    @Autowired
    private Trabajadordao trabajadordao;

    @Override
    public CluaDTO findById(String id) {
        Clua clua = cluadao.findById(id).orElse(null);
        CluaDTO cluadto = new CluaDTO(clua.getIdclua(),clua.getEstado(),clua.getFechaCreacion(),
                clua.getVigencia(),clua.getAnioAfiliacion(),null);
        return cluadto;
    }
    
    @Override
    public CluaDTO save(CluaDTO cluadto) {
        Clua clua = mapearClua(cluadto);
        Clua nuevaClua = cluadao.save(clua);
        Trabajador trabajador=trabajadordao.findById(cluadto.getTrabajadordto().getCurp()).orElse(null);
        trabajador.setClua(clua);
        trabajadordao.save(trabajador);
        CluaDTO tipoclua = mapearCluadto(nuevaClua);
        
        return tipoclua;
    }
    
    
    public Object crear(CluaDTO cluadto){
        if((cluadao.existsById(cluadto.getIdclua())))
            return 0;
        if((!cluadao.existsById(cluadto.getIdclua()))){
            Clua clua = mapearClua(cluadto);
            Clua nuevaClua = cluadao.save(clua);
            CluaDTO tipoclua = mapearCluadto(nuevaClua);
        return tipoclua;
        }
        return null;
    }

    @Override
    public entidadRespuesta<CluaDTO> findAll(int numeroDePagina, int medidaDePagina) {
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);
       Page<Clua> cluaPage = cluadao.findAll(pageable);
       List<Clua> listaCluas = cluaPage.getContent();
       List<CluaDTO> listaCluaDTO= new ArrayList<>();
       
       for(Clua clua : listaCluas){
           
           listaCluaDTO.add(new CluaDTO(
           clua.getIdclua(),clua.getEstado(),clua.getFechaCreacion(),clua.getVigencia(),clua.getAnioAfiliacion(), (TrabajadorDTO)clua.getTrabajadorList()
           ));
       }
        entidadRespuesta entidadrespuesta  = new entidadRespuesta();
        entidadrespuesta.setContenido(listaCluaDTO);
        entidadrespuesta.setNumeroPagina(cluaPage.getNumber());
        entidadrespuesta.setMedidaPagina(cluaPage.getSize());
        entidadrespuesta.setTotalElementos(cluaPage.getTotalElements());
        entidadrespuesta.setTotalPaginas(cluaPage.getTotalPages());
        entidadrespuesta.setUltima(cluaPage.isLast());
        entidadrespuesta.setPrimera(cluaPage.isFirst());
         
        return entidadrespuesta;
    }
    
    
    
    @Override
    public CluaDTO update(CluaDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<CluaDTO> findAll(){
        List<Clua> listaclua = cluadao.findAll();
        List<CluaDTO> listaDTO = new ArrayList<>();
        for(Clua clua:listaclua)
            listaDTO.add(new CluaDTO(clua.getIdclua(),clua.getEstado(),clua.getFechaCreacion(),
                    clua.getVigencia(),clua.getAnioAfiliacion(),null));
        return listaDTO;
    }
    private CluaDTO mapearCluadto(Clua clua){
        CluaDTO cluadto = new CluaDTO();
        cluadto.setAnioafiliacion(clua.getAnioAfiliacion());
        cluadto.setEstado(clua.getEstado());
        cluadto.setVigencia(clua.getVigencia());
        cluadto.setFechaCreacion(clua.getFechaCreacion());
        
        return cluadto;
    }
    
    private Clua mapearClua(CluaDTO cluadto){
        
        Clua clua = new Clua();
        
        Trabajador trabajador = trabajadordao.findById(cluadto.getTrabajadordto().getCurp()).orElse(null);
        clua.setIdclua(cluadto.getAnioafiliacion() + trabajador.getSector().getIdsector()
                +trabajador.getCargo().getIdcargo()+trabajador.getPersona().getMunicipio().getClavemunicipio()
                +trabajador.getRegion().getClaveRegion()+trabajador.getFolio());
        
        clua.setEstado(cluadto.getEstado());
        clua.setVigencia(cluadto.getVigencia());
        clua.setFechaCreacion(cluadto.getFechaCreacion());
        clua.setAnioAfiliacion(cluadto.getAnioafiliacion());
        return clua;    
    }
    
    public entidadRespuesta<TrabajadorCluaDTO>findAllclua(int numeroDePagina, int medidaDePagina){
        String clua=" "; 
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);
        Page<Trabajador> trabajadorPage = trabajadordao.findAll(pageable);
        List<Trabajador> listaCluas = trabajadorPage.getContent();
        List<TrabajadorCluaDTO> listaCluaDTO= new ArrayList<>();
        
        for(Trabajador trabajador : listaCluas){
            if(trabajador.getClua()!=null){
                clua=trabajador.getClua().getIdclua();
                
                listaCluaDTO.add(new TrabajadorCluaDTO(
                trabajador.getFolio(),trabajador.getClua().getAnioAfiliacion(),
                trabajador.getSector().getIdsector(),
                trabajador.getCargo().getNombrecargo(),
                trabajador.getPersona().getMunicipio().getClavemunicipio(),
                trabajador.getRegion().getNombreRegion(),
                trabajador.getClua().getFechaCreacion(),
                trabajador.getClua().getEstado(),
                trabajador.getClua().getVigencia()
                /**,trabajador.getIdtrabajador(), trabajador.getSector().getIdsector(), trabajador.getCargo().getIdcargo(), trabajador.getRegion().getClaveRegion(),
                clua, trabajador.getCdc().getIdCdcs(), trabajador.getFolio(), trabajador.getPersona().getCurp() , trabajador.getPersona().getApPaterno(), trabajador.getPersona().getApMaterno(), 
                trabajador.getPersona().getCalle(), trabajador.getPersona().getCelular(), trabajador.getPersona().getClaveElector(), trabajador.getPersona().getColonia(),
                trabajador.getPersona().getCorreoElectronico(), trabajador.getPersona().getCp(), trabajador.getPersona().getEstadoCivil(), trabajador.getPersona().getFacebook(), trabajador.getPersona().getFechaNacimiento(), 
                trabajador.getPersona().getGenero(), trabajador.getPersona().getInstagram(), trabajador.getPersona().getLocalidad(), trabajador.getPersona().getNombre(), trabajador.getPersona().getNumero(),
                trabajador.getPersona().getSeccion(), trabajador.getPersona().getTelCasa(), trabajador.getPersona().getTipoSanguineo(), trabajador.getPersona().getTwitter(),
                trabajador.getPersona().getMunicipio().getNombreMunicipio()**/));
            }
            
            
        }
        entidadRespuesta entidadrespuesta  = new entidadRespuesta();
        entidadrespuesta.setContenido(listaCluaDTO);
        entidadrespuesta.setNumeroPagina(trabajadorPage.getNumber());
        entidadrespuesta.setMedidaPagina(trabajadorPage.getSize());
        entidadrespuesta.setTotalElementos(trabajadorPage.getTotalElements());
        entidadrespuesta.setTotalPaginas(trabajadorPage.getTotalPages());
        entidadrespuesta.setUltima(trabajadorPage.isLast());
        entidadrespuesta.setPrimera(trabajadorPage.isFirst());  
        
        return entidadrespuesta;
    }
    
}
