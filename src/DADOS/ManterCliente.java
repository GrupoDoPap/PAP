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
                + "CEPCLIENTE,LOGRADOUROCLIENTE,BAIRROCLIENTE) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
            stm.setString(4, CPFcliente);
            stm.setInt(5, numeroCliente);
            stm.setString(6, cidadecliente);
            stm.setString(7, complementocliente);
            stm.setString(8, cepcliente);
            stm.setString(9, logradourocliente);
            stm.setString(10, bairrocliente);

            stm.execute();

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }

    public void DeletarCliente(int CPFCLIENTE) {
        System.out.println("Entrou no metodo");
        Connection conn = null;
        String delete = "DELETE FROM CLIENTECRM WHERE CPFCLIENTE=(?)";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }

            PreparedStatement sd = conn.prepareStatement(delete);
            sd.setInt(1, CPFCLIENTE);
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
