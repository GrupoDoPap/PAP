package Metodista_DataAccess.PAP_Metodista_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {

    private Connection conexao = null;
    private final String url = "jdbc:oracle:thin:@//localhost:1521/xe";
    private final String userName = "TEST_PAP";
    private final String userPwd = "TEST_PAP";

    /**
     * Método que abre a conexão com o banco de dados
     *
     * @return Conexão aberta
     */
    public Connection abrirConexao() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conexao = DriverManager.getConnection(url, userName, userPwd);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return conexao;
    }

    /**
     * Método que fecha uma conexão
     *
     * @param conexao: Conexão a ser fechada
     */
    public void fecharConexao(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível fechar a conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
