package com.test.gerenciamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.gerenciamento.atributos.Endereco;
import com.test.gerenciamento.atributos.Pessoa;
import com.test.gerenciamento.repository.PessoaRepository;
import com.test.gerenciamento.service.EnderecoService;
import com.test.gerenciamento.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoasController {
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> findAll(){
		return pessoaService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Pessoa findbyId(@PathVariable Long id){
		return pessoaService.findbyId(id);
	}
	
	@PostMapping
	public Pessoa insert(@RequestBody Pessoa pessoa){
		return pessoaService.save(pessoa);
	}
	
	@PutMapping(value = "/editar/{id}")
	public Pessoa update(@PathVariable Long id,@RequestBody Pessoa updpessoa) {
		return pessoaService.update(id,updpessoa);
	}
	
}
