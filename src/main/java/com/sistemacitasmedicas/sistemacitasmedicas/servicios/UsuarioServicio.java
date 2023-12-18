package com.sistemacitasmedicas.sistemacitasmedicas.servicios;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Usuario;

public interface UsuarioServicio {
    public Usuario guardarUsuario(Usuario usuario) throws Exception;
    public Usuario obtenerUsuario(String username);
    public void eliminarUsuario(Integer id);
}
