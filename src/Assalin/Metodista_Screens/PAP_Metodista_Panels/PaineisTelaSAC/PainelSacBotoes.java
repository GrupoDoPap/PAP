package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaSAC;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public class PainelSacBotoes extends MasterButtons {

    public PainelSacBotoes() {
        super(Aba.Sac);
    }

    public JButton getBotaoSacAnaliseAtual() {
        return botoesSac[0];
    }

    public JButton getBotaoSacGerarAtendimento() {
        return botoesSac[1];
    }

    public JButton getBotaoSacAlterarAtendimento() {
        return botoesSac[2];
    }

    public JButton getBotaoSacGrauSatisfacao() {
        return botoesSac[3];
    }

}
