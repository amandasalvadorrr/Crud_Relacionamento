package com.weg.crud_relacionamento.repository;

import com.weg.crud_relacionamento.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
