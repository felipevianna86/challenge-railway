package com.example.challengerailway.service;

import com.example.challengerailway.dto.DadosMatriculaCursoDTO;
import com.example.challengerailway.dto.MatriculaUsuarioDTO;
import com.example.challengerailway.exception.MatriculaNaoEncontradaException;
import com.example.challengerailway.exception.UsuarioNaoEncontradoException;

public interface MatricularUsuarioService {

    String matricularUsuarioCurso(MatriculaUsuarioDTO matriculaUsuarioDTO) throws UsuarioNaoEncontradoException;

    DadosMatriculaCursoDTO getDadosMatricula(String matricula) throws MatriculaNaoEncontradaException;
}
