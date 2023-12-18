package com.sistemacitasmedicas.sistemacitasmedicas.implementacion;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Usuario;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.PersonaRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.UsuarioRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServicioImplementacion implements UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private PersonaRepositorio personaRepositorio;
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        Persona persona = personaRepositorio.findById(usuario.getPersona().getPersona_id())
                .orElseThrow(() -> new Exception("Persona no encontrada"));
        usuario.setPersona(persona);
        usuario.asignarRolesPorEncargo();
        return usuarioRepositorio.save(usuario);
    }
    @Override
    public Usuario obtenerUsuario(String username) {
        Optional<Usuario> usuario = usuarioRepositorio.findByUsername(username);
        return usuario.orElse(null);
    }
    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepositorio.deleteById(id);
    }
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        Optional<Usuario> usuarioExistente = usuarioRepositorio.findByUsername(usuario.getUsername());
        if (!usuarioExistente.isPresent()) {
            throw new Exception("Usuario no encontrado");
        }
        Persona persona = personaRepositorio.findById(usuario.getPersona().getPersona_id())
                .orElseThrow(() -> new Exception("Persona no encontrada"));
        Usuario usuarioActualizado = usuarioExistente.get();
        usuarioActualizado.setEncargo(usuario.getEncargo());
        usuarioActualizado.setUsername(usuario.getUsername());
        usuarioActualizado.setPassword(usuario.getPassword());
        usuarioActualizado.setEstado(usuario.getEstado());
        usuarioActualizado.setGeneral(usuario.getGeneral());
        usuarioActualizado.setAdministrador(usuario.getAdministrador());
        usuarioActualizado.setPersona(persona);
        return usuarioRepositorio.save(usuarioActualizado);
    }
}
