package com.exampleteste.trabalhoteste.entities.dto;

import java.io.Serializable;


public class ProdutoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ProdutoDTO() {
	}

	private String nome;
	private Double valor;

	public ProdutoDTO(String nome, Double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
