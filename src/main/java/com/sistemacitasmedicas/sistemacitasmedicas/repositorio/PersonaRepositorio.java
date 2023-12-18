package com.sistemacitasmedicas.sistemacitasmedicas.repositorio;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonaRepositorio extends JpaRepository<Persona,Integer> {
    Persona findByCedula(String cedula);
    Optional<Persona> findById(Integer persona_id);
}
