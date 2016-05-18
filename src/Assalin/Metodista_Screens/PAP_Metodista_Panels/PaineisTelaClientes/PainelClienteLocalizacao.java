package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaClientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class PainelClienteLocalizacao extends JPanel {

    private JPanel painelClienteLocalizacao;

    private JLabel label;

    public PainelClienteLocalizacao() {
        try {
            BuildComponentes();
            add(BuildPainel());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(painelClienteLocalizacao, "OPS, falha na criação dos componentes!");
            exception.printStackTrace();
        }
    }

    private void BuildComponentes() {
        painelClienteLocalizacao = new JPanel();

        label = new JLabel("Localização de Clientes");
    }

    private JPanel BuildPainel() {
        painelClienteLocalizacao.add(label);

        return painelClienteLocalizacao;
    }
}
