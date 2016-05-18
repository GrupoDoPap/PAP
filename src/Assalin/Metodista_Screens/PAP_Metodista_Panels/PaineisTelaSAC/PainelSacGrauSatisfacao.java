package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaSAC;

import Metodista_DataAccess.PAP_Metodista_Dao.DaoAtendimento;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public final class PainelSacGrauSatisfacao extends JPanel {

    private JPanel painelSacGrauSatisfacao;
    ChartPanel cp = null;
    private DaoAtendimento daoAtendimento;

    public PainelSacGrauSatisfacao() {
        try {
            BuildComponentes();
            add(BuildPainel());
            add(BuildGrafico());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "OPS, falha na criação dos componentes!");
            exception.printStackTrace();
        }
    }

    public void BuildComponentes() {
        painelSacGrauSatisfacao = new JPanel();
        daoAtendimento = new DaoAtendimento();
    }

    private ChartPanel BuildGrafico() {
        try {
            CachedRowSet resultSet = daoAtendimento.grauDeSatisfacao();
            DefaultPieDataset dataset = new DefaultPieDataset();

            while (resultSet.next()) {
                dataset.setValue(
                        resultSet.getString(1),
                        Double.parseDouble(resultSet.getString(2)));
            }

            JFreeChart chart = ChartFactory.createPieChart(
                    "Grau Satisfação",
                    dataset,
                    true,
                    true,
                    false);

            cp = new ChartPanel(chart);
        } catch (Exception exception) {

        }
        return cp;
    }

    public JPanel BuildPainel() {

        return painelSacGrauSatisfacao;
    }
}
