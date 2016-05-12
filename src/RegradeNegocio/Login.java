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
public class Login {

    private String idFuncionario;
    private String Senha;

    public void login(String idFuncionario, String Senha) {

        if (!idFuncionario.equals(this.idFuncionario)) {
            //   JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto");
            System.out.println("Usuario ou senha Incorreto");
        } else {
            //   JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto");
            System.out.println("Login realizado com sucesso");
        }

    }
}
