package com.backend.portfolio.controller;

import com.backend.portfolio.model.Educacion;
import com.backend.portfolio.service.IEducacionService;

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
@CrossOrigin(origins = "https://front-portfolio-angular.web.app/iniciar-sesion")
public class EducacionController {
    
    @Autowired
    private IEducacionService eduServ;
    
    @GetMapping("/educacion")
    public List<Educacion> verEducacion(){
    return eduServ.getEducacion();
    }
    
    @PostMapping("/educacion")
    public String agregarEducacion(@RequestBody Educacion edu){
        eduServ.saveEducacion(edu);
        return "El registro fue creado correctamente.";
    }
    
    @DeleteMapping("/educacion/{id}")
    public String borrarEducacion(@PathVariable Long id){
        eduServ.deleteEducacion(id);
        return "El registro fue eliminado correctamente";    
    }
    
    @PutMapping("/educacion")
    public String editarEducacion(@RequestBody Educacion edu){
        eduServ.saveEducacion(edu);
        return "El registro fue editado correctamente.";
    }
    
}
