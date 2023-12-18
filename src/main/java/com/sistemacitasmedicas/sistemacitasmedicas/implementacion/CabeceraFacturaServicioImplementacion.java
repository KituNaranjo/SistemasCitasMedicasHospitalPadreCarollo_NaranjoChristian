package com.sistemacitasmedicas.sistemacitasmedicas.implementacion;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.CabeceraFactura;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.CabeceraFacturaRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.CabeceraFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CabeceraFacturaServicioImplementacion implements CabeceraFacturaServicio {
    @Autowired
    private CabeceraFacturaRepositorio cabeceraFacturaRepositorio;
    @Override
    public List<CabeceraFactura> findAll() {
        return cabeceraFacturaRepositorio.findAll();
    }
    @Override
    public Optional<CabeceraFactura> findById(Integer id) {
        return cabeceraFacturaRepositorio.findById(id);
    }
    @Override
    public CabeceraFactura save(CabeceraFactura cabeceraFactura) {
        return cabeceraFacturaRepositorio.save(cabeceraFactura);
    }
    @Override
    public CabeceraFactura obtenerCabeceraFacturaPorId(Integer cabeceraFactura_id) {
        Optional<CabeceraFactura> cabeceraFacturaOptional = cabeceraFacturaRepositorio.findById(cabeceraFactura_id);
        return cabeceraFacturaOptional.orElse(null);

    }
    @Override
    public Optional<CabeceraFactura> get(Integer id) {
        return cabeceraFacturaRepositorio.findById(id);
    }
}