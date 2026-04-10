package com.weg.crud_relacionamento.mapper;

import com.weg.crud_relacionamento.dto.request.AssentoRequestDto;
import com.weg.crud_relacionamento.dto.response.AssentoResponseDto;
import com.weg.crud_relacionamento.model.Assento;
import org.springframework.stereotype.Component;

@Component
public class AssentoMapper {

    public Assento paraEntidade(AssentoRequestDto requestDto){
        return new Assento(
                requestDto.codigo()
        );
    }

    public AssentoResponseDto paraDto(Assento assento){
        return new AssentoResponseDto(
                assento.getId(),
                assento.getCodigo(),
                assento.getFuncionario().getId()
        );
    }
}
