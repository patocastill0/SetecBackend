package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Cdcsdao;
import com.agremiados.setec.dto.CdcsDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Cdcs;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CdcsServicioImpl implements Crud<CdcsDTO>{
    
    @Autowired
    private Cdcsdao cdcsdao;

    @Override
    public CdcsDTO findById(String id) {
        Cdcs cdcs = cdcsdao.findById(Integer.SIZE).orElse(null);
        
        CdcsDTO cdcsdto = new CdcsDTO(cdcs.getIdCdcs(),cdcs.getNombreCdc());
        return cdcsdto;
    }
    public CdcsDTO findById(Integer id) {
        Cdcs cdcs = cdcsdao.findById(id).orElse(null);
        
        CdcsDTO cdcsdto = new CdcsDTO(cdcs.getIdCdcs(),cdcs.getNombreCdc());
        return cdcsdto;
    }

    @Override
    public CdcsDTO save(CdcsDTO tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public entidadRespuesta<CdcsDTO> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CdcsDTO update(CdcsDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<CdcsDTO> findAll(){
        List<Cdcs> listacdcs = cdcsdao.findAll();
        List<CdcsDTO> listaDTO = new ArrayList<>();
        for(Cdcs cdcs: listacdcs)
            listaDTO.add(new CdcsDTO(cdcs.getIdCdcs(),cdcs.getNombreCdc()));
        return listaDTO;
    }
}
