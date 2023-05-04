package com.example.example_with_services.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.example_with_services.model.Persona;
import com.example.example_with_services.repositories.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonaServiceIMPL implements PersonaService {

    HashMap<String, Object> data = new HashMap<>();

    @Autowired private PersonaRepository repo;

    @Override
    public List<Persona> getPersonas() {
       return this.repo.findAll();
    }

    @Override
    public ResponseEntity<Object> createPersona(Persona persona) {
       Optional<Persona> res = repo.findByClave(persona.getClave());
      
       // persona.setNombre(persona.getNombre());

         if(res.isPresent() && persona.getId() == null ){
            data.put("error", true);
            data.put("msg:", "Ya existe una persona con esa clave");
            return new ResponseEntity<>(data, HttpStatus.CONFLICT);
         }

         data.put("msg: ", "Se guardó correctamente!");

         if( persona.getId() != null ){
            data.put("msg: ", "Se actualizó correctamente!");
         }

        this.repo.save(persona);
        data.put("data", persona);
        
        return new ResponseEntity<>(data, HttpStatus.CREATED);

    }

    @Override
    public Persona editPersona(Persona persona) {
       return this.repo.save(persona);
    }

    @Override
    public ResponseEntity<Object> findPersona(@PathVariable Long id) {

      Optional<Persona> finded = repo.findById(id);

        boolean exists = this.repo.existsById(id);

        if(!exists){
         data.put("error", true);
        data.put("msg:", "No existe la persona con el id: " + '"' + id + '"');
        return new ResponseEntity<>(data, HttpStatus.CONFLICT);
        }

        data.put("data", finded);
        data.put("msg:", "Persona encontrada");
       return new ResponseEntity<>(data, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Object> deletePersona(@PathVariable Long id) {
       boolean exists = this.repo.existsById(id);

       if(!exists){
        data.put("error", true);
        data.put("msg:", "No existe la persona con el id: " + '"' + id + '"');
        return new ResponseEntity<>(data, HttpStatus.CONFLICT);
       }

       data.put("msg:", "Persona eliminada");
       return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }

}
