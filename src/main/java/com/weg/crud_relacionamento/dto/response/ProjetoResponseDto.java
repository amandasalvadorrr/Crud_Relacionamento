package com.weg.crud_relacionamento.dto.response;

import com.weg.crud_relacionamento.model.Funcionario;

import java.util.List;

public record ProjetoResponseDto(
        Long id,
        String nome,
        List<Funcionario> funcionarios
) {
}
