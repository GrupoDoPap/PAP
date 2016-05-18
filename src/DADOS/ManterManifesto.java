/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DADOS;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author greis
 */
public class ManterManifesto {

public void InserirManifesto(int idFuncionario,int Idcliente,String Tipomanifesto,String infomanifesto,String datamanifesto){
    Connection conn = null;
    String inserirManifesto= "insert into Manifesto(idfuncionario,idcliente,tipomanifesto,infomanifesto, datamanifesto) values (?,?,?,?,?)";
    try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stt = conn.prepareStatement(inserirManifesto);
            stt.setInt(1, idFuncionario);
            stt.setInt(2, Idcliente);
            stt.setString(3,Tipomanifesto);
            stt.setString(4,infomanifesto);
            stt.setString(5, datamanifesto);
            stt.execute();

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }
}
    

