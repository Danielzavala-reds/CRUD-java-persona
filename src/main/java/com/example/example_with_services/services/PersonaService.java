package com.example.example_with_services.services;

import java.util.List;

import com.example.example_with_services.model.Persona;

public interface PersonaService {
    
    public List<Persona> getPersonas();

    public Persona createPersona(Persona persona);

    public Persona editPersona(Persona persona);

    public Persona findPersona(Long id);

    public void deletePersona( Long id );


}
