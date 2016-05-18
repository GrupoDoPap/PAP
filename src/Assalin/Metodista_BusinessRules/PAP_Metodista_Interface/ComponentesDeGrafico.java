package Metodista_BusinessRules.PAP_Metodista_Interface;

import Metodista_BusinessRules.PAP_Metodista_Enum.AbaSolicitante;
import Metodista_BusinessRules.PAP_Metodista_Enum.GraficoSolicitante;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public interface ComponentesDeGrafico {

    DefaultCategoryDataset DCDataset = new DefaultCategoryDataset();
    DefaultPieDataset DPDataset = new DefaultPieDataset();

    public CategoryDataset BuildDatasetInicio(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante);

    public CategoryDataset BuildDatasetCliente(GraficoSolicitante graficoSolicitante);

    public CategoryDataset BuildDatasetMercado(GraficoSolicitante graficoSolicitante);

    public CategoryDataset BuildDatasetVendas(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante);

    public CategoryDataset BuildDatasetProdutos(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante);

    public CategoryDataset BuildDatasetSac(GraficoSolicitante graficoSolicitante);

    public PieDataset BuildPieDatasetInicio(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante);

    public PieDataset BuildPieDatasetCliente(GraficoSolicitante graficoSolicitante);

    public PieDataset BuildPieDatasetMercado(GraficoSolicitante graficoSolicitante);

    public PieDataset BuildPieDatasetVendas(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante);

    public PieDataset BuildPieDatasetProdutos(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante);

    public PieDataset BuildPieDatasetSac(GraficoSolicitante graficoSolicitante);

    public void BuildGrafico();

    public void AdicionarEventoLabel();
}
