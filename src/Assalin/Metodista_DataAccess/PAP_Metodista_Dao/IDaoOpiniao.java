package Metodista_DataAccess.PAP_Metodista_Dao;

import java.sql.ResultSet;

public interface IDaoOpiniao {

    public ResultSet atualizarCitacoes(String fonte);

    public ResultSet atualizarElogios(String fonte);

    public ResultSet atualizarCriticas(String fonte);

    public ResultSet buscaPersonalizada(String palavra);
}
