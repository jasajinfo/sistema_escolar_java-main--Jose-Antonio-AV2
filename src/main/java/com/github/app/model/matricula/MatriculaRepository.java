package com.github.app.model.matricula;

import org.springframework.data.jpa.repository.JpaRepository;

// Repositório responsável pelas operações de persistência de Matricula.
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}
