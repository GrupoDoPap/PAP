package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoVeiculo extends DaoBase implements IDaoVeiculo {
    private final Conexao con = new Conexao();
    private Veiculo car;
    private Connection conexao = null;
    private ResultSet resultado = null;
    private final ArrayList<Veiculo> arrayVeiculos = new ArrayList<>();

    private PreparedStatement stm;
    private String sql;

    /**
     * Tela Viagem - Seleciona todos os veículos
     *
     * @return Array com todos os veículos do sistema
     */
    public ArrayList<Veiculo> listarVeiculos() {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_VEICULO";
            stm = conexao.prepareStatement(sql);
            resultado = stm.executeQuery();

            while (resultado.next()) {
                car = new Veiculo(resultado.getString("VCL_PLACA"),
                        resultado.getString("VCL_MODELO"),
                        resultado.getString("VCL_DESCRICAO"),
                        resultado.getDouble("VCL_CAPACIDADE"),
                        resultado.getDouble("VCL_ALTURA"),
                        resultado.getDouble("VCL_LARGURA"),
                        resultado.getDouble("VCL_PROFUNDIDADE"));

                arrayVeiculos.add(car);
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível executar o comando SQL",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return arrayVeiculos;
    }

    /**
     * Busca veículo pela descrição
     *
     * @param descricao: Descrição do veículo a ser buscado
     * @return Veículo buscado
     */
    public Veiculo buscarVeiculoPorDescricao(String descricao) {

        try {
            conexao = con.abrirConexao();
            sql = "SELECT * FROM TAB_VEICULO WHERE VCL_DESCRICAO = ?";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, descricao);

            resultado = stm.executeQuery();
            resultado.next();
            car = new Veiculo(resultado.getString("VCL_PLACA"),
                    resultado.getString("VCL_MODELO"),
                    resultado.getString("VCL_DESCRICAO"),
                    resultado.getDouble("VCL_CAPACIDADE"),
                    resultado.getDouble("VCL_ALTURA"),
                    resultado.getDouble("VCL_LARGURA"),
                    resultado.getDouble("VCL_PROFUNDIDADE"));

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o veículo",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return car;
    }
}
