package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMidiasSociais;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public class PainelMidiasSociaisBotoes extends MasterButtons {

    public PainelMidiasSociaisBotoes() {
        super(Aba.MidiasSociais);
    }

    public JButton getBotaoMidiasSociaisCitacoes() {
        return botoesMidiasSociais[0];
    }

    public JButton getBotaoMidiasSociaisElogios() {
        return botoesMidiasSociais[1];
    }

    public JButton getBotaoMidiasSociaisCriticas() {
        return botoesMidiasSociais[2];
    }

    public JButton getBotaoMidiasSociaisBuscaPersonalizada() {
        return botoesMidiasSociais[3];
    }

}
