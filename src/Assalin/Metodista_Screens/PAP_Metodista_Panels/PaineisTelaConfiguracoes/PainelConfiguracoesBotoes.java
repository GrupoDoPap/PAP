package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaConfiguracoes;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public class PainelConfiguracoesBotoes extends MasterButtons {

    public PainelConfiguracoesBotoes() {
        super(Aba.Configuracoes);
    }

    public JButton getBotaoConfiguracoesAdicionarUsuario() {
        return botoesConfiguracoes[0];
    }

    public JButton getBotaoConfiguracoesAlterarUsuario() {
        return botoesConfiguracoes[1];
    }
}
