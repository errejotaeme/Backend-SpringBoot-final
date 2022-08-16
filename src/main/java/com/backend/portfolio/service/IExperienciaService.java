package com.backend.portfolio.service;

import java.util.List;
import com.backend.portfolio.model.Experiencia;

public interface IExperienciaService {
    
    public List<Experiencia> getExperiencias();
    
    public void saveExperiencia (Experiencia expe);
    
    public void deleteExperiencia (Long id);
    
    public Experiencia findExperiencia (Long id);
    
}
