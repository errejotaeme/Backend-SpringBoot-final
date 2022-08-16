package com.backend.portfolio.service;

import com.backend.portfolio.model.Persona;
import com.backend.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = persoRepo.findById(id).orElse(null);
        return perso;
    }
    
}
