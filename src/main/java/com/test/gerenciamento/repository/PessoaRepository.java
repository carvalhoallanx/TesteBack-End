package com.test.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.gerenciamento.atributos.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
