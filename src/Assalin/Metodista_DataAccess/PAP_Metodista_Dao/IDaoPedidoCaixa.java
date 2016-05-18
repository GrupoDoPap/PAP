package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Caixa;
import java.util.List;

public interface IDaoPedidoCaixa {

    public List<Caixa> listarCaixasPorPedido(int codPedido);
}
