/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.pc.repository;


import com.portfolio.pc.entity.Certificados;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCertificado extends JpaRepository<Certificados,Integer>{
     public Optional<Certificados> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
