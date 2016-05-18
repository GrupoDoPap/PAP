package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Veiculo;
import java.util.ArrayList;

public interface IDaoVeiculo {

    public ArrayList<Veiculo> listarVeiculos();

    public Veiculo buscarVeiculoPorDescricao(String descricao);
}
