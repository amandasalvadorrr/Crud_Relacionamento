package com.weg.crud_relacionamento.dto.request;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioRequestDto(
        @NotBlank(message = "O nome é obrigatório.")
        String nome
) {
}
