package com.sistemacitasmedicas.sistemacitasmedicas.implementacion;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Especialidad;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Medico;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.EspecialidadRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.MedicoRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.EspecialidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServicioImplementacion implements EspecialidadServicio {
    @Autowired
    EspecialidadRepositorio especialidadRepositorio;
    @Autowired
    MedicoRepositorio medicoRepositorio;
    @Override
    public Especialidad guardarEspecialidad(Especialidad especialidades) {
        return especialidadRepositorio.save(especialidades);
    }
    @Override
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepositorio.findAll();
    }
    @Override
    public Especialidad obtenerEspecialidadPorId(Integer id) {
        Optional<Especialidad> especialidadOptional = especialidadRepositorio.findById(id);
        return especialidadOptional.orElse(null);
    }
    @Override
    public Optional<Especialidad> get(Integer id) {
        return especialidadRepositorio.findById(id);
    }
    @Override
    public void eliminarEspecialidadPorId(Integer id) {
        Especialidad especialidad = especialidadRepositorio.findById(id).orElse(null);
        if (especialidad != null) {
            List<Medico> medicos = especialidad.getMedicoEspecialidades();
            for (Medico medico : medicos) {
                medico.setEspecialidad(null);
            }
            medicoRepositorio.saveAll(medicos);
            especialidadRepositorio.deleteById(id);
        }
    }
    @Override
    public Especialidad actualizarEspecialidad(Integer id, Especialidad especialidadActualizada) {
        Optional<Especialidad> optionalEspecialidad = especialidadRepositorio.findById(id);
        if (optionalEspecialidad.isPresent()) {
            Especialidad especialidadExistente = optionalEspecialidad.get();
            especialidadExistente.setEspecialidad(especialidadActualizada.getEspecialidad());
            return especialidadRepositorio.save(especialidadExistente);
        } else {
            return null;
        }
    }
}
