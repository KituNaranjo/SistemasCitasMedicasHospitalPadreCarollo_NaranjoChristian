package com.sistemacitasmedicas.sistemacitasmedicas.repositorio;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClinicaRepositorio extends JpaRepository<Clinica, Integer> {
    Optional<Clinica> findById(Integer clinica_id);
}
