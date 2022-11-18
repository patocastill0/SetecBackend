/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.servicios;

import com.agremiados.setec.dao.Cargodao;
import com.agremiados.setec.dto.CargoDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.modelo.Cargo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoServicioImpl implements Crud<CargoDTO>{
    @Autowired
    private Cargodao cargodao;
    
    @Override
    public CargoDTO findById(String id) {
        Cargo cargo = cargodao.findById(id).orElse(null);
        CargoDTO cargodto = new CargoDTO(cargo.getIdcargo(), cargo.getNombrecargo());
        return cargodto;
    }

    @Override
    public CargoDTO save(CargoDTO tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public entidadRespuesta<CargoDTO> findAll(int numeroDePagina, int medidaDePagina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CargoDTO update(CargoDTO tipo, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<CargoDTO> findAll(){
        List<Cargo> listacargo = cargodao.findAll();
        List<CargoDTO> listaDTO = new ArrayList<>();
        for(Cargo cargo:listacargo)
            listaDTO.add(new CargoDTO(cargo.getIdcargo(), cargo.getNombrecargo()));
        return listaDTO;
    }
}
