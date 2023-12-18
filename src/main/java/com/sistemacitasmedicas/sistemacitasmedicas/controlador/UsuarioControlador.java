package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Usuario;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.PersonaRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private PersonaRepositorio personaRepositorio;
    @PostMapping("/registrar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        Persona persona = personaRepositorio.findById(usuario.getPersona().getPersona_id())
                .orElseThrow(() -> new Exception("Persona no encontrada"));
        usuario.setPersona(persona);
        return usuarioServicio.guardarUsuario(usuario);
    }
    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username) {
        return usuarioServicio.obtenerUsuario(username);
    }
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Integer usuarioId) {
        usuarioServicio.eliminarUsuario(usuarioId);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario usuarioBD = usuarioServicio.obtenerUsuario(usuario.getUsername());
        if (usuarioBD != null && usuarioBD.getPassword().equals(usuario.getPassword())) {
            return ResponseEntity.ok().body("{\"message\": \"Inicio de sesión exitoso\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Credenciales de inicio de sesión inválidas\"}");
        }
    }
    @PutMapping("/{username}")
    public Usuario actualizarUsuario(@PathVariable("username") String username, @RequestBody Usuario usuario) throws Exception {
        Usuario usuarioExistente = usuarioServicio.obtenerUsuario(username);
        if (usuarioExistente == null) {
            throw new Exception("Usuario no encontrado");
        }
        Persona persona = personaRepositorio.findById(usuario.getPersona().getPersona_id())
                .orElseThrow(() -> new Exception("Persona no encontrada"));
        usuarioExistente.setEncargo(usuario.getEncargo());
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setPassword(usuario.getPassword());
        usuarioExistente.setEstado(usuario.getEstado());
        usuarioExistente.setGeneral(usuario.getGeneral());
        usuarioExistente.setAdministrador(usuario.getAdministrador());
        usuarioExistente.setPersona(persona);
        return usuarioServicio.guardarUsuario(usuarioExistente);
    }
}
