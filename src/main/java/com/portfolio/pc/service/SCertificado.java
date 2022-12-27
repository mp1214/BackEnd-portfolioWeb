/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pc.service;

import com.portfolio.pc.entity.Certificados;
import com.portfolio.pc.repository.RCertificado;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCertificado {
     @Autowired 
     RCertificado rCertificado;
     
      public List<Certificados> list(){
        return rCertificado.findAll();
        
    }
    public Optional<Certificados> getOne(int id) {
        return rCertificado.findById(id);
    }
 public Optional<Certificados> getByTitulo(String titulo){
    return rCertificado.findByTitulo(titulo);
 }
    public void save(Certificados certi) {
        rCertificado.save(certi);
    }

    public void delete(int id) {
        rCertificado.deleteById(id);
    }

    public boolean existsById(int id) {
        return rCertificado.existsById(id);
    }

    public boolean existsByTitulo(String titulo) {
        return rCertificado.existsByTitulo(titulo);
    }
}

