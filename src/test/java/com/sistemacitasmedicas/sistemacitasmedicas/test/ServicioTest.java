package com.sistemacitasmedicas.sistemacitasmedicas.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.DetalleFactura;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Servicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioTest {

    private Servicio servicio;

    @Before
    public void setUp() {
        servicio = new Servicio();
    }

    @Test
    public void testServicio() {
        // Configuración
        Integer servicioId = 1;
        String nombreServicio = "Consulta Médica";
        double precio = 50.0;
        double iva = 10.0;
        int cantidad = 1;
        String estado = "Activo";

        // Actuar
        servicio.setServicio_id(servicioId);
        servicio.setNombreServicio(nombreServicio);
        servicio.setPrecio(precio);
        servicio.setIva(iva);
        servicio.setCantidad(cantidad);
        servicio.setEstado(estado);

        // Afirmar
        assertEquals(servicioId, servicio.getServicio_id());
        assertEquals(nombreServicio, servicio.getNombreServicio());
        assertEquals(precio, servicio.getPrecio(), 0.0);
        assertEquals(iva, servicio.getIva(), 0.0);
        assertEquals(cantidad, servicio.getCantidad());
        assertEquals(estado, servicio.getEstado());
    }

    @Test
    public void testListaDetallesFacturas() {
        // Configuración
        DetalleFactura detalleFactura1 = new DetalleFactura();
        DetalleFactura detalleFactura2 = new DetalleFactura();
        DetalleFactura detalleFactura3 = new DetalleFactura();

        List<DetalleFactura> detallesFacturas = new ArrayList<>();
        detallesFacturas.add(detalleFactura1);
        detallesFacturas.add(detalleFactura2);

        // Actuar
        servicio.setDetallesFacturas(detallesFacturas);

        // Afirmar
        assertTrue(servicio.getDetallesFacturas().contains(detalleFactura1));
        assertTrue(servicio.getDetallesFacturas().contains(detalleFactura2));
        assertFalse(servicio.getDetallesFacturas().contains(detalleFactura3));
    }
}
