package com.backend.portfolio.service;

import java.util.List;
import com.backend.portfolio.model.Acceso;

public interface IAccesoService {
    
    public List<Acceso> getAccesos();
        
    public Acceso findAcceso (Long id);
    
    public void saveAcceso (Acceso acces);
    
    public void deleteAcceso (Long id);
    
}
