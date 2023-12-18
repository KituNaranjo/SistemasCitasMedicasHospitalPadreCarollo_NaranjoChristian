package com.sistemacitasmedicas.sistemacitasmedicas.implementacion;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Medico;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.MedicoRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.EspecialidadServicio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoServicioImplementacion implements MedicoServicio {
    @Autowired
    MedicoRepositorio medicoRepositorio;
    @Override
    public Medico guardarMedicoEspecialidad(Medico medico, List<Medico> medicoEspecialidades) throws Exception {
        return medicoRepositorio.save(medico);
    }
    @Override
    public List<Medico> listarMedicos() {

        return medicoRepositorio.findAll();
    }
    @Override
    public Medico obtenerMedicoPorId(Integer id) {
        Optional<Medico> medicoOptional = medicoRepositorio.findById(id);
        return medicoOptional.orElse(null);
    }
    @Override
    public Optional<Medico> get(Integer id) {
        return medicoRepositorio.findById(id);
    }
}