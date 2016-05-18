package Metodista_DataAccess.PAP_Metodista_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DaoClassificacao extends DaoBase implements IDaoClassificacao {

    private final Conexao con = new Conexao();
    private Connection conexao;
    private String sql, classificacao;
    private int codigo;
    private PreparedStatement stm;
    private ResultSet resultado;

    /**
     * Busca o nome da classificação pelo código
     *
     * @param codigo: código a ser buscado
     * @return Nome da classificação
     */
    public String selecionarNomeClassificacao(int codigo) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_CLASSIFICACAO WHERE CLF_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, codigo);

            resultado = stm.executeQuery();
            resultado.next();
            classificacao = resultado.getString("CLF_NOME");

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível selecionar a classificação",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return classificacao;
    }

    /**
     * Busca o código de uma classificação pelo nome
     *
     * @param nome: Nome da classificação a ser buscada
     * @return código da classificação
     */
    public int selecionarCodigoClassificacao(String nome) {
        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_CLASSIFICACAO WHERE CLF_NOME = ?";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, nome);
            resultado = stm.executeQuery();
            resultado.next();
            codigo = resultado.getInt("CLF_CODIGO");

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível selecionar o código",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return codigo;
    }
}
