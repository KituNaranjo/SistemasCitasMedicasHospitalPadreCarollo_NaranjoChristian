package com.sistemacitasmedicas.sistemacitasmedicas.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Cita;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Especialidad;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Medico;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;

public class MedicoTest {

    private Medico medico;

    @Before
    public void setUp() {
        medico = new Medico();
    }

    @Test
    public void testGetterSetter() {
        // Configuración
        Integer id = 1;
        String telefonoConsultorio = "123-456-7890";

        // Actuar
        medico.setMedico_id(id);
        medico.setTelefonoConsultorio(telefonoConsultorio);

        // Afirmar
        assertEquals(id, medico.getMedico_id());
        assertEquals(telefonoConsultorio, medico.getTelefonoConsultorio());
    }

    @Test
    public void testPersona() {
        // Configuración
        Persona persona = mock(Persona.class);

        // Actuar
        medico.setPersona(persona);

        // Afirmar
        assertEquals(persona, medico.getPersona());
    }

    @Test
    public void testEspecialidad() {
        // Configuración
        Especialidad especialidad = mock(Especialidad.class);

        // Actuar
        medico.setEspecialidad(especialidad);

        // Afirmar
        assertEquals(especialidad, medico.getEspecialidad());
    }

    @Test
    public void testMedicoCita() {
        // Configuración
        Cita cita1 = mock(Cita.class);
        Cita cita2 = mock(Cita.class);

        List<Cita> listaCitas = new ArrayList<>();
        listaCitas.add(cita1);
        listaCitas.add(cita2);

        // Actuar
        medico.setMedicoCita(listaCitas);

        // Afirmar
        assertEquals(listaCitas, medico.getMedicoCita());
    }

    @Test
    public void testConstructor() {
        // Configuración
        Integer id = 1;
        String telefonoConsultorio = "987-654-3210";

        // Actuar
        Medico nuevoMedico = new Medico(id, telefonoConsultorio);

        // Afirmar
        assertEquals(id, nuevoMedico.getMedico_id());
        assertEquals(telefonoConsultorio, nuevoMedico.getTelefonoConsultorio());
    }
}
