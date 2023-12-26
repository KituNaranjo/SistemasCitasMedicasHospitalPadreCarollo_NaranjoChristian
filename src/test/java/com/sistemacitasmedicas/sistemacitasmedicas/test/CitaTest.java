package com.sistemacitasmedicas.sistemacitasmedicas.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Cita;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaTest {

    private Cita cita;

    @Before
    public void setUp() {
        // Configurar cualquier inicialización necesaria antes de cada prueba
        cita = new Cita();
    }

    @Test
    public void testCita() {
        // Configuración
        Integer id = 1;
        LocalDate fechaCita = LocalDate.of(2023, 1, 1);
        LocalTime hora = LocalTime.of(10, 30);
        boolean estado = true;

        // Actuar
        cita.setCita_id(id);
        cita.setFechaCita(fechaCita);
        cita.setHora(hora);
        cita.setEstado(estado);

        // Afirmar
        assertEquals(id, cita.getCita_id());
        assertEquals(fechaCita, cita.getFechaCita());
        assertEquals(hora, cita.getHora());
        assertEquals(estado, cita.isEstado());
    }
}
