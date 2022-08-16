package com.backend.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter
@Entity
public class Acceso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    
    private String usuario;
    private String clave;
    
    public Acceso(){
    }

    public Acceso(Long id, String usuario, String clave) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
    }
}
