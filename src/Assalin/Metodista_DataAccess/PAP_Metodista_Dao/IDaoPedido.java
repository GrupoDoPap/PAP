package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Pedido;
import java.util.ArrayList;

public interface IDaoPedido {

    public ArrayList<Pedido> listarPedidos();

    public int ultimoID();
}
