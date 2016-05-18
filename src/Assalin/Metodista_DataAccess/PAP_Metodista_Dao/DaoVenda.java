package Metodista_DataAccess.PAP_Metodista_Dao;

import javax.sql.rowset.CachedRowSet;

public class DaoVenda extends DaoBase implements IDaoVenda {

    private String sql;

    /**
     * Tela Início - Aba Hoje - Gráfico 1
     *
     * @return Data, Soma do valor monetário
     */
    public CachedRowSet quantidadeVendida() {

        sql = "SELECT VND_DATA, SUM(VND_VALOR_FINAL) FROM TAB_VENDA "
                + "WHERE VND_DATA <= SYSDATE AND VND_DATA >= SYSDATE - 7 "
                + "GROUP BY VND_DATA ORDER BY SUM(VND_VALOR_FINAL) DESC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Vendas - Aba Hoje - Gráfico 3
     *
     * @return Mês, Soma do valor monetário
     */
    public CachedRowSet quantidadeVendidaValorMonetario() {

        sql = "SELECT TO_CHAR(VND_DATA, 'MM/YY'), SUM(VND_VALOR_FINAL) "
                + "FROM TAB_VENDA "
                + "WHERE TO_CHAR(VND_DATA, 'MM/YY') <= TO_CHAR(SYSDATE,'MM/YY') "
                + "AND TO_CHAR(VND_DATA, 'MM/YY') >= TO_CHAR(ADD_MONTHS(SYSDATE, -5),'MM/YY') "
                + "GROUP BY TO_CHAR(VND_DATA, 'MM/YY') ORDER BY TO_CHAR(VND_DATA, 'MM/YY')";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Hoje - Gráfico 4; Tela Mercado - Aba Hoje - Gráfico 1
     *
     * @return estado, quandidade de vendas
     */
    public CachedRowSet estadosMaiorVenda() {

        sql = "SELECT * FROM (SELECT C.CLI_UF, COUNT(V.VND_CODIGO) "
                + "FROM TAB_CLIENTE C JOIN TAB_VENDA V ON C.CLI_CODIGO = "
                + "V.CLI_CODIGO GROUP BY C.CLI_UF ORDER BY 2 DESC) WHERE ROWNUM <=5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Vendas - Aba Hoje - Gráfico 2
     *
     * @return estado, soma do valor monetário
     */
    public CachedRowSet estadosMaiorVendaValorMonetario() {

        sql = "SELECT * FROM (SELECT C.CLI_UF, SUM(V.VND_VALOR_FINAL) FROM TAB_CLIENTE C "
                + "JOIN TAB_VENDA V ON C.CLI_CODIGO = V.CLI_CODIGO "
                + "GROUP BY C.CLI_UF ORDER BY 2 DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Mercado - Aba Hoje - Gráfico 2
     *
     * @return estado, soma da quantidade vendida
     */
    public CachedRowSet estadosMaiorAumentoMesPassadoAtual() {

        sql = "SELECT * FROM (SELECT C.CLI_UF, SUM(V.VND_CODIGO) FROM "
                + "TAB_CLIENTE C JOIN TAB_VENDA V ON C.CLI_CODIGO = "
                + "V.CLI_CODIGO WHERE TO_CHAR(V.VND_DATA, 'MM/YY')  >= "
                + "TO_CHAR(ADD_MONTHS(SYSDATE, -2), 'MM/YY') GROUP BY "
                + "C.CLI_UF ORDER BY SUM(V.VND_CODIGO) DESC) WHERE ROWNUM <=5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Mercado - Aba Hoje - Gráfico 4
     *
     * @return estado, soma da quantidade vendida
     */
    public CachedRowSet estadosMaiorQuedaMesPassadoAtual() {

        sql = "SELECT * FROM (SELECT C.CLI_UF, SUM(V.VND_CODIGO) FROM TAB_CLIENTE C "
                + "JOIN TAB_VENDA V ON C.CLI_CODIGO = V.CLI_CODIGO "
                + "WHERE TO_CHAR(V.VND_DATA, 'MM/YY')  >= TO_CHAR(ADD_MONTHS(SYSDATE, -2), 'MM/YY') "
                + "GROUP BY C.CLI_UF ORDER BY SUM(V.VND_CODIGO) ASC) WHERE ROWNUM <=5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Oportunidades - Gráfico 4
     *
     * @return estado, mês, valor monetário
     */
    public CachedRowSet estadoMaiorAumento() {

        sql = "SELECT C.CLI_UF, TO_CHAR(V.VND_DATA, 'MONTH/YY'), "
                + "V.VND_VALOR_FINAL FROM TAB_CLIENTE C JOIN TAB_VENDA V "
                + "ON C.CLI_CODIGO = V.CLI_CODIGO WHERE ADD_MONTHS(SYSDATE, -5) "
                + "< VND_DATA AND V.CLI_CODIGO IN (SELECT CLI_CODIGO FROM "
                + "(SELECT CLI_CODIGO, COUNT(VND_CODIGO) FROM TAB_VENDA "
                + "WHERE ADD_MONTHS(SYSDATE,-5) < VND_DATA GROUP BY "
                + "CLI_CODIGO ORDER BY 2 DESC) WHERE ROWNUM =1 ) "
                + "ORDER BY TO_CHAR(V.VND_DATA, 'MM/YY') ASC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Ameaças - Gráfico 4
     *
     * @return estado, mês, valor monetário
     */
    public CachedRowSet estadoMaiorQueda() {

        sql = "SELECT C.CLI_UF, TO_CHAR(V.VND_DATA, 'MONTH/YY'), "
                + "V.VND_VALOR_FINAL FROM TAB_CLIENTE C JOIN TAB_VENDA V "
                + "ON C.CLI_CODIGO = V.CLI_CODIGO WHERE ADD_MONTHS(SYSDATE, -5) "
                + "< VND_DATA AND V.CLI_CODIGO IN (SELECT CLI_CODIGO FROM "
                + "(SELECT CLI_CODIGO, COUNT(VND_CODIGO) FROM TAB_VENDA "
                + "WHERE ADD_MONTHS(SYSDATE,-5) < VND_DATA GROUP BY "
                + "CLI_CODIGO ORDER BY 2 ASC) WHERE ROWNUM =1 ) "
                + "ORDER BY TO_CHAR(V.VND_DATA, 'MM/YY') ASC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Vendas - Aba Ameaças - Gráfico 2
     *
     * @return estado, mes, valor monetário
     */
    public CachedRowSet estadoMaiorQuedaValorMonetario() {

        sql = "SELECT C.CLI_UF, TO_CHAR(V.VND_DATA, 'MONTH/YY'), "
                + "V.VND_VALOR_FINAL FROM TAB_CLIENTE C JOIN TAB_VENDA V ON "
                + "C.CLI_CODIGO = V.CLI_CODIGO WHERE ADD_MONTHS(SYSDATE, -5) "
                + "< VND_DATA AND V.CLI_CODIGO IN (SELECT CLI_CODIGO FROM "
                + "(SELECT CLI_CODIGO, SUM(VND_VALOR_FINAL) FROM TAB_VENDA "
                + "WHERE ADD_MONTHS(SYSDATE,-5) < VND_DATA GROUP BY "
                + "CLI_CODIGO ORDER BY 2 ASC) WHERE ROWNUM =1 ) ORDER BY "
                + "TO_CHAR(V.VND_DATA, 'MM/YY') ASC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Vendas - Aba Oportunidades - Gráfico 2
     *
     * @return estado, data, valor monetário
     */
    public CachedRowSet estadoMaiorAumentoValorMonetario() {

        sql = "SELECT \"ESTADO\", \"DATA\", SUM(\"QNTD\") FROM "
                + "(SELECT C.CLI_UF \"ESTADO\", TO_CHAR(V.VND_DATA, 'MM/YY') "
                + "\"DATA\", V.VND_VALOR_FINAL \"QNTD\" FROM TAB_CLIENTE C "
                + "JOIN TAB_VENDA V ON C.CLI_CODIGO = V.CLI_CODIGO WHERE "
                + "ADD_MONTHS(SYSDATE, -5) < V.VND_DATA AND C.CLI_UF IN "
                + "(SELECT CLI_UF FROM (SELECT C2.CLI_UF, COUNT(V2.VND_CODIGO) "
                + "FROM TAB_VENDA V2 JOIN TAB_CLIENTE C2 ON V2.CLI_CODIGO = "
                + "C2.CLI_CODIGO WHERE ADD_MONTHS(SYSDATE,-5) < V2.VND_DATA "
                + "GROUP BY C2.CLI_UF ORDER BY 2 DESC) WHERE ROWNUM = 1 )) "
                + "GROUP BY ESTADO, \"DATA\" ORDER BY DATA ASC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Mercado - Aba Hoje - Gráfico 3
     *
     * @return cidade, estado, data, valor monerário
     */
    public CachedRowSet cidadesMaioresCompras() {

        sql = "SELECT * FROM (SELECT C.CLI_CIDADE, C.CLI_UF, V.VND_DATA, "
                + "SUM(V.VND_VALOR_FINAL) FROM TAB_CLIENTE C JOIN TAB_VENDA "
                + "V ON C.CLI_CODIGO = V.CLI_CODIGO GROUP BY C.CLI_CIDADE, "
                + "C.CLI_UF, V.VND_DATA ORDER BY 4 DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Oportunidades - Gráfico 1
     *
     * @return data, quantidade vendida
     */
    public CachedRowSet mesMaiorVenda() {

        sql = "SELECT * FROM (SELECT TO_CHAR(VND_DATA, 'MONTH/YY'), "
                + "SUM(VND_CODIGO) FROM TAB_VENDA GROUP BY TO_CHAR(VND_DATA,"
                + " 'MONTH/YY') ORDER BY COUNT(VND_CODIGO) DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Ameaças - Gráfico 1
     *
     * @return data, quantidade vendida
     */
    public CachedRowSet mesMenorVenda() {

        sql = "SELECT * FROM (SELECT TO_CHAR(VND_DATA, 'MONTH/YY'), "
                + "SUM(VND_CODIGO) FROM TAB_VENDA GROUP BY TO_CHAR(VND_DATA, "
                + "'MONTH/YY') ORDER BY COUNT(VND_CODIGO) ASC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Produtos - Aba Ameaças - Gráfico 3
     *
     * @return mes, quantidade vendida
     */
    public CachedRowSet mesesMaiorQuedaVenda() {

        sql = "SELECT TO_CHAR(VND_DATA, 'MONTH/YY'), SUM(VND_CODIGO) FROM "
                + "TAB_VENDA WHERE ADD_MONTHS(SYSDATE, -2) < VND_DATA AND "
                + "TO_CHAR(VND_DATA, 'MM/YY') IN (SELECT \"MES\" FROM (SELECT "
                + "TO_CHAR(VND_DATA, 'MM/YY')\"MES\", COUNT(VND_CODIGO) FROM "
                + "TAB_VENDA WHERE ADD_MONTHS(SYSDATE,-2) < VND_DATA GROUP "
                + "BY TO_CHAR(VND_DATA, 'MM/YY') ORDER BY 2 ASC) WHERE "
                + "ROWNUM <= 5 ) GROUP BY TO_CHAR(VND_DATA, 'MONTH/YY') ORDER BY 2 ASC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Vendas - Aba Oportunidades - Gráfico 4
     *
     * @return mes, quantidade vendida
     */
    public CachedRowSet mesesMaiorAumentoVenda() {

        sql = "SELECT TO_CHAR(VND_DATA, 'MONTH/YY'), SUM(VND_CODIGO) FROM "
                + "TAB_VENDA WHERE ADD_MONTHS(SYSDATE, -2) < VND_DATA AND "
                + "TO_CHAR(VND_DATA, 'MM/YY') IN (SELECT \"MES\" FROM (SELECT "
                + "TO_CHAR(VND_DATA, 'MM/YY')\"MES\", COUNT(VND_CODIGO) FROM "
                + "TAB_VENDA WHERE ADD_MONTHS(SYSDATE,-2) < VND_DATA GROUP "
                + "BY TO_CHAR(VND_DATA, 'MM/YY') ORDER BY 2 DESC) WHERE "
                + "ROWNUM <= 5 ) GROUP BY TO_CHAR(VND_DATA, 'MONTH/YY') ORDER BY 2 DESC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Produtos - Aba Oportunidade - Gráfico 3
     *
     * @return mes, valor monetário
     */
    public CachedRowSet mesMaiorAumentoValorMonetario() {

        sql = "SELECT TO_CHAR(VND_DATA, 'MONTH/YY'), SUM(VND_VALOR_FINAL) "
                + "FROM TAB_VENDA WHERE ADD_MONTHS(SYSDATE, -2) < VND_DATA "
                + "AND TO_CHAR(VND_DATA, 'MM/YY') IN (SELECT \"MES\" FROM "
                + "(SELECT TO_CHAR(VND_DATA, 'MM/YY')\"MES\", COUNT(VND_CODIGO) "
                + "FROM TAB_VENDA WHERE ADD_MONTHS(SYSDATE,-2) < VND_DATA "
                + "GROUP BY TO_CHAR(VND_DATA, 'MM/YY') ORDER BY 2 DESC) WHERE "
                + "ROWNUM <= 5 ) GROUP BY TO_CHAR(VND_DATA, 'MONTH/YY') ORDER BY 2 DESC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Vendas - Aba Ameaças - Gráfico 4
     *
     * @return mes, quantidade vendida
     */
    public CachedRowSet mesMaiorQuedaValorMonetario() {

        sql = "SELECT TO_CHAR(VND_DATA, 'MONTH/YY'), SUM(VND_CODIGO) FROM "
                + "TAB_VENDA WHERE ADD_MONTHS(SYSDATE, -2) < VND_DATA AND "
                + "TO_CHAR(VND_DATA, 'MM/YY') IN (SELECT \"MES\" FROM "
                + "(SELECT TO_CHAR(VND_DATA, 'MM/YY')\"MES\", COUNT(VND_CODIGO) "
                + "FROM TAB_VENDA WHERE ADD_MONTHS(SYSDATE,-2) < VND_DATA "
                + "GROUP BY TO_CHAR(VND_DATA, 'MM/YY') ORDER BY 2 ASC) WHERE "
                + "ROWNUM <= 5 ) GROUP BY TO_CHAR(VND_DATA, 'MONTH/YY') ORDER BY 2 ASC";

        return super.executeQuery(sql);
    }
}
