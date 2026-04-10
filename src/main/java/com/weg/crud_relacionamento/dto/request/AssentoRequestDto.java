package com.weg.crud_relacionamento.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AssentoRequestDto(
        @NotBlank(message = "O código é obrigatório")
        String codigo
){
}
