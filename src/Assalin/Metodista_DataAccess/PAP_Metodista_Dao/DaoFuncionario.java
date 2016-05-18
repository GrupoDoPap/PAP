package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Funcionario;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Motorista;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoFuncionario extends DaoBase implements IDaoFuncionario {

    private final Conexao con = new Conexao();
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado;

    private Usuario user = null;
    private Motorista driver = null;
    private Funcionario ajudante = null;
    private final ArrayList<Motorista> listaMotorista = new ArrayList<>();
    private final ArrayList<Funcionario> listaAjudante = new ArrayList<>();
    private final ArrayList<Usuario> listaUsuario = new ArrayList<>();

    /**
     * Tela Viagem - Lista todos os usuarios
     *
     * @return Array com todos os usuarios
     */
    public ArrayList<Usuario> listarUsuarios() {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_FUNCIONARIO WHERE FUN_LOGIN IS NOT NULL";
            stm = conexao.prepareStatement(sql);

            resultado = stm.executeQuery();

            while (resultado.next()) {
                user = new Usuario(resultado.getString("FUN_NOME"),
                        resultado.getString("FUN_CARGO"),
                        resultado.getString("FUN_TELEFONE"),
                        resultado.getString("FUN_LOGIN"),
                        resultado.getString("FUN_SENHA"));

                user.setCodigo(resultado.getInt("FUN_CODIGO"));

                listaUsuario.add(user);
            }

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar a lista", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return listaUsuario;
    }

    /**
     * Tela Viagem - Lista todos os motoristas
     *
     * @return Array com todos os motoristas
     */
    public ArrayList<Motorista> listarMotoristas() {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_FUNCIONARIO WHERE FUN_CARGO = 'MOTORISTA'";
            stm = conexao.prepareStatement(sql);

            resultado = stm.executeQuery();

            while (resultado.next()) {
                driver = new Motorista(resultado.getString("FUN_CNH"),
                        resultado.getString("FUN_NOME"),
                        resultado.getString("FUN_CARGO"),
                        resultado.getString("FUN_TELEFONE"));

                driver.setCodigo(resultado.getInt("FUN_CODIGO"));

                listaMotorista.add(driver);
            }

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar a lista", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return listaMotorista;
    }

    /**
     * Tela Viagem - Lista todos os usuarios
     *
     * @return Array com todos os usuários
     */
    public ArrayList<Funcionario> listarAjudantes() {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_FUNCIONARIO WHERE FUN_CARGO = 'AJUDANTE' ";
            stm = conexao.prepareStatement(sql);

            resultado = stm.executeQuery();

            while (resultado.next()) {
                ajudante = new Funcionario(resultado.getString("FUN_NOME"),
                        resultado.getString("FUN_CARGO"),
                        resultado.getString("FUN_TELEFONE"));

                ajudante.setCodigo(resultado.getInt("FUN_CODIGO"));

                listaAjudante.add(ajudante);
            }

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar a lista", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return listaAjudante;
    }

    /**
     * Tela Configurações - Aba Add Usuário
     *
     * @param funcionario: Funcionario a ser inserido
     * @return True se der certo. Falso se der errado
     */
    public boolean inserirUsuario(Usuario funcionario) {

        try {
            int id = this.idMaisRecente() + 1;
            conexao = con.abrirConexao();
            sql = "INSERT INTO TAB_FUNCIONARIO (FUN_CODIGO, FUN_NOME, FUN_CARGO, "
                    + "FUN_TELEFONE, FUN_LOGIN, FUN_SENHA) VALUES (?, ?, ?, ?, ?, ?)";

            stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, funcionario.getNome());
            stm.setString(3, funcionario.getCargo());
            stm.setString(4, funcionario.getTelefone());
            stm.setString(5, funcionario.getLogin());
            stm.setString(6, funcionario.getSenha());

            stm.execute();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
    }

    /**
     * Tela Configurações - Aba Alterar Usuário
     *
     * @param funcionario: Funcionario a ser atualizado
     * @return True para ok. False para não ok
     */
    public boolean atualizarUsuario(Usuario funcionario) {

        try {
            conexao = con.abrirConexao();
            sql = "UPDATE TAB_FUNCIONARIO SET FUN_NOME = ?, FUN_CARGO = ?, "
                    + "FUN_TELEFONE = ?, FUN_LOGIN = ?, FUN_SENHA = ? WHERE FUN_CODIGO = ?";

            stm = conexao.prepareStatement(sql);
            stm.setString(1, funcionario.getNome());
            stm.setString(2, funcionario.getCargo());
            stm.setString(3, funcionario.getTelefone());
            stm.setString(4, funcionario.getLogin());
            stm.setString(5, funcionario.getSenha());
            stm.setInt(6, funcionario.getCodigo());

            stm.executeUpdate();

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
        return true;
    }

    /**
     * Tela Configurações - Aba Alterar Usuário (coloca cargo do funcionario
     * como inativo)
     *
     * @param funcionario: Funcionario a ser excluido
     * @return True para ok. False para não ok
     */
    public boolean excluirUsuario(Usuario funcionario) {

        try {
            conexao = con.abrirConexao();
            sql = "UPDATE TAB_FUNCIONARIO SET FUN_CARGO = 'INATIVO' WHERE FUN_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, funcionario.getCodigo());

            stm.execute();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
    }

    /**
     * Tela Configurações - Aba Alterar Usuário
     *
     * @param id: Id do usuario a ser selecionado
     * @return Usuario selecionado
     */
    public Usuario selecionarUsuarioPorId(int id) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_FUNCIONARIO WHERE FUN_CODIGO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            resultado = stm.executeQuery();
            resultado.next();
            user = new Usuario(
                    resultado.getString("FUN_NOME"),
                    resultado.getString("FUN_CARGO"),
                    resultado.getString("FUN_TELEFONE"),
                    resultado.getString("FUN_LOGIN"),
                    resultado.getString("FUN_SENHA"));

            user.setCodigo(resultado.getInt("FUN_CODIGO"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return user;
    }

    /**
     * Tela Viagem
     *
     * @param nome: Nome do usuario a ser selecionado
     * @return Usuario selecionado
     */
    public Usuario selecionarUsuarioPorNome(String nome) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_FUNCIONARIO WHERE FUN_NOME = ?";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, nome);
            resultado = stm.executeQuery();
            resultado.next();
            user = new Usuario(resultado.getString("FUN_NOME"),
                    resultado.getString("FUN_CARGO"),
                    resultado.getString("FUN_TELEFONE"),
                    resultado.getString("FUN_LOGIN"),
                    resultado.getString("FUN_SENHA"));

            user.setCodigo(resultado.getInt("FUN_CODIGO"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return user;
    }

    /**
     * Tela Login
     *
     * @param login: Login do usuario a ser selecionado
     * @return Usuario selecionado
     */
    public Usuario selecionarUsuarioPorLogin(String login) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_FUNCIONARIO WHERE FUN_LOGIN = ?";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, login);
            resultado = stm.executeQuery();
            resultado.next();
            user = new Usuario(resultado.getString("FUN_NOME"),
                    resultado.getString("FUN_CARGO"),
                    resultado.getString("FUN_TELEFONE"),
                    resultado.getString("FUN_LOGIN"),
                    resultado.getString("FUN_SENHA"));

            user.setCodigo(resultado.getInt("FUN_CODIGO"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return user;
    }

    /**
     * Tela Viagem
     *
     * @param nome: Nome do motorista a ser selecionado
     * @return Motorista selecionado
     */
    public Motorista selecionarMotoristaPorNome(String nome) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_FUNCIONARIO WHERE FUN_NOME = ? AND FUN_CARGO = 'MOTORISTA' ";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, nome);
            resultado = stm.executeQuery();
            resultado.next();
            driver = new Motorista(resultado.getString("FUN_CNH"),
                    resultado.getString("FUN_NOME"),
                    resultado.getString("FUN_CARGO"),
                    resultado.getString("FUN_TELEFONE"));

            driver.setCodigo(resultado.getInt("FUN_CODIGO"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o motorista", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return driver;
    }

    /**
     * Seleciona o id mais recente no banco
     *
     * @return último número inserido no banco
     */
    public int idMaisRecente() {
        int lastId = -1;
        try {
            conexao = con.abrirConexao();
            sql = "SELECT MAX(FUN_CODIGO) FROM TAB_FUNCIONARIO";
            stm = conexao.prepareStatement(sql);

            resultado = stm.executeQuery();
            resultado.next();
            lastId = resultado.getInt(1);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível coletar o ID", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return lastId;
    }
}
