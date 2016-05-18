package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Caixa;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoPedido extends DaoBase implements IDaoPedido {

    private final DaoCliente dc = new DaoCliente();
    private final DaoPedidoCaixa dpc = new DaoPedidoCaixa();

    private final Conexao con = new Conexao();
    private Connection conexao;
    private PreparedStatement stm;
    private ResultSet resultado;
    private String sql;

    private Cliente cliente = null;
    private Pedido pedido = null;
    private ArrayList<Caixa> arrayCaixas = new ArrayList<>();
    private final ArrayList<Pedido> arrayPedidos = new ArrayList<>();

    /**
     * Tela Viagem
     *
     * @param codigo: Código do pedido que será buscado
     * @return Pedido informado
     */
    public Pedido get(int codigo) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_PEDIDO WHERE PDD_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, codigo);
            resultado = stm.executeQuery();
            resultado.next();

            //coleta o array de caixas
            arrayCaixas.clear();
            arrayCaixas = dpc.listarCaixasPorPedido(codigo);

            //coleta o cliente
            cliente = dc.pesquisarClientePorCodigo(resultado.getInt("CLI_CODIGO"));

            //criando o pedido
            pedido = new Pedido(resultado.getDouble("PDD_PESO"),
                    resultado.getString("PDD_DATA_ENTREGA"),
                    arrayCaixas,
                    cliente);

            pedido.setCodigo(resultado.getInt("PDD_CODIGO"));
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o pedido", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            con.fecharConexao(conexao);
        }
        return pedido;
    }

    /**
     * Tela pedido
     *
     * @param pedido: Pedido a ser incluído
     */
    public boolean save(Pedido pedido) {

        try {
            int id = this.ultimoID() + 1;
            conexao = con.abrirConexao();
            sql = "INSERT INTO TAB_PEDIDO (PDD_CODIGO, CLI_CODIGO, PDD_PESO, "
                    + "PDD_DATA_ENTREGA) VALUES (?, ?, ?, ?)";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, pedido.getCliente().getCodigo());
            stm.setDouble(3, pedido.getPesoPedido());
            stm.setString(4, pedido.getDataEntrega());

            stm.execute();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o pedido", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
    }

    /**
     * Lista todos os pedidos
     *
     * @return Array com os pedidos existentes
     */
    public ArrayList<Pedido> listarPedidos() {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_PEDIDO";
            stm = conexao.prepareStatement(sql);

            resultado = stm.executeQuery();

            while (resultado.next()) {
                //coleta o array de caixas
                arrayCaixas = dpc.listarCaixasPorPedido(resultado.getInt("PDD_CODIGO"));

                //coleta o cliente
                cliente = dc.pesquisarClientePorCodigo(resultado.getInt("CLI_CODIGO"));

                //criando o pedido
                pedido = new Pedido(resultado.getDouble("PDD_PESO"),
                        resultado.getString("PDD_DATA_ENTREGA"),
                        arrayCaixas,
                        cliente);

                pedido.setCodigo(resultado.getInt("PDD_CODIGO"));

                arrayPedidos.add(pedido);
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar a lista", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return arrayPedidos;
    }

    /**
     * Busca o último id inserido no banco
     *
     * @return ultimo id do banco
     */
    public int ultimoID() {

        int id = -1;
        try {
            conexao = con.abrirConexao();
            sql = "SELECT MAX(PDD_CODIGO) FROM TAB_PEDIDO";
            stm = conexao.prepareStatement(sql);
            resultado = stm.executeQuery();
            resultado.next();
            id = resultado.getInt(1);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o ID", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return id;
    }
}
