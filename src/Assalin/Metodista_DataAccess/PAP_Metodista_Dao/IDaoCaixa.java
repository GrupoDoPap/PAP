package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Caixa;

public interface IDaoCaixa {

    public Caixa pesquisarCaixaPorNome(String nome);

    public Caixa pesquisarCaixaPorCodigo(int codigo);

}
