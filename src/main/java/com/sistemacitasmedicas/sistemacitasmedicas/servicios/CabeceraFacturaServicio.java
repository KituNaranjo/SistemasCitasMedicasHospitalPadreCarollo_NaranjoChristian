package com.sistemacitasmedicas.sistemacitasmedicas.servicios;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.CabeceraFactura;
import java.util.List;
import java.util.Optional;

public interface CabeceraFacturaServicio {
    List<CabeceraFactura> findAll();
    Optional<CabeceraFactura> findById(Integer id);
    CabeceraFactura save(CabeceraFactura cabeceraFactura);
    CabeceraFactura obtenerCabeceraFacturaPorId(Integer cabeceraFactura_id);
    Optional<CabeceraFactura> get(Integer id);
}