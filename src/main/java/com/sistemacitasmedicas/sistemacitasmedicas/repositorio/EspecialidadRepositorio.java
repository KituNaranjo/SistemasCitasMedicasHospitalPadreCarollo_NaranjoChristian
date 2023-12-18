package com.sistemacitasmedicas.sistemacitasmedicas.repositorio;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EspecialidadRepositorio extends JpaRepository<Especialidad, Integer> {
    Optional<Especialidad> findById(Integer especialidad_id);
}