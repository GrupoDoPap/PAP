package Metodista_Screens.PAP_Metodista_Frames;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JProgressBar;

public final class TelaCarregarCRM extends JFrame {

    private JPanel painelTelaCarregarCRM;
    private Timer temporizador;

    private JProgressBar progressBar;
    private JLabel label;

    private ImageIcon imagemLogoACC;
    private JLabel labelImagemACC;

    public TelaCarregarCRM() {
        try {
            BuildComponentes();
            LoadTimer(3);
            add(BuildPainel());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "OPS, falha na criação dos componentes!");
            exception.printStackTrace();
        }
        setSize(500, 510);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void BuildComponentes() {
        painelTelaCarregarCRM = new JPanel();
        temporizador = new Timer();

        progressBar = new JProgressBar();

        progressBar.setIndeterminate(true);
        progressBar.setSize(500, 20);
        pack();

        label = new JLabel("Carregando...");

        imagemLogoACC = new ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/CarregarCRM.png"));
        labelImagemACC = new JLabel(imagemLogoACC);
    }

    private JPanel BuildPainel() {
        getContentPane().add(labelImagemACC, BorderLayout.BEFORE_FIRST_LINE);
        painelTelaCarregarCRM.add(label);
        painelTelaCarregarCRM.add(progressBar);

        return painelTelaCarregarCRM;
    }

    private void LoadTimer(int segundos) {
        temporizador.schedule(new FimDoTempo(), segundos * 1000);
    }

    //Classe que trata do evento que ocorre apos ecerramento do tempo do timer
    public class FimDoTempo extends TimerTask {

        @Override
        public void run() {
            dispose();
            TelaLogin telaLogin = new TelaLogin();
        }

    }
}
