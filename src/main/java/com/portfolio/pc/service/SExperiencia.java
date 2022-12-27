
package com.portfolio.pc.service;

import com.portfolio.pc.entity.Experiencia;
import com.portfolio.pc.repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list(){
        return rExperiencia.findAll();
        
    }
public Optional<Experiencia> getOne(int id){
    return rExperiencia.findById(id);
}
public Optional<Experiencia> getBycargo(String cargo){
return rExperiencia.findByCargo(cargo);
}
public void save(Experiencia expe){
    rExperiencia.save(expe);
}
public void delete(int id){
    rExperiencia.deleteById(id);
}

public boolean existsById(int id){
    return rExperiencia.existsById(id);
}
public boolean existsByCargo(String cargo){
return rExperiencia.existsByCargo(cargo);
}
}

