package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Usuario extends Funcionario {

    private String login, senha;

    public Usuario(String nome, String cargo, String telefone, String login, String senha) {
        super(nome, cargo, telefone);
        this.login = login;
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
