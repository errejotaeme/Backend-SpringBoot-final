package com.backend.portfolio.controller;
import com.backend.portfolio.model.Experiencia;
import com.backend.portfolio.service.IExperienciaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://front-portfolio-angular.web.app")
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expeServ;
    
    @GetMapping("/experiencias")
    public List<Experiencia> verExperiencias(){
    return expeServ.getExperiencias();
    }
    
    @PostMapping("/experiencias")
    public String agregarExperiencia(@RequestBody Experiencia expe){
        expeServ.saveExperiencia(expe);
        return "El registro fue creado correctamente.";
    }
    
    @DeleteMapping("/experiencias/{id}")
    public String borrarExperiencia(@PathVariable Long id){
        expeServ.deleteExperiencia(id);
        return "El registro fue eliminado correctamente";    
    }
    
    @PutMapping("/experiencias")
    public String editarExperiencia(@RequestBody Experiencia expe){
        expeServ.saveExperiencia(expe);
        return "El registro fue editado correctamente.";
    }    
}
