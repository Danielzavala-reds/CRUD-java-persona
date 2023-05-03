package com.example.example_with_services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.example_with_services.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
