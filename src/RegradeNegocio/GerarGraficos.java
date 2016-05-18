package RegradeNegocio;


import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class GerarGraficos extends JFrame {

    private String produto;
    private double valores;

    public void gerarPizzas(String produto, String nomeDoGrafico, double valor) {

        this.produto = produto;

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue(this.produto, new Double(valor));

        JFreeChart grafico = ChartFactory.createPieChart(
                nomeDoGrafico,
                pieDataset,
                true,
                true,
                false);
        add(new ChartPanel(grafico));
        this.pack();
        setVisible(true);

    }

    public void gerarLinhas() {

        XYSeries series = new XYSeries("XYGraph");
        series.add(1, 1);
        series.add(1, 2);
        series.add(2, 1);
        series.add(3, 9);
        series.add(4, 10);

// Add the series to your data set
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

// Generate the graph
        JFreeChart chart = ChartFactory.createXYLineChart(
                "XY Chart", // Title
                "x-axis", // x-axis Label
                "y-axis", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );

        add(new ChartPanel(chart));
        this.pack();
        setVisible(true);

    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValores() {
        return valores;
    }

    public void setValores(double valores) {
        this.valores = valores;
    }

}
