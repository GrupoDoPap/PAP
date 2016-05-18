package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMercado;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public class PainelMercadoBotoes extends MasterButtons {

    public PainelMercadoBotoes() {
        super(Aba.Mercado);
    }

    public JButton getBotaoMercadoHoje() {
        return botoesMercado[0];
    }
}
