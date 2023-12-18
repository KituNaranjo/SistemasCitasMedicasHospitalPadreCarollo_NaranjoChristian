package com.sistemacitasmedicas.sistemacitasmedicas.repositorio;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.CabeceraFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CabeceraFacturaRepositorio extends JpaRepository<CabeceraFactura, Integer> {
    Optional<CabeceraFactura> findById(Integer cabeceraFactura_id);
}
