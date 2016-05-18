package Metodista_DataAccess.PAP_Metodista_Dao;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class DaoOpiniao extends DaoBase implements IDaoOpiniao {

    private final Conexao con = new Conexao();
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado = null;
    private CachedRowSet crs = null;

    /**
     * Tela Mídias Sociais - Aba Citações
     *
     * @param fonte: Fonte das citações
     * @return cliente, descrição, data
     */
    public CachedRowSet atualizarCitacoes(String fonte) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM (SELECT C.CLI_NOME, O.OPN_DESCRICAO, "
                    + "TO_CHAR(O.OPN_DATA, 'DD/MM/YY - HH:MM:SS') "
                    + "FROM TAB_OPINIAO O INNER JOIN TAB_CLIENTE C ON "
                    + "O.CLI_CODIGO = C.CLI_CODIGO WHERE O.OPN_FONTE = ? "
                    + "ORDER BY O.OPN_DATA DESC) WHERE ROWNUM <= 12";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, fonte);

            resultado = stm.executeQuery();

            crs = new CachedRowSetImpl();
            crs.populate(resultado);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar as "
                    + "opiniões", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return crs;
    }

    /**
     * Telas Mídias Sociais - Aba Elogios
     *
     * @param fonte: Fonte das citações
     * @return cliente, descrição, data
     */
    public CachedRowSet atualizarElogios(String fonte) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM (SELECT C.CLI_NOME, O.OPN_DESCRICAO, "
                    + "TO_CHAR(O.OPN_DATA, 'DD/MM/YY - HH:MM:SS') "
                    + "FROM TAB_OPINIAO O INNER JOIN TAB_CLIENTE C ON "
                    + "O.CLI_CODIGO = C.CLI_CODIGO WHERE O.OPN_FONTE = ? AND "
                    + "O.OPN_CLASSIFICACAO = 'ELOGIO' ORDER BY O.OPN_DATA DESC) "
                    + "WHERE ROWNUM <= 12";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, fonte);

            resultado = stm.executeQuery();

            crs = new CachedRowSetImpl();

            crs.populate(resultado);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar as "
                    + "opiniões", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return crs;
    }

    /**
     * Telas Mídias Sociais - Aba Críticas
     *
     * @param fonte: Fonte das citações
     * @return cliente, descrição, data
     */
    public CachedRowSet atualizarCriticas(String fonte) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM (SELECT C.CLI_NOME, O.OPN_DESCRICAO, "
                    + "TO_CHAR(O.OPN_DATA, 'DD/MM/YY - HH:MM:SS') FROM "
                    + "TAB_OPINIAO O INNER JOIN TAB_CLIENTE C "
                    + "ON O.CLI_CODIGO = C.CLI_CODIGO WHERE O.OPN_FONTE = ? AND "
                    + "O.OPN_CLASSIFICACAO = 'CRITICA' ORDER BY O.OPN_DATA DESC) "
                    + "WHERE ROWNUM <= 12";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, fonte);

            resultado = stm.executeQuery();

            crs = new CachedRowSetImpl();
            crs.populate(resultado);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar as "
                    + "opiniões", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return crs;
    }

    /**
     * Telas Mídias Sociais - Aba Busca Personalizada
     *
     * @param palavra: Palavra a ser buscada nas citações
     * @return cliente, descrição, data
     */
    public CachedRowSet buscaPersonalizada(String palavra) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM (SELECT C.CLI_NOME, O.OPN_DESCRICAO, "
                    + "TO_CHAR(O.OPN_DATA, 'DD/MM/YY - HH:MM:SS') FROM TAB_OPINIAO O "
                    + "INNER JOIN TAB_CLIENTE C ON O.CLI_CODIGO = C.CLI_CODIGO "
                    + "WHERE O.OPN_DESCRICAO LIKE ? ORDER BY O.OPN_DATA DESC) "
                    + "WHERE ROWNUM <= 12";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, palavra);

            resultado = stm.executeQuery();

            crs = new CachedRowSetImpl();
            crs.populate(resultado);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar as "
                    + "opiniões", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return crs;
    }
}
