package DADOS;

import RegradeNegocio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManterCliente {

    ArrayList consulta = new ArrayList(10);

    String add;

    public void CadastrarCliente(String nomecliente, String emailCliente, String CPFcliente, int numeroCliente, String cidadecliente, String complementocliente, String cepcliente, String logradourocliente, String bairrocliente) {

        Connection conn = null;
        String Cadastro = "insert into clientecrm(idcliente,NOMECLIENTE,EMAILCLIENTE,CPFCLIENTE,NUMEROCLIENTE,CIDADECLIENTE,COMPLEMENTOCLIENTE,CEPCLIENTE,LOGRADOUROCLIENTE,BAIRROCLIENTE) VALUES (SEQ_ID_CLIE.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stm = conn.prepareStatement(Cadastro);

            stm.setString(1, nomecliente);
            stm.setString(2, emailCliente);
            stm.setString(3, CPFcliente);
            stm.setInt(4, numeroCliente);
            stm.setString(5, cidadecliente);
            stm.setString(6, complementocliente);
            stm.setString(7, cepcliente);
            stm.setString(8, logradourocliente);
            stm.setString(9, bairrocliente);

            stm.execute();

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }

    public void DeletarCliente(String cpf) {
        System.out.println("Entrou no metodo");
        Connection conn = null;
        String dTel = "DELETE FROM TELEFONECLIENTE WHERE CLIENTE=" + cpf + "";
        String delete = "DELETE FROM CLIENTECRM WHERE CPFCLIENTE=" + cpf + "";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement dt = conn.prepareStatement(dTel);
            PreparedStatement sd = conn.prepareStatement(delete);

            dt.execute();
            sd.execute();

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
    }

    public void TelefoneCliente(String cpfCli, String telefoneClie) {

        Connection conn = null;
        String Cadastro = "insert into TELEFONECLIENTE (CLIENTE,TELEFONECLIENTE) values (" + cpfCli + ",?)";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stm = conn.prepareStatement(Cadastro);
            stm.setString(1, telefoneClie);
            stm.execute();

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }

    }

    public Cliente ConsultarCliente(String CPFCLIENTE) {
        Conectar c = new Conectar();
        Cliente cli = new Cliente();
        String ConsultaCliente = " SELECT idcliente,nomecliente,emailcliente,cpfcliente,numerocliente,"
                + "cidadecliente,complementocliente,cepcliente,logradourocliente,bairrocliente "
                + "FROM CLIENTECRM WHERE CPFCLIENTE='"+CPFCLIENTE+"'";
        try {
            Connection conn = null;
            try {
                conn = c.Conectar();

                PreparedStatement sd = conn.prepareStatement(ConsultaCliente);
                ResultSet rs = sd.executeQuery();

                while (rs.next()) {
                    cli.setId_Cliente(rs.getInt(1));
                    cli.setNome(rs.getString(2));
                    cli.setEmail(rs.getString(3));
                    cli.setCPFCNPJ(rs.getString(4));
                    cli.setNumero(rs.getInt(5));
                    cli.setCidade(rs.getString(6));
                    cli.setComplemento(rs.getString(7));
                    cli.setCep(rs.getString(8));
                    cli.setRua(rs.getString(9));
                    cli.setBairro(rs.getString(10));

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }
        return cli;
    }

    public void AtualizarCliente(String nomecliente, String emailCliente, String CPFcliente, int numeroCliente, String cidadecliente, String complementocliente, String cepcliente, String logradourocliente, String bairrocliente) {
        Connection conn = null;
        String Cadastro = "update clientecrm set NOMECLIENTE = ?,EMAILCLIENTE = ?,CPFCLIENTE = ?,NUMEROCLIENTE = ?,CIDADECLIENTE = ?,COMPLEMENTOCLIENTE = ? ,CEPCLIENTE = ? ,LOGRADOUROCLIENTE = ? ,BAIRROCLIENTE = ?   WHERE CPFCLIENTE=" + CPFcliente + "";
        try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            PreparedStatement stm = conn.prepareStatement(Cadastro);
            stm.setString(1, nomecliente);
            stm.setString(2, emailCliente);
            stm.setString(3, CPFcliente);
            stm.setInt(4, numeroCliente);
            stm.setString(5, cidadecliente);
            stm.setString(6, complementocliente);
            stm.setString(7, cepcliente);
            stm.setString(8, logradourocliente);
            stm.setString(9, bairrocliente);

            stm.execute();

        } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
        }

    }

    public static void main(String[] args) {
        ManterCliente m = new ManterCliente();
        m.DeletarCliente("23234");
    }

}
