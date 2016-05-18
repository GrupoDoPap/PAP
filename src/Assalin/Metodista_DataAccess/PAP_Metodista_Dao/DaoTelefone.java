package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoTelefone extends DaoBase implements IDaoTelefone {

    private final List<String> listaTel = new ArrayList<>();
    private final Conexao con = new Conexao();
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado;

    /**
     * Lista todos os telefones de um determinado Cliente
     *
     * @param codigoCliente: Código do cliente a ser buscado
     * @return Lista com os telefones do Cliente selecionado
     */
    public List<String> listarTelefonesPorCodCliente(int codigoCliente) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_TELEFONE WHERE CLI_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, codigoCliente);

            resultado = stm.executeQuery();

            while (resultado.next()) {
                listaTel.add(resultado.getString("TEL_NUMERO"));
            }

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o telefone", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return listaTel;
    }

    /**
     * Insere o telefone de um determinado Cliente
     *
     * @param Cliente: Cliente a ser buscado
     */
    public void saveTelefone(Cliente cliente) {

        try {
            int id = this.ultimoID() + 1;
            conexao = con.abrirConexao();
            sql = "INSERT INTO TAB_TELEFONE (TEL_CODIGO, CLI_CODIGO, TEL_TIPO, TEL_NUMERO) VALUES (?, ?, ?, ?)";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, cliente.getCodigo());
            stm.setString(3, "FIXO");
            stm.setString(4, cliente.getCelular());
            stm.execute();

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o telefone", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
    }

    /**
     * Insere o celular de um determinado Cliente
     *
     * @param cliente: Cliente a ser buscado
     */
    public void saveCelular(Cliente cliente) {

        try {
            int id = this.ultimoID() + 1;
            conexao = con.abrirConexao();
            sql = "INSERT INTO TAB_TELEFONE (TEL_CODIGO, CLI_CODIGO, TEL_TIPO, TEL_NUMERO) VALUES (?, ?, ?, ?)";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, cliente.getCodigo());
            stm.setString(3, "CELULAR");
            stm.setString(4, cliente.getTelefone());
            stm.execute();

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o celular", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
    }

    public int ultimoID() {
        int id = -1;
        try {
            conexao = con.abrirConexao();
            sql = "SELECT MAX(TEL_CODIGO) FROM TAB_TELEFONE";
            stm = conexao.prepareStatement(sql);
            resultado = stm.executeQuery();
            resultado.next();
            id = resultado.getInt(1);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o celular", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return id;
    }
}
