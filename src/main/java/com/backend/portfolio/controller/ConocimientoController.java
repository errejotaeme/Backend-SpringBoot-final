package com.backend.portfolio.controller;
import com.backend.portfolio.model.Conocimiento;
import com.backend.portfolio.service.IConocimientoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConocimientoController {
    
    @Autowired
    private IConocimientoService conocServ;
    
    @GetMapping("/conocimientos")
    public List<Conocimiento> verConocimientos(){
    return conocServ.getConocimientos();
    }
    
    @PostMapping("/conocimientos")
    public String agregarConocimiento(@RequestBody Conocimiento conoc){
        conocServ.saveConocimiento(conoc);
        return "El registro fue creado correctamente.";
    }
    
    @DeleteMapping("/conocimientos/{id}")
    public String borrarConocimiento(@PathVariable Long id){
        conocServ.deleteConocimiento(id);
        return "El registro fue eliminado correctamente";    
    }
    
    @PutMapping("/conocimientos")
    public String editarConocimiento(@RequestBody Conocimiento conoc) {
        conocServ.saveConocimiento(conoc);
        return "El registro fue editado correctamente.";    
    }    
}
