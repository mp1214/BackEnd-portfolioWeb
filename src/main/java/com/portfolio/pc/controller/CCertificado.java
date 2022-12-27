
package com.portfolio.pc.controller;
        
import com.portfolio.pc.Dto.dtoCertificado;
import com.portfolio.pc.Security.Controller.Mensaje;
import com.portfolio.pc.entity.Certificados;
import com.portfolio.pc.service.SCertificado;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import javax.validation.Valid;
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
@RequestMapping("certificado")
public class CCertificado {
     @Autowired
     SCertificado sCertificado;
     
      @GetMapping("/lista")
    public ResponseEntity<List<Certificados>> list(){
        List<Certificados> list = sCertificado.list();
        return new ResponseEntity(list,HttpStatus.OK);
    
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Certificados> getById(@PathVariable("id")int id){
    
    if(!sCertificado.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.BAD_REQUEST);
        
    
    }
    Certificados educacion= sCertificado.getOne(id).get();
    return new ResponseEntity(educacion,HttpStatus.OK);
        }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sCertificado.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe il ID"),HttpStatus.NOT_FOUND);
    }
    sCertificado.delete(id);
    return new ResponseEntity(new Mensaje("Certificado eliminado"),HttpStatus.OK
            );
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody dtoCertificado dtocertificado){
    
       
    if(StringUtils.isBlank(dtocertificado.getTitulo())){
    return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
    }
    if(sCertificado.existsByTitulo(dtocertificado.getTitulo())){
    return new ResponseEntity(new Mensaje("Ese titulo ya existe"),HttpStatus.BAD_REQUEST);
    }
    
    Certificados certificado= new Certificados(dtocertificado.getTitulo(),dtocertificado.getImg());
    sCertificado.save(certificado);
    return new ResponseEntity(new Mensaje("Certificado creado"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody dtoCertificado dtocertificado){
    if(!sCertificado.existsById(id)){
    return new ResponseEntity(new Mensaje("no existe el id"),HttpStatus.NOT_FOUND);
    }
    if(sCertificado.existsByTitulo(dtocertificado.getTitulo())&& sCertificado.getByTitulo(dtocertificado.getTitulo()).get().getId()!=id){
    return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
    
    }
    if(StringUtils.isBlank(dtocertificado.getTitulo())){
    return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
    }
    
    Certificados certificado=sCertificado.getOne(id).get();
    certificado.setTitulo(dtocertificado.getTitulo());
    certificado.setImg(dtocertificado.getImg());
    
        
    sCertificado.save(certificado);
    return new ResponseEntity(new Mensaje("Certificado actualizado"),HttpStatus.OK);
    }
      
}
