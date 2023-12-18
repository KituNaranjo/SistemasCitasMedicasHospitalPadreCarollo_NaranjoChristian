package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
@CrossOrigin("*")
public class PersonaControlador {
    @Autowired
    PersonaServicio personaServicio;
    @PostMapping("/crear")
    public ResponseEntity<Persona> registrarPersona(@RequestBody Persona persona) {
        Persona personaGuardada = personaServicio.crearPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaGuardada);
    }
    @GetMapping("/{persona_id}")
    public Persona obtenerPersona(@PathVariable("persona_id")Integer persona_id){
        return personaServicio.obtenerPersonaPorId(persona_id);
    }
    @GetMapping("/persona")
    public Persona obtenerPersonaC(@PathVariable("persona_id")Integer persona_id){
        return personaServicio.obtenerPersonaPorId(persona_id);
    }
    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Integer id) {
        personaServicio.eliminarPersona(id);
    }
    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Integer id, @RequestBody Persona personaActualizada) {
        Persona personaExistente = personaServicio.obtenerPersonaPorId(id);
        if (personaExistente != null) {
            personaExistente.setCedula(personaActualizada.getCedula());
            personaExistente.setNombre(personaActualizada.getNombre());
            personaExistente.setApellido(personaActualizada.getApellido());
            personaExistente.setDireccion(personaActualizada.getDireccion());
            personaExistente.setTelefono(personaActualizada.getTelefono());
            personaExistente.setCorreo(personaActualizada.getCorreo());
            personaExistente.setEstado(personaActualizada.getEstado());
            personaExistente.setFechaNacimiento(personaActualizada.getFechaNacimiento());
            personaExistente.setSexo(personaActualizada.getSexo());
            personaExistente.setTipo(personaActualizada.getTipo());
            return personaServicio.crearPersona(personaExistente);
        } else {
            throw new PersonaNoEncontradaException("No se encontró la persona a actualizar.");
        }
    }
    public class PersonaNoEncontradaException extends RuntimeException {
        public PersonaNoEncontradaException(String mensaje) {
            super(mensaje);
        }
    }
}
