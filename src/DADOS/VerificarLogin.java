/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DADOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 254988
 */
public class VerificarLogin {
   
    public void VerificarSenha(int id){
            String g="";
        Conectar c = new Conectar();
        Connection conn = c.Conectar();
        String consulta = "SELECT SENHAFUNCIONARIO FROM usuario WHERE idfuncionario="+id+"";         
        try {
            Statement pst = conn.createStatement();
         
            ResultSet rs = pst.executeQuery(consulta);
        
            
            while (rs.next()){
      
             g =  rs.getString("SENHAFUNCIONARIO");
           
            }
             
        } catch (SQLException ex) {
            
        }      
          System.out.println("Senha = "+g);
       }
    
    public static void main(String[] args) {
            VerificarLogin f = new VerificarLogin();
            f.VerificarSenha(4558);
            f.VerificarSenha(1234);
            f.VerificarSenha(7785);
            f.VerificarSenha(8895);
            f.VerificarSenha(1245);
            f.VerificarSenha(8859);
                                 
    }
}
