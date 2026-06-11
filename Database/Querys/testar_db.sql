INSERT INTO produto (nome, precoAtual, quantidadeEstoque, estoqueMinimo, permiteFracionamento, ativo) 
VALUES ('sal', 10.0, 50, 2.0, 1, 1),
       ('leite', 9.5, 10, 7.0, 1, 1),
       ('pera', 4.75, 0, 4, 0, 0);

INSERT INTO user (nome, senha, tipoCadastro)
VALUES ('Chef', '123', 2),
       ('teste', '123', 3);

INSERT INTO receita (preco, nome, cardapio)
VALUES (15,'leite e sal', 3);

INSERT INTO ingrediente (id_p, id_r, quantidade)
VALUES (5, 2, 3.0),
       (6, 1, 1.0);

 -- INSERT INTO movimentacao 
 -- VALUES (1, 1, 1, 2, '2026-05-28 16:50:40', 10.5, 5.99, '2026-06-12', 'Entrada de estoque');
