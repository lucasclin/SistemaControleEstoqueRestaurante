package sdedr.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Receita {

  @Id
	private Long id;
	private String nome;
	private BigDecimal preco;

  @Enumerated(EnumType.ORDINAL)
	private Cardapio cardapio;

  @OneToMany(mappedBy="receita")
	private List<Ingrediente> ingredientes;
	
	public Receita() { }
	
	public Receita(Long id, String nome, BigDecimal preco, Cardapio cardapio) {
		this();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.cardapio = cardapio;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	public void adicionarIngrediente(Ingrediente ingrediente) {
		if (ingrediente != null && !this.ingredientes.contains(ingrediente)) {
			this.ingredientes.add(ingrediente);
			ingrediente.setReceita(this);
		}
	}
}
