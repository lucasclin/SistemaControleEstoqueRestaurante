package sdedr.ctrl;

import java.util.ArrayList;

import sdedr.model.Produto;
import sdedr.dao.ProdutoDao;

/* Class ProdutoCtrl
 * (obj.)
 * - Carregar uma lista de produtos da Dao [ok!]
 * - Retornar a lista                      [ok!]
 * - Descarregar na Dao a lista            []
 */

public class ProdutoCtrl {

  private ArrayList<Produto> produtos = new ArrayList<>();

  public boolean prepararProdutos() {
    ProdutoDao produtoDao = new ProdutoDao();
    return produtoDao.retornarTudo(produtos);
  }

  public ArrayList<Produto> getProdutos() {
    return this.produtos;
  }
}
