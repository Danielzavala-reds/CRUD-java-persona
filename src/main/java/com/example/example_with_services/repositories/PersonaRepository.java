package com.example.example_with_services.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.example_with_services.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    // @Query("SELECT * FROM humano h WHERE h.clave = ?")

    Optional<Persona> findByClave(Integer clave);

}
