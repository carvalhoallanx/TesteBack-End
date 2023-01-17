package com.test.gerenciamento.controller;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.gerenciamento.atributos.Endereco;
import com.test.gerenciamento.atributos.Pessoa;
import com.test.gerenciamento.atributos.TipoEndereco;
import com.test.gerenciamento.repository.EnderecoRepository;
import com.test.gerenciamento.repository.PessoaRepository;
import com.test.gerenciamento.service.EnderecoService;
import com.test.gerenciamento.service.PessoaService;

import ch.qos.logback.core.status.Status;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PessoasController.class)
@AutoConfigureMockMvc
public class PessoaControllerTest{
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PessoaRepository pessoaRepository;
	
	@MockBean
	private EnderecoRepository enderecoRepository;
	
	@MockBean
	private PessoaService pessoaService;
	
	@BeforeEach
	public void setUp() {
		standaloneSetup(pessoaRepository);
		standaloneSetup(enderecoRepository);
	}
	
	@Test
	public void InserirNovaPessoa() throws Exception {
		Endereco endereco = new Endereco();
		endereco.setId_endereco(1);
		endereco.setCEP(412552);
		endereco.setCidade("Serrinha");
		endereco.setLagradouro("Centro");
		endereco.setNumero(5);
		endereco.setTipo(TipoEndereco.PRINCIPAL);
		
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		pessoa.setDatadenascimento("09/09/2009");
		pessoa.setNome("ALAN");

		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(pessoa);
		String json1 = mapper.writeValueAsString(endereco);
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/pessoas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json));
						
	}
	
	@SneakyThrows
	@Test
	public void BuscarUmaPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		pessoa.setDatadenascimento("09/09/2009");
		pessoa.setNome("ALAN");
		
		List<Pessoa> Pessoaslista = List.of(pessoa);
		
		when(pessoaRepository.findAll()).thenReturn(Pessoaslista);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/pessoas"));
	}
}
