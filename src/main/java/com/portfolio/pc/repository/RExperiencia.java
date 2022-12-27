
package com.portfolio.pc.repository;

import com.portfolio.pc.entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia,Integer>{
   public Optional<Experiencia> findByCargo(String cargo);
   public boolean existsByCargo(String cargo);
}
