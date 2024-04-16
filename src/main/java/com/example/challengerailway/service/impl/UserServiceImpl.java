package com.example.challengerailway.service.impl;

import com.example.challengerailway.dto.CadastroUsuarioDTO;
import com.example.challengerailway.model.PessoaFisica;
import com.example.challengerailway.model.Usuario;
import com.example.challengerailway.repository.UsuarioRepository;
import com.example.challengerailway.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UserServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario criar(CadastroUsuarioDTO cadastroUsuarioDTO) {
        this.validaCadastroUsuario(cadastroUsuarioDTO);

        Usuario usuario = new Usuario();
        usuario.setUsuario(cadastroUsuarioDTO.getUsuario());
        usuario.setEmail(cadastroUsuarioDTO.getEmail());
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCpf(cadastroUsuarioDTO.getCpf());
        pessoaFisica.setNome(cadastroUsuarioDTO.getNome());
        pessoaFisica.setDataNascimento(cadastroUsuarioDTO.getDataNascimento());
        usuario.setPessoa(pessoaFisica);

        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findByUsuario(String usuario) {
        return this.usuarioRepository.findByUsuario(usuario);
    }

    private void validaCadastroUsuario(CadastroUsuarioDTO cadastroUsuarioDTO){

        if(this.usuarioRepository.existsByUsuario(cadastroUsuarioDTO.getUsuario())){
            throw new IllegalArgumentException("Este usuário já existe.");
        }
    }
}
