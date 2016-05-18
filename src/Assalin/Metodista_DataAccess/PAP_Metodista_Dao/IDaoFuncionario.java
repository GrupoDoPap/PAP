package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Funcionario;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Motorista;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Usuario;
import java.util.ArrayList;

public interface IDaoFuncionario {

    public ArrayList<Motorista> listarMotoristas();

    public ArrayList<Funcionario> listarAjudantes();

    public ArrayList<Usuario> listarUsuarios();

    public boolean inserirUsuario(Usuario user);

    public boolean atualizarUsuario(Usuario user);

    public boolean excluirUsuario(Usuario user);

    public Usuario selecionarUsuarioPorId(int codigo);

    public Usuario selecionarUsuarioPorNome(String nome);

    public Motorista selecionarMotoristaPorNome(String nome);

    public int idMaisRecente();

}
