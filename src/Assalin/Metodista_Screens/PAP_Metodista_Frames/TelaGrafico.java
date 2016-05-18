package Metodista_Screens.PAP_Metodista_Frames;

import Metodista_BusinessRules.PAP_Metodista_Enum.AbaSolicitante;
import Metodista_BusinessRules.PAP_Metodista_Enum.GraficoComboBoxItens;
import Metodista_BusinessRules.PAP_Metodista_Enum.GraficoSolicitante;
import Metodista_BusinessRules.PAP_Metodista_Interface.ComponentesDeGrafico;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoAtendimento;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoCliente;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoProduto;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoVenda;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;

public class TelaGrafico extends JFrame implements ComponentesDeGrafico {

    public static TelaGrafico InicioHojeSingleton[];
    public static TelaGrafico InicioOportunidadesSingleton[];
    public static TelaGrafico InicioAmeacasSingleton[];
    public static TelaGrafico ClienteHojeSingleton[];
    public static TelaGrafico MercadoHojeSingleton[];
    public static TelaGrafico VendasHojeSingleton[];
    public static TelaGrafico VendasOportunidadesSingleton[];
    public static TelaGrafico VendasAmeacasSingleton[];
    public static TelaGrafico ProdutosOportunidadesSingleton[];
    public static TelaGrafico ProdutosAmeacasSingleton[];
    public static TelaGrafico SacAnaliseAtualSingleton[];

    private JPanel painelTelaGrafico;
    private AcaoListener acaoListener;

    private AbaSolicitante abaSolicitante;
    private GraficoSolicitante graficoSolicitante;

    private JFreeChart graf;
    private ChartPanel ChartPanel;
    private JComboBox combo;
    private JButton botaoSalvar;

    private String incrementoNoTituloDoGrafico;
    private String tituloDoGrafico;

    private CachedRowSet resul = null;
    private final DaoVenda daoVenda = new DaoVenda();
    private final DaoCliente daoCliente = new DaoCliente();
    private final DaoProduto daoProduto = new DaoProduto();
    private final DaoAtendimento daoAtendimento = new DaoAtendimento();

    public TelaGrafico() {
        addWindowListener(acaoListener);
    }

    public TelaGrafico(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {

        this.abaSolicitante = abaSolicitante;
        this.graficoSolicitante = graficoSolicitante;

        try {
            BuildComponentes();
            BuildSingleton(abaSolicitante);
            TratamentoGraficoSolicitante(abaSolicitante, graficoSolicitante);
            setTitle(tituloDoGrafico + incrementoNoTituloDoGrafico);
            BuildGrafico();
            add(BuildPainel());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "OPS, falha na criação dos componentes!");
            exception.printStackTrace();
        }

        addWindowListener(acaoListener);
        setResizable(false);
        setSize(690, 500);
        setVisible(true);
    }

    private void BuildComponentes() {
        painelTelaGrafico = new JPanel();
        acaoListener = new AcaoListener();
        tituloDoGrafico = "Gráfico ";
        combo = new JComboBox();
        combo.addItem(GraficoComboBoxItens.Padrao);
        combo.addItem(GraficoComboBoxItens.GraficoDeBarra);
        combo.addItem(GraficoComboBoxItens.GraficoDeBarra3D);
        combo.addItem(GraficoComboBoxItens.GraficoDeLinha);
        combo.addItem(GraficoComboBoxItens.GraficoDeTorta);
        combo.addActionListener(acaoListener);
        botaoSalvar = new JButton("Salvar Gráfico");
        botaoSalvar.addActionListener(acaoListener);
        botaoSalvar.setToolTipText("Gravar gráfico em seu computador.");
    }

    private void BuildSingleton(AbaSolicitante abaSolicitante) {
        switch (abaSolicitante) {
            case InicioHoje:
                for (int contador = 0; contador > InicioHojeSingleton.length; contador++) {
                    InicioHojeSingleton[contador] = new TelaGrafico();
                }
                break;

            case InicioOportunidades:
                for (int contador = 0; contador > InicioOportunidadesSingleton.length; contador++) {
                    InicioOportunidadesSingleton[contador] = new TelaGrafico();
                }
                break;

            case InicioAmeacas:
                for (int contador = 0; contador > InicioAmeacasSingleton.length; contador++) {
                    InicioAmeacasSingleton[contador] = new TelaGrafico();
                }
                break;

            case ClienteHoje:
                for (int contador = 0; contador > ClienteHojeSingleton.length; contador++) {
                    ClienteHojeSingleton[contador] = new TelaGrafico();
                }
                break;

            case MercadoHoje:
                for (int contador = 0; contador > MercadoHojeSingleton.length; contador++) {
                    MercadoHojeSingleton[contador] = new TelaGrafico();
                }
                break;

            case VendasHoje:
                for (int contador = 0; contador > VendasHojeSingleton.length; contador++) {
                    VendasHojeSingleton[contador] = new TelaGrafico();
                }
                break;

            case VendasOportunidades:
                for (int contador = 0; contador > VendasOportunidadesSingleton.length; contador++) {
                    VendasOportunidadesSingleton[contador] = new TelaGrafico();
                }
                break;

            case VendasAmeacas:
                for (int contador = 0; contador > VendasAmeacasSingleton.length; contador++) {
                    VendasAmeacasSingleton[contador] = new TelaGrafico();
                }
                break;

            case ProdutosOportunidades:
                for (int contador = 0; contador > ProdutosOportunidadesSingleton.length; contador++) {
                    ProdutosOportunidadesSingleton[contador] = new TelaGrafico();
                }
                break;

            case ProdutosAmeacas:
                for (int contador = 0; contador > ProdutosAmeacasSingleton.length; contador++) {
                    ProdutosAmeacasSingleton[contador] = new TelaGrafico();
                }
                break;
        }
    }

    private void TratamentoGraficoSolicitante(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {
        DCDataset.clear();
        switch (abaSolicitante) {
            case InicioHoje:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Vendas Por Período";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Vendas Por Cliente";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Vendas Por Produto";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.HORIZONTAL);
                        break;

                    case BaixoDir:
                        incrementoNoTituloDoGrafico = "Vendas Por Local";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.HORIZONTAL);
                        break;
                }

                BuildPieDatasetInicio(abaSolicitante, graficoSolicitante);
                break;

            case InicioOportunidades:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Oportunidade - Período";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.HORIZONTAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Oportunidade - Cliente";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.HORIZONTAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Oportunidade - Produto";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.HORIZONTAL);
                        break;

                    case BaixoDir:
                        incrementoNoTituloDoGrafico = "Oportunidade - Local";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.HORIZONTAL);
                        break;
                }
                break;

            case InicioAmeacas:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Ameaça - Período";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.HORIZONTAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Ameaça - Cliente";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.HORIZONTAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Ameaça - Produto";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.HORIZONTAL);
                        break;

                    case BaixoDir:
                        incrementoNoTituloDoGrafico = "Ameaça - Local";
                        BuildDatasetInicio(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.HORIZONTAL);
                        break;
                }
                break;

            case ClienteHoje:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Compras Por Cliente";
                        BuildDatasetCliente(graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Dias Sem Comprar";
                        BuildDatasetCliente(graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Compras Por Belt";
                        BuildDatasetCliente(graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoDir:
                        //Tabela...
                        break;
                }
                break;

            case MercadoHoje:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Local - Mais Vendidos";
                        BuildDatasetMercado(graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoEsq:
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Local - Aumento De Compras";
                        BuildDatasetMercado(graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoDir:
                        incrementoNoTituloDoGrafico = "Local - Queda Nas Compras";
                        BuildDatasetMercado(graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;
                }
                break;

            case VendasHoje:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Lucros Por Produto";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Lucros Por Tempo";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.VERTICAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Lucros Por Estado";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoDir:
                        incrementoNoTituloDoGrafico = "Lucros Por Cliente";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;
                }
                break;

            case VendasOportunidades:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Oportunidade - Produto";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Oportunidade - Cliente";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Oportunidade - Local";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoDir:
                        incrementoNoTituloDoGrafico = "Oportunidade - Periodo";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;
                }
                break;

            case VendasAmeacas:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Ameaça - Produto";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Ameaça - Cliente";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Ameaça - Local";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.VERTICAL);
                        break;

                    case BaixoDir:
                        incrementoNoTituloDoGrafico = "Ameaça - Periodo";
                        BuildDatasetVendas(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.VERTICAL);
                        break;
                }
                break;

            case ProdutosOportunidades:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Produtos Mais Vendidos";
                        BuildDatasetProdutos(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Aumento De Venda Por Produtos";
                        BuildDatasetProdutos(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.VERTICAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Produtos Mais Elogiados";
                        BuildDatasetProdutos(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoDir:
                        break;
                }
                break;

            case ProdutosAmeacas:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Produtos Menos Vendidos";
                        BuildDatasetProdutos(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Queda De Venda Por Produtos";
                        BuildDatasetProdutos(abaSolicitante, graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.VERTICAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Produtos Mais Reclamados";
                        BuildDatasetProdutos(abaSolicitante, graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoDir:
                        break;
                }
                break;

            case SacAnaliseAtual:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        incrementoNoTituloDoGrafico = "Ocorrencias Por Dia Da Semana";
                        BuildDatasetSac(graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case BaixoEsq:
                        incrementoNoTituloDoGrafico = "Maiores Reclamações";
                        BuildDatasetSac(graficoSolicitante);
                        BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                        break;

                    case CimaDir:
                        incrementoNoTituloDoGrafico = "Ocorrencias Por Dia";
                        BuildDatasetSac(graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.VERTICAL);
                        break;

                    case BaixoDir:
                        incrementoNoTituloDoGrafico = "Tempo Médio De Solução";
                        BuildDatasetSac(graficoSolicitante);
                        BuildGraficoLinha(PlotOrientation.VERTICAL);
                        break;
                }
                break;
        }
    }

    private JPanel BuildPainel() {
        painelTelaGrafico.removeAll();
        painelTelaGrafico.revalidate();
        painelTelaGrafico.repaint();

        painelTelaGrafico.add(ChartPanel, BorderLayout.NORTH);
        painelTelaGrafico.add(combo);
        painelTelaGrafico.add(botaoSalvar);

        return painelTelaGrafico;
    }

    private void BuildGraficoBarra(PlotOrientation posicao) {
        graf = ChartFactory.createBarChart(
                incrementoNoTituloDoGrafico,
                "",
                "R$",
                this.DCDataset,
                posicao,
                true,
                false,
                false
        );
    }

    private void BuildGraficoBarra3D(PlotOrientation posicao) {
        graf = ChartFactory.createBarChart3D(
                incrementoNoTituloDoGrafico,
                "",
                "R$",
                this.DCDataset,
                posicao,
                true,
                false,
                false
        );
    }

    private void BuildGraficoLinha(PlotOrientation posicao) {
        graf = ChartFactory.createLineChart3D(
                incrementoNoTituloDoGrafico,
                "",
                "R$",
                this.DCDataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
    }

    public void BuildGraficoTorta() {
        graf = ChartFactory.createPieChart(
                incrementoNoTituloDoGrafico,
                this.DPDataset,
                true,
                false,
                false
        );
    }

    @Override
    public CategoryDataset BuildDatasetInicio(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {

        switch (abaSolicitante) {

            case InicioHoje:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoVenda.quantidadeVendida();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.clientesQueMaisCompraramPorQuantidade();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.produtosMaisVendidosPorQuantidade();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.estadosMaiorVenda();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;

            case InicioOportunidades:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoVenda.mesMaiorVenda();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.clienteAumentoCompras();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.oportunidadeProdutoPorQuantidade();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.estadoMaiorAumento();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Total");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;

            case InicioAmeacas:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoVenda.mesMenorVenda();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Total");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.ameacaCliente();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.ameacaProdutoPorQuantidade();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Total");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.estadoMaiorQueda();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;
        }
        return DCDataset;
    }

    @Override
    public CategoryDataset BuildDatasetCliente(GraficoSolicitante graficoSolicitante) {
        switch (graficoSolicitante) {
            case CimaEsq:
                resul = daoCliente.clientesQueMaisCompraramPorQuantidade();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoEsq:
                resul = daoCliente.clientesHaMaisTempoSemComprar();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Valor Monetário");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case CimaDir:
                resul = daoCliente.beltsQueMaisCompraram();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoDir:
                resul = daoCliente.clientesHaMaisTempoSemComprar();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;
        }
        return DCDataset;
    }

    @Override
    public CategoryDataset BuildDatasetMercado(GraficoSolicitante graficoSolicitante) {
        switch (graficoSolicitante) {
            case CimaEsq:
                resul = daoVenda.estadosMaiorVenda();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoEsq:
                resul = daoVenda.cidadesMaioresCompras();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(4)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case CimaDir:
                resul = daoVenda.estadosMaiorAumentoMesPassadoAtual();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Total");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoDir:
                resul = daoVenda.estadosMaiorQuedaMesPassadoAtual();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;
        }
        return DCDataset;
    }

    @Override
    public CategoryDataset BuildDatasetVendas(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {

        switch (abaSolicitante) {
            case VendasHoje:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.produtosMaisVendidosPorValor();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoVenda.quantidadeVendidaValorMonetario();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoVenda.estadosMaiorVendaValorMonetario();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                }
                break;

            case VendasOportunidades:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.oportunidadeProdutoPorValor();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.clienteAumentoCompras();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoVenda.estadoMaiorAumentoValorMonetario();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.mesesMaiorAumentoVenda();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;

            case VendasAmeacas:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.ameacaProdutoPorValor();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.clienteQuedaCompras();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoVenda.estadoMaiorQuedaValorMonetario();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(3)), resul.getString(2), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.mesMaiorQuedaValorMonetario();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Valor Monetário");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;
        }
        return DCDataset;
    }

    @Override
    public CategoryDataset BuildDatasetProdutos(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {

        switch (abaSolicitante) {
            case ProdutosOportunidades:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.produtosMaisVendidosPorQuantidade();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoVenda.mesMaiorAumentoValorMonetario();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.produtosMaisElogiados();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoProduto.produtosMaisCompradosPorEstado();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;

            case ProdutosAmeacas:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.produtosMenosVendidos();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoVenda.mesesMaiorQuedaVenda();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.produtosMaisCriticados();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoProduto.produtosMaisDevolvidosPorEstado();
                        try {
                            while (resul.next()) {
                                DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;
        }
        return DCDataset;
    }

    @Override
    public CategoryDataset BuildDatasetSac(GraficoSolicitante graficoSolicitante) {

        switch (graficoSolicitante) {
            case CimaEsq:
                resul = daoAtendimento.ocorrenciasAbertasPorDiaDaSemana();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoEsq:
                resul = daoAtendimento.clientesQueMaisReclamaram();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case CimaDir:
                resul = daoAtendimento.ocorrenciasAbertasPorDia();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoDir:
                resul = daoAtendimento.tempoMedioDeSolucao();
                try {
                    while (resul.next()) {
                        DCDataset.setValue(Double.parseDouble(resul.getString(2)), resul.getString(1), "Quantidade");
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;
        }
        return DCDataset;
    }

    @Override
    public PieDataset BuildPieDatasetInicio(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {

        switch (abaSolicitante) {

            case InicioHoje:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoVenda.quantidadeVendida();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.clientesQueMaisCompraramPorQuantidade();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.produtosMaisVendidosPorQuantidade();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.estadosMaiorVenda();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;

            case InicioOportunidades:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoVenda.mesMaiorVenda();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.clienteAumentoCompras();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.oportunidadeProdutoPorQuantidade();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.estadoMaiorAumento();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;

            case InicioAmeacas:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoVenda.mesMenorVenda();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.ameacaCliente();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.ameacaProdutoPorQuantidade();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.estadoMaiorQueda();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;
        }
        return DPDataset;
    }

    @Override
    public PieDataset BuildPieDatasetCliente(GraficoSolicitante graficoSolicitante) {
        switch (graficoSolicitante) {
            case CimaEsq:
                resul = daoCliente.clientesQueMaisCompraramPorQuantidade();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoEsq:
                resul = daoCliente.clientesHaMaisTempoSemComprar();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case CimaDir:
                resul = daoCliente.beltsQueMaisCompraram();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoDir:
                resul = daoCliente.clientesHaMaisTempoSemComprar();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;
        }
        return DPDataset;
    }

    @Override
    public PieDataset BuildPieDatasetMercado(GraficoSolicitante graficoSolicitante) {
        switch (graficoSolicitante) {
            case CimaEsq:
                resul = daoVenda.estadosMaiorVenda();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoEsq:
                resul = daoVenda.cidadesMaioresCompras();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(4)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case CimaDir:
                resul = daoVenda.estadosMaiorAumentoMesPassadoAtual();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoDir:
                resul = daoVenda.estadosMaiorQuedaMesPassadoAtual();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;
        }
        return DPDataset;
    }

    @Override
    public PieDataset BuildPieDatasetVendas(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {

        switch (abaSolicitante) {
            case VendasHoje:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.produtosMaisVendidosPorValor();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoVenda.quantidadeVendidaValorMonetario();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoVenda.estadosMaiorVendaValorMonetario();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                }
                break;

            case VendasOportunidades:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.oportunidadeProdutoPorValor();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.clienteAumentoCompras();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoVenda.estadoMaiorAumentoValorMonetario();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Oportunidade - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.mesesMaiorAumentoVenda();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;

            case VendasAmeacas:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.ameacaProdutoPorValor();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoCliente.clienteQuedaCompras();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoVenda.estadoMaiorQuedaValorMonetario();
                        try {
                            while (resul.next()) {
                                incrementoNoTituloDoGrafico = "Ameaça - " + resul.getString(1);
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoVenda.mesMaiorQuedaValorMonetario();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;
        }
        return DPDataset;
    }

    @Override
    public PieDataset BuildPieDatasetProdutos(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {
        switch (abaSolicitante) {
            case ProdutosOportunidades:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.produtosMaisVendidosPorQuantidade();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoVenda.mesMaiorAumentoValorMonetario();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.produtosMaisElogiados();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoProduto.produtosMaisCompradosPorEstado();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(2), Double.parseDouble(resul.getString(3)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;

            case ProdutosAmeacas:
                switch (graficoSolicitante) {
                    case CimaEsq:
                        resul = daoProduto.produtosMenosVendidos();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoEsq:
                        resul = daoVenda.mesesMaiorQuedaVenda();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case CimaDir:
                        resul = daoProduto.produtosMaisCriticados();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;

                    case BaixoDir:
                        resul = daoProduto.produtosMaisDevolvidosPorEstado();
                        try {
                            while (resul.next()) {
                                DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                            }
                        } catch (Exception erro) {
                            erro.printStackTrace();
                        }
                        break;
                }
                break;
        }
        return DPDataset;
    }

    @Override
    public PieDataset BuildPieDatasetSac(GraficoSolicitante graficoSolicitante) {
        switch (graficoSolicitante) {
            case CimaEsq:
                resul = daoAtendimento.ocorrenciasAbertasPorDiaDaSemana();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoEsq:
                resul = daoAtendimento.clientesQueMaisReclamaram();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case CimaDir:
                resul = daoAtendimento.ocorrenciasAbertasPorDia();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;

            case BaixoDir:
                resul = daoAtendimento.tempoMedioDeSolucao();
                try {
                    while (resul.next()) {
                        DPDataset.setValue(resul.getString(1), Double.parseDouble(resul.getString(2)));
                    }
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
                break;
        }
        return DPDataset;
    }

    @Override
    public void BuildGrafico() {
        ChartPanel = new ChartPanel(graf);
    }

    @Override
    public void AdicionarEventoLabel() {

    }

    public class AcaoListener implements ActionListener, WindowListener {

        public void actionPerformed(ActionEvent event) {
            Object recuperaItem = combo.getSelectedItem();

            switch (recuperaItem.toString()) {
                case "Padrao":
                    BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                    BuildGrafico();
                    add(BuildPainel());
                    break;

                case "GraficoDeBarra":
                    BuildGraficoBarra(PlotOrientation.VERTICAL);
                    BuildGrafico();
                    add(BuildPainel());
                    break;

                case "GraficoDeBarra3D":
                    BuildGraficoBarra3D(PlotOrientation.VERTICAL);
                    BuildGrafico();
                    add(BuildPainel());
                    break;

                case "GraficoDeLinha":
                    BuildGraficoLinha(PlotOrientation.VERTICAL);
                    BuildGrafico();
                    add(BuildPainel());
                    break;

                case "GraficoDeTorta":
                    BuildGraficoTorta();
                    BuildGrafico();
                    add(BuildPainel());
                    break;
            }

            if (event.getSource() == botaoSalvar) {
                Object[] options = {".PNG",
                    ".JPEG",
                    "Cancelar"};
                int dialogButton = JOptionPane.showOptionDialog(painelTelaGrafico,
                        "Deseja salvar este gráfico em qual formato?",
                        "Salvar Gráfico",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[2]);

                if (dialogButton == JOptionPane.YES_OPTION) { //.PNG
                    try {
                        final ChartRenderingInfo info = new ChartRenderingInfo();
                        final File file = new File("Gráfico - " + tituloDoGrafico + ".png");
                        ChartUtilities.saveChartAsPNG(file, graf, 660, 290, info);
                        JOptionPane.showMessageDialog(painelTelaGrafico, "Salvo com Sucesso.");
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(painelTelaGrafico, "Ocorreu um erro ao salvar o gráfico .png");
                        exception.printStackTrace();
                    }
                } else if (dialogButton == JOptionPane.NO_OPTION) { //.JPG
                    try {
                        final ChartRenderingInfo info = new ChartRenderingInfo();
                        final File file = new File("Gráfico - " + tituloDoGrafico + ".jpeg");
                        ChartUtilities.saveChartAsJPEG(file, graf, 660, 290, info);
                        JOptionPane.showMessageDialog(painelTelaGrafico, "Salvo com Sucesso.");
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(painelTelaGrafico, "Ocorreu um erro ao salvar o gráfico .jpeg");
                        exception.printStackTrace();
                    }
                }
            }
        }

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            switch (abaSolicitante) {
                case InicioHoje:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            InicioHojeSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            InicioHojeSingleton[1] = null;
                            break;

                        case CimaDir:
                            InicioHojeSingleton[2] = null;
                            break;

                        case BaixoDir:
                            InicioHojeSingleton[3] = null;
                            break;
                    }
                    break;

                case InicioOportunidades:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            InicioOportunidadesSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            InicioOportunidadesSingleton[1] = null;
                            break;

                        case CimaDir:
                            InicioOportunidadesSingleton[2] = null;
                            break;

                        case BaixoDir:
                            InicioOportunidadesSingleton[3] = null;
                            break;
                    }
                    break;

                case InicioAmeacas:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            InicioAmeacasSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            InicioAmeacasSingleton[1] = null;
                            break;

                        case CimaDir:
                            InicioAmeacasSingleton[2] = null;
                            break;

                        case BaixoDir:
                            InicioAmeacasSingleton[3] = null;
                            break;
                    }
                    break;

                case ClienteHoje:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            ClienteHojeSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            ClienteHojeSingleton[1] = null;
                            break;

                        case CimaDir:
                            ClienteHojeSingleton[2] = null;
                            break;

                        case BaixoDir:
                            break;
                    }
                    break;

                case MercadoHoje:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            MercadoHojeSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            break;

                        case CimaDir:
                            MercadoHojeSingleton[1] = null;
                            break;

                        case BaixoDir:
                            MercadoHojeSingleton[2] = null;
                            break;
                    }
                    break;

                case VendasHoje:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            VendasHojeSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            VendasHojeSingleton[1] = null;
                            break;

                        case CimaDir:
                            VendasHojeSingleton[2] = null;
                            break;

                        case BaixoDir:
                            VendasHojeSingleton[3] = null;
                            break;
                    }
                    break;

                case VendasOportunidades:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            VendasOportunidadesSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            VendasOportunidadesSingleton[1] = null;
                            break;

                        case CimaDir:
                            VendasOportunidadesSingleton[2] = null;
                            break;

                        case BaixoDir:
                            VendasOportunidadesSingleton[3] = null;
                            break;
                    }
                    break;

                case VendasAmeacas:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            VendasAmeacasSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            VendasAmeacasSingleton[1] = null;
                            break;

                        case CimaDir:
                            VendasAmeacasSingleton[2] = null;
                            break;

                        case BaixoDir:
                            VendasAmeacasSingleton[3] = null;
                            break;
                    }
                    break;

                case ProdutosOportunidades:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            ProdutosOportunidadesSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            ProdutosOportunidadesSingleton[1] = null;
                            break;

                        case CimaDir:
                            ProdutosOportunidadesSingleton[2] = null;
                            break;

                        case BaixoDir:
                            break;
                    }
                    break;

                case ProdutosAmeacas:
                    switch (graficoSolicitante) {
                        case CimaEsq:
                            ProdutosAmeacasSingleton[0] = null;
                            break;

                        case BaixoEsq:
                            ProdutosAmeacasSingleton[1] = null;
                            break;

                        case CimaDir:
                            ProdutosAmeacasSingleton[2] = null;
                            break;

                        case BaixoDir:
                            break;
                    }
                    break;
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}
