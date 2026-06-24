package com.github.app.model.aluno;

import com.github.app.model.endereco.DadosCadastroEndereco;

// DTO responsável por receber os dados de atualização de um Aluno.
public record DadosAtualizacaoAluno(
    Integer id,
    String nome,
    String telefone,
    String curso,
    DadosCadastroEndereco endereco
) {
}
