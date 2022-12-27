package com.portfolio.pc.controller;

import org.apache.commons.lang3.StringUtils;
import com.portfolio.pc.Dto.dtoExperiencia;
import com.portfolio.pc.Security.Controller.Mensaje;
import com.portfolio.pc.entity.Experiencia;
import com.portfolio.pc.service.SExperiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = {"http://localhost:4200","https://portfolio-frontend-5c541.web.app"})
@RequestMapping("explab")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
   @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
    List<Experiencia> list = sExperiencia.list();
    return new ResponseEntity(list, HttpStatus.OK);

    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        System.out.println(dtoexp.getInicio());
   
    
    if(StringUtils.isBlank(dtoexp.getCargo()))
        return new ResponseEntity("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
    if (sExperiencia.existsByCargo(dtoexp.getEmpresa()))
        return new ResponseEntity("Esa experiencia no existe",HttpStatus.BAD_REQUEST);
    
    Experiencia experiencia= new Experiencia(dtoexp.getCargo(), dtoexp.getDescripcion(), dtoexp.getEmpresa(), dtoexp.getEsTrabajoActual(), dtoexp.getInicio(), dtoexp.getFin(), dtoexp.getImgE());
    sExperiencia.save(experiencia);
    
    return new ResponseEntity(dtoexp.getInicio(), HttpStatus.OK);//new Mensaje("Experiencia agregada"),HttpStatus.OK);
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody dtoExperiencia dtoexp){
        if(!sExperiencia.existsById(id))
         return new ResponseEntity("El id no existe",HttpStatus.BAD_REQUEST);
        
        if(sExperiencia.existsByCargo(dtoexp.getCargo())&& sExperiencia.getBycargo(dtoexp.getCargo()).get().getId()!= id)
         return new ResponseEntity("Experiencia ya existe", HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoexp.getCargo()))
        {   return new ResponseEntity("El nombre es obligatorio", HttpStatus.BAD_REQUEST);}

        Experiencia experiencia= sExperiencia.getOne(id).get();
        experiencia.setCargo(dtoexp.getCargo());
        experiencia.setDescripcion(dtoexp.getDescripcion());
        experiencia.setInicio(dtoexp.getInicio());
        experiencia.setFin(dtoexp.getFin());
        experiencia.setImgE(dtoexp.getImgE());
        experiencia.setEsTrabajoActual(dtoexp.getEsTrabajoActual());
        
        sExperiencia.save(experiencia);
        return new ResponseEntity("experiencia actualizada", HttpStatus.OK);
    }  
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sExperiencia.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    sExperiencia.delete(id);
    return new ResponseEntity(new Mensaje("Experiencia elimnada"),HttpStatus.OK);
    }
    
      @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id")int id){
    
    if(!sExperiencia.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.BAD_REQUEST);
        
    
    }
    Experiencia experiencia= sExperiencia.getOne(id).get();
    return new ResponseEntity(experiencia,HttpStatus.OK);
        }
}


