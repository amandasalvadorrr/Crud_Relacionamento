package com.weg.crud_relacionamento.service;

import com.weg.crud_relacionamento.dto.request.FuncionarioRequestDto;
import com.weg.crud_relacionamento.dto.response.FuncionarioResponseDto;
import com.weg.crud_relacionamento.mapper.FuncionarioMapper;
import com.weg.crud_relacionamento.model.Assento;
import com.weg.crud_relacionamento.model.Funcionario;
import com.weg.crud_relacionamento.model.Projeto;
import com.weg.crud_relacionamento.repository.AssentoRepository;
import com.weg.crud_relacionamento.repository.FuncionarioRepository;
import com.weg.crud_relacionamento.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;
    private final ProjetoRepository projetoRepository;
    private final AssentoRepository assentoRepository;

    public FuncionarioResponseDto criar(FuncionarioRequestDto requestDto){
        Assento assento = assentoRepository.findById(requestDto.assentoId())
                .orElseThrow(()-> new RuntimeException("Nenhuma assento encontrado"));

        List<Projeto> projetos = projetoRepository.findAllById(requestDto.projetoIds());
        if (projetos.isEmpty() && !requestDto.projetoIds().isEmpty()){
            throw new RuntimeException("Nenhum projeto encontrado");
        }

        Funcionario funcionario = mapper.paraEntidade(requestDto);

        funcionario.setAssento(assento);
        funcionario.setProjetos(projetos);
        return mapper.paraDto(repository.save(funcionario));
    }

    public List<FuncionarioResponseDto> listarTodos(){
        List<Funcionario> funcionarios = repository.findAll();

        return funcionarios.stream()
                .map(mapper::paraDto)
                .toList();
    }
}