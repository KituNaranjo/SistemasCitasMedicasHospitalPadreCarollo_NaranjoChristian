package com.sistemacitasmedicas.sistemacitasmedicas.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Usuario;

public class UsuarioTest {

    private Usuario usuario;

    @Before
    public void setUp() {
        usuario = new Usuario();
    }

    @Test
    public void testUsuario() {
        // Configuración
        Integer usuarioId = 1;
        String encargo = "General";
        String username = "Christian";
        String password = "1234567";
        boolean estado = true;

        // Actuar
        usuario.setUsuario_id(usuarioId);
        usuario.setEncargo(encargo);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEstado(estado);

        // Afirmar
        assertEquals(usuarioId, usuario.getUsuario_id());
        assertEquals(encargo, usuario.getEncargo());
        assertEquals(username, usuario.getUsername());
        assertEquals(password, usuario.getPassword());
        assertEquals(estado, usuario.getEstado());
    }

    @Test
    public void testRolesPorEncargo() {
        // Configuración
        usuario.setEncargo("General");

        // Actuar
        usuario.asignarRolesPorEncargo();

        // Afirmar
        assertTrue(usuario.getGeneral());
        assertFalse(usuario.getAdministrador());
    }
}
