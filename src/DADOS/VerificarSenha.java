/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DADOS;

import DADOS.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author greis
 */
public class VerificarSenha {

    private String senha;

    public void BuscarSenha(int id) {
        Connection conn = null;
        String senhabanco = null;
        String verificar = "SELECT SENHAUSUARIO FROM USUARIO WHERE IDFUNCIONARIO=" + id + "";
        try {
            try {
                Conectar c = new Conectar();
                conn = c.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stm = conn.prepareStatement(verificar);
            ResultSet RS = stm.executeQuery();
            while (RS.next()) {
                senhabanco = RS.getString("senhausuario");

            }
              
        } catch (Exception f) {

        }

        this.senha = senhabanco;
        System.out.println(senha);
      
    }

    public boolean ValidarSenha(String senhaTela) {
        if (senha.equals(senhaTela)) {
            return true;
        }
        return false;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
