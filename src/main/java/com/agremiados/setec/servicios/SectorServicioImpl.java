/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Sectordao;
import com.agremiados.setec.dto.SectorDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Sector;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class SectorServicioImpl implements Crud<SectorDTO>{
    
    @Autowired
    private Sectordao sectordao;
    
    
    @Override
    public SectorDTO findById(String id) {
        Sector sector = sectordao.findById(id).orElse(null);
        
        SectorDTO sectordto = new SectorDTO(sector.getIdsector(),sector.getNombresector());
        return sectordto;
    }

    @Override
    public SectorDTO save(SectorDTO tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public entidadRespuesta<SectorDTO> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SectorDTO update(SectorDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<SectorDTO> findAll(){
        List<Sector> listasector = sectordao.findAll();
        List<SectorDTO> listaDTO = new ArrayList<>();
        for(Sector sector:listasector)
            listaDTO.add(new SectorDTO(sector.getIdsector(),sector.getNombresector()));
        return listaDTO;
    }
}
