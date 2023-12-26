package com.sistemacitasmedicas.sistemacitasmedicas.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Especialidad;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Medico;

public class EspecialidadTest {

    private Especialidad especialidad;

    @Before
    public void setUp() {
        especialidad = new Especialidad();
    }

    @Test
    public void testEspecialidad() {
        // Configuración
        Integer id = 1;
        String nombreEspecialidad = "Cardiología";

        // Actuar
        especialidad.setEspecialidad_id(id);
        especialidad.setEspecialidad(nombreEspecialidad);

        // Afirmar
        assertEquals(id, especialidad.getEspecialidad_id());
        assertEquals(nombreEspecialidad, especialidad.getEspecialidad());
    }

    @Test
    public void testMedicoEspecialidades() {
        // Configuración
        Medico medico1 = new Medico();
        Medico medico2 = new Medico();

        List<Medico> listaMedicos = new ArrayList<>();
        listaMedicos.add(medico1);
        listaMedicos.add(medico2);

        // Actuar
        especialidad.setMedicoEspecialidades(listaMedicos);

        // Afirmar
        assertEquals(listaMedicos, especialidad.getMedicoEspecialidades());
    }

    @Test
    public void testConstructor() {
        // Configuración
        Integer id = 1;
        String nombreEspecialidad = "Oftalmología";

        // Actuar
        Especialidad nuevaEspecialidad = new Especialidad(id, nombreEspecialidad);

        // Afirmar
        assertEquals(id, nuevaEspecialidad.getEspecialidad_id());
        assertEquals(nombreEspecialidad, nuevaEspecialidad.getEspecialidad());
    }

    @Test
    public void testConstructorConListaMedicos() {
        // Configuración
        Integer id = 1;
        String nombreEspecialidad = "Dermatología";

        Medico medico1 = mock(Medico.class);
        Medico medico2 = mock(Medico.class);

        List<Medico> listaMedicos = new ArrayList<>();
        listaMedicos.add(medico1);
        listaMedicos.add(medico2);

        // Actuar
        Especialidad nuevaEspecialidad = new Especialidad(id, nombreEspecialidad, listaMedicos);

        // Afirmar
        assertEquals(id, nuevaEspecialidad.getEspecialidad_id());
        assertEquals(nombreEspecialidad, nuevaEspecialidad.getEspecialidad());
        assertEquals(listaMedicos, nuevaEspecialidad.getMedicoEspecialidades());
    }
}
