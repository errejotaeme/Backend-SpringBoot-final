package com.backend.portfolio.service;

import com.backend.portfolio.model.Conocimiento;
import com.backend.portfolio.repository.ConocimientoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConocimientoService implements IConocimientoService{
    
    @Autowired
    private ConocimientoRepository conocRepo;

    @Override
    public List<Conocimiento> getConocimientos() {
        List<Conocimiento> listaConocimientos = conocRepo.findAll();
        return listaConocimientos;
    }

    @Override
    public void saveConocimiento(Conocimiento conoc) {
        conocRepo.save(conoc);
    }

    @Override
    public void deleteConocimiento(Long id) {
        conocRepo.deleteById(id);
    }

    @Override
    public Conocimiento findConocimiento(Long id) {
        Conocimiento conoc = conocRepo.findById(id).orElse(null);
        return conoc;
    }
    
}
