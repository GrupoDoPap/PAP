package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Atendimento;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Usuario;
import java.sql.ResultSet;

public interface IDaoAtendimento {

    public ResultSet ocorrenciasAbertasPorDiaDaSemana();

    public ResultSet clientesQueMaisReclamaram();

    public ResultSet ocorrenciasAbertasPorDia();

    public ResultSet tempoMedioDeSolucao();

    public ResultSet grauDeSatisfacao();

    public boolean registrarAtendimento(Atendimento atendimento, Usuario usuario);

    public int ultimoID();

}
