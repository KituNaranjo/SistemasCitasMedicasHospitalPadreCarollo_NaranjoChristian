package com.sistemacitasmedicas.sistemacitasmedicas.repositorio;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HospitalRepositorio extends JpaRepository<Hospital, Integer> {
    Optional<Hospital> findById(Integer hospital_id);
}
