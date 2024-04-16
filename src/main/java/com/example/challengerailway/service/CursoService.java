package com.example.challengerailway.service;

import com.example.challengerailway.dto.CadastroCursoDTO;
import com.example.challengerailway.model.Curso;

public interface CursoService {

    Curso findById(Long id);

    Curso findByNome(String nome);

    Curso criar(CadastroCursoDTO cadastroCursoDTO);
}
