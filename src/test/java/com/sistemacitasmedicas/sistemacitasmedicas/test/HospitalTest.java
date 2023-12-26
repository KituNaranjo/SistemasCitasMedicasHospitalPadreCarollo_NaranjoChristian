package com.sistemacitasmedicas.sistemacitasmedicas.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Hospital;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Medico;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;

public class HospitalTest {

    private Hospital hospital;

    @Before
    public void setUp() {
        hospital = new Hospital();
    }

    @Test
    public void testHospital() {
        // Configuración
        Integer id = 1;
        String prescripciones = "Prescripciones médicas";
        String ordenes = "Órdenes médicas";
        String certificados = "Certificados médicos";

        // Actuar
        hospital.setHospital_id(id);
        hospital.setPrescripciones(prescripciones);
        hospital.setOrdenes(ordenes);
        hospital.setCertificados(certificados);

        // Afirmar
        assertEquals(id, hospital.getHospital_id());
        assertEquals(prescripciones, hospital.getPrescripciones());
        assertEquals(ordenes, hospital.getOrdenes());
        assertEquals(certificados, hospital.getCertificados());
    }

    @Test
    public void testPersona() {
        // Configuración
        Persona persona = mock(Persona.class);

        // Actuar
        hospital.setPersona(persona);

        // Afirmar
        assertEquals(persona, hospital.getPersona());
    }

    @Test
    public void testMedico() {
        // Configuración
        Medico medico = mock(Medico.class);

        // Actuar
        hospital.setMedico(medico);

        // Afirmar
        assertEquals(medico, hospital.getMedico());
    }

    @Test
    public void testConstructor() {
        // Configuración
        Integer id = 1;
        String prescripciones = "Prescripciones iniciales";
        String ordenes = "Órdenes iniciales";
        String certificados = "Certificados iniciales";

        // Actuar
        Hospital nuevoHospital = new Hospital(id, prescripciones, ordenes, certificados);

        // Afirmar
        assertEquals(id, nuevoHospital.getHospital_id());
        assertEquals(prescripciones, nuevoHospital.getPrescripciones());
        assertEquals(ordenes, nuevoHospital.getOrdenes());
        assertEquals(certificados, nuevoHospital.getCertificados());
    }
}
