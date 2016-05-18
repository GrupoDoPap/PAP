package Metodista_Screens.PAP_Metodista_SuperClasses;

import Metodista_BusinessRules.PAP_Metodista_Enum.AbaSolicitante;
import Metodista_BusinessRules.PAP_Metodista_Enum.GraficoSolicitante;
import Metodista_BusinessRules.PAP_Metodista_Interface.ComponentesSplitPane;
import static Metodista_BusinessRules.PAP_Metodista_Interface.ComponentesSplitPane.splitPaneBaixo;
import static Metodista_BusinessRules.PAP_Metodista_Interface.ComponentesSplitPane.splitPaneCima;
import static Metodista_BusinessRules.PAP_Metodista_Interface.ComponentesSplitPane.splitPaneMaster;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class SplitMasterPane extends JPanel implements ComponentesSplitPane {

    private JPanel painelSplitMasterPane;

    public SplitMasterPane(AbaSolicitante abaSolicitante) {
        try {
            BuildComponentes();
            AddInSplitPane(abaSolicitante);
            BuildSplitPaneMaster();
            add(BuildPainel());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(painelSplitMasterPane, "OPS, ocorreu um erro na construção dos componentes!");
            exception.printStackTrace();
        }
        setVisible(true);
    }

    private void BuildComponentes() {
        painelSplitMasterPane = new JPanel();
    }

    @Override
    public void AddInSplitPane(AbaSolicitante abaSolicitante) {
        splitPaneCima.setLeftComponent(new MasterPanel(abaSolicitante, GraficoSolicitante.CimaEsq));
        splitPaneCima.setRightComponent(new MasterPanel(abaSolicitante, GraficoSolicitante.CimaDir));
        splitPaneBaixo.setLeftComponent(new MasterPanel(abaSolicitante, GraficoSolicitante.BaixoEsq));
        splitPaneBaixo.setRightComponent(new MasterPanel(abaSolicitante, GraficoSolicitante.BaixoDir));
    }

    @Override
    public void BuildSplitPaneMaster() {
        splitPaneMaster.setTopComponent(splitPaneCima);
        splitPaneMaster.setBottomComponent(splitPaneBaixo);
    }

    private JPanel BuildPainel() {
        painelSplitMasterPane.add(splitPaneMaster);
        return painelSplitMasterPane;
    }
}
