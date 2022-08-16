package com.backend.portfolio.repository;

import com.backend.portfolio.model.Conocimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConocimientoRepository extends JpaRepository <Conocimiento, Long> {
    
}
