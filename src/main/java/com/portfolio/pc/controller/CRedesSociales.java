
package com.portfolio.pc.controller;

import com.portfolio.pc.Dto.dtoHabilidad;
import com.portfolio.pc.Dto.dtoRedesSociales;
import com.portfolio.pc.Security.Controller.Mensaje;
import com.portfolio.pc.entity.Habilidad;
import com.portfolio.pc.entity.RedesSociales;
import com.portfolio.pc.service.SHabilidad;
import com.portfolio.pc.service.SRedesSociales;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","https://portfolio-frontend-5c541.web.app"})
@RequestMapping("redes")
public class CRedesSociales {
     @Autowired 
    SRedesSociales sRedesSociales;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list(){
    List<RedesSociales> list = sRedesSociales.list();
    return new ResponseEntity(list, HttpStatus.OK);

    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoRedesSociales dtoredes){
    
    if(StringUtils.isBlank(dtoredes.getNombre()))
        return new ResponseEntity("El nombre de la red social es obligatorio", HttpStatus.BAD_REQUEST);
    if (sRedesSociales.existsByNombre(dtoredes.getNombre()))
        return new ResponseEntity("Esa red ya existe",HttpStatus.BAD_REQUEST);
    
    RedesSociales redes= new RedesSociales(dtoredes.getNombre(), dtoredes.getImagen(),dtoredes.getPath());
    sRedesSociales.save(redes);
    
    return new ResponseEntity("Red social agregada", HttpStatus.OK);//new Mensaje("Experienci agregada"),HttpStatus.OK);
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody dtoRedesSociales dtoredes){
        if(!sRedesSociales.existsById(id))
         return new ResponseEntity("El id no existe",HttpStatus.BAD_REQUEST);
      //if(sExperiencia.existsByCargo(dtoexp.getCargo())&& sExperiencia.getBycargo(dtoexp.getCargo()).get().getId()!= id)
        if(sRedesSociales.existsByNombre(dtoredes.getNombre())&& sRedesSociales.getByNombre(dtoredes.getNombre()).get().getId()!= id)
         return new ResponseEntity("esa red ya existe", HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoredes.getNombre()))
        {   return new ResponseEntity("El nombre es obligatorio", HttpStatus.BAD_REQUEST);}

        RedesSociales red= sRedesSociales.getOne(id).get();
        red.setNombre(dtoredes.getNombre());
        red.setImagen(dtoredes.getImagen());
        red.setPath(dtoredes.getPath());
        
        sRedesSociales.save(red);
        return new ResponseEntity("Red Social actualizada", HttpStatus.OK);
    }  
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sRedesSociales.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    sRedesSociales.delete(id);
    return new ResponseEntity(new Mensaje("Red social elimnada"),HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<RedesSociales> getById(@PathVariable("id")int id){
    
            if(!sRedesSociales.existsById(id))
                return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
    
            RedesSociales red= sRedesSociales.getOne(id).get();
            return new ResponseEntity(red,HttpStatus.OK);   
    
    }
}
