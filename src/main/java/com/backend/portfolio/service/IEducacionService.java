package com.backend.portfolio.service;

import java.util.List;
import com.backend.portfolio.model.Educacion;

public interface IEducacionService {
    
    public List<Educacion> getEducacion();
    
    public void saveEducacion (Educacion edu);
    
    public void deleteEducacion (Long id);
    
    public Educacion findEducacion (Long id);
}
