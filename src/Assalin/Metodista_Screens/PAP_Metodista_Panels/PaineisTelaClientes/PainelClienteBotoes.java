package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaClientes;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public class PainelClienteBotoes extends MasterButtons {

    public PainelClienteBotoes() {
        super(Aba.Clientes);
    }

    public JButton getBotaoClienteHoje() {
        return botoesClientes[0];
    }

    public JButton getBotaoClientesLista() {
        return botoesClientes[1];
    }

    public JButton getBotaoClientesAdicionar() {
        return botoesClientes[2];
    }

    public JButton getBotaoClientesAlterar() {
        return botoesClientes[3];
    }
}
