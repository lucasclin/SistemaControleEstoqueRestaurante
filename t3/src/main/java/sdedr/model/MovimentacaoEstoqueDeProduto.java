package sdedr.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

import sdedr.model.Produto;
import sdedr.model.User;
import sdedr.model.Enum.TipoMovimentacao;

@Entity
public class MovimentacaoEstoqueDeProduto {

  @Id
	private Long id;
	private LocalDateTime dataHora;
	private BigDecimal quantidade;
	private BigDecimal precoUnitario;
	private LocalDate validadeLote;
	private String observacao;

  @Enumerated(EnumType.ORDINAL)
	private TipoMovimentacao tipoMovimentacao;

  @ManyToOne
  @JoinColumn(name = "id_p")
	private Produto produto;  

  @ManyToOne
  @JoinColumn(name = "id_u")
	private User user;
	
	public MovimentacaoEstoqueDeProduto() { }
	
	public MovimentacaoEstoqueDeProduto(Long id, BigDecimal quantidade, TipoMovimentacao tipo, Produto produto, User user) {
		this();
		this.id = id;
		this.quantidade = quantidade;
		this.tipoMovimentacao = tipo;
		this.produto = produto;
		this.user = user;
	}

	public MovimentacaoEstoqueDeProduto(Long id, LocalDateTime dataHora, BigDecimal quantidade,
			BigDecimal precoUnitario, LocalDate validadeLote, String observacao, TipoMovimentacao tipoMovimentacao,
			Produto produto, User user) {
		this.id = id;
		this.dataHora = dataHora;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.validadeLote = validadeLote;
		this.observacao = observacao;
		this.tipoMovimentacao = tipoMovimentacao;
		this.produto = produto;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public LocalDate getValidadeLote() {
		return validadeLote;
	}

	public void setValidadeLote(LocalDate validadeLote) {
		this.validadeLote = validadeLote;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
