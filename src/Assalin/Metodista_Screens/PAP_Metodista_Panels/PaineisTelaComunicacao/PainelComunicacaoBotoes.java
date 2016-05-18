package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaComunicacao;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public class PainelComunicacaoBotoes extends MasterButtons {

    public PainelComunicacaoBotoes() {
        super(Aba.Comunicacao);
    }

    public JButton getBotaoComunicacaoEmailEntrada() {
        return botoesComunicacao[0];
    }

    public JButton getBotaoComunicacaoEmailNovo() {
        return botoesComunicacao[1];
    }

    public JButton getBotaoComunicacaoEmailEnviados() {
        return botoesComunicacao[2];
    }
}
