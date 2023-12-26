package com.sistemacitasmedicas.sistemacitasmedicas.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.DetalleFactura;

public class DetalleFacturaTest {

    private DetalleFactura detalleFactura;

    @Before
    public void setUp() {
        detalleFactura = new DetalleFactura();
    }

    @Test
    public void testDetalleFactura() {
        // Configuración
        Integer id = 1;
        String nombre = "Servicio A";
        int cantidad = 2;
        double precioUnitario = 50.0;
        double total = 100.0;

        // Actuar
        detalleFactura.setDetalleFactura_id(id);
        detalleFactura.setNombre(nombre);
        detalleFactura.setCantidad(cantidad);
        detalleFactura.setPrecioUnitario(precioUnitario);
        detalleFactura.setTotal(total);

        // Afirmar
        assertEquals(id, detalleFactura.getDetalleFactura_id());
        assertEquals(nombre, detalleFactura.getNombre());
        assertEquals(cantidad, detalleFactura.getCantidad());
        assertEquals(precioUnitario, detalleFactura.getPrecioUnitario(), 0.0);
        assertEquals(total, detalleFactura.getTotal(), 0.0);
    }
}
