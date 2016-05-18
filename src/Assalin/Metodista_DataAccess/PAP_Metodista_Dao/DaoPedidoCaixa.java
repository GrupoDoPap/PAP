package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoPedidoCaixa extends DaoBase implements IDaoPedidoCaixa {

    private final DaoCaixa dc = new DaoCaixa();
    private final Conexao con = new Conexao();
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado;
    private final ArrayList<Caixa> listaCaixa = new ArrayList<>();

    /**
     * Lista todas as caixas de um determinado pedido
     *
     * @param codPedido: Pedido a ser consultado
     * @return Array com as caixas do pedido
     */
    public ArrayList<Caixa> listarCaixasPorPedido(int codPedido) {
        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_PEDIDO_CAIXA WHERE PDD_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, codPedido);

            resultado = stm.executeQuery();

            while (resultado.next()) {
                for (int i = 0; i < resultado.getInt("CXA_QUANTIDADE"); i++) {
                    listaCaixa.add(dc.pesquisarCaixaPorCodigo(resultado.getInt("CXA_CODIGO")));
                }
            }

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar a lista", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return listaCaixa;
    }

    /**
     * Insere quantidade de caixas em um determinado pedido.
     *
     * @param codPedido: Código do pedido a ser incluído
     * @param codCaixa: Código da caixa a ser incluída
     * @param qntdCaixa: Quantidade de caixas a ser incluída
     */
    public void saveCaixasPedido(int codPedido, int codCaixa, int qntdCaixa) {
        try {
            conexao = con.abrirConexao();
            sql = "INSERT INTO TAB_PEDIDO_CAIXA (PDD_CODIGO, CXA_CODIGO, CXA_QUANTIDADE) VALUES (?,?,?)";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, codPedido);
            stm.setInt(2, codCaixa);
            stm.setInt(3, qntdCaixa);

            stm.execute();

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível inserir a lista de caixas", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
    }
}
