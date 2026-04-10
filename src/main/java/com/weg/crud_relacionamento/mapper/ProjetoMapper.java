package com.weg.crud_relacionamento.mapper;

import com.weg.crud_relacionamento.dto.request.ProjetoRequestDto;
import com.weg.crud_relacionamento.dto.response.ProjetoResponseDto;
import com.weg.crud_relacionamento.model.Projeto;
import org.springframework.stereotype.Component;

@Component
public class ProjetoMapper {

    public Projeto paraEntidade(ProjetoRequestDto requestDto){
        return new Projeto(
                requestDto.nome()
        );
    }

    public ProjetoResponseDto paraDto(Projeto projeto){
        return new ProjetoResponseDto(
                projeto.getId(),
                projeto.getNome(),
                projeto.getFuncionarios()
        );
    }
}
