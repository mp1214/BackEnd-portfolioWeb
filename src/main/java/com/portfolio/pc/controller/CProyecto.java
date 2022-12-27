/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pc.controller;

import com.portfolio.pc.Dto.dtoCertificado;
import com.portfolio.pc.Dto.dtoProyecto;
import com.portfolio.pc.Security.Controller.Mensaje;
import com.portfolio.pc.entity.Proyecto;
import com.portfolio.pc.service.SProyecto;
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
@RequestMapping("proyecto")
public class CProyecto {
     @Autowired
     SProyecto sProyecto;
     
      @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list,HttpStatus.OK);
    
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id")int id){
    
    if(!sProyecto.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.BAD_REQUEST);
        
    
    }
    Proyecto proyecto= sProyecto.getOne(id).get();
    return new ResponseEntity(proyecto,HttpStatus.OK);
        }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sProyecto.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe il ID"),HttpStatus.NOT_FOUND);
    }
    sProyecto.delete(id);
    return new ResponseEntity(new Mensaje("Proyecto eliminado"),HttpStatus.OK
            );
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody dtoProyecto dtoproyecto){
    
       
    if(StringUtils.isBlank(dtoproyecto.getProyecto())){
    return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
    }
    if(sProyecto.existsByProyecto(dtoproyecto.getProyecto())){
    return new ResponseEntity(new Mensaje("Ese proyecto ya existe"),HttpStatus.BAD_REQUEST);
    }
        
    Proyecto proyecto= new Proyecto(dtoproyecto.getProyecto(),dtoproyecto.getPath(),dtoproyecto.getImg(),dtoproyecto.getFecha(),dtoproyecto.getRepositorio());
    sProyecto.save(proyecto);
    return new ResponseEntity(new Mensaje("proyecto creado"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody dtoProyecto dtoproyecto){
    if(!sProyecto.existsById(id)){
    return new ResponseEntity(new Mensaje("no existe el id"),HttpStatus.NOT_FOUND);
    }
    if(sProyecto.existsByProyecto(dtoproyecto.getProyecto())&& sProyecto.getByProyecto(dtoproyecto.getProyecto()).get().getId()!=id){
    return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
    
    }
    if(StringUtils.isBlank(dtoproyecto.getProyecto())){
    return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
    }
    
    Proyecto proyecto=sProyecto.getOne(id).get();
    proyecto.setProyecto(dtoproyecto.getProyecto());
    proyecto.setPath(dtoproyecto.getPath());
    proyecto.setImg(dtoproyecto.getImg());
    proyecto.setFecha(dtoproyecto.getFecha());
    proyecto.setRepositorio(dtoproyecto.getRepositorio());
        
    sProyecto.save(proyecto);
    return new ResponseEntity(new Mensaje("Proyecto actualizado"),HttpStatus.OK);
    }
  
}
