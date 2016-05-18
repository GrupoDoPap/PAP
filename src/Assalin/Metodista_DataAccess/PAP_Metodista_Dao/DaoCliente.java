package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class DaoCliente extends DaoBase implements IDaoCliente {

    private final Conexao con = new Conexao();
    private final DaoTelefone dt = new DaoTelefone();
    private final DaoClassificacao dclass = new DaoClassificacao();
    private final ArrayList<Cliente> arrayClientes = new ArrayList<>();
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado;
    private Cliente cliente = null;
    private CachedRowSet crs = null;

    /**
     * Tela Vendas - Aba Hoje - Gráfico 4
     *
     * @return cliente, valor monetário
     */
    public CachedRowSet clientesQueMaisCompraramPorValor() {

        sql = "SELECT * FROM (SELECT C.CLI_NOME, SUM(V.VND_VALOR_FINAL) "
                + "FROM TAB_CLIENTE C JOIN TAB_VENDA V ON C.CLI_CODIGO = "
                + "V.CLI_CODIGO GROUP BY C.CLI_NOME ORDER BY "
                + "SUM(V.VND_VALOR_FINAL) DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - aba Oportunidades - Gráfico 3
     *
     * @return cliente, mês, quantidade
     */
    public CachedRowSet oportunidadeCliente() {

        sql = "SELECT C.CLI_NOME, TO_CHAR(V.VND_DATA, 'MONTH/YY'), "
                + "COUNT(V.VND_CODIGO) FROM TAB_CLIENTE C JOIN TAB_VENDA V "
                + "ON C.CLI_CODIGO = V.CLI_CODIGO WHERE V.CLI_CODIGO IN "
                + "(SELECT CLI_CODIGO FROM (SELECT CLI_CODIGO, COUNT(VND_CODIGO) "
                + "FROM TAB_VENDA WHERE VND_DATA > ADD_MONTHS(SYSDATE, -5) "
                + "GROUP BY CLI_CODIGO ORDER BY 2 DESC) WHERE ROWNUM = 1) "
                + "GROUP BY C.CLI_NOME, TO_CHAR(V.VND_DATA, 'MONTH/YY') "
                + "ORDER BY 2 ASC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - aba Ameaças - Gráfico 3
     *
     * @return cliente, mês, quantidade
     */
    public CachedRowSet ameacaCliente() {

        sql = "SELECT C.CLI_NOME, TO_CHAR(V.VND_DATA, 'MONTH/YY'), "
                + "COUNT(V.VND_CODIGO) FROM TAB_CLIENTE C JOIN TAB_VENDA V "
                + "ON C.CLI_CODIGO = V.CLI_CODIGO WHERE V.CLI_CODIGO IN "
                + "(SELECT CLI_CODIGO FROM (SELECT CLI_CODIGO, COUNT(VND_CODIGO) "
                + "FROM TAB_VENDA WHERE VND_DATA > ADD_MONTHS(SYSDATE, -5) "
                + "GROUP BY CLI_CODIGO ORDER BY 2 ASC) WHERE ROWNUM = 1) "
                + "GROUP BY C.CLI_NOME, TO_CHAR(V.VND_DATA, 'MONTH/YY') "
                + "ORDER BY 2 ASC";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Hoje - Gráfico 3; Tela Clientes - Aba Hoje - Gráfico 1
     *
     * @return cliente, quantidade
     */
    public CachedRowSet clientesQueMaisCompraramPorQuantidade() {

        sql = "SELECT * FROM (SELECT C.CLI_NOME, COUNT(V.VND_CODIGO) FROM "
                + "TAB_CLIENTE C JOIN TAB_VENDA V ON C.CLI_CODIGO = "
                + "V.CLI_CODIGO GROUP BY C.CLI_NOME ORDER BY "
                + "COUNT(V.VND_CODIGO) DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Cliente - Aba Hoje - Gráfico 2
     *
     * @return belt, quantidade
     */
    public CachedRowSet beltsQueMaisCompraram() {

        sql = "SELECT * FROM (SELECT CL.CLF_NOME, COUNT(V.VND_CODIGO) FROM "
                + "TAB_CLASSIFICACAO CL JOIN TAB_CLIENTE C ON CL.CLF_CODIGO "
                + "= C.CLF_CODIGO JOIN TAB_VENDA V ON V.CLI_CODIGO = "
                + "C.CLI_CODIGO WHERE CL.CLF_NOME <> 'INATIVO' GROUP BY "
                + "CL.CLF_NOME ORDER BY 2 DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Clientes - Aba Hoje - Gráfico 3
     *
     * @return cliente, quantidade
     */
    public CachedRowSet clientesHaMaisTempoSemComprar() {

        sql = "SELECT * FROM (SELECT C.CLI_NOME, ROUND(V.VND_DATA - SYSDATE) "
                + "FROM TAB_CLIENTE C JOIN TAB_VENDA V ON V.CLI_CODIGO = "
                + "C.CLI_CODIGO ORDER BY 2 DESC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Clientes - Aba Hoje - Gráfico 4
     *
     * @return cliente, quantidade
     */
    public CachedRowSet clientesQueCompraramRecentemente() {

        sql = "SELECT * FROM (SELECT C.CLI_NOME, ROUND(V.VND_DATA - "
                + "SYSDATE) FROM TAB_CLIENTE C JOIN TAB_VENDA V ON "
                + "V.CLI_CODIGO = C.CLI_CODIGO ORDER BY 2 ASC) WHERE ROWNUM <= 5";

        return super.executeQuery(sql);
    }

    /**
     * Tela Início - Aba Oportunidades - Gráfico 3; Tela Vendas - Aba
     * Oportunidades - Gráfico 3
     *
     * @return cliente, mês, valor monetário
     */
    public CachedRowSet clienteAumentoCompras() {

        sql = "SELECT C.CLI_NOME, TO_CHAR(V.VND_DATA, 'MONTH/YY'), "
                + "V.VND_VALOR_FINAL FROM TAB_CLIENTE C "
                + "JOIN TAB_VENDA V ON C.CLI_CODIGO = V.CLI_CODIGO "
                + "WHERE ADD_MONTHS(SYSDATE, -5) > VND_DATA AND V.CLI_CODIGO "
                + "IN (SELECT CLI_CODIGO FROM (SELECT CLI_CODIGO, SUM(VND_VALOR_FINAL) "
                + "FROM TAB_VENDA WHERE ADD_MONTHS(SYSDATE,-5) > VND_DATA "
                + "GROUP BY CLI_CODIGO ORDER BY 2 DESC) WHERE ROWNUM =1)";

        return super.executeQuery(sql);
    }

    /**
     * Tela Inicio - Aba Ameaças - Gráfico 3; Tela Vendas - Aba Ameaças -
     * Gráfico 3
     *
     * @return cliente, mês, valor monetário
     */
    public CachedRowSet clienteQuedaCompras() {

        sql = "SELECT C.CLI_NOME, TO_CHAR(V.VND_DATA, 'MONTH/YY'), "
                + "V.VND_VALOR_FINAL FROM TAB_CLIENTE C "
                + "JOIN TAB_VENDA V ON C.CLI_CODIGO = V.CLI_CODIGO "
                + "WHERE ADD_MONTHS(SYSDATE, -5) > VND_DATA AND V.CLI_CODIGO "
                + "IN (SELECT CLI_CODIGO FROM (SELECT CLI_CODIGO, "
                + "SUM(VND_VALOR_FINAL) FROM TAB_VENDA "
                + "WHERE ADD_MONTHS(SYSDATE,-5) > VND_DATA "
                + "GROUP BY CLI_CODIGO ORDER BY 2 ASC) WHERE ROWNUM =1)";

        return super.executeQuery(sql);
    }

    /**
     * Tela Clientes - Aba Lista de Clentes
     *
     * @param cliente Cliente que será consultado
     * @return codigo da venda, data, produto, quantidade, preço inicial.
     * desconto, preço final
     */
    public CachedRowSet comprasPorCLiente(Cliente cliente) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT V.VND_CODIGO, V.VND_DATA, P.PRD_NOME, "
                    + "SUM(PRD_QUANTIDADE), P.PRD_PRECO, V.VND_DESCONTO, "
                    + "V.VND_VALOR_FINAL FROM TAB_PRODUTO P JOIN "
                    + "TAB_VENDA_PRODUTO VP ON P.PRD_CODIGO = VP.PRD_CODIGO "
                    + "JOIN TAB_VENDA V ON VP.VND_CODIGO = V.VND_CODIGO JOIN "
                    + "TAB_CLIENTE C ON V.CLI_CODIGO = C.CLI_CODIGO WHERE "
                    + "C.CLI_CODIGO = ? GROUP BY V.VND_CODIGO, V.VND_DATA, "
                    + "P.PRD_NOME, P.PRD_PRECO, V.VND_DESCONTO, "
                    + "V.VND_VALOR_FINAL ORDER BY 2 DESC";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, cliente.getCodigo());

            resultado = stm.executeQuery();

            crs = new CachedRowSetImpl();

            crs.populate(resultado);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a pesquisa", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return crs;
    }

    /**
     * Tela Clientes - Aba Lista de Clientes - Busca de clientes por CNPJ ou
     * CPF; Tela Clientes - Aba Alterar Cliente
     *
     * @param cpfCnpj: CPF ou CNPJ do cliente a ser buscado
     * @return Cliente selecionado
     */
    public Cliente pesquisarClientePorCpfCnpj(String cpfCnpj) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_CLIENTE WHERE CLI_CPF_CNPJ = ?";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, cpfCnpj);

            resultado = stm.executeQuery();
            resultado.next();
            cliente = new Cliente(resultado.getString("CLI_EMAIL"),
                    resultado.getString("CLI_CPF_CNPJ"),
                    resultado.getString("CLI_CEP"),
                    resultado.getString("CLI_RUA"),
                    resultado.getString("CLI_BAIRRO"),
                    resultado.getString("CLI_CIDADE"),
                    resultado.getString("CLI_UF"),
                    dclass.selecionarNomeClassificacao(resultado.getInt("CLF_CODIGO")),
                    resultado.getDouble("CLI_DISTANCIA_FILIAL"),
                    resultado.getString("CLI_NOME"),
                    dt.listarTelefonesPorCodCliente(resultado.getInt("CLI_CODIGO")).get(1),
                    dt.listarTelefonesPorCodCliente(resultado.getInt("CLI_CODIGO")).get(0));

            cliente.setCodigo(resultado.getInt("CLI_CODIGO"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o cliente", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return cliente;
    }

    /**
     * Tela Clientes - Aba Lista de Clientes - Tabela com listagem de clientes
     *
     * @return Lista de clientes
     */
    public ArrayList<Cliente> listarClientes() {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_CLIENTE";
            stm = conexao.prepareStatement(sql);

            resultado = stm.executeQuery();

            while (resultado.next()) {
                cliente = new Cliente(resultado.getString("CLI_EMAIL"),
                        resultado.getString("CLI_CPF_CNPJ"),
                        resultado.getString("CLI_CEP"),
                        resultado.getString("CLI_RUA"),
                        resultado.getString("CLI_BAIRRO"),
                        resultado.getString("CLI_CIDADE"),
                        resultado.getString("CLI_UF"),
                        dclass.selecionarNomeClassificacao(resultado.getInt("CLF_CODIGO")),
                        resultado.getDouble("CLI_DISTANCIA_FILIAL"),
                        resultado.getString("CLI_NOME"),
                        dt.listarTelefonesPorCodCliente(resultado.getInt("CLI_CODIGO")).get(0),
                        dt.listarTelefonesPorCodCliente(resultado.getInt("CLI_CODIGO")).get(1));

                cliente.setCodigo(resultado.getInt("CLI_CODIGO"));

                arrayClientes.add(cliente);
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar a lista", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return arrayClientes;
    }

    /**
     * Tela Clientes - Aba Add Cliente
     *
     * @param cliente: Cliente a ser inserido
     * @return True para ok. False para não ok
     */
    public boolean save(Cliente cliente) {

        try {
            int id = this.ultimoIdCliente() + 1;
            conexao = con.abrirConexao();
            sql = "INSERT INTO TAB_CLIENTE (CLI_CODIGO, CLF_CODIGO, CLI_NOME, "
                    + "CLI_EMAIL, CLI_CPF_CNPJ, CLI_CEP, CLI_RUA, CLI_BAIRRO, "
                    + "CLI_CIDADE, CLI_UF, CLI_DISTANCIA_FILIAL) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, dclass.selecionarCodigoClassificacao(cliente.getClassificacao()));
            stm.setString(3, cliente.getNome());
            stm.setString(4, cliente.getEmail());
            stm.setString(5, cliente.getCpf_cnpj());
            stm.setString(6, cliente.getCep());
            stm.setString(7, cliente.getRua());
            stm.setString(8, cliente.getBairro());
            stm.setString(9, cliente.getCidade());
            stm.setString(10, cliente.getUf());
            stm.setDouble(11, cliente.getDistanciaFilial());

            resultado = stm.executeQuery();

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
        return true;
    }

    /**
     * Tela Clientes - Aba Alterar Cliente
     *
     * @param cliente: Cliente a ser atualizado
     * @return True para ok. False para não ok
     */
    public boolean update(Cliente cliente) {

        try {
            conexao = con.abrirConexao();
            sql = "UPDATE TAB_CLIENTE SET CLF_CODIGO = ?, "
                    + "CLI_NOME = ?, CLI_EMAIL = ?, CLI_CPF_CNPJ = ?, CLI_CEP = ?, "
                    + "CLI_RUA = ?, CLI_BAIRRO = ?, CLI_UF = ?, CLI_DISTANCIA_FILIAL = ? "
                    + "WHERE CLI_CODIGO = ?";

            stm = conexao.prepareStatement(sql);

            stm.setInt(1, dclass.selecionarCodigoClassificacao(cliente.getClassificacao()));
            stm.setString(2, cliente.getNome());
            stm.setString(3, cliente.getEmail());
            stm.setString(4, cliente.getCpf_cnpj());
            stm.setString(5, cliente.getCep());
            stm.setString(6, cliente.getRua());
            stm.setString(7, cliente.getBairro());
            stm.setString(8, cliente.getUf());
            stm.setDouble(9, cliente.getDistanciaFilial());
            stm.setInt(10, cliente.getCodigo());

            stm.executeUpdate();

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
        return true;
    }

    /**
     * Tela Clientes - Aba Alterar Cliente
     *
     * @param cliente: Cliente a ser excluído (atribui o status inativo ao
     * cliente)
     * @return True para ok. False para não ok
     */
    public boolean delete(Cliente cliente) {

        try {
            conexao = con.abrirConexao();
            sql = "UPDATE TAB_CLIENTE SET CLF_CODIGO = 0 WHERE CLI_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, cliente.getCodigo());

            stm.executeUpdate();

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível inativar o cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
        return true;
    }

    /**
     * Tela pedido
     *
     * @param codigo Código do cliente a ser buscado
     * @return Cliente selecionado
     */
    public Cliente pesquisarClientePorCodigo(int codigo) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_CLIENTE WHERE CLI_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, codigo);

            resultado = stm.executeQuery();
            resultado.next();
            cliente = new Cliente(resultado.getString("CLI_EMAIL"),
                    resultado.getString("CLI_CPF_CNPJ"),
                    resultado.getString("CLI_CEP"),
                    resultado.getString("CLI_RUA"),
                    resultado.getString("CLI_BAIRRO"),
                    resultado.getString("CLI_CIDADE"),
                    resultado.getString("CLI_UF"),
                    dclass.selecionarNomeClassificacao(resultado.getInt("CLF_CODIGO")),
                    resultado.getDouble("CLI_DISTANCIA_FILIAL"),
                    resultado.getString("CLI_NOME"),
                    dt.listarTelefonesPorCodCliente(codigo).get(0),
                    dt.listarTelefonesPorCodCliente(codigo).get(1));

            cliente.setCodigo(resultado.getInt("CLI_CODIGO"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o cliente", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return cliente;
    }

    /**
     * Busca o ultimo ID inserido na base
     *
     * @return ultimo ID da base
     */
    public int ultimoIdCliente() {

        int id = -1;
        try {
            conexao = con.abrirConexao();
            sql = "SELECT MAX(CLI_CODIGO) FROM TAB_CLIENTE";
            stm = conexao.prepareStatement(sql);
            resultado = stm.executeQuery();
            resultado.next();
            id = resultado.getInt(1);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o Id", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return id;
    }
}
