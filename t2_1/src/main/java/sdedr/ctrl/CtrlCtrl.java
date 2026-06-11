package sdedr.ctrl;

import sdedr.ctrl.*;

/* Class CtrlCtrl
 * (obj.)
 * > Manter Ctrl por longo prazo          [ok!]
 * > Facilitar referência e arg nas views [?] 
 */

public class CtrlCtrl {
  public final UserCtrl userCtrl;
  public final MovimentacaoEstoqueDeProdutoCtrl movimentacaoEstoqueDeProdutoCtrl;
  public final ProdutoCtrl produtoCtrl;

  public CtrlCtrl() {
    this.userCtrl = new UserCtrl();
    this.movimentacaoEstoqueDeProdutoCtrl = new MovimentacaoEstoqueDeProdutoCtrl();
    this.produtoCtrl = new ProdutoCtrl();
  }
}
