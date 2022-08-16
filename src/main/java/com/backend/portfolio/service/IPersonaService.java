package com.backend.portfolio.service;

import java.util.List;
import com.backend.portfolio.model.Persona;


public interface IPersonaService {
    
    public List<Persona> getPersonas();
    
    public void savePersona (Persona per);
    
    public void deletePersona (Long id);
    
    public Persona findPersona (Long id);
    
}
