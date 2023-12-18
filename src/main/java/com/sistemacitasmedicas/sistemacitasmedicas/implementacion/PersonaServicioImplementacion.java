package com.sistemacitasmedicas.sistemacitasmedicas.implementacion;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.PersonaRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServicioImplementacion implements PersonaServicio {
    @Autowired
    private PersonaRepositorio personaRepositorio;
    public Persona obtenerPersonaPorId(Integer persona_id) {
        Optional<Persona> personaOptional = personaRepositorio.findById(persona_id);
        return personaOptional.orElse(null);
    }
    public Persona crearPersona(Persona persona) {
        Persona personaExistente = personaRepositorio.findByCedula(persona.getCedula());
        if (personaExistente != null && personaExistente.equals(persona.getCedula())) {
            throw new PersonaExistenteException("Existe una persona con la misma cédula.");
        }
        persona.asignarRolesPorTipo();
        return personaRepositorio.save(persona);
    }
    public void eliminarPersona(Integer id) {
        Optional<Persona> personaOptional = personaRepositorio.findById(id);
        personaOptional.ifPresent(personaRepositorio::delete);
    }
    @Override
    public Optional<Persona> get(Integer persona_id) {
        return personaRepositorio.findById(persona_id);
    }
    @Override
    public List<Persona> listarPersonas() {
        return personaRepositorio.findAll();
    }
    public Persona actualizarPersona(Persona persona) {
        Optional<Persona> personaExistente = personaRepositorio.findById(persona.getPersona_id());
        if (!personaExistente.isPresent()) {
            throw new PersonaNoEncontradaException("Persona a actualizar no encontrado.");
        }
        Persona personaActualizada = personaExistente.get();
        personaActualizada.setCedula(persona.getCedula());
        personaActualizada.setNombre(persona.getNombre());
        personaActualizada.setApellido(persona.getApellido());
        personaActualizada.setDireccion(persona.getDireccion());
        personaActualizada.setTelefono(persona.getTelefono());
        personaActualizada.setCorreo(persona.getCorreo());
        personaActualizada.setEstado(persona.getEstado());
        personaActualizada.setFechaNacimiento(persona.getFechaNacimiento());
        personaActualizada.setSexo(persona.getSexo());
        personaActualizada.setTipo(persona.getTipo());
        personaActualizada.setCliente(persona.getCliente());
        personaActualizada.setMedico(persona.getMedico());
        personaActualizada.setEmpleado(persona.getEmpleado());
        return personaRepositorio.save(personaActualizada);
    }
    public class PersonaExistenteException extends RuntimeException {
        public PersonaExistenteException(String message) {
            super(message);
        }
    }
    public class PersonaNoEncontradaException extends RuntimeException {
        public PersonaNoEncontradaException(String mensaje) {
            super(mensaje);
        }
    }
}