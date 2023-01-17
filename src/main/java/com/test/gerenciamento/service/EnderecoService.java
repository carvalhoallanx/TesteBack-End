package com.test.gerenciamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.gerenciamento.atributos.Endereco;
import com.test.gerenciamento.atributos.Pessoa;
import com.test.gerenciamento.repository.EnderecoRepository;

@Service
@RestController
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Endereco findbyId(@PathVariable Long id) {
		return enderecoRepository.findById(id).get();
	}
	
	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco update(@PathVariable long id, 
			@RequestBody Endereco updendereco) {
		
		Endereco newendereco = findbyId(id);
		
		newendereco.setCEP(updendereco.getCEP());
		newendereco.setCidade(updendereco.getCidade());
		newendereco.setLagradouro(updendereco.getLagradouro());
		newendereco.setNumero(updendereco.getNumero());
		newendereco.setTipo(updendereco.getTipo());
		
		return enderecoRepository.save(newendereco);
	}


}
