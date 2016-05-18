/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegradeNegocio;

import javax.swing.JOptionPane;

/**
 *
 * @author Sanches
 */
public class MetodoLogin {

    private String idFuncionario;
    private String Senha;
    private boolean validacao;

    public boolean login(String idFuncionario, String Senha) {

        if ( ! Senha.equals(this.Senha)) {
            JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto");
            validacao = false;
        } else {
            validacao = true;
        }
        return validacao;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public boolean isValidacao() {
        return validacao;
    }

    public void setValidacao(boolean validacao) {
        this.validacao = validacao;
    }

}
