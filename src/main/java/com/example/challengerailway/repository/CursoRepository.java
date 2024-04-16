package com.example.challengerailway.repository;

import com.example.challengerailway.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);

    boolean existsByNome(String nome);
}
