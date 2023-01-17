package com.test.gerenciamento.atributos;

public enum TipoEndereco {
	PRINCIPAL ("Principal"),
	SECUNDARIO ("Secundario"),
	PROFISSIONAL ("Profissional");

	private String tipo;
	
	TipoEndereco(String tipo) {
		this.tipo = tipo;
	}
}
