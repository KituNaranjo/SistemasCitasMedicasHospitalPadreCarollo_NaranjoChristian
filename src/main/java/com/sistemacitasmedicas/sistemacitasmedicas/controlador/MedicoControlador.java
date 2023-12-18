package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Especialidad;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Medico;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.EspecialidadServicio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.MedicoServicio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
@CrossOrigin("*")
public class MedicoControlador {
    @Autowired
    PersonaServicio personaServicio;
    @Autowired
    EspecialidadServicio especialidadServicio;
    @Autowired
    MedicoServicio medicoServicio;
    @PostMapping("/guardarMedicoEspecialidad/{persona_id}/{especialidad_id}")
    public Medico guardarMedicoEspecialidad(@PathVariable("persona_id") Integer persona_id,
                                            @PathVariable("especialidad_id") Integer especialidad_id,
                                            @RequestBody Medico medico) throws Exception {
        List<Medico> medicoEspecialidad = new ArrayList<>();
        Especialidad especialidad = new Especialidad();
        Optional<Especialidad> especialidadOptional = especialidadServicio.get(especialidad_id);
        Persona persona = new Persona();
        Optional<Persona> personaOptional = personaServicio.get(persona_id);
        persona.setPersona_id(personaOptional.get().getPersona_id());
        especialidad.setEspecialidad_id(especialidadOptional.get().getEspecialidad_id());
        if (!personaOptional.isPresent()) {
            throw new Exception("La persona no existe");
        }
        if (!especialidadOptional.isPresent()) {
            throw new Exception("La especialidad no existe");
        }
        medico.setPersona(persona);
        medico.setEspecialidad(especialidad);
        medicoEspecialidad.add(medico);
        return medicoServicio.guardarMedicoEspecialidad(medico,medicoEspecialidad);
    }
    @GetMapping("/listar")
    public List<Medico> listarMedicos(){
        return medicoServicio.listarMedicos();
    }
    @GetMapping("/listar/{medico_id}")
    public ResponseEntity<Medico> listarMedicosId(@PathVariable("medico_id") Integer medico_id){
        return ResponseEntity.status(HttpStatus.OK).body(medicoServicio.obtenerMedicoPorId(medico_id));
    }
}
