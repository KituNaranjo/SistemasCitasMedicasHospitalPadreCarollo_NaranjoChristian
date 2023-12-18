package com.sistemacitasmedicas.sistemacitasmedicas.repositorio;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositorio extends JpaRepository<Medico,Integer> {
}
