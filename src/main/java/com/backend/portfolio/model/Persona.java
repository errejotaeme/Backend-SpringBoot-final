package com.backend.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    
    private String email;
    private String nombre;
    private String banner;
    private String foto;
    private String titulo;
    private String descripcion;
    
    public Persona(){
    }

    public Persona(
            Long id, 
            String email, 
            String nombre, 
            String banner, 
            String foto, 
            String titulo, 
            String descripcion) {
        
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.banner = banner;
        this.foto = foto;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }  
    
}
