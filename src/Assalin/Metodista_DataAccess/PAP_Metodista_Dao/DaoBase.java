package Metodista_DataAccess.PAP_Metodista_Dao;

import com.sun.rowset.CachedRowSetImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public abstract class DaoBase implements IDaoBase<Object> {

    private final Conexao con = new Conexao();
    private Connection conexao;
    private PreparedStatement stm;
    private ResultSet resultado;
    private CachedRowSet crs = null;

    /**
     * Deleta um objeto
     *
     * @param businessObjetc: Objeto a ser deletado
     * @return true;
     */
    public boolean delete(Object businessObjetc) {
        return true;
    }

    /**
     * Seleciona um objeto
     *
     * @param id: Primary key a ser buscada no banco
     * @return Objeto encontrado.
     */
    public Object get(Serializable id) {
        return true;
    }

    /**
     * Cria uma lista de objetos
     *
     * @return Lista de objeto selecionado
     */
    public List<Object> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Insere objeto no banco
     *
     * @param businessObject: Objeto a ser inserido
     */
    public boolean save(Object businessObject) {
        return true;
    }

    /**
     * Deleta objeto do banco
     *
     * @param businessObject: Objeto a ser deletado
     */
    public boolean update(Object businessObject) {
        return true;
    }

    /**
     * Executa a consulta do comando SQL especificado
     *
     * @param sql: Comando SQL para consulta
     * @return Resultado da consulta
     */
    public CachedRowSet executeQuery(String sql) {

        try {
            conexao = con.abrirConexao();
            stm = conexao.prepareStatement(sql);
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
}
