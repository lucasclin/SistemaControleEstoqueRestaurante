package sdedr.ctrl;

import java.util.ArrayList;
import java.util.List;

import sdedr.model.Produto;
import sdedr.model.Receita;
import sdedr.model.Unidade;
import sdedr.dao.ProdutoDao;
import sdedr.dao.ReceitaDao;

public class ProdutoCtrl {

  private ArrayList<Receita> receitas = new ArrayList<>();

  public boolean prepararReceitas() {
    ReceitaDao receitaDao = new ReceitaDao();
    return receitaDao.retornarTudo(receitas);
  }

  public ArrayList<Receita> getReceitas() {
    return this.receitas;
  }
}
