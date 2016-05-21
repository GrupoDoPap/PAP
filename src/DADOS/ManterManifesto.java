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

    public void InserirManifesto(int idFuncionario, int Idcliente, String Tipomanifesto, String infomanifesto, String datamanifesto) {
        Connection conn = null;
        String inserirManifesto = "insert into Manifesto(IDMANIFESTO,idfuncionario,idcliente,tipomanifesto,infomanifesto, datamanifesto) values (SEQ_ID_MANI,?,?,?,?,?)";
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
            stt.setString(3, Tipomanifesto);
            stt.setString(4, infomanifesto);
            stt.setString(5, datamanifesto);
            stt.execute();

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }

    public void ConsultarManifesto(String CPFCLIENTE) {
        Connection conn = null;
        String inserirManifesto = "SELECT * FROM MANIFESTO WHERE CPFCLIENTE=" + CPFCLIENTE + "";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stt = conn.prepareStatement(inserirManifesto);
            ResultSet resultManifesto = stt.executeQuery();
            while (resultManifesto.next()) {
                this.consultarmanifesto.add(resultManifesto.getString(1));
                this.consultarmanifesto.add(resultManifesto.getString(2));
                this.consultarmanifesto.add(resultManifesto.getString(3));
                this.consultarmanifesto.add(resultManifesto.getString(4));
                this.consultarmanifesto.add(resultManifesto.getString(5));
                this.consultarmanifesto.add(resultManifesto.getString(6));
            }

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }

    public void AtualizarManifesto(int idcliente, int idfuncionario, int idmanifesto, String info, String tipo, String Data) {
        Connection conn = null;
        String Cadastro = "update manifesto set idcliente = " + idcliente + ",idfuncionario" + idfuncionario + ",infomanifesto= ?,tipomanifesto = ?,datamanifesto = ?  WHERE IDCLIENTE=" + idmanifesto + "";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stm = conn.prepareStatement(Cadastro);
            stm.setString(1, info);
            stm.setString(2, tipo);
            stm.setString(3, Data);
            stm.execute();

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }

    }

    public void DeletarManifesto(int IDMANIFESTO) {
        Connection conn = null;
        String inserirManifesto = " DELETE FROM MANIFESTO WHERE IDMANIFESTO=" + IDMANIFESTO + "";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stt = conn.prepareStatement(inserirManifesto);
            stt.execute();
        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }
}
