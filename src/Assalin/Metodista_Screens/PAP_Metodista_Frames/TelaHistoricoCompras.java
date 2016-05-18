package Metodista_Screens.PAP_Metodista_Frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaHistoricoCompras extends JFrame {

    public TelaHistoricoCompras() {
        try {
            BuildComponentes();
            add(BuildPainel());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Opa");
            exception.printStackTrace();
        }
    }

    private void BuildComponentes() {
    }

    private JPanel BuildPainel() {
        return null;
    }
}
