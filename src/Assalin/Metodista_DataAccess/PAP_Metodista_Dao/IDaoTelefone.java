package Metodista_DataAccess.PAP_Metodista_Dao;

import java.util.List;

public interface IDaoTelefone {

    public List<String> listarTelefonesPorCodCliente(int codigoCliente);
}
