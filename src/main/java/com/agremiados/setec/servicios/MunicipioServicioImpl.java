/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Municipiosdao;
import com.agremiados.setec.dto.MunicipiosDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Municipios;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioServicioImpl implements Crud<MunicipiosDTO> {
    
    @Autowired
    private Municipiosdao munidao;
    
    @Override   
    public MunicipiosDTO findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<MunicipiosDTO> findByTerm(String term) {
        
        List<Municipios> listaMunicipios = munidao.findByTerminoMunicipio(term,term);
        List<MunicipiosDTO> listaMunicipiosDTO= new ArrayList<>();

        for (Municipios municipios : listaMunicipios) {
            
            listaMunicipiosDTO.add(new MunicipiosDTO(
                    municipios.getClavemunicipio(), municipios.getNombreMunicipio(),municipios.getCabeceraMunicipal()));
        }
        return listaMunicipiosDTO;
    }
    
    @Override
    public MunicipiosDTO save(MunicipiosDTO tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public entidadRespuesta<MunicipiosDTO> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MunicipiosDTO update(MunicipiosDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<MunicipiosDTO> findAll(){
        List<Municipios> listamuni = munidao.findAll();
        List<MunicipiosDTO> listaDTO = new ArrayList<>();
        for(Municipios municipios:listamuni)
            listaDTO.add(new MunicipiosDTO(municipios.getClavemunicipio(), municipios.getNombreMunicipio(), municipios.getCabeceraMunicipal()));
        return listaDTO;
    }
    
}
