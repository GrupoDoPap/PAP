package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Produto;
import java.util.ArrayList;

public interface IDaoReclamacao {

    public ArrayList<Produto> selecionarProdutoPorAtendimento(int numAtendimento);
}
