package com.backend.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter
@Entity
public class Conocimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private Long progreso;
    
    public Conocimiento(){
    }

    public Conocimiento(Long id, String nombre, Long progreso) {
        this.id = id;
        this.nombre = nombre;
        this.progreso = progreso;
    }   
    
}
