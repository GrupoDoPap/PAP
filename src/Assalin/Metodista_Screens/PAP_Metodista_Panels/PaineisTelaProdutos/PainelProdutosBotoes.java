package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaProdutos;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import Metodista_Screens.PAP_Metodista_SuperClasses.MasterButtons;
import javax.swing.JButton;

public class PainelProdutosBotoes extends MasterButtons {

    public PainelProdutosBotoes() {
        super(Aba.Produtos);
    }

    public JButton getBotaoProdutosOportunidades() {
        return botoesProdutos[0];
    }

    public JButton getBotaoProdutosAmeacas() {
        return botoesProdutos[1];
    }
}
