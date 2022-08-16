package com.backend.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter
@Entity
public class Experiencia {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)    
  private Long id;
  
  private String posicion;
  private String empresa;
  private String tareas;
  private String modalidad;
  private String inicio;
  private String fin;
  
  public Experiencia(){
  }

    public Experiencia(
            Long id, 
            String posicion, 
            String empresa, 
            String tareas, 
            String modalidad, 
            String inicio, 
            String fin) {
        
        this.id = id;
        this.posicion = posicion;
        this.empresa = empresa;
        this.tareas = tareas;
        this.modalidad = modalidad;
        this.inicio = inicio;
        this.fin = fin;
    }
  
    
}
