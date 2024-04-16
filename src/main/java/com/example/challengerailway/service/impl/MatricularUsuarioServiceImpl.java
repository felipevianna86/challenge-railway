package com.example.challengerailway.service.impl;

import com.example.challengerailway.DateUtils;
import com.example.challengerailway.dto.DadosMatriculaCursoDTO;
import com.example.challengerailway.dto.MatriculaUsuarioDTO;
import com.example.challengerailway.exception.MatriculaNaoEncontradaException;
import com.example.challengerailway.exception.UsuarioNaoEncontradoException;
import com.example.challengerailway.model.Curso;
import com.example.challengerailway.model.Matricula;
import com.example.challengerailway.model.Usuario;
import com.example.challengerailway.repository.MatriculaRepository;
import com.example.challengerailway.repository.UsuarioRepository;
import com.example.challengerailway.service.CursoService;
import com.example.challengerailway.service.MatricularUsuarioService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MatricularUsuarioServiceImpl implements MatricularUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CursoService cursoService;
    private final MatriculaRepository matriculaRepository;

    public MatricularUsuarioServiceImpl(UsuarioRepository usuarioRepository,
                                        CursoService cursoService,
                                        MatriculaRepository matriculaRepository){
        this.usuarioRepository = usuarioRepository;
        this.cursoService = cursoService;
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public String matricularUsuarioCurso(MatriculaUsuarioDTO matriculaUsuarioDTO) throws UsuarioNaoEncontradoException {

        this.validaUsuario(matriculaUsuarioDTO.getUsuario());

        Matricula matricula = new Matricula();
        matricula.setUsuario(this.getUsuario(matriculaUsuarioDTO.getUsuario()));
        matricula.setCurso(this.getCursoById(matriculaUsuarioDTO.getIdCurso()));
        matricula.setMatricula(this.getNextNumeroMatricula(matricula.getCurso().getSigla()));

        this.matriculaRepository.save(matricula);

        return matricula.getMatricula();
    }

    @Override
    public DadosMatriculaCursoDTO getDadosMatricula(String matricula) throws MatriculaNaoEncontradaException {
        Matricula matriculaDB = this.getDadosMatriculaByMatricula(matricula);

        DadosMatriculaCursoDTO dadosMatriculaCursoDTO = new DadosMatriculaCursoDTO();
        dadosMatriculaCursoDTO.setMatricula(matriculaDB.getMatricula());
        dadosMatriculaCursoDTO.setUsuario(matriculaDB.getUsuario().getUsuario());
        dadosMatriculaCursoDTO.setNomeCurso(matriculaDB.getCurso().getNome());

        return dadosMatriculaCursoDTO;
    }

    private void validaUsuario(String usuario) throws UsuarioNaoEncontradoException {
        if(!this.usuarioRepository.existsByUsuario(usuario)){
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }
    }

    private Usuario getUsuario(String usuario){
        return this.usuarioRepository.findByUsuario(usuario);
    }

    private String getNextNumeroMatricula(String siglaCurso){
        StringBuilder matricula = new StringBuilder();
        matricula.append(DateUtils.getYearByDate(new Date()))
                .append(siglaCurso)
                .append(this.getNextIdMatricula());

        return matricula.toString();
    }

    private Curso getCursoById(Long id){
        return this.cursoService.findById(id);
    }

    private Integer getNextIdMatricula(){
        Integer nextIdMatricula = this.matriculaRepository.findNextIdMatricula();
        return nextIdMatricula == null ? 1 : nextIdMatricula + 1;
    }

    private Matricula getDadosMatriculaByMatricula(String matricula) throws MatriculaNaoEncontradaException {
        Matricula matriculaDB = this.matriculaRepository.findByMatricula(matricula);
        if(matriculaDB == null){
            throw new MatriculaNaoEncontradaException("Matrícula não encontrada.");
        }
        return matriculaDB;
    }
}
