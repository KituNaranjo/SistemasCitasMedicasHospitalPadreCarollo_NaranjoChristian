package com.sistemacitasmedicas.sistemacitasmedicas.servicios;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.DetalleFactura;
import java.util.List;
import java.util.Optional;

public interface DetalleFacturaServicio {
    DetalleFactura save(DetalleFactura detalleFactura);
    Optional<DetalleFactura> get(Integer id);
    List<DetalleFactura> findAll();
}