package com.backend.portfolio.service;

import java.util.List;
import com.backend.portfolio.model.Conocimiento;

public interface IConocimientoService {
    
    public List<Conocimiento> getConocimientos();
    
    public void saveConocimiento (Conocimiento conoc);
    
    public void deleteConocimiento (Long id);
    
    public Conocimiento findConocimiento (Long id);
    
}
