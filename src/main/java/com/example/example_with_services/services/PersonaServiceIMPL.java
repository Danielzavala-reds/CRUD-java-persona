package com.example.example_with_services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example_with_services.model.Persona;
import com.example.example_with_services.repositories.PersonaRepository;

@Service
public class PersonaServiceIMPL implements PersonaService {


    @Autowired
    private  PersonaRepository repo;

    @Override
    public List<Persona> getPersonas() {
        return (List<Persona>) this.repo.findAll();
    }

    @Override
    public Persona createPersona(Persona persona) {
        persona.setNombre(persona.getNombre());
        return this.repo.save(persona);

    }

    @Override
    public Persona editPersona(Persona persona) {
       return this.repo.save(persona);
    }

    @Override
    public Persona findPersona(Long id) {
       
        return this.repo.findById(id).get();

    }

    @Override
    public void deletePersona(Long id) {
       this.repo.deleteById(id);
    }

  

}
