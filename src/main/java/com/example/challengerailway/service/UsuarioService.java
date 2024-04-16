package com.example.challengerailway.service;

import com.example.challengerailway.dto.CadastroUsuarioDTO;
import com.example.challengerailway.model.Usuario;

public interface UsuarioService {

    Usuario findById(Long id);

    Usuario criar(CadastroUsuarioDTO cadastroUsuarioDTO);

    Usuario findByUsuario(String usuario);
}
