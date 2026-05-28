package br.com.restaurante.sistema_estoque_restaurante.model;

import java.math.BigDecimal;

public class Ingrediente {
	
	private BigDecimal quantidadeProduto;
	private Produto produto;
	private Receita receita;
	
	public Ingrediente() {
		this.quantidadeProduto = BigDecimal.ZERO;
	}
	
	public Ingrediente(BigDecimal quantidade, Produto produto, Receita receita) {
		this();
		this.quantidadeProduto = quantidade;
		this.produto = produto;
		this.receita = receita;
	}

	public BigDecimal getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(BigDecimal quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	/*
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingrediente that = (Ingrediente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return quantidadeProduto + " de " + (produto != null ? produto.getNome() : "Produto Indefinido");
    } */

}
