package com.test.gerenciamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.gerenciamento.atributos.Endereco;
import com.test.gerenciamento.atributos.Pessoa;
import com.test.gerenciamento.repository.EnderecoRepository;
import com.test.gerenciamento.service.EnderecoService;
import com.test.gerenciamento.service.PessoaService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public List<Endereco> findAll(){
		return enderecoService.findAll();
	}
	@PostMapping
	public Endereco insert(@RequestBody Endereco endereco){
		return enderecoService.save(endereco);
	}
	
	@PutMapping(value = "/editar/{id}")
	public Endereco update (@PathVariable long id, @RequestBody Endereco updendereco){
		return enderecoService.update(id,updendereco);
	}
}
