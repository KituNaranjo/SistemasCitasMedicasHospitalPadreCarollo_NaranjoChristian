package com.sistemacitasmedicas.sistemacitasmedicas.implementacion;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Servicio;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.ServicioRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImplementacion implements ServicioService {
    @Autowired
    ServicioRepositorio servicioRepositorio;
    @Override
    public Servicio save(Servicio servicio) {
        return servicioRepositorio.save(servicio);
    }
    @Override
    public Optional<Servicio> get(Integer servicio_id) {
        return servicioRepositorio.findById(servicio_id);
    }
    @Override
    public Servicio update(Servicio servicio) {
        return servicioRepositorio.save(servicio);
    }
    @Override
    public void delete(Integer id) {
        servicioRepositorio.deleteById(id);
    }
    @Override
    public List<Servicio> findAll() {
        return servicioRepositorio.findAll();
    }
    @Override
    public Servicio obtenerServicioPorServicioId(Integer servicio_id) {
        Optional<Servicio> servicioOptional = servicioRepositorio.findById(servicio_id);
        return servicioOptional.orElse(null);
    }
}
