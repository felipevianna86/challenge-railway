package com.example.challengerailway.controller;

import com.example.challengerailway.dto.CadastroCursoDTO;
import com.example.challengerailway.model.Curso;
import com.example.challengerailway.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.cursoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody CadastroCursoDTO cadastroCursoDTO){
        var cursoCriado = this.cursoService.criar(cadastroCursoDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(cursoCriado.getId())
                .toUri();
        return ResponseEntity.created(location).body(cursoCriado);
    }
}
