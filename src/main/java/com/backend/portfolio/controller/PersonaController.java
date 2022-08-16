package com.backend.portfolio.controller;
import com.backend.portfolio.model.Persona;
import com.backend.portfolio.service.IPersonaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping("/persona")
    public List<Persona> verPersonas(){
    return persoServ.getPersonas();
    }
    
    @PostMapping("/persona")
    public String agregarPersona(@RequestBody Persona per){
        persoServ.savePersona(per);
        return "El registro fue creado correctamente.";
    }
    
    @DeleteMapping("/persona/{id}")
    public String borrarPersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "El registro fue eliminado correctamente";    
    }
    
    @PutMapping("/persona")
    public String editarPersona(@RequestBody Persona per){
        persoServ.savePersona(per);
        return "El registro fue editado correctamente.";
    }    
}
