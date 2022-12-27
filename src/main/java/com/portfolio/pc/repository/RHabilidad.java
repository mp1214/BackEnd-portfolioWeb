/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.pc.repository;

import com.portfolio.pc.entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Repository
@Validated
public interface RHabilidad extends JpaRepository<Habilidad, Integer>{
    Optional<Habilidad>findByHabilidad(String habilidad) ;
    public boolean existsByHabilidad(String habilidad);
}
