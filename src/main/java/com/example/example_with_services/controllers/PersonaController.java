package com.example.example_with_services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.example_with_services.model.Persona;
import com.example.example_with_services.services.PersonaServiceIMPL;

@RestController
@RequestMapping(path = "/api/v1")
public class PersonaController {
    
    @Autowired  
    private PersonaServiceIMPL implementation;

    @GetMapping
    @RequestMapping(value = "personas", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> allPersonas(){
        // List<Persona> listaPersona = this.implementation.getPersonas();
        return ResponseEntity.status(HttpStatus.OK).body(implementation.getPersonas()); 
    }

    @PostMapping
    @RequestMapping(value = "nueva-persona", method = RequestMethod.POST)
    public ResponseEntity<Object> postPersonas(@RequestBody Persona persona ){
        // Persona createdPersona = this.implementation.createPersona(persona);
       return ResponseEntity.status(HttpStatus.CREATED).body(implementation.createPersona(persona));
    }

    @PutMapping
    @RequestMapping(value = "editar-persona", method = RequestMethod.PUT)
    public ResponseEntity<Object> editPersonas(@RequestBody Persona persona ){
        // Persona editedPersona = this.implementation.editPersona(persona);

        return this.implementation.createPersona(persona);
    }   

    @GetMapping
    @RequestMapping(value = "personas/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findbyIdPersona(@PathVariable Long id){
        // Persona persona = this.implementation.findPersona(id);

        return this.implementation.findPersona(id);
    }

    @DeleteMapping
    @RequestMapping(value = "personas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteByIdPersona(@PathVariable Long id){
        
        return this.implementation.deletePersona(id);
    }

}
