package Metodista_Screens.PAP_Metodista_TruckSystem.Paineis;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public class PainelTruckSystemBotoes extends MasterButtons {

    public PainelTruckSystemBotoes() {
        super(Aba.Mais);
    }

    public JButton getBotaoTruckSystemPedidos() {
        return botoesMais[0];
    }

    public JButton getBotaoTruckSystemViagens() {
        return botoesMais[1];
    }

}
