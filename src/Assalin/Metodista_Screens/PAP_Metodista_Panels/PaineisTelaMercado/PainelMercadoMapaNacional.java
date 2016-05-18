package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMercado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class PainelMercadoMapaNacional extends JPanel {

    private JPanel painelMercadoMapaNacinal;

    private JLabel label;

    public PainelMercadoMapaNacional() {
        try {
            BuildComponentes();
            add(BuildPainel());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(painelMercadoMapaNacinal, "OPS, falha na criação dos componentes!");
            exception.printStackTrace();
        }
    }

    private void BuildComponentes() {
        painelMercadoMapaNacinal = new JPanel();

        label = new JLabel("Mercado Mapa Nacional");
    }

    private JPanel BuildPainel() {
        painelMercadoMapaNacinal.add(label);

        return painelMercadoMapaNacinal;
    }
}
