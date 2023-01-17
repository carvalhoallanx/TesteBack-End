package com.test.gerenciamento.atributos;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_endereco;
	private String Lagradouro;
	private String Cidade;
	private int CEP;
	private int Numero;
	
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipo;
	
	/*public Endereco(long id_endereco, int cep, String cidade, String lagradouro, int numero, String tipo) {
		setId_endereco(id_endereco);
		setCEP(cep);
		setCidade(cidade);
		setLagradouro(lagradouro);
		setNumero(numero);
		setTipo(TipoEndereco.PROFISSIONAL);
	}*/
	public String getLagradouro() {
		return Lagradouro;
	}
	public void setLagradouro(String lagradouro) {
		Lagradouro = lagradouro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int cEP) {
		CEP = cEP;
	}
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	public TipoEndereco getTipo() {
		return tipo;
	}
	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}
	public long getId_endereco() {
		return id_endereco;
	}
	public void setId_endereco(long id_endereco) {
		this.id_endereco = id_endereco;
	}
}
