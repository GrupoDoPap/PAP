package Metodista_DataAccess.PAP_Metodista_Dao;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Viagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DaoViagem extends DaoBase implements IDaoViagem {

    private final Conexao con = new Conexao();
    private final DaoVeiculo dv = new DaoVeiculo();
    private Connection conexao;
    private String sql;
    private PreparedStatement stm;
    private ResultSet resultado;

    /**
     * Tela Viagem - Adiciona nova viagem
     *
     * @param viagem: Viagem a ser inserida
     * @return True se der certo. False se der errado.
     */
    public boolean save(Viagem viagem) {

        try {
            int id = this.ultimoID() + 1;

            conexao = con.abrirConexao();

            sql = "INSERT INTO TAB_VIAGEM (VGM_CODIGO, VCL_PLACA, FUN_CODIGO, "
                    + "VGM_PESO, VGM_STATUS) VALUES (?, ?, ?, ?, ?)";

            stm = conexao.prepareStatement(sql);

            stm.setInt(1, id);
            stm.setString(2, viagem.getVeiculo().getPlaca());
            stm.setInt(3, viagem.getMotorista().getCodigo());
            stm.setDouble(4, viagem.getPesoViagem());
            stm.setString(5, viagem.getStatus());

            stm.execute();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a inclusão",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            con.fecharConexao(conexao);
        }
    }

    /**
     * Seleciona o ultimo ID inserido na tabela de viagens
     *
     * @return Último ID do banco de dados
     */
    public int ultimoID() {

        int id = -1;

        try {
            conexao = con.abrirConexao();
            sql = "SELECT MAX(VGM_CODIGO) FROM TAB_VIAGEM";
            stm = conexao.prepareStatement(sql);
            resultado = stm.executeQuery();
            resultado.next();
            id = resultado.getInt(1);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a pesquisa",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return id;
    }
}
