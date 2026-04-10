package com.weg.crud_relacionamento.dto.response;

import java.util.List;

public record FuncionarioResponseDto(
        Long id,
        String nome,
        Long assentoId,
        List<Long> projetos
) {
}
