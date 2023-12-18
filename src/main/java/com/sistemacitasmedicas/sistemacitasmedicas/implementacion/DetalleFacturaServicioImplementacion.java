package com.sistemacitasmedicas.sistemacitasmedicas.implementacion;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.DetalleFactura;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.DetalleFacturaRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.DetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaServicioImplementacion implements DetalleFacturaServicio {
    @Autowired
    DetalleFacturaRepositorio detalleFacturaRepositorio;
    @Override
    public DetalleFactura save(DetalleFactura detalleFactura) {
        return detalleFacturaRepositorio.save(detalleFactura);
    }
    @Override
    public Optional<DetalleFactura> get(Integer id) {
        return detalleFacturaRepositorio.findById(id);
    }
    @Override
    public List<DetalleFactura> findAll() {
        return detalleFacturaRepositorio.findAll();
    }
}