package br.com.restaurante.sistema_estoque_restaurante.model;

import java.util.Objects;

public class Unidade {
	
	private Long id;
	private String nome;
	private String desc;
	
	public Unidade(){
		
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unidade unidade = (Unidade) o;
        return Objects.equals(id, unidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // O toString ajuda na depuração e pode ser útil para preencher ComboBoxes no JavaFX
    @Override
    public String toString() {
        return desc + " - " + nome;
    }

}
