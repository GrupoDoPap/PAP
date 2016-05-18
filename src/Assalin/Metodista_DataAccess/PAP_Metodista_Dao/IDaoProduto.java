package Metodista_DataAccess.PAP_Metodista_Dao;

import java.sql.ResultSet;

public interface IDaoProduto {

    public ResultSet produtosMaisVendidosPorQuantidade();

    public ResultSet oportunidadeProdutoPorQuantidade();

    public ResultSet ameacaProdutoPorQuantidade();

    public ResultSet produtosMaisVendidosPorValor();

    public ResultSet oportunidadeProdutoPorValor();

    public ResultSet ameacaProdutoPorValor();

    public ResultSet produtosMaisElogiados();

    public ResultSet produtosMaisCompradosPorEstado();

    public ResultSet produtosMenosVendidos();

    public ResultSet produtosMaisCriticados();

    public ResultSet produtosMaisDevolvidosPorEstado();
}
