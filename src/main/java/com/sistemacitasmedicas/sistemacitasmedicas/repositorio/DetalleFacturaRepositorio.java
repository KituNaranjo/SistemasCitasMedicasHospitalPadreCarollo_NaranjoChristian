package com.sistemacitasmedicas.sistemacitasmedicas.repositorio;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFactura, Integer> {
    Optional<DetalleFactura> findById(Integer detalleFactura_id);
}
