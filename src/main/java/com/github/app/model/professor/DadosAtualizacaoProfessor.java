package com.github.app.model.professor;

import com.github.app.model.endereco.DadosCadastroEndereco;

// DTO responsável por receber os dados de atualização de um Professor.
public record DadosAtualizacaoProfessor(
    Integer id,
    String nome,
    String email,
    String telefone,
    DadosCadastroEndereco endereco
) {
}
