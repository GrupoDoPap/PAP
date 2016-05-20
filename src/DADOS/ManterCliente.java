package DADOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManterCliente {

    ArrayList consulta = new ArrayList(10);

    String add;

    public void CadastrarCliente(int idCliente, String nomecliente, String emailCliente,
            String CPFcliente, int numeroCliente,
            String cidadecliente, String complementocliente, String cepcliente,
            String logradourocliente, String bairrocliente) {
        System.out.println("Entrou no metodo");
        Connection conn = null;
        String Cadastro = "insert into clientecrm(IDCLIENTE,NOMECLIENTE,EMAILCLIENTE,CPFCLIENTE,NUMEROCLIENTE,CIDADECLIENTE,COMPLEMENTOCLIENTE,CEPCLIENTE,LOGRADOUROCLIENTE,BAIRROCLIENTE) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stm = conn.prepareStatement(Cadastro);
            stm.setInt(1, idCliente);
            stm.setString(2, nomecliente);
            stm.setString(3, emailCliente);
            stm.setString(5, CPFcliente);
            stm.setInt(6, numeroCliente);
            stm.setString(7, cidadecliente);
            stm.setString(8, complementocliente);
            stm.setString(9, cepcliente);
            stm.setString(10, logradourocliente);
            stm.setString(11, bairrocliente);

            stm.execute();

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }

    public void DeletarCliente(int idCliente) {
        System.out.println("Entrou no metodo");
        Connection conn = null;
        String delete = "DELETE FROM CLIENTECRM WHERE IDCLIENTE=" + idCliente + "";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }

            PreparedStatement sd = conn.prepareStatement(delete);
            //sd.setInt(1, idCliente);
            sd.execute();
        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }

    public void ConsultarCliente(int idcliente) {
        Connection conn = null;

        String ConsultaCliente = " SELECT * FROM CLIENTECRM WHERE IDCLIENTE=" + idcliente + "";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }

            PreparedStatement sd = conn.prepareStatement(ConsultaCliente);
            ResultSet rs = sd.executeQuery();

            while (rs.next()) {
                consulta.add(rs.getString(1));
                consulta.add(rs.getString(2));
                consulta.add(rs.getString(3));
                consulta.add(rs.getString(4));
                consulta.add(rs.getString(5));
                consulta.add(rs.getString(6));
                consulta.add(rs.getString(7));
                consulta.add(rs.getString(8));
                consulta.add(rs.getString(9));
                consulta.add(rs.getString(10));
            }
        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }

    }

    public void AtualizarCliente() {

    }

    public static void main(String[] args) {
        ManterCliente m = new ManterCliente();
        m.ConsultarCliente(254988);
    }
}
