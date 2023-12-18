package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Cita;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Medico;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.CitaServicio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.MedicoServicio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cita")
@CrossOrigin("*")
public class CitaControlador {
    @Autowired
    CitaServicio citaServicio;
    @Autowired
    MedicoServicio medicioServicio;
    @Autowired
    PersonaServicio personaServicio;
    @PostMapping("/crear/{medico_id}/{persona_id}")
    public Cita guardarCita(@PathVariable("medico_id") Integer medico_id,
                            @PathVariable("persona_id") Integer persona_id,
                            @RequestBody Cita cita) throws Exception{
        List<Cita> citaMedico = new ArrayList<>();
        Persona persona = new Persona();
        Optional<Persona> personaOptional = personaServicio.get(persona_id);
        Medico medico = new Medico();
        Optional<Medico> medicoOptional = medicioServicio.get(medico_id);
        if (personaOptional.isPresent()) {
            persona.setPersona_id(personaOptional.get().getPersona_id());
        } else {
            throw new Exception("La persona no existe");
        }
        if (medicoOptional.isPresent()) {
            medico.setMedico_id(medicoOptional.get().getMedico_id());
        } else {
            throw new Exception("El medico no existe");
        }
        cita.setPersona(persona);
        cita.setMedico(medico);
        citaMedico.add(cita);
        return citaServicio.guardarCitaMedico(cita, citaMedico);
    }
    @GetMapping("/obtenerCitas")
    public List<Cita> listarCitas(){
        return citaServicio.listarCitas();
    }
}