package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.*;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.ClinicaServicio;
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
@RequestMapping("/clinica")
@CrossOrigin("*")
public class ClinicaControlador {
    @Autowired
    ClinicaServicio clinicaServicio;
    @Autowired
    MedicoServicio medicoServicio;
    @Autowired
    PersonaServicio personaServicio;
    @PostMapping("/crear/{medico_id}/{persona_id}")
    public Clinica guardarClinica(@PathVariable("medico_id") Integer medico_id,
                                  @PathVariable("persona_id") Integer persona_id,
                                  @RequestBody Clinica clinica) throws Exception{
        List<Clinica> clinicaPersona = new ArrayList<>();
        Persona persona = new Persona();
        Optional<Persona> personaOptional = personaServicio.get(persona_id);
        Medico medico = new Medico();
        Optional<Medico> medicoOptional = medicoServicio.get(medico_id);
        persona.setPersona_id(personaOptional.get().getPersona_id());
        medico.setMedico_id(medicoOptional.get().getMedico_id());
        if (!personaOptional.isPresent()) {
            throw new Exception("La persona no existe");
        }
        if (!medicoOptional.isPresent()) {
            throw new Exception("El medico no existe");
        }
        clinica.setPersona(persona);
        clinica.setMedico(medico);
        clinicaPersona.add(clinica);
        return clinicaServicio.guardarprescripcion(clinica, clinicaPersona);

    }
    @DeleteMapping("/eliminarClinica/{id}")
    public void eliminarClinica(@PathVariable("id") Integer id){
        clinicaServicio.delete(id);
    }
    @GetMapping("/listarClinicas")
    public List<Clinica> listarClinicas() { return clinicaServicio.listarClinica(); }
    @GetMapping("/listar/{clinica_id}")
    public Clinica listarClinicasId (@PathVariable("clinica_id") Integer clinica_id) {
        return clinicaServicio.obtenerClinicaPorId( clinica_id );  }
    @PutMapping("/actualizarClinica/{id}")
    public ResponseEntity<Clinica> actualizarClinica(@PathVariable("id") Integer id, @RequestBody Clinica clinicaActualizada) {
        Clinica clinica = clinicaServicio.actualizarClinica(id, clinicaActualizada);
        if (clinica != null) {
            return ResponseEntity.status(HttpStatus.OK).body(clinica);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}