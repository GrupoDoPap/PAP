package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoCaixa extends DaoBase implements IDaoCaixa {

    private final Conexao con = new Conexao();
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado;

    private Caixa box = null;
    private final ArrayList<Caixa> arrayCaixas = new ArrayList<>();

    /**
     * Tela pedido - Seleciona todas as caixas
     *
     * @return Array com todas as caixas disponíveis no sistema
     */
    public ArrayList list() {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_CAIXA";
            stm = conexao.prepareStatement(sql);

            resultado = stm.executeQuery();

            while (resultado.next()) {
                Caixa box = new Caixa(resultado.getInt("CXA_CODIGO"),
                        resultado.getString("CXA_NOME"),
                        resultado.getString("CXA_DESCRICAO"),
                        resultado.getDouble("CXA_PESO"),
                        resultado.getDouble("CXA_ALTURA"),
                        resultado.getDouble("CXA_LARGURA"),
                        resultado.getDouble("CXA_PROFUNDIDADE"));

                arrayCaixas.add(box);
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar a lista de caixas",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return arrayCaixas;
    }

    /**
     * Localiza uma caixa pelo nome
     *
     * @param nome: Nome da caixa que será pesquisada
     * @return Caixa encontrada
     */
    public Caixa pesquisarCaixaPorNome(String nome) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_CAIXA WHERE CXA_NOME = ?";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, nome);
            resultado = stm.executeQuery();
            resultado.next();

            box = new Caixa(resultado.getInt("CXA_CODIGO"),
                    resultado.getString("CXA_NOME"),
                    resultado.getString("CXA_DESCRICAO"),
                    resultado.getDouble("CXA_PESO"),
                    resultado.getDouble("CXA_ALTURA"),
                    resultado.getDouble("CXA_LARGURA"),
                    resultado.getDouble("CXA_PROFUNDIDADE"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar a caixa", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return box;
    }

    /**
     * Localiza uma caixa pelo código
     *
     * @param codigo: Código da caixa que será pesquisada
     * @return Caixa encontrada
     */
    public Caixa pesquisarCaixaPorCodigo(int codigo) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_CAIXA WHERE CXA_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, codigo);
            resultado = stm.executeQuery();
            resultado.next();

            box = new Caixa(resultado.getInt("CXA_CODIGO"),
                    resultado.getString("CXA_NOME"),
                    resultado.getString("CXA_DESCRICAO"),
                    resultado.getDouble("CXA_PESO"),
                    resultado.getDouble("CXA_ALTURA"),
                    resultado.getDouble("CXA_LARGURA"),
                    resultado.getDouble("CXA_PROFUNDIDADE"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar a caixa", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return box;
    }
}
