/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DADOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author greis
 */
public class Conectar {

public Connection Conectar() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver JDBC carregado com sucesso!");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            try {
                conn = DriverManager.getConnection(url, "SANCHES", "SANCHES");
            } catch (SQLException ex) {
                Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Conexão estabelecida com sucesso!");
            return conn;
           
        } catch (ClassNotFoundException ex) {
            System.err.println("Classe do driver não encontrada!");
            return conn;
    }
}

    public static void main(String[] args) {
       Conectar c = new Conectar(); 
       Connection conn = c.Conectar(); 
        
    }
}
