package sdedr.model;

import sdedr.model.Unidade;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
	private Long id;
	private String nome;
	private BigDecimal precoAtual;
	private BigDecimal quantidadeEstoque;
	private BigDecimal estoqueMinimo;
	private boolean permiteFracionamento;
	private boolean ativo;
	
	private Unidade unidade;
	
	public Produto() { }

	public Produto(Long id, String nome, BigDecimal precoAtual, BigDecimal quantidadeEstoque, BigDecimal estoqueMinimo, boolean permiteFracionamento, boolean isAtivo) {
		this.id = id;
		this.nome = nome;
		this.precoAtual = precoAtual;
		this.quantidadeEstoque = quantidadeEstoque;
		this.estoqueMinimo = estoqueMinimo;
		this.permiteFracionamento = permiteFracionamento;
		this.ativo = isAtivo;
	}

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

	public BigDecimal getPrecoAtual() {
		return precoAtual;
	}

	public void setPrecoAtual(BigDecimal precoAtual) {
		this.precoAtual = precoAtual;
	}

	public BigDecimal getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(BigDecimal quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public BigDecimal getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public boolean isPermiteFracionamento() {
		return permiteFracionamento;
	}

	public void setPermiteFracionamento(boolean permiteFracionamento) {
		this.permiteFracionamento = permiteFracionamento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean isAtivo) {
		this.ativo = isAtivo;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
}
