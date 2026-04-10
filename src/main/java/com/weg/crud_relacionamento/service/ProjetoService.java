package com.weg.crud_relacionamento.service;

import com.weg.crud_relacionamento.dto.request.ProjetoRequestDto;
import com.weg.crud_relacionamento.dto.response.ProjetoResponseDto;
import com.weg.crud_relacionamento.mapper.ProjetoMapper;
import com.weg.crud_relacionamento.model.Projeto;
import com.weg.crud_relacionamento.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;

    public ProjetoResponseDto criar(ProjetoRequestDto requestDto){
        Projeto projeto = mapper.paraEntidade(requestDto);
        repository.save(projeto);
        return mapper.paraDto(projeto);
    }

    public List<ProjetoResponseDto> listarTodos(){
        List<Projeto> projetos = repository.findAll();

        return projetos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public ProjetoResponseDto atualizar(ProjetoRequestDto requestDto, Long id){
        Projeto projeto = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Projeto não encontrado"));

        projeto.setId(projeto.getId());
        projeto.setNome(projeto.getNome());
        projeto.setFuncionarios(projeto.getFuncionarios());

        return mapper.paraDto(projeto);
    }


    public void deletar(Long id){
        repository.deleteById(id);
    }
}