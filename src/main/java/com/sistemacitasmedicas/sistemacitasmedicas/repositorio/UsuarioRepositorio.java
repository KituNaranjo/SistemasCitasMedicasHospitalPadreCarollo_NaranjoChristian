package com.sistemacitasmedicas.sistemacitasmedicas.repositorio;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByUsername(String usuario);
}

