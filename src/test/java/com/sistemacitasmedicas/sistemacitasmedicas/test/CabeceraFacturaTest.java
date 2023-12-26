package com.sistemacitasmedicas.sistemacitasmedicas.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.CabeceraFactura;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CabeceraFacturaTest {

    private CabeceraFactura cabeceraFactura;

    @Before
    public void setUp() {
        cabeceraFactura = new CabeceraFactura();
    }

    @Test
    public void testCabeceraFactura() throws ParseException {
        // Configuración
        Integer id = 1;
        String fechaString = "01-01-2023";
        double subtotal = 100.0;
        double totalIva = 20.0;
        double totalFactura = 120.0;
        boolean estado = true;

        // Actuar
        cabeceraFactura.setCabeceraFactura_id(id);
        cabeceraFactura.setFecha(new SimpleDateFormat("dd-MM-yyyy").parse(fechaString));
        cabeceraFactura.setSubtotal(subtotal);
        cabeceraFactura.setTotalIva(totalIva);
        cabeceraFactura.setTotalFactura(totalFactura);
        cabeceraFactura.setEstado(estado);

        // Afirmar
        assertEquals(id, cabeceraFactura.getCabeceraFactura_id());
        assertEquals(new SimpleDateFormat("dd-MM-yyyy").parse(fechaString), cabeceraFactura.getFecha());
        assertEquals(subtotal, cabeceraFactura.getSubtotal(), 0.0);
        assertEquals(totalIva, cabeceraFactura.getTotalIva(), 0.0);
        assertEquals(totalFactura, cabeceraFactura.getTotalFactura(), 0.0);
        assertEquals(estado, cabeceraFactura.getEstado());
    }
}
