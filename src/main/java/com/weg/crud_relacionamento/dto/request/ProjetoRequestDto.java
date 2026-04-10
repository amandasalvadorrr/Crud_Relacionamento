package com.weg.crud_relacionamento.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProjetoRequestDto(
        @NotBlank(message = "O nome é obrigatório.")
        String nome
) {
}
