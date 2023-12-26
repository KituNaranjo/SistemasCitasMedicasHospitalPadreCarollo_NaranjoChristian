package com.sistemacitasmedicas.sistemacitasmedicas.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.CabeceraFactura;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Cita;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Medico;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonaTest {

    private Persona persona;

    @Before
    public void setUp() {
        persona = new Persona();
    }

    @Test
    public void testAsignarRolesPorTipo_Cliente() {
        // Configuración
        persona.setTipo("Cliente");

        // Actuar
        persona.asignarRolesPorTipo();

        // Afirmar
        assertTrue(persona.getCliente());
        assertFalse(persona.getMedico());
        assertFalse(persona.getEmpleado());
    }

    @Test
    public void testAsignarRolesPorTipo_Medico() {
        // Configuración
        persona.setTipo("Medico");

        // Actuar
        persona.asignarRolesPorTipo();

        // Afirmar
        assertFalse(persona.getCliente());
        assertTrue(persona.getMedico());
        assertFalse(persona.getEmpleado());
    }

    @Test
    public void testAsignarRolesPorTipo_Empleado() {
        // Configuración
        persona.setTipo("Empleado");

        // Actuar
        persona.asignarRolesPorTipo();

        // Afirmar
        assertFalse(persona.getCliente());
        assertFalse(persona.getMedico());
        assertTrue(persona.getEmpleado());
    }

    @Test
    public void testAsignarRolesPorTipo_Defecto() {
        // Configuración
        persona.setTipo("OtroTipo");

        // Actuar
        persona.asignarRolesPorTipo();

        // Afirmar
        assertFalse(persona.getCliente());
        assertFalse(persona.getMedico());
        assertFalse(persona.getEmpleado());
    }

    @Test
    public void testPersona() {
        // Configuración
        Integer personaId = 1;
        String cedula = "1751121680";
        String nombre = "Christian";
        String apellido = "Naranjo";
        String direccion = "El Tejar Alto";
        String telefono = "555-1234";
        String correo = "christianitonaranjo@gmail.com";
        String estado = "Activo";
        String fechaNacimiento = "14-03-2003";
        String sexo = "Masculino";
        String tipo = "Cliente";

        // Actuar
        persona.setPersona_id(personaId);
        persona.setCedula(cedula);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setDireccion(direccion);
        persona.setTelefono(telefono);
        persona.setCorreo(correo);
        persona.setEstado(estado);
        persona.setFechaNacimiento(fechaNacimiento);
        persona.setSexo(sexo);
        persona.setTipo(tipo);

        // Afirmar
        assertEquals(personaId, persona.getPersona_id());
        assertEquals(cedula, persona.getCedula());
        assertEquals(nombre, persona.getNombre());
        assertEquals(apellido, persona.getApellido());
        assertEquals(direccion, persona.getDireccion());
        assertEquals(telefono, persona.getTelefono());
        assertEquals(correo, persona.getCorreo());
        assertEquals(estado, persona.getEstado());
        assertEquals(fechaNacimiento, persona.getFechaNacimiento());
        assertEquals(sexo, persona.getSexo());
        assertEquals(tipo, persona.getTipo());
    }

    @Test
    public void testListas() {
        // Configuración
        CabeceraFactura cabeceraFactura = new CabeceraFactura();
        Medico medico = new Medico();
        Cita cita = new Cita();
        Usuario usuario = new Usuario();

        // Actuar
        persona.getCabeceraFacturas().add(cabeceraFactura);
        persona.getMedicoEspecialidades().add(medico);
        persona.getMedicoCita().add(cita);
        persona.getUsuarios().add(usuario);

        // Afirmar
        assertTrue(persona.getCabeceraFacturas().contains(cabeceraFactura));
        assertTrue(persona.getMedicoEspecialidades().contains(medico));
        assertTrue(persona.getMedicoCita().contains(cita));
        assertTrue(persona.getUsuarios().contains(usuario));
    }
}
