package com.github.app.model.professor;

import org.springframework.data.jpa.repository.JpaRepository;

// Repositório responsável pelas operações de persistência de Professor.
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
