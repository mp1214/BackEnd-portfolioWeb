
package com.portfolio.pc.controller;

import com.portfolio.pc.Dto.dtoPersona;
import com.portfolio.pc.Security.Controller.Mensaje;
import com.portfolio.pc.entity.Persona;
import com.portfolio.pc.service.ImpPersonaservice;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"http://localhost:4200","https://portfolio-frontend-5c541.web.app"})
public class PersonaController {
    @Autowired
    ImpPersonaservice personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
    
    if(!personaService.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.BAD_REQUEST);
        
    
    }
    Persona persona= personaService.getOne(id).get();
    return new ResponseEntity(persona,HttpStatus.OK);
        }
    
 /*   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!personaService.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe il ID"),HttpStatus.NOT_FOUND);
    }
    personaService.delete(id);
    return new ResponseEntity(new Mensaje("Persona eliminada"),HttpStatus.OK
            );
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody dtoPersona dtopersona){
    
       
    if(StringUtils.isBlank(dtopersona.getTitulo())){
    return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
    }
    if(sEducacion.existsByTitulo(dtopersona.getTitulo())){
    return new ResponseEntity(new Mensaje("Ese titulo ya existe"),HttpStatus.BAD_REQUEST);
    }
    
    Educacion persona= new Educacion(dtopersona.getTitulo(),dtopersona.getTipopersona(),dtopersona.getInstitucion(),dtopersona.getIcono(),dtopersona.getinicio(),dtopersona.getfin());
    sEducacion.save(persona);
    return new ResponseEntity(new Mensaje("Educacion creada"),HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody dtoPersona dtopersona){
    if(!personaService.existsById(id)){
    return new ResponseEntity(new Mensaje("no existe el id"),HttpStatus.NOT_FOUND);
    }
    if(personaService.existsByNombre(dtopersona.getNombre())&& personaService.getByNombre(dtopersona.getNombre()).get().getId()!=id){
    return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
    
    }
    if(StringUtils.isBlank(dtopersona.getNombre())){
    return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
    }
    
    Persona persona=personaService.getOne(id).get();
    
    persona.setNombre(dtopersona.getNombre());
    persona.setAcercaDeMi(dtopersona.getAcercaDeMi());
    persona.setImg(dtopersona.getImg());
    persona.setApellido(dtopersona.getApellido());
    persona.setEmail(dtopersona.getEmail());
    persona.setTelefono(dtopersona.getTelefono());
    persona.setImgBanner(dtopersona.getImgBanner());
    persona.setTituloEfecto(dtopersona.getTituloEfecto());
    persona.setDomicilio(dtopersona.getDomicilio());
        
    personaService.save(persona);
    return new ResponseEntity(new Mensaje("Persona actualizada"),HttpStatus.OK);
    }
      
    
}
