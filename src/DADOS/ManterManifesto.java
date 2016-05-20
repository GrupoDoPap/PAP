/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DADOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author greis
 */
public class ManterManifesto {
    ArrayList consultarmanifesto = new ArrayList();
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
        public void ConsultarManifesto(int idCliente){
             Connection conn = null;
             String inserirManifesto= "SELECT * FROM MANIFESTO WHERE IDCLIENTE="+idCliente+"";
            try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stt = conn.prepareStatement(inserirManifesto);
                ResultSet resultManifesto = stt.executeQuery();
                while(resultManifesto.next()){
                    this.consultarmanifesto.add(resultManifesto.getString(1));
                    this.consultarmanifesto.add(resultManifesto.getString(2));
                    this.consultarmanifesto.add(resultManifesto.getString(3));
                    this.consultarmanifesto.add(resultManifesto.getString(4));
                    this.consultarmanifesto.add(resultManifesto.getString(5));
                }
                
        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
      
            System.out.println(consultarmanifesto.get(0));
            System.out.println(consultarmanifesto.get(1));
            System.out.println(consultarmanifesto.get(2));
            System.out.println(consultarmanifesto.get(3));
            System.out.println(consultarmanifesto.get(4));
    
    }

    public static void main(String[] args) {
        ManterManifesto mani = new ManterManifesto();
        mani.InserirManifesto(8859, 254988, "Tipomanifesto", "infomanifesto", "19/05/2016");
        mani.ConsultarManifesto(254988);
    }
}
    

