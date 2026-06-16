DROP TABLE ingrediente;
DROP TABLE movimentacao;
DROP TABLE produto;
DROP TABLE receita;
DROP TABLE unidade;
DROP TABLE tipoUnidade;

CREATE TABLE produto(
	id                    INTEGER,
	nome                  TEXT,
	precoAtual            NUMERIC,
	quantidadeEstoque     NUMERIC,
	estoqueMinimo         NUMERIC,
	permiteFracionamento  INTEGER,
	ativo                 INTEGER, 
	PRIMARY KEY(id)
);

CREATE TABLE receita(
	id        INTEGER,
	preco     NUMERIC,
	nome      TEXT,
	cardapio  INTEGER,
	PRIMARY KEY(id)
);

CREATE TABLE ingrediente(
	id_p        INTEGER,
	id_r        INTEGER,
	quantidade  NUMERIC,
	FOREIGN KEY (id_p) REFERENCES produto(id),
	FOREIGN KEY (id_r) REFERENCES receita(id),
	PRIMARY KEY(id_p, id_r)
);

CREATE TABLE movimentacao(
	id                INTEGER,
	id_p              INTEGER,
	id_u              INTEGER,
	tipoMovimentacao  INTEGER,
	dataMovimentacao  TEXT,
	quantidade        NUMERIC,
	precoUnitario     NUMERIC,
	dataValidade      TEXT,
	observacao        TEXT,
	FOREIGN KEY (id_p) REFERENCES produto(id),
	FOREIGN KEY (id_u) REFERENCES user(id),
	PRIMARY KEY(id)
);

CREATE TABLE unidade(
	id         INTEGER,
	nome       TEXT,
	descricao  TEXT,
	PRIMARY KEY(id)
);

CREATE TABLE tipoUnidade(
	id_p  INTEGER,
	id_u  INTEGER,
	FOREIGN KEY(id_p) REFERENCES produto(id),
	FOREIGN KEY(id_u) REFERENCES unidade(id),
	PRIMARY KEY(id_p, id_u)
);
