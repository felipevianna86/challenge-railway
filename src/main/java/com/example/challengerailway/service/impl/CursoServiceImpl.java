package com.example.challengerailway.service.impl;

import com.example.challengerailway.dto.CadastroCursoDTO;
import com.example.challengerailway.exception.CursoExistenteException;
import com.example.challengerailway.exception.CursoNaoEncontradoException;
import com.example.challengerailway.model.Curso;
import com.example.challengerailway.repository.CursoRepository;
import com.example.challengerailway.service.CursoService;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }
    @Override
    public Curso findById(Long id) {
        return this.cursoRepository.findById(id).orElseThrow(() -> new CursoNaoEncontradoException("Curso não encontrado."));
    }

    @Override
    public Curso findByNome(String nome) {
        Curso curso = this.cursoRepository.findByNome(nome);
        if(curso == null){
            throw new CursoNaoEncontradoException("Curso não encontrado.");
        }
        return curso;
    }

    @Override
    public Curso criar(CadastroCursoDTO cadastroCursoDTO) {
        this.validaCursoExistente(cadastroCursoDTO.getNome());

        Curso curso = new Curso();
        curso.setNome(cadastroCursoDTO.getNome());
        curso.setSigla(cadastroCursoDTO.getSigla());

        return this.cursoRepository.save(curso);
    }

    private void validaCursoExistente(String nome){
        if(this.cursoRepository.existsByNome(nome)){
            throw new CursoExistenteException("Curso já existe.");
        }
    }
}
