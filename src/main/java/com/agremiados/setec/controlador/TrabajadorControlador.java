/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agremiados.setec.controlador;

import com.agremiados.setec.dto.CargoDTO;
import com.agremiados.setec.dto.CdcsDTO;
import com.agremiados.setec.dto.RegionDTO;
import com.agremiados.setec.dto.SectorDTO;
import com.agremiados.setec.dto.TrabajadorDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.servicios.CargoServicioImpl;
import com.agremiados.setec.servicios.CdcsServicioImpl;
import com.agremiados.setec.servicios.RegionServicioImpl;
import com.agremiados.setec.servicios.SectorServicioImpl;
import com.agremiados.setec.servicios.TrabajadorServicioImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trabajador")
public class TrabajadorControlador {
    
    @Autowired
    private TrabajadorServicioImpl trabajadorser;
    @Autowired
    private SectorServicioImpl sectorser;
    @Autowired
    private CargoServicioImpl cargoser;
    @Autowired
    private RegionServicioImpl regionser;
    @Autowired
    private CdcsServicioImpl cdcsser;
    
    @GetMapping("/{id}")
    public ResponseEntity <TrabajadorDTO> findByID(@PathVariable(name="id")String id){
        return ResponseEntity.ok(trabajadorser.findById(id));
    }
    
    @GetMapping("/sector/{id}")
    public ResponseEntity<SectorDTO> findByIDSector(@PathVariable(name="id")String id){
        return ResponseEntity.ok(sectorser.findById(id));
    }

    @GetMapping("/term/{term}")
    public List<TrabajadorDTO> findByTerm(@PathVariable(name="term")String term){
        return trabajadorser.findByTerm(term);
    }
    
    @GetMapping("/cargo/{id}")
    public ResponseEntity<CargoDTO> findByIDCargo(@PathVariable(name="id")String id){
        return ResponseEntity.ok(cargoser.findById(id));
    }
    @GetMapping("/region/{id}")
    public ResponseEntity<RegionDTO> findByIDRegion(@PathVariable(name="id")String id){
        return ResponseEntity.ok(regionser.findById(id));
    }
    @GetMapping("/cdcs/{id}")
    public ResponseEntity<CdcsDTO> findByIDCdcs (@PathVariable(name="id")Integer id){
        return ResponseEntity.ok(cdcsser.findById(id));
    }
    
    /**@PostMapping()
    public ResponseEntity <TrabajadorDTO> añadirTrabajador(@RequestBody TrabajadorDTO trabajadordto){
        TrabajadorDTO trabajadorDTO = trabajadorser.save(trabajadordto);
        if(trabajadorDTO == null)
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(trabajadorDTO,HttpStatus.OK);
    }*/

    @PostMapping()
    public ResponseEntity<TrabajadorDTO> crearEmpleado(@RequestBody TrabajadorDTO  trabajadordto) {
        Object obj=trabajadorser.crear(trabajadordto);
        if(!(obj instanceof TrabajadorDTO)){
            if((int)obj ==0){
                return new ResponseEntity<>(null, HttpStatus.FOUND);}
        }
        return new ResponseEntity<>((TrabajadorDTO)obj, HttpStatus.CREATED);

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDTO> actulizarEmpleado(@RequestBody TrabajadorDTO  trabajadordto, @PathVariable (name="id")String id){
        TrabajadorDTO trabajadoractualizado = trabajadorser.update(trabajadordto, id);
        return new ResponseEntity<>(trabajadoractualizado,HttpStatus.OK);
    }
    
    @GetMapping("/page/{page}")
    public entidadRespuesta<TrabajadorDTO> listar(@PathVariable Integer page, @RequestParam(value = "pageSize", 
            defaultValue = "40", required = false)int cantidadPagina){
        return trabajadorser.findAll(page,cantidadPagina);
    }
    @GetMapping("/sector")
    public List<SectorDTO> listarsector(){
        return sectorser.findAll();
    }
    @GetMapping("/cargo")
    public List<CargoDTO> listarcargo(){
        return cargoser.findAll();
    }
    @GetMapping("/region")
    public List<RegionDTO> listarregion(){
        return regionser.findAll();
    }
    @GetMapping("/cdcs")
    public List<CdcsDTO> listarcdcs(){
        return cdcsser.findAll();
    }
}
