package sdedr.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.*;

/* Não sei como fica isso daqui em JPA, ver depois:
 * links úteis:
 * [1] https://github.com/jeftegoes/java-jpa-overview-and-examples#91-one-to-one
 * [2] https://www.baeldung.com/jpa-persisting-enums-in-jpa
 */ 

@Entity
public class Produto {
  @Id
	private Long id;
	private String nome;
	private BigDecimal precoAtual;
	private BigDecimal quantidadeEstoque;
	private BigDecimal estoqueMinimo;
	private boolean permiteFracionamento;
	private boolean isAtivo;
	
	private Unidade unidade;
	
	public Produto() { }
	
	public Produto(Long id, String nome, BigDecimal precoAtual, Unidade unidade) {
		this();
		this.id = id;
		this.nome = nome;
		this.precoAtual = precoAtual;
		this.unidade = unidade;
	}

	public Produto(Long id, String nome, BigDecimal precoAtual, BigDecimal quantidadeEstoque, BigDecimal estoqueMinimo,
			boolean permiteFracionamento, boolean isAtivo) {
		this.id = id;
		this.nome = nome;
		this.precoAtual = precoAtual;
		this.quantidadeEstoque = quantidadeEstoque;
		this.estoqueMinimo = estoqueMinimo;
		this.permiteFracionamento = permiteFracionamento;
		this.isAtivo = isAtivo;

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
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nome + " (Stock: " + quantidadeEstoque + " " + (unidade != null ? unidade.getDescricao() : "") + ")";
    }

}
