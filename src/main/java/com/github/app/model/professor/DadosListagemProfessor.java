package com.github.app.model.professor;

// DTO utilizado para listar professores com campos resumidos.
public record DadosListagemProfessor(
    Integer id,
    String nome,
    String email,
    String registro,
    Disciplina disciplina
) {
    public DadosListagemProfessor(Professor professor) {
        this(
            professor.getId(),
            professor.getNome(),
            professor.getEmail(),
            professor.getRegistro(),
            professor.getDisciplina()
        );
    }
}
