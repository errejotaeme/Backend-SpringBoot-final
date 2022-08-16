package com.backend.portfolio.service;

import com.backend.portfolio.model.Experiencia;
import com.backend.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository expeRepo;

    @Override
    public List<Experiencia> getExperiencias() {
        List<Experiencia> listaExperiencia = expeRepo.findAll();
        return listaExperiencia;
    }

    @Override
    public void saveExperiencia(Experiencia expe) {
        expeRepo.save(expe);
    }

    @Override
    public void deleteExperiencia(Long id) {
        expeRepo.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia expe = expeRepo.findById(id).orElse(null);
        return expe;
    }
    
}
