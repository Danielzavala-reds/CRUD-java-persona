package com.example.example_with_services.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.example_with_services.model.Persona;

public interface PersonaService {
    
    public List<Persona> getPersonas();

    public ResponseEntity<Object> createPersona(Persona persona);

    public Persona editPersona(Persona persona);

    public ResponseEntity<Object> findPersona(Long id);

    public ResponseEntity<Object> deletePersona( Long id );


}
