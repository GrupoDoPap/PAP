package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class DaoProduto extends DaoBase implements IDaoProduto {

    private Produto produto = null;
    private final Conexao con = new Conexao();
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado;

    /**
     * Tela Início - Aba Hoje - Gráfico 2; Tela Produtos - Aba Oportunidades -
     * Gráfico 1
     *
     * @return nome do produto, quantidade de produtos
     */
    public CachedRowSet produtosMaisVendidosPorQuantidade() {

        sql = "SELECT * FROM (SELECT P.PRD_NOME, SUM(V.PRD_QUANTIDADE) FROM "
                + "TAB_PRODUTO P JOIN TAB_VENDA_PRODUTO V ON P.PRD_CODIGO = "
                + "V.PRD_CODIGO GROUP BY P.PRD_NOME ORDER BY 2 DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Oportunidade - Gráfico 2
     *
     * @return produto, mes, quantidade de produtos
     */
    public CachedRowSet oportunidadeProdutoPorQuantidade() {

        sql = "SELECT P.PRD_NOME, TO_CHAR(V.VND_DATA, 'MM/YY'), "
                + "SUM(VP.PRD_QUANTIDADE) FROM TAB_PRODUTO P JOIN "
                + "TAB_VENDA_PRODUTO VP ON VP.PRD_CODIGO = P.PRD_CODIGO "
                + "JOIN TAB_VENDA V ON VP.VND_CODIGO = V.VND_CODIGO WHERE "
                + "V.VND_DATA >= ADD_MONTHS(SYSDATE, -5) AND P.PRD_CODIGO "
                + "IN(SELECT PRD_CODIGO FROM (SELECT VP2.PRD_CODIGO, "
                + "SUM(VP2.PRD_QUANTIDADE) FROM TAB_VENDA_PRODUTO VP2 JOIN "
                + "TAB_VENDA V2 ON VP2.VND_CODIGO = V2.VND_CODIGO WHERE "
                + "V2.VND_DATA >= ADD_MONTHS(SYSDATE, -5) GROUP BY "
                + "PRD_CODIGO ORDER BY 2 DESC) WHERE ROWNUM = 1) GROUP BY "
                + "P.PRD_NOME, TO_CHAR(V.VND_DATA, 'MM/YY') ORDER BY 2 DESC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Ameaças - Gráfico 2
     *
     * @return produto, mês, quantidade vendida
     */
    public CachedRowSet ameacaProdutoPorQuantidade() {

        sql = "SELECT P.PRD_NOME, TO_CHAR(V.VND_DATA, 'MM/YY'), "
                + "SUM(VP.PRD_QUANTIDADE) FROM TAB_PRODUTO P JOIN "
                + "TAB_VENDA_PRODUTO VP ON VP.PRD_CODIGO = P.PRD_CODIGO "
                + "JOIN TAB_VENDA V ON VP.VND_CODIGO = V.VND_CODIGO WHERE "
                + "V.VND_DATA >= ADD_MONTHS(SYSDATE, -5) AND P.PRD_CODIGO "
                + "IN(SELECT PRD_CODIGO FROM (SELECT VP2.PRD_CODIGO, "
                + "SUM(VP2.PRD_QUANTIDADE) FROM TAB_VENDA_PRODUTO VP2 JOIN "
                + "TAB_VENDA V2 ON VP2.VND_CODIGO = V2.VND_CODIGO WHERE "
                + "V2.VND_DATA >= ADD_MONTHS(SYSDATE, -5) GROUP BY "
                + "PRD_CODIGO ORDER BY 2 ASC) WHERE ROWNUM = 1) GROUP BY "
                + "P.PRD_NOME, TO_CHAR(V.VND_DATA, 'MM/YY') ORDER BY 2 DESC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Vendas - Aba Hoje - Gráfico 1
     *
     * @return produto, valor monetário
     */
    public CachedRowSet produtosMaisVendidosPorValor() {

        sql = "SELECT * FROM (SELECT P.PRD_NOME, VP.PRD_QUANTIDADE * "
                + "P.PRD_PRECO FROM TAB_PRODUTO P JOIN TAB_VENDA_PRODUTO VP "
                + "ON P.PRD_CODIGO = VP.PRD_CODIGO ORDER BY 2 DESC) "
                + "WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Vendas - Aba Oportunidades - Gráfico 1
     *
     * @return produto, mês, valor monetário
     */
    public CachedRowSet oportunidadeProdutoPorValor() {

        sql = "SELECT P.PRD_NOME, TO_CHAR(V.VND_DATA, 'MM/YY'), "
                + "SUM(V.VND_VALOR_FINAL) FROM TAB_PRODUTO P JOIN "
                + "TAB_VENDA_PRODUTO VP ON VP.PRD_CODIGO = P.PRD_CODIGO "
                + "JOIN TAB_VENDA V ON VP.VND_CODIGO = V.VND_CODIGO WHERE "
                + "V.VND_DATA >= ADD_MONTHS(SYSDATE, -5) AND P.PRD_CODIGO "
                + "IN(SELECT PRD_CODIGO FROM (SELECT VP2.PRD_CODIGO, "
                + "SUM(V2.VND_VALOR_FINAL) FROM TAB_VENDA_PRODUTO VP2 JOIN "
                + "TAB_VENDA V2 ON VP2.VND_CODIGO = V2.VND_CODIGO WHERE "
                + "V2.VND_DATA >= ADD_MONTHS(SYSDATE, -5) GROUP BY "
                + "PRD_CODIGO ORDER BY 2 DESC) WHERE ROWNUM = 1) GROUP BY "
                + "P.PRD_NOME, TO_CHAR(V.VND_DATA, 'MM/YY') ORDER BY 2 DESC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Oportunidades - Gráfico 2; Tela Vendas - Aba Ameaças -
     * Gráfico 1
     *
     * @return produto, mês, valor monetário
     */
    public CachedRowSet ameacaProdutoPorValor() {

        sql = "SELECT P.PRD_NOME, TO_CHAR(V.VND_DATA, 'MM/YY'), "
                + "SUM(V.VND_VALOR_FINAL) FROM TAB_PRODUTO P JOIN "
                + "TAB_VENDA_PRODUTO VP ON VP.PRD_CODIGO = P.PRD_CODIGO "
                + "JOIN TAB_VENDA V ON VP.VND_CODIGO = V.VND_CODIGO WHERE "
                + "V.VND_DATA >= ADD_MONTHS(SYSDATE, -5) AND P.PRD_CODIGO "
                + "IN(SELECT PRD_CODIGO FROM (SELECT VP2.PRD_CODIGO, "
                + "SUM(V2.VND_VALOR_FINAL) FROM TAB_VENDA_PRODUTO VP2 JOIN "
                + "TAB_VENDA V2 ON VP2.VND_CODIGO = V2.VND_CODIGO WHERE "
                + "V2.VND_DATA >= ADD_MONTHS(SYSDATE, -5) GROUP BY "
                + "PRD_CODIGO ORDER BY 2 ASC) WHERE ROWNUM = 1) GROUP BY "
                + "P.PRD_NOME, TO_CHAR(V.VND_DATA, 'MM/YY') ORDER BY 2 DESC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Produto - Aba Oportunidades - Gráfico 2
     *
     * @return produto, quantidade
     */
    public CachedRowSet produtosMaisElogiados() {

        sql = "SELECT * FROM (SELECT P.PRD_NOME, COUNT(R.ATD_NUMERO) FROM "
                + "TAB_PRODUTO P JOIN TAB_RECLAMACAO R ON P.PRD_CODIGO = "
                + "R.PRD_CODIGO JOIN TAB_ATENDIMENTO A ON A.ATD_NUMERO = "
                + "R.ATD_NUMERO WHERE A.ATD_SATISFACAO "
                + "IN('SATISFEITO','MUITO SATISFEITO') GROUP BY P.PRD_NOME "
                + "ORDER BY COUNT (R.ATD_NUMERO) DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Produtos - Aba Oportunidades - Gráfico 4
     *
     * @return estado, produto, quantidade
     */
    public CachedRowSet produtosMaisCompradosPorEstado() {

        sql = "SELECT * FROM (SELECT C.CLI_UF, P.PRD_NOME, "
                + "SUM(VP.PRD_QUANTIDADE) FROM TAB_CLIENTE C JOIN TAB_VENDA "
                + "V ON V.CLI_CODIGO = C.CLI_CODIGO JOIN TAB_VENDA_PRODUTO "
                + "VP ON VP.VND_CODIGO = V.VND_CODIGO JOIN TAB_PRODUTO P ON "
                + "VP.PRD_CODIGO = P.PRD_CODIGO WHERE V.VND_DATA >= "
                + "ADD_MONTHS(SYSDATE, -5) AND C.CLI_UF IN (SELECT CLI_UF "
                + "FROM (SELECT C1.CLI_UF, SUM(VP1.PRD_QUANTIDADE) FROM "
                + "TAB_CLIENTE C1 JOIN TAB_VENDA V1 ON V1.CLI_CODIGO = "
                + "C1.CLI_CODIGO JOIN TAB_VENDA_PRODUTO VP1 ON "
                + "VP1.VND_CODIGO = V1.VND_CODIGO WHERE V1.VND_DATA >= "
                + "ADD_MONTHS(SYSDATE, -5) GROUP BY C1.CLI_UF ORDER BY 2 "
                + "DESC) WHERE ROWNUM <= 5) GROUP BY C.CLI_UF, P.PRD_NOME "
                + "ORDER BY 3 DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Protudos - Aba Ameaças - Gráfico 1
     *
     * @return produto, quantidade
     */
    public CachedRowSet produtosMenosVendidos() {

        sql = "SELECT * FROM (SELECT P.PRD_NOME, SUM(V.PRD_QUANTIDADE) FROM "
                + "TAB_PRODUTO P JOIN TAB_VENDA_PRODUTO V ON P.PRD_CODIGO = "
                + "V.PRD_CODIGO GROUP BY P.PRD_NOME ORDER BY 2 ASC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Produtos - Aba Ameaças - Gráfico 2
     *
     * @return produto, quantidade
     */
    public CachedRowSet produtosMaisCriticados() {

        sql = "SELECT * FROM (SELECT P.PRD_NOME, COUNT (R.ATD_NUMERO) FROM "
                + "TAB_PRODUTO P JOIN TAB_RECLAMACAO R ON P.PRD_CODIGO = "
                + "R.PRD_CODIGO JOIN TAB_ATENDIMENTO A ON A.ATD_NUMERO = "
                + "R.ATD_NUMERO WHERE A.ATD_SATISFACAO "
                + "IN('INSATISFEITO','MUITO INSATISFEITO') "
                + "GROUP BY P.PRD_NOME ORDER BY COUNT "
                + "(R.ATD_NUMERO) DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Produtos - Aba Ameaças - Gráfico 4
     *
     * @return produto, quantidade
     */
    public CachedRowSet produtosMaisDevolvidosPorEstado() {

        sql = "SELECT * FROM (SELECT P.PRD_NOME, COUNT(R.ATD_NUMERO) FROM "
                + "TAB_PRODUTO P JOIN TAB_RECLAMACAO R ON P.PRD_CODIGO = "
                + "R.PRD_CODIGO JOIN TAB_ATENDIMENTO A ON A.ATD_NUMERO = "
                + "R.ATD_NUMERO WHERE A.ATD_MOTIVO = 'DEVOLUÇÃO' GROUP BY "
                + "P.PRD_NOME ORDER BY COUNT (R.ATD_NUMERO) DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Seleciona produto por código
     *
     * @param codigo: código do produto a ser escolhido
     * @return Produto selecionado
     */
    public Produto get(int codigo) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_PRODUTO WHERE PRD_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, codigo);

            resultado = stm.executeQuery();
            resultado.next();
            produto = new Produto(resultado.getInt("PRD_CODIGO"),
                    resultado.getDouble("PRD_PRECO"),
                    resultado.getString("PRD_NOME"),
                    resultado.getString("PRD_VALIDADE"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o produto", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return produto;
    }
}
