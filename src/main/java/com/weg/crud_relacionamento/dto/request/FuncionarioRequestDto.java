package com.weg.crud_relacionamento.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record FuncionarioRequestDto(
        @NotBlank(message = "O nome é obrigatório.")
        String nome,
        Long assentoId,
        List<Long> projetoIds
) {
}
