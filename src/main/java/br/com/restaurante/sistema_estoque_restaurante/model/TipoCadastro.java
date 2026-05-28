package br.com.restaurante.sistema_estoque_restaurante.model;

public enum TipoCadastro {
	ADMIN,
	CHEF,
	ALMOXARIFADO,
	ERRO; 
	
	public static TipoCadastro tipoCadastroInt(int tipo) {
		return switch (tipo) {
			case 0 -> ADMIN;
			case 1 -> CHEF;
			case 2 -> ALMOXARIFADO;
			default -> ERRO;
		};
	}
}
