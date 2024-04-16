package com.example.challengerailway.repository;

import com.example.challengerailway.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query("SELECT max(id) from Matricula")
    Integer findNextIdMatricula();

    Matricula findByMatricula(String matricula);
}
