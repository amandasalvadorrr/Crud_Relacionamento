package com.weg.crud_relacionamento.repository;

import com.weg.crud_relacionamento.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
