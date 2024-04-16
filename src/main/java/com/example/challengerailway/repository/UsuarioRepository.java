package com.example.challengerailway.repository;

import com.example.challengerailway.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByUsuario(String usuario);

    Usuario findByUsuario(String usuario);
}
