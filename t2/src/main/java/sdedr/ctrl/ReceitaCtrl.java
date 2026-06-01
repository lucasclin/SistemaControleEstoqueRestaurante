package sdedr.ctrl;

import java.util.ArrayList;
import java.util.List;

import sdedr.model.Receita;
import sdedr.model.Enum.Cardapio;
import sdedr.dao.ReceitaDao;

public class ReceitaCtrl {

  private ArrayList<Receita> receitas = new ArrayList<>();

  public boolean prepararReceitas() {
    ReceitaDao receitaDao = new ReceitaDao();
    return receitaDao.retornarTudo(receitas);
  }

  public ArrayList<Receita> getReceitas() {
    return this.receitas;
  }
}
