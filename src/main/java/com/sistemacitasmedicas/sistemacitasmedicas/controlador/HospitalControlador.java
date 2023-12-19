package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.*;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.HospitalServicio;
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
@RequestMapping("/hospital")
@CrossOrigin("*")
public class HospitalControlador {
    @Autowired
    HospitalServicio hospitalServicio;
    @Autowired
    MedicoServicio medicoServicio;
    @Autowired
    PersonaServicio personaServicio;
    @PostMapping("/crear/{medico_id}/{persona_id}")
    public Hospital guardarHospital(@PathVariable("medico_id") Integer medico_id,
                                  @PathVariable("persona_id") Integer persona_id,
                                  @RequestBody Hospital hospital) throws Exception{
        List<Hospital> hospitalPersona = new ArrayList<>();
        Persona persona = new Persona();
        Optional<Persona> personaOptional = personaServicio.get(persona_id);
        Medico medico = new Medico();
        Optional<Medico> medicoOptional = medicoServicio.get(medico_id);
        persona.setPersona_id(personaOptional.get().getPersona_id());
        medico.setMedico_id(medicoOptional.get().getMedico_id());
        if (!personaOptional.isPresent()) {
            throw new Exception("No existe la persona");
        }
        if (!medicoOptional.isPresent()) {
            throw new Exception("No existe el medico");
        }
        hospital.setPersona(persona);
        hospital.setMedico(medico);
        hospitalPersona.add(hospital);
        return hospitalServicio.guardarprescripcion(hospital, hospitalPersona);
    }
    @DeleteMapping("/eliminarHospital/{id}")
    public void eliminarHospital(@PathVariable("id") Integer id){
        hospitalServicio.delete(id);
    }
    @GetMapping("/listarHospitals")
    public List<Hospital> listarHospitals() { 
        return hospitalServicio.listarHospital(); 
    }
    @GetMapping("/listar/{hospital_id}")
    public Hospital listarHospitalsId (@PathVariable("hospital_id") Integer hospital_id) {
        return hospitalServicio.obtenerHospitalPorId(hospital_id);  
    }
    @PutMapping("/actualizarHospital/{id}")
    public ResponseEntity<Hospital> actualizarHospital(@PathVariable("id") Integer id, @RequestBody Hospital hospitalActualizada) {
        Hospital hospital = hospitalServicio.actualizarHospital(id, hospitalActualizada);
        if (hospital != null) {
            return ResponseEntity.status(HttpStatus.OK).body(hospital);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}