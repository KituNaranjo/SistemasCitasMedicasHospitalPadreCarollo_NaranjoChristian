package com.sistemacitasmedicas.sistemacitasmedicas.repositorio;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ServicioRepositorio extends JpaRepository<Servicio, Integer> {
    Optional<Servicio> findById(Integer servicio_id);
}