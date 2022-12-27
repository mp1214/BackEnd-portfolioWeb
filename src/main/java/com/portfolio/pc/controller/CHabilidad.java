/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pc.controller;

import com.portfolio.pc.Dto.dtoHabilidad;
import com.portfolio.pc.Security.Controller.Mensaje;
import com.portfolio.pc.entity.Habilidad;
import com.portfolio.pc.service.SHabilidad;
import java.util.List;
import javax.validation.Valid;
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
@RequestMapping("/habilidad")
public class CHabilidad {
    @Autowired 
    SHabilidad sHabilidad;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list(){
    List<Habilidad> list = sHabilidad.list();
    return new ResponseEntity(list, HttpStatus.OK);

    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid dtoHabilidad dtohab){
    
    if(StringUtils.isBlank(dtohab.getHabilidad()))
        return new ResponseEntity("El nombre de la habilidad es obligatorio", HttpStatus.BAD_REQUEST);
    if (sHabilidad.existsByHabilidad(dtohab.getHabilidad()))
        return new ResponseEntity("Esa habilidad ya existe",HttpStatus.BAD_REQUEST);
    
    Habilidad habilidad= new Habilidad(dtohab.getHabilidad(), dtohab.getPorcentaje(),dtohab.getIcono());
    sHabilidad.save(habilidad);
    
    return new ResponseEntity("Habilidad agregada", HttpStatus.OK);//new Mensaje("Experienci agregada"),HttpStatus.OK);
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody dtoHabilidad dtohab){
        if(!sHabilidad.existsByid(id))
         return new ResponseEntity("El id no existe",HttpStatus.BAD_REQUEST);
      //if(sExperiencia.existsByCargo(dtoexp.getCargo())&& sExperiencia.getBycargo(dtoexp.getCargo()).get().getId()!= id)
        if(sHabilidad.existsByHabilidad(dtohab.getHabilidad())&& sHabilidad.getByHabilidad(dtohab.getHabilidad()).get().getId()!= id)
         return new ResponseEntity("habilidad ya existe", HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtohab.getHabilidad()))
        {   return new ResponseEntity("El nombre es obligatorio", HttpStatus.BAD_REQUEST);}

        Habilidad hab= sHabilidad.getOne(id).get();
        hab.setHabilidad(dtohab.getHabilidad());
        hab.setPorcentaje(dtohab.getPorcentaje());
        hab.setIcono(dtohab.getIcono());
       
        sHabilidad.save(hab);
        return new ResponseEntity("habilidad actualizada", HttpStatus.OK);
    }  
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sHabilidad.existsByid(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    sHabilidad.delete(id);
    return new ResponseEntity(new Mensaje("Experiencia elimnada"),HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id")int id){
    
            if(!sHabilidad.existsByid(id))
                return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
    
            Habilidad hab= sHabilidad.getOne(id).get();
            return new ResponseEntity(hab,HttpStatus.OK);   
    
    }
}
    

