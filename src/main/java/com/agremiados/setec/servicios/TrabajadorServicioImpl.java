/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Cargodao;
import com.agremiados.setec.dao.Cdcsdao;
import com.agremiados.setec.dao.Cluadao;
import com.agremiados.setec.dao.Municipiosdao;
import com.agremiados.setec.dao.Personadao;
import com.agremiados.setec.dao.Regiondao;
import com.agremiados.setec.dao.Sectordao;
import com.agremiados.setec.dao.Trabajadordao;
import com.agremiados.setec.dto.CluaDTO;
import com.agremiados.setec.dto.TrabajadorCluaDTO;
import com.agremiados.setec.dto.TrabajadorDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Cargo;
import com.agremiados.setec.modelo.Cdcs;
import com.agremiados.setec.modelo.Clua;
import com.agremiados.setec.modelo.Municipios;
import com.agremiados.setec.modelo.Persona;
import com.agremiados.setec.modelo.Region;
import com.agremiados.setec.modelo.Sector;
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
public class TrabajadorServicioImpl implements Crud<TrabajadorDTO> {
    @Autowired
    private Personadao personadao;
    @Autowired
    private Cargodao cargodao;
    @Autowired
    private Cluadao cluadao;
    @Autowired
    private Regiondao regiondao;
    @Autowired
    private Sectordao sectordao;
    @Autowired
    private Cdcsdao cdcsdao;
    @Autowired
    private Trabajadordao trabajadordao;
    @Autowired
    private Municipiosdao municipiosdao;
    
    
    @Override
    public TrabajadorDTO findById(String id) {
        Trabajador trabajador=trabajadordao.findById(id).orElse(null);
        
        TrabajadorDTO trabajadordto = new TrabajadorDTO(trabajador.getIdtrabajador(), trabajador.getSector().getIdsector(), trabajador.getCargo().getIdcargo(), trabajador.getRegion().getClaveRegion(),
                " ", trabajador.getCdc().getIdCdcs(), trabajador.getFolio(), trabajador.getPersona().getCurp() , trabajador.getPersona().getApPaterno(), trabajador.getPersona().getApMaterno(), 
                trabajador.getPersona().getCalle(), trabajador.getPersona().getCelular(), trabajador.getPersona().getClaveElector(), trabajador.getPersona().getColonia(),
                trabajador.getPersona().getCorreoElectronico(), trabajador.getPersona().getCp(), trabajador.getPersona().getEstadoCivil(), trabajador.getPersona().getFacebook(), trabajador.getPersona().getFechaNacimiento(), 
                trabajador.getPersona().getGenero(), trabajador.getPersona().getInstagram(), trabajador.getPersona().getLocalidad(), trabajador.getPersona().getNombre(), trabajador.getPersona().getNumero(),
                trabajador.getPersona().getSeccion(), trabajador.getPersona().getTelCasa(), trabajador.getPersona().getTipoSanguineo(), trabajador.getPersona().getTwitter(),
                trabajador.getPersona().getMunicipio().getClavemunicipio(),
                trabajador.isHasactanacimiento(),
                trabajador.isHascomprobante(),
                trabajador.isHascurp(),
                trabajador.isHasine());
        return trabajadordto;   
    }

    public List<TrabajadorDTO> findByTerm(String term) {
        String clua=" ";
        List<Trabajador> listaTrabajadores = trabajadordao.findByTerm(term,term,term,term,term);
        List<TrabajadorDTO> listaTrabajadorDTO= new ArrayList<>();

        for (Trabajador trabajador : listaTrabajadores) {
            if(trabajador.getClua()!=null){
                clua=trabajador.getClua().getIdclua();
            }
            listaTrabajadorDTO.add(new TrabajadorDTO(
                    trabajador.getIdtrabajador(), trabajador.getSector().getIdsector(), trabajador.getCargo().getIdcargo(), trabajador.getRegion().getClaveRegion(),
                    clua, trabajador.getCdc().getIdCdcs(), trabajador.getFolio(), trabajador.getPersona().getCurp() , trabajador.getPersona().getApPaterno(), trabajador.getPersona().getApMaterno(),
                    trabajador.getPersona().getCalle(), trabajador.getPersona().getCelular(), trabajador.getPersona().getClaveElector(), trabajador.getPersona().getColonia(),
                    trabajador.getPersona().getCorreoElectronico(), trabajador.getPersona().getCp(), trabajador.getPersona().getEstadoCivil(), trabajador.getPersona().getFacebook(), trabajador.getPersona().getFechaNacimiento(),
                    trabajador.getPersona().getGenero(), trabajador.getPersona().getInstagram(), trabajador.getPersona().getLocalidad(), trabajador.getPersona().getNombre(), trabajador.getPersona().getNumero(),
                    trabajador.getPersona().getSeccion(), trabajador.getPersona().getTelCasa(), trabajador.getPersona().getTipoSanguineo(), trabajador.getPersona().getTwitter(),
                    trabajador.getPersona().getMunicipio().getNombreMunicipio(),
                    trabajador.isHasactanacimiento(),
                    trabajador.isHascomprobante(),
                    trabajador.isHascurp(),
                    trabajador.isHasine()));
        }

        return listaTrabajadorDTO;

    }

    @Override
    public TrabajadorDTO save(TrabajadorDTO trabajadordto) {
        Trabajador trabajador= mapearEntidad(trabajadordto);
        Trabajador nuevoTrabajador=trabajadordao.save(trabajador);
        TrabajadorDTO tipotrabajador= mapearDTO(nuevoTrabajador);
  
        return tipotrabajador;        
    }
    
    public Object crear(TrabajadorDTO trabajadorDTO) {
        if((trabajadordao.existsById(trabajadorDTO.getIdtrabajador())))
            return 0;// significa que el empleado ya existe
        if((!trabajadordao.existsById(trabajadorDTO.getIdtrabajador()))){
            Trabajador trabajador= mapearEntidad(trabajadorDTO);
            Trabajador nuevoTrabajador=trabajadordao.save(trabajador);
            TrabajadorDTO tipotrabajador= mapearDTO(nuevoTrabajador);
  
        return tipotrabajador;
        }   
        return null;     
    }
    
    public String mostrarClua(String dato){
        if(dato==null){
            return " ";
        }else
            return dato;
    }
    
    @Override   
    //@Transactional(readOnly = true)
    public entidadRespuesta<TrabajadorDTO> findAll(int numeroDePagina, int medidaDePagina) {   
       String clua=" ";
       Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);
       Page<Trabajador> trabajadorPage = trabajadordao.findAll(pageable);
       List<Trabajador> listaTrabajadores = trabajadorPage.getContent();
       List<TrabajadorDTO> listaTrabajadorDTO= new ArrayList<>();
       
        for (Trabajador trabajador : listaTrabajadores) {
            if(trabajador.getClua()!=null){
                clua=trabajador.getClua().getIdclua();
            }
            listaTrabajadorDTO.add(new TrabajadorDTO(
            trabajador.getIdtrabajador(), trabajador.getSector().getIdsector(), trabajador.getCargo().getIdcargo(), trabajador.getRegion().getClaveRegion(),
                clua, trabajador.getCdc().getIdCdcs(), trabajador.getFolio(), trabajador.getPersona().getCurp() , trabajador.getPersona().getApPaterno(), trabajador.getPersona().getApMaterno(), 
                trabajador.getPersona().getCalle(), trabajador.getPersona().getCelular(), trabajador.getPersona().getClaveElector(), trabajador.getPersona().getColonia(),
                trabajador.getPersona().getCorreoElectronico(), trabajador.getPersona().getCp(), trabajador.getPersona().getEstadoCivil(), trabajador.getPersona().getFacebook(), trabajador.getPersona().getFechaNacimiento(), 
                trabajador.getPersona().getGenero(), trabajador.getPersona().getInstagram(), trabajador.getPersona().getLocalidad(), trabajador.getPersona().getNombre(), trabajador.getPersona().getNumero(),
                trabajador.getPersona().getSeccion(), trabajador.getPersona().getTelCasa(), trabajador.getPersona().getTipoSanguineo(), trabajador.getPersona().getTwitter(),
                trabajador.getPersona().getMunicipio().getNombreMunicipio(),
                    trabajador.isHasactanacimiento(),
                    trabajador.isHascomprobante(),
                    trabajador.isHascurp(),
                    trabajador.isHasine()));
        }
        entidadRespuesta entidadrespuesta  = new entidadRespuesta();
        entidadrespuesta.setContenido(listaTrabajadorDTO);
        entidadrespuesta.setNumeroPagina(trabajadorPage.getNumber());
        entidadrespuesta.setMedidaPagina(trabajadorPage.getSize());
        entidadrespuesta.setTotalElementos(trabajadorPage.getTotalElements());
        entidadrespuesta.setTotalPaginas(trabajadorPage.getTotalPages());
        entidadrespuesta.setUltima(trabajadorPage.isLast());
        entidadrespuesta.setPrimera(trabajadorPage.isFirst());  
        
        return entidadrespuesta;
               
    }
    
    
    @Override
    public TrabajadorDTO update(TrabajadorDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private TrabajadorDTO mapearDTO(Trabajador trabajador){
        TrabajadorDTO trabajadordto = new TrabajadorDTO();
        trabajadordto.setSector(trabajador.getSector().getNombresector());
        trabajadordto.setCargo(trabajador.getCargo().getNombrecargo());
        trabajadordto.setRegion(trabajador.getRegion().getNombreRegion());
        //trabajadordto.setClua(trabajador.getClua().getIdclua());
        trabajadordto.setCdc(trabajador.getCdc().getIdCdcs());
        trabajadordto.setFolio(trabajador.getFolio());
        trabajadordto.setCurp(trabajador.getPersona().getCurp());
        trabajadordto.setApPaterno(trabajador.getPersona().getApPaterno());
        trabajadordto.setApMaterno(trabajador.getPersona().getApMaterno());
        trabajadordto.setCalle(trabajador.getPersona().getCalle());
        trabajadordto.setCelular(trabajador.getPersona().getCelular());
        trabajadordto.setClaveElector(trabajador.getPersona().getClaveElector());
        trabajadordto.setColonia(trabajador.getPersona().getColonia());
        trabajadordto.setCorreoElectronico(trabajador.getPersona().getCorreoElectronico());
        trabajadordto.setCp(trabajador.getPersona().getCp());
        trabajadordto.setEstadoCivil(trabajador.getPersona().getEstadoCivil());
        trabajadordto.setFacebook(trabajador.getPersona().getFacebook());
        trabajadordto.setFechaNacimiento(trabajador.getPersona().getFechaNacimiento());
        trabajadordto.setGenero(trabajador.getPersona().getGenero());
        trabajadordto.setInstagram(trabajador.getPersona().getInstagram());
        trabajadordto.setLocalidad(trabajador.getPersona().getLocalidad());
        trabajadordto.setNombre(trabajador.getPersona().getNombre());
        trabajadordto.setNumero(trabajador.getPersona().getNumero());
        trabajadordto.setSeccion(trabajador.getPersona().getSeccion());
        trabajadordto.setTelCasa(trabajador.getPersona().getTelCasa());
        trabajadordto.setTipoSanguineo(trabajador.getPersona().getTipoSanguineo());
        trabajadordto.setTwitter(trabajador.getPersona().getTwitter());
        trabajadordto.setMunicipio(trabajador.getPersona().getMunicipio().getNombreMunicipio());
        trabajadordto.setHasactanacimiento(trabajador.isHasactanacimiento());
        trabajadordto.setHascomprobante(trabajador.isHascomprobante());
        trabajadordto.setHascurp(trabajador.isHascurp());
        trabajadordto.setHasine(trabajador.isHasine());
        
        return  trabajadordto;
    }
    
    private Trabajador mapearEntidad(TrabajadorDTO trabajadordto){
        Trabajador trabajador = new Trabajador();
        
        Persona persona = new Persona();
               
        persona.setCurp(trabajadordto.getCurp());
        persona.setApPaterno(trabajadordto.getApPaterno());       
        persona.setApMaterno(trabajadordto.getApMaterno());
        persona.setCalle(trabajadordto.getCalle());
        persona.setCelular(trabajadordto.getCelular());
        persona.setClaveElector(trabajadordto.getClaveElector());
        persona.setColonia(trabajadordto.getColonia());
        persona.setCorreoElectronico(trabajadordto.getCorreoElectronico());
        persona.setCp(trabajadordto.getCp());
        persona.setEstadoCivil(trabajadordto.getEstadoCivil());
        persona.setFacebook(trabajadordto.getFacebook());
        persona.setFechaNacimiento(trabajadordto.getFechaNacimiento());
        persona.setGenero(trabajadordto.getGenero());
        persona.setInstagram(trabajadordto.getInstagram());
        persona.setLocalidad(trabajadordto.getLocalidad());
        persona.setNombre(trabajadordto.getNombre());
        persona.setNumero(trabajadordto.getNumero());
        persona.setSeccion(trabajadordto.getSeccion());
        persona.setTelCasa(trabajadordto.getTelCasa());
        persona.setTipoSanguineo(trabajadordto.getTipoSanguineo());
        persona.setTwitter(trabajadordto.getTwitter());
        
        Municipios municipios = municipiosdao.findById(trabajadordto.getMunicipio()).orElse(null);       
        persona.setMunicipio(municipios);
        
        Persona personaguardada = personadao.save(persona);
        trabajador.setIdtrabajador(trabajadordto.getCurp());
        trabajador.setPersona(personaguardada);
                      
                
        Sector sector = sectordao.findById(trabajadordto.getSector()).orElse(null);
        trabajador.setSector(sector);
        
        Cargo cargo = cargodao.findById(trabajadordto.getCargo()).orElse(null);
        trabajador.setCargo(cargo);
        
        Region region = regiondao.findById(trabajadordto.getRegion()).orElse(null);
        trabajador.setRegion(region);
                     
        Clua clua = cluadao.findById(" ").orElse(null);
        if(clua!= null){
            trabajador.setClua(clua);}
        
        Cdcs cdcs = cdcsdao.findById(trabajadordto.getCdc()).orElse(null);
        trabajador.setCdc(cdcs);
        
        trabajador.setFolio(trabajadordto.getFolio());
        trabajador.setHasactanacimiento(trabajadordto.isHasactanacimiento());
        trabajador.setHascomprobante(trabajadordto.isHascomprobante());
        trabajador.setHascurp(trabajadordto.isHascurp());
        trabajador.setHasine(trabajadordto.isHasine());
               
        return  trabajador;
    }    
}
