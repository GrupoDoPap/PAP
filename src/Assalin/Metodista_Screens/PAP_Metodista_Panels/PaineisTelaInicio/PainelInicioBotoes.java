package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaInicio;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public final class PainelInicioBotoes extends MasterButtons {

    public PainelInicioBotoes() {
        super(Aba.Inicio);
    }

    public JButton getBotaoInicioHoje() {
        return botoesInicio[0];
    }

    public JButton getBotaoInicioOportunidades() {
        return botoesInicio[1];
    }

    public JButton getBotaoInicioAmeacas() {
        return botoesInicio[2];
    }
}
