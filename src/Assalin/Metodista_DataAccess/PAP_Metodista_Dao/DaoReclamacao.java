package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoReclamacao extends DaoBase implements IDaoReclamacao {

    private final ArrayList<Produto> listaProdutos = new ArrayList<>();
    private final DaoProduto dp = new DaoProduto();
    private final Conexao con = new Conexao();
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado;

    /**
     * Seleciona os produtos de um determinado atendimento
     *
     * @param numAtendimento: Atendimento a ser buscado
     * @return Array com os produtos
     */
    public ArrayList<Produto> selecionarProdutoPorAtendimento(int numAtendimento) {
        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_RECLAMACAO WHERE ATD_NUMERO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, numAtendimento);

            resultado = stm.executeQuery();

            while (resultado.next()) {
                listaProdutos.add(dp.get(resultado.getInt("PRD_CODIGO")));
            }

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível montar a lista", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return listaProdutos;
    }
}
