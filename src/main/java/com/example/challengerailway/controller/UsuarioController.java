package com.example.challengerailway.controller;

import com.example.challengerailway.dto.CadastroUsuarioDTO;
import com.example.challengerailway.model.Usuario;
import com.example.challengerailway.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody @Valid CadastroUsuarioDTO cadastroUsuarioDTO){
        var usuarioCriado = this.usuarioService.criar(cadastroUsuarioDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(usuarioCriado.getId())
                .toUri();
        return ResponseEntity.created(location).body(usuarioCriado);
    }
}
