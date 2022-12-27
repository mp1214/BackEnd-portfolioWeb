/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pc.service;

import com.portfolio.pc.entity.RedesSociales;
import com.portfolio.pc.repository.RRedesSociales;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRedesSociales  {
    @Autowired 
     RRedesSociales rRedesSociales;
     
      public List<RedesSociales> list(){
        return rRedesSociales.findAll();
        
    }
    public Optional<RedesSociales> getOne(int id) {
        return rRedesSociales.findById(id);
    }
 public Optional<RedesSociales> getByNombre(String titulo){
    return rRedesSociales.findByNombre(titulo);
 }
      public void save(RedesSociales redes) {
        rRedesSociales.save(redes);
    }

    public void delete(int id) {
        rRedesSociales.deleteById(id);
    }

    public boolean existsById(int id) {
        return rRedesSociales.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return rRedesSociales.existsByNombre(nombre);
    }
}
