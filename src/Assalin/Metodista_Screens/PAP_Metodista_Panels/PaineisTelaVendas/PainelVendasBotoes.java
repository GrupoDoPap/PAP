package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaVendas;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public class PainelVendasBotoes extends MasterButtons {

    public PainelVendasBotoes() {
        super(Aba.Vendas);
    }

    public JButton getBotaoVendasHoje() {
        return botoesVendas[0];
    }

    public JButton getBotaoVendasOportunidades() {
        return botoesVendas[1];
    }

    public JButton getBotaoVendasAmeacas() {
        return botoesVendas[2];
    }
}
