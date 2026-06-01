package br.com.restaurante.sistema_estoque_restaurante.model;

import java.util.Objects;

public class User {
	
	private Long id;
	private String nome;
	private String senha;
	
	private TipoCadastro tipoCadastro;
	
	public User() {
		
	}
	
	public User(Long id, String nome, String senha, TipoCadastro tipo) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.tipoCadastro = tipo;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoCadastro getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(TipoCadastro tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Ocultamos a senha do toString() por questões de segurança de log
    @Override
    public String toString() {
        return nome + " (" + tipoCadastro + ")";
    }
    

}
