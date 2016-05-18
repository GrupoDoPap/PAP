package DADOS;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ManterCliente {

    public void CadastrarCliente(int idCliente, String nomecliente, String emailCliente,
            String CPFcliente, int numeroCliente, String cidadecliente, String complementocliente, String cepcliente,
            String logradourocliente, String bairrocliente) {

        Connection conn = null;
        String Cadastro = "insert into clientecrm(IDCLIENTE,NOMECLIENTE,EMAILCLIENTE,"
                + "CPFCLIENTE,NUMEROCLIENTE,CIDADECLIENTE,COMPLEMENTOCLIENTE,"
                + "CEPCLIENTE,LOGRADOUROCLIENTE,BAIRROCLIENTE) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
        String delete = "DELETE FROM CLIENTECRM WHERE IDCLIENTE=(?)";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }

            PreparedStatement sd = conn.prepareStatement(delete);
            sd.setInt(1, idCliente);
            sd.execute();
        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }

    public static void main(String[] args) {
        ManterCliente m = new ManterCliente();
        m.DeletarCliente(122334);
    }
}
