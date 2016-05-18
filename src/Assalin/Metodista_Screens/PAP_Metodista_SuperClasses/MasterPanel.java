package Metodista_Screens.PAP_Metodista_SuperClasses;

import Metodista_BusinessRules.PAP_Metodista_Enum.AbaSolicitante;
import Metodista_BusinessRules.PAP_Metodista_Enum.GraficoSolicitante;
import Metodista_Screens.PAP_Metodista_Frames.TelaGrafico;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class MasterPanel extends javax.swing.JPanel {

    private final AcaoListener acaoListener;
    private final AbaSolicitante abaSolicitante;
    private final GraficoSolicitante graficoSolicitante;

    private TelaGrafico telaGrafico;
    JFreeChart chart = null;
    ChartPanel chartPanel = null;

    public MasterPanel(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {
        this.abaSolicitante = abaSolicitante;
        this.graficoSolicitante = graficoSolicitante;

        acaoListener = new AcaoListener();
        initComponents();
        ChangeLabelProperties(abaSolicitante, graficoSolicitante);
        labelGrafico.addMouseListener(acaoListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelGrafico = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(540, 335));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(540, 335));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelGrafico)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelGrafico)
                .addGap(0, 290, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ChangeLabelProperties(AbaSolicitante abaSolicitante, GraficoSolicitante graficoSolicitante) {
        switch (abaSolicitante) {
            case InicioHoje:
                TelaGrafico.InicioHojeSingleton = new TelaGrafico[4];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioHoje/InicioHoje - Vendas Por Periodo.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioHoje/InicioHoje - Vendas Por Clientes.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioHoje/InicioHoje - Vendas Por Produtos.png")));
                        break;

                    case BaixoDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioHoje/InicioHoje - Vendas Por Locais.png")));
                        break;
                }
                break;

            case InicioOportunidades:
                TelaGrafico.InicioOportunidadesSingleton = new TelaGrafico[4];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioOportunidades/InicioOportunidades - Periodo.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioOportunidades/InicioOportunidades - Cliente.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioOportunidades/InicioOportunidades - Produto.png")));
                        break;

                    case BaixoDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioOportunidades/InicioOportunidades - Local.png")));
                        break;
                }
                break;

            case InicioAmeacas:
                TelaGrafico.InicioAmeacasSingleton = new TelaGrafico[4];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioAmeacas/InicioAmeacas - Periodo.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioAmeacas/InicioAmeacas - Cliente.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioAmeacas/InicioAmeacas - Produto.png")));
                        break;

                    case BaixoDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Inicio/InicioAmeacas/InicioAmeacas - Local.png")));
                        break;
                }
                break;

            case ClienteHoje:
                TelaGrafico.ClienteHojeSingleton = new TelaGrafico[3];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Clientes/ClientesHoje/ClientesHoje - Compras por Cliente.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Clientes/ClientesHoje/ClientesHoje - Dias sem Comprar.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Clientes/ClientesHoje/ClientesHoje - Compras por Belt.png")));
                        break;

                    case BaixoDir:
                        //Tabela...
                        break;
                }
                break;

            case MercadoHoje:
                TelaGrafico.MercadoHojeSingleton = new TelaGrafico[3];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Mercado/MercadoHoje/MercadoHoje - Mais Vendidos.png")));
                        break;

                    case BaixoEsq:
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Mercado/MercadoHoje/MercadoHoje - Aumento nas Compras.png")));
                        break;

                    case BaixoDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Mercado/MercadoHoje/MercadoHoje - Queda nas Compras.png")));
                        break;
                }
                break;

            case VendasHoje:
                TelaGrafico.VendasHojeSingleton = new TelaGrafico[4];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasHoje/VendasHoje - Lucros por Produto.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasHoje/VendasHoje - Lucros por Tempo.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasHoje/VendasHoje - Lucros por Estado.png")));
                        break;

                    case BaixoDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasHoje/VendasHoje - Lucros por Cliente.png")));
                        break;
                }
                break;

            case VendasOportunidades:
                TelaGrafico.VendasOportunidadesSingleton = new TelaGrafico[4];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasOportunidades/VendasOportunidades - Produto.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasOportunidades/VendasOportunidades - Cliente.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasOportunidades/VendasOportunidades - Local.png")));
                        break;

                    case BaixoDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasOportunidades/VendasOportunidades - Periodo.png")));
                        break;
                }
                break;

            case VendasAmeacas:
                TelaGrafico.VendasAmeacasSingleton = new TelaGrafico[4];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasAmeacas/VendasAmeacas - Produto.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasAmeacas/VendasAmeacas - Cliente.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasAmeacas/VendasAmeacas - Local.png")));
                        break;

                    case BaixoDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Vendas/VendasAmeacas/VendasAmeacas - Periodo.png")));
                        break;
                }
                break;

            case ProdutosOportunidades:
                TelaGrafico.ProdutosOportunidadesSingleton = new TelaGrafico[3];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Produtos/ProdutosOportunidades/ProdutosOportunidades - Mais Vendidos.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Produtos/ProdutosOportunidades/ProdutosOportunidades - Aumento de Vendas por Produtos.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Produtos/ProdutosOportunidades/ProdutosOportunidades - Mais Elogiados.png")));
                        break;

                    case BaixoDir:
                        break;
                }
                break;

            case ProdutosAmeacas:
                TelaGrafico.ProdutosAmeacasSingleton = new TelaGrafico[3];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Produtos/ProdutosAmeacas/ProdutosAmeacas - Menos Vendidos.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Produtos/ProdutosAmeacas/ProdutosAmeacas - Queda de Vendas por Produtos.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Produtos/ProdutosAmeacas/ProdutosAmeacas - Mais Reclamados.png")));
                        break;

                    case BaixoDir:
                        break;
                }
                break;

            case SacAnaliseAtual:
                TelaGrafico.SacAnaliseAtualSingleton = new TelaGrafico[3];

                switch (graficoSolicitante) {
                    case CimaEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Sac/SacAnaliseAtual/Sac - Ocorrencia por Dia da Semana.png")));
                        break;

                    case BaixoEsq:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Sac/SacAnaliseAtual/Sac - Maiores Reclamacoes.png")));
                        break;

                    case CimaDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Sac/SacAnaliseAtual/Sac - Ocorrencia por Dia.png")));
                        break;

                    case BaixoDir:
                        labelGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metodista_Screens/PAP_Metodista_Images/Sac/SacAnaliseAtual/Sac - Ocorrencia por Dia.png")));
                        break;
                }
                break;

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelGrafico;
    // End of variables declaration//GEN-END:variables

    public class AcaoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {
            if (event.getSource() == labelGrafico) {
                switch (abaSolicitante) {
                    case InicioHoje:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioHojeSingleton[0] = telaGrafico;
                                break;
                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioHojeSingleton[1] = telaGrafico;
                                break;
                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioHojeSingleton[2] = telaGrafico;
                                break;
                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioHojeSingleton[3] = telaGrafico;
                                break;
                        }
                        break;

                    case InicioOportunidades:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[1] = telaGrafico;
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[3] = telaGrafico;
                                break;
                        }
                        break;

                    case InicioAmeacas:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[1] = telaGrafico;
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[3] = telaGrafico;
                                break;
                        }
                        break;

                    case ClienteHoje:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[1] = telaGrafico;
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                break;
                        }
                        break;

                    case MercadoHoje:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[3] = telaGrafico;
                                break;
                        }
                        break;

                    case VendasHoje:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[3] = telaGrafico;
                                break;
                        }
                        break;

                    case VendasOportunidades:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[3] = telaGrafico;
                                break;
                        }

                        break;

                    case VendasAmeacas:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[3] = telaGrafico;
                                break;
                        }
                        break;

                    case ProdutosOportunidades:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[3] = telaGrafico;
                                break;
                        }
                        break;

                    case ProdutosAmeacas:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[3] = telaGrafico;
                                break;
                        }
                        break;

                    case SacAnaliseAtual:
                        switch (graficoSolicitante) {
                            case CimaEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case BaixoEsq:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[0] = telaGrafico;
                                break;

                            case CimaDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;

                            case BaixoDir:
                                telaGrafico = new TelaGrafico(abaSolicitante, graficoSolicitante);
                                TelaGrafico.InicioOportunidadesSingleton[2] = telaGrafico;
                                break;
                        }
                        break;
                }
            }
        }

        //DEMAIS MÉTODOS NÃO SERÃO UTILIZADOS...
        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
