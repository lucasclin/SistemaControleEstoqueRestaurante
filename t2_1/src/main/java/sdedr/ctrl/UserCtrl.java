package sdedr.ctrl;

import sdedr.model.User;
import sdedr.model.Enum.TipoCadastro;
import sdedr.dao.UserDao;

public class UserCtrl {

  private User usuarioAtual = new User();

  public UserCtrl() { }

  public boolean primeiroUso() {
    UserDao userDao = new UserDao();
    return userDao.primeiroLogin();
  }

  public boolean cadastrarPrimeiroLogin(String nome, String senha) {
    User userNovo = new User();
    userNovo.setNome(nome);
    userNovo.setSenha(senha);
    userNovo.setTipoCadastro(TipoCadastro.tipoCadastroInt(1));
    UserDao userDao = new UserDao();
    return userDao.inserir(userNovo);
  }

  public boolean confirmarLogin(String nome, String senha) {
    UserDao userDao = new UserDao();
    return userDao.logar(nome, senha, usuarioAtual);
  }

  public boolean confirmarPermissao(int acesso) {
    return this.usuarioAtual.getTipoCadastro().equals(TipoCadastro.tipoCadastroInt(acesso));
  }

  public String retornarNomeOuCadastro(boolean nome) {
    return nome ? this.usuarioAtual.getNome() : this.usuarioAtual.getTipoCadastro().name();
  }  

  public int retornarId() {
    return this.usuarioAtual.getId().intValue();
  }
}
