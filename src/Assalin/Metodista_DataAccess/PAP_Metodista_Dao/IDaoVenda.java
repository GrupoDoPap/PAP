package Metodista_DataAccess.PAP_Metodista_Dao;

import java.sql.ResultSet;

public interface IDaoVenda {

    public ResultSet quantidadeVendida();

    public ResultSet quantidadeVendidaValorMonetario();

    public ResultSet estadosMaiorVenda();

    public ResultSet estadosMaiorVendaValorMonetario();

    public ResultSet estadosMaiorAumentoMesPassadoAtual();

    public ResultSet estadosMaiorQuedaMesPassadoAtual();

    public ResultSet estadoMaiorAumento();

    public ResultSet estadoMaiorQueda();

    public ResultSet estadoMaiorQuedaValorMonetario();

    public ResultSet cidadesMaioresCompras();

    public ResultSet mesMaiorVenda();

    public ResultSet mesMenorVenda();

    public ResultSet mesesMaiorQuedaVenda();

    public ResultSet mesesMaiorAumentoVenda();

    public ResultSet mesMaiorAumentoValorMonetario();

    public ResultSet mesMaiorQuedaValorMonetario();

}
