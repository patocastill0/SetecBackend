/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Regiondao;
import com.agremiados.setec.dto.RegionDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Region;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegionServicioImpl implements Crud<RegionDTO>{
    @Autowired
    private Regiondao regiondao;
    
    @Override
    public RegionDTO findById(String id) {
        Region region = regiondao.findById(id).orElse(null);
        
        RegionDTO regiondto = new RegionDTO(region.getClaveRegion(),region.getNombreRegion());
        return regiondto;
    }

    @Override
    public RegionDTO save(RegionDTO tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public entidadRespuesta<RegionDTO> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegionDTO update(RegionDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<RegionDTO> findAll(){
        List<Region> listregion = regiondao.findAll();
        List<RegionDTO> listaDTO = new ArrayList<>();
        for(Region region:listregion)
            listaDTO.add(new RegionDTO(region.getClaveRegion(),region.getNombreRegion()));
        return listaDTO;
    }
    }
