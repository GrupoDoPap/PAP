package Metodista_DataAccess.PAP_Metodista_Dao;

public interface IDaoClassificacao {

    public String selecionarNomeClassificacao(int codigo);

    public int selecionarCodigoClassificacao(String nome);
}
