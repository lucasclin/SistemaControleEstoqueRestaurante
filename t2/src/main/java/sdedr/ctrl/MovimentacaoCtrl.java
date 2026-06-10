package sdedr.ctrl;

import java.util.ArrayList;

import sdedr.dao.MovimentacaoDao;
import sdedr.model.MovimentacaoEstoqueDeProduto;

public class MovimentacaoCtrl {
    public ArrayList<MovimentacaoEstoqueDeProduto> getRelatorio(){
        ArrayList<MovimentacaoEstoqueDeProduto> relatorio = new ArrayList<>();
        MovimentacaoDao movimentacaoDao = new MovimentacaoDao();
        if (movimentacaoDao.retornarTudo(relatorio)) {
          return relatorio;
        } else {
          return null;
        }
    }
}
