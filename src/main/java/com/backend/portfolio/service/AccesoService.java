package com.backend.portfolio.service;

import com.backend.portfolio.model.Acceso;
import com.backend.portfolio.repository.AccesoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccesoService implements IAccesoService{
    
    @Autowired
    private AccesoRepository accesRepo;

    @Override
    public List<Acceso> getAccesos() {
        List<Acceso> listaAccesos = accesRepo.findAll();
        return listaAccesos;
    }
    
    @Override
    public void saveAcceso(Acceso acces) {
        accesRepo.save(acces);
    }

    @Override
    public void deleteAcceso(Long id) {
        accesRepo.deleteById(id);
    }

    @Override
    public Acceso findAcceso(Long id) {
       Acceso acces = accesRepo.findById(id).orElse(null);
       return acces;
    }
    
}
