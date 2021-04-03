package com.exampleteste.trabalhoteste.dto;

import java.io.Serializable;
import java.time.Instant;

import com.exampleteste.trabalhoteste.entities.Produto;


public class ProdutoDTO extends Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ProdutoDTO() {
	}

	private String nome;
	private Double valor;

	public ProdutoDTO(Long id, String nome, Double valor, Instant insercao) {
		super(id, nome, valor, insercao);
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
