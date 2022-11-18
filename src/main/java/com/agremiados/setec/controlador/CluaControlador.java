
package com.agremiados.setec.controlador;

import com.agremiados.setec.dto.CluaDTO;
import com.agremiados.setec.dto.TrabajadorCluaDTO;
import com.agremiados.setec.dto.TrabajadorDTO;
import com.agremiados.setec.entidadrespuesta.entidadRespuesta;
import com.agremiados.setec.servicios.CluaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clua")
public class CluaControlador {
    
    @Autowired
    private CluaServicioImpl cluaservicio;
    
    @GetMapping("{id}")
    public ResponseEntity<CluaDTO> findById(@PathVariable(name="id")String id){
        return ResponseEntity.ok(cluaservicio.findById(id));
    }
    
    
    //@Secured({"ROLE_"})
    @PostMapping()
    public ResponseEntity<CluaDTO> añadirClua(@RequestBody CluaDTO cluadto){
        System.out.println(cluadto.getTrabajadordto().getCurp());
        CluaDTO cluaDTO = cluaservicio.save(cluadto);
        if(cluaDTO == null)
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(cluaDTO,HttpStatus.OK);
    }
     
    @GetMapping("/page/{page}")
    public entidadRespuesta<TrabajadorCluaDTO> listar(@PathVariable Integer page, @RequestParam(value = "pageSize", 
            defaultValue = "70", required = false)int cantidadPagina){
        return cluaservicio.findAllclua(page,cantidadPagina);
    }
}
