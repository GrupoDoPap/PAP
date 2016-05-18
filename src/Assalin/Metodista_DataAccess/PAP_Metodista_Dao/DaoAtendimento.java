package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Atendimento;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class DaoAtendimento extends DaoBase implements IDaoAtendimento {

    private final Conexao con = new Conexao();
    private final DaoCliente dc = new DaoCliente();
    private final DaoReclamacao dr = new DaoReclamacao();
    private Atendimento atendimento = null;
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado;

    /**
     * Tela SAC - Aba Análise Atual - Gráfico 1
     *
     * @return dia da semana, quantidade
     */
    public CachedRowSet ocorrenciasAbertasPorDiaDaSemana() {

        sql = "SELECT TO_CHAR(ATD_DATA_INICIO, 'DAY'), COUNT(ATD_NUMERO) "
                + "FROM TAB_ATENDIMENTO GROUP BY TO_CHAR(ATD_DATA_INICIO, 'DAY')";

        return super.executeQuery(sql);
    }

    /**
     * Tela SAC - Aba Análise Atual - Gráfico 3
     *
     * @return cliente, quantidade
     */
    public CachedRowSet clientesQueMaisReclamaram() {

        sql = "SELECT * FROM (SELECT C.CLI_NOME, COUNT(A.ATD_NUMERO) FROM "
                + "TAB_ATENDIMENTO A JOIN TAB_CLIENTE C ON C.CLI_CODIGO = "
                + "A.CLI_CODIGO GROUP BY C.CLI_NOME ORDER BY 2 DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela SAC - Aba Análise Atual - Gráfico 2
     *
     * @return data, quantidade
     */
    public CachedRowSet ocorrenciasAbertasPorDia() {

        sql = "SELECT ATD_DATA_INICIO, COUNT (ATD_NUMERO) FROM TAB_ATENDIMENTO "
                + "WHERE ATD_DATA_INICIO >= SYSDATE - 7 GROUP BY ATD_DATA_INICIO ORDER BY 1 DESC";

        return super.executeQuery(sql);
    }

    /**
     * Tela SAC - Aba Análise Atual - Gráfico 4
     *
     * @return mês, quantidade
     */
    public CachedRowSet tempoMedioDeSolucao() {

        sql = "SELECT TO_CHAR(ATD_DATA_FIM, 'MONTH/YY'), AVG(ATD_DATA_FIM - "
                + "ATD_DATA_INICIO) FROM TAB_ATENDIMENTO WHERE ATD_DATA_FIM "
                + ">= ADD_MONTHS(SYSDATE, -1) GROUP BY "
                + "TO_CHAR(ATD_DATA_FIM, 'MONTH/YY') ORDER BY 1 DESC";

        return super.executeQuery(sql);
    }

    /**
     * Tela SAC - Aba Grau de Satisfação - Gráfico 1
     *
     * @return satisfação, quantidade
     */
    public CachedRowSet grauDeSatisfacao() {

        sql = "SELECT ATD_SATISFACAO, COUNT(ATD_SATISFACAO) "
                + "FROM TAB_ATENDIMENTO GROUP BY ATD_SATISFACAO";

        return super.executeQuery(sql);
    }

    /**
     * Tela SAC - Aba Gerar Novo Atendimento
     *
     * @param atendimento: Atendimento a ser inserido
     * @param usuario: usuário que efetuou o atendimento
     * @return True para ok. False para não ok
     */
    public boolean registrarAtendimento(Atendimento atendimento, Usuario usuario) {

        try {
            int id = this.ultimoID() + 1;
            conexao = con.abrirConexao();
            sql = "INSERT INTO TAB_ATENDIMENTO(ATD_NUMERO, CLI_CODIGO, FUN_CODIGO, "
                    + "ATD_DATA_INICIO, ATD_DATA_FIM, ATD_SATISFACAO, ATD_STATUS, "
                    + "ATD_MOTIVO, ATD_DESCRICAO) VALUES (?,?,?,?,?,?,?,?,?)";

            stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, 1);
            stm.setInt(3, usuario.getCodigo());
            stm.setString(4, atendimento.getDataInicio());
            stm.setString(5, atendimento.getDataFim());
            stm.setString(6, atendimento.getSatisfacao());
            stm.setString(7, atendimento.getStatus());
            stm.setString(8, atendimento.getMotivo());
            stm.setString(9, atendimento.getMotivo());

            stm.execute();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir o atendimento", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
    }

    /**
     * Tela SAC - Aba Alterar Atendimento
     *
     * @param numAtendimento: Código do atendimento a ser buscado
     * @return Atendimento selecionado
     */
    public Atendimento get(int numAtendimento) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_ATENDIMENTO WHERE ATD_NUMERO = ?";

            stm = conexao.prepareStatement(sql);
            stm.setInt(1, numAtendimento);

            resultado = stm.executeQuery();
            resultado.next();
            atendimento = new Atendimento(resultado.getInt("ATD_NUMERO"),
                    resultado.getString("ATD_DATA_INICIO"),
                    resultado.getString("ATD_DATA_FIM"),
                    resultado.getString("ATD_SATISFACAO"),
                    resultado.getString("ATD_STATUS"),
                    resultado.getString("ATD_MOTIVO"),
                    resultado.getString("ATD_DESCRICAO"),
                    dc.pesquisarClientePorCodigo(resultado.getInt("CLI_CODIGO")),
                    dr.selecionarProdutoPorAtendimento(numAtendimento));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o atendimento", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return atendimento;
    }

    /**
     * Tela SAC - Aba Alterar Atendimento
     *
     * @param atendimento: atendimento a ser atualizado
     */
    public boolean update(Atendimento atendimento) {

        try {
            conexao = con.abrirConexao();
            sql = "UPDATE TAB_ATENDIMENTO SET CLI_CODIGO = ?, "
                    + "ATD_DATA_INICIO = ?, ATD_DATA_FIM = ?, ATD_SATISFACAO = ?, "
                    + "ATD_STATUS = ?, ATD_MOTIVO = ?, ATD_DESCRICAO = ? "
                    + "WHERE ATD_NUMERO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, atendimento.getNumero());
            stm.setString(2, atendimento.getDataInicio());
            stm.setString(3, atendimento.getDataFim());
            stm.setString(4, atendimento.getSatisfacao());
            stm.setString(5, atendimento.getStatus());
            stm.setString(6, atendimento.getMotivo());
            stm.setString(7, atendimento.getDescricao());
            stm.setInt(8, atendimento.getNumero());
            stm.executeUpdate();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o atendimento", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
    }

    /**
     * Seleciona o ultimo id inserido na base
     *
     * @return ultimo id na base
     */
    public int ultimoID() {
        int id = -1;

        try {
            conexao = con.abrirConexao();
            sql = "SELECT MAX(ATD_NUMERO) FROM TAB_ATENDIMENTO";
            stm = conexao.prepareStatement(sql);
            resultado = stm.executeQuery();
            resultado.next();
            id = resultado.getInt(1);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o Id", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return id;
    }
}
