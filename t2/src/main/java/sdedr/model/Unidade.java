package sdedr.model;

import java.util.Objects;

public class Unidade {
	
	private Long id;
	private String nome;
	private String descricao;
	
	public Unidade(){ }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String desc) {
		this.descricao = desc;
	}
}
