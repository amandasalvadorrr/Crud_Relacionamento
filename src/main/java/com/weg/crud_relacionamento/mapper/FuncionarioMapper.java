package com.weg.crud_relacionamento.mapper;

import com.weg.crud_relacionamento.dto.request.FuncionarioRequestDto;
import com.weg.crud_relacionamento.dto.response.FuncionarioResponseDto;
import com.weg.crud_relacionamento.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario paraEntidade(FuncionarioRequestDto requestDto){
        return new Funcionario(
                requestDto.nome()
        );
    }

    public FuncionarioResponseDto paraDto(Funcionario funcionario){
        return new FuncionarioResponseDto(
                funcionario.getId(),
                funcionario.getNome()
        );
    }
}
