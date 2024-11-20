package com.example.ventas.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ventas.model.producto;

@Repository
public interface repository extends JpaRepository<producto, Long> {
    
}
