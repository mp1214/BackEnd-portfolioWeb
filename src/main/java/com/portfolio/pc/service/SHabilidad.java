/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pc.service;

import com.portfolio.pc.entity.Habilidad;
import com.portfolio.pc.repository.RHabilidad;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SHabilidad {
    @Autowired
    RHabilidad rHabilidad;
    
    public List<Habilidad> list(){
    return rHabilidad.findAll();
    }
    
    public Optional<Habilidad> getOne(int id){
    return rHabilidad.findById(id);
    }
    
    public Optional<Habilidad> getByHabilidad(String habilidad){
    return rHabilidad.findByHabilidad(habilidad);
    }
    
    public void save(Habilidad hab){
    rHabilidad.save(hab);
    }
    
    public void delete(int id){
    rHabilidad.deleteById(id);
    }
    
    public boolean existsByid(int id){
    return rHabilidad.existsById(id);
    }
    public boolean existsByHabilidad(String habilidad){
    return rHabilidad.existsByHabilidad(habilidad);
    }
}
