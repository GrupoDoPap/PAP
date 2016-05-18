package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface IDaoCliente {

    public ResultSet clientesQueMaisCompraramPorValor();

    public ResultSet oportunidadeCliente();

    public ResultSet ameacaCliente();

    public ResultSet clientesQueMaisCompraramPorQuantidade();

    public ResultSet beltsQueMaisCompraram();

    public ResultSet clientesHaMaisTempoSemComprar();

    public ResultSet clientesQueCompraramRecentemente();

    public ResultSet comprasPorCLiente(Cliente cliente);

    public ResultSet clienteAumentoCompras();

    public ResultSet clienteQuedaCompras();

    public Cliente pesquisarClientePorCpfCnpj(String cpfCnpj);

    public Cliente pesquisarClientePorCodigo(int codigo);

    public ArrayList<Cliente> listarClientes();

    public int ultimoIdCliente();

}
