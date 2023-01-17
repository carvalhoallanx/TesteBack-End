package com.test.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.gerenciamento.atributos.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
