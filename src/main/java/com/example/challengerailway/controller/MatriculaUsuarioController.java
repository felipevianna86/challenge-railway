package com.example.challengerailway.controller;

import com.example.challengerailway.dto.DadosMatriculaCursoDTO;
import com.example.challengerailway.dto.MatriculaUsuarioDTO;
import com.example.challengerailway.exception.MatriculaNaoEncontradaException;
import com.example.challengerailway.exception.UsuarioNaoEncontradoException;
import com.example.challengerailway.service.MatricularUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula")
public class MatriculaUsuarioController {

    private final MatricularUsuarioService matricularUsuarioService;
    public MatriculaUsuarioController(MatricularUsuarioService matricularUsuarioService){
        this.matricularUsuarioService = matricularUsuarioService;
    }

    @PostMapping
    public ResponseEntity<String> matricularUsuario(@RequestBody final MatriculaUsuarioDTO matriculaUsuarioDTO) throws UsuarioNaoEncontradoException {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.matricularUsuarioService.matricularUsuarioCurso(matriculaUsuarioDTO));
    }

    public ResponseEntity<DadosMatriculaCursoDTO> getDadosMatricula(@PathVariable final String matricula) throws MatriculaNaoEncontradaException {
        return ResponseEntity.ok(this.matricularUsuarioService.getDadosMatricula(matricula));
    }
}
