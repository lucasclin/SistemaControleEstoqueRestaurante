package sdedr.ctrl;

import java.util.ArrayList;

import sdedr.model.MovimentacaoEstoqueDeProduto;

import sdedr.dao.MovimentacaoDao;
import sdedr.dao.ProdutoDao;

/* Class ProdutoCtrl
 * (obj.)
 * - Carregar uma lista de produtos da Dao [ok!]
 * - Retornar a lista                      [ok!]
 * - Descarregar na Dao a lista            []
 */

public class MovimentacaoEstoqueDeProdutoCtrl {

  private ArrayList<MovimentacaoEstoqueDeProduto> movimentacaoEstoqueDeProdutos = new ArrayList<>();

  public boolean prepararMovimentacoes(int id) {
    
    MovimentacaoDao movimentacaoDao = new MovimentacaoDao();
    this.movimentacaoEstoqueDeProdutos.clear();
    return movimentacaoDao.retornarTudoPorId(movimentacaoEstoqueDeProdutos, id);
  }

  public ArrayList<MovimentacaoEstoqueDeProduto> getMovimentacaoEstoqueDeProdutos() {
    return this.movimentacaoEstoqueDeProdutos;
  }

  public boolean movimentarEstoque(MovimentacaoEstoqueDeProduto entrada) {
    ProdutoDao produtoDao = new ProdutoDao();
    if(entrada.getProduto() != null){
      produtoDao.atualizarQuantidade(entrada.getProduto(), entrada.getQuantidade(), entrada.getTipoMovimentacao());
    }
    MovimentacaoDao movimentacaoDao = new MovimentacaoDao();
    return movimentacaoDao.inserir(entrada);
  }

}
