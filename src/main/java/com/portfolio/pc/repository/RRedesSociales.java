
package com.portfolio.pc.repository;

import com.portfolio.pc.entity.RedesSociales;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRedesSociales extends JpaRepository<RedesSociales,Integer> {
    public Optional<RedesSociales> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    public Optional<RedesSociales> findById(int id);
    public boolean existsById(int id);

    public List<RedesSociales> findAll();
}
