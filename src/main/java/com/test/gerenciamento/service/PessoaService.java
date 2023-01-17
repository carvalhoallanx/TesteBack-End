package com.test.gerenciamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.gerenciamento.atributos.Endereco;
import com.test.gerenciamento.atributos.Pessoa;
import com.test.gerenciamento.atributos.TipoEndereco;
import com.test.gerenciamento.repository.EnderecoRepository;
import com.test.gerenciamento.repository.PessoaRepository;

@Service
@RestController
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	public Pessoa findbyId(@PathVariable Long id) {
		return pessoaRepository.findById(id).get();
	}

	public Pessoa save(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa update(@PathVariable Long id,@RequestBody Pessoa updpessoa) {
		Pessoa newpessoa = findbyId(id);
		
		newpessoa.setNome(updpessoa.getNome());
		newpessoa.setDatadenascimento(updpessoa.getDatadenascimento());
		
		return pessoaRepository.save(newpessoa);
		
	}
}
