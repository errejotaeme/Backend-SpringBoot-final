package com.backend.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter
@Entity
public class Educacion {
    
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) 
  private Long id;
  
  private String comentario;
  private String escuela;
  private String fin;
  private String inicio;
  private String titulo;
  
  public Educacion(){
  }

    public Educacion(
            Long id, 
            String comentario, 
            String escuela, 
            String fin, 
            String inicio, 
            String titulo) {
        
        this.id = id;
        this.comentario = comentario;
        this.escuela = escuela;
        this.fin = fin;
        this.inicio = inicio;
        this.titulo = titulo;
    }
  
}
