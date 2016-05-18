package Metodista_BusinessRules.PAP_Metodista_Validation;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Viagem;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoViagem;

public class ViagemValidation {

    private final DaoViagem dv = new DaoViagem();

    public int insertViagem(Viagem viagem) {

        dv.save(viagem);

        return dv.ultimoID();
    }

}
