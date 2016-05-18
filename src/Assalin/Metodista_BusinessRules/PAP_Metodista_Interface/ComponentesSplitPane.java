package Metodista_BusinessRules.PAP_Metodista_Interface;

import Metodista_BusinessRules.PAP_Metodista_Enum.AbaSolicitante;
import javax.swing.JSplitPane;

public interface ComponentesSplitPane {

    JSplitPane splitPaneMaster = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    JSplitPane splitPaneCima = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPaneBaixo = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

    public void BuildSplitPaneMaster();

    public void AddInSplitPane(AbaSolicitante abaSolicitante);
}
