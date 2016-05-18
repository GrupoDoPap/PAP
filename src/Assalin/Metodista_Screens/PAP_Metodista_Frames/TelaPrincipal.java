package Metodista_Screens.PAP_Metodista_Frames;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Usuario;
import Metodista_BusinessRules.PAP_Metodista_Enum.AbaSolicitante;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoFuncionario;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaClientes.PainelClienteAdicionar;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaClientes.PainelClienteAlterar;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaClientes.PainelClienteLista;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaClientes.PainelClienteLocalizacao;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaClientes.PainelClienteBotoes;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaConfiguracoes.PainelConfiguracoesAdicionarUsuario;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaConfiguracoes.PainelConfiguracoesAlterarUsuario;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaConfiguracoes.PainelConfiguracoesBotoes;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMercado.PainelMercadoBotoes;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMercado.PainelMercadoMapaNacional;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMidiasSociais.PainelMidiasSociaisBotoes;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMidiasSociais.PainelMidiasSociaisBuscaPersonalizada;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMidiasSociais.PainelMidiasSociaisCitacoes;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMidiasSociais.PainelMidiasSociaisCriticas;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMidiasSociais.PainelMidiasSociaisElogios;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaInicio.PainelInicioBotoes;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaProdutos.PainelProdutosBotoes;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaSAC.PainelSacAlterarAtendimento;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaSAC.PainelSacBotoes;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaSAC.PainelSacGerarAtendimento;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaSAC.PainelSacGrauSatisfacao;
import Metodista_Screens.PAP_Metodista_Panels.PaineisTelaVendas.PainelVendasBotoes;
import Metodista_Screens.PAP_Metodista_SuperClasses.SplitMasterPane;
import Metodista_Screens.PAP_Metodista_TruckSystem.Paineis.PainelTruckSystemBotoes;
import Metodista_Screens.PAP_Metodista_TruckSystem.Paineis.PainelPedidos;
import Metodista_Screens.PAP_Metodista_TruckSystem.Paineis.PainelViagens;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public final class TelaPrincipal extends JFrame {

    private JTabbedPane abaTela;

    private AcaoListener acaoListener;
    DaoFuncionario daoFuncionario;
    private Usuario usuario;
    private String departamento;

    private PainelInicioBotoes painelInicioBotoes;

    private PainelClienteBotoes painelClienteBotoes;
    private PainelClienteLista painelClienteLista;
    private PainelClienteAdicionar painelClienteAdicionar;
    private PainelClienteAlterar painelClienteAlterar;
    private PainelClienteLocalizacao painelClienteLocalizacao;

    private PainelProdutosBotoes painelProdutosBotoes;

    private PainelMercadoBotoes painelMercadoBotoes;
    private PainelMercadoMapaNacional painelMercadoMapaNacional;

    private PainelVendasBotoes painelVendasBotoes;

    private PainelSacBotoes painelSacBotoes;
    private PainelSacGerarAtendimento painelSacGerarAtendimento;
    private PainelSacAlterarAtendimento painelSacAlterarAtendimento;
    private PainelSacGrauSatisfacao painelSacGrauSatisfacao;

    private PainelMidiasSociaisBotoes painelMidiasSociaisBotoes;
    private PainelMidiasSociaisCitacoes painelMidiasSociaisCitacoes;
    private PainelMidiasSociaisElogios painelMidiasSociaisElogios;
    private PainelMidiasSociaisCriticas painelMidiasSociaisCriticas;
    private PainelMidiasSociaisBuscaPersonalizada painelMidiasSociaisBuscaPersonalizada;

    private PainelConfiguracoesBotoes painelConfiguracoesBotoes;
    private PainelConfiguracoesAdicionarUsuario painelConfiguracoesAdicionarUsuario;
    private PainelConfiguracoesAlterarUsuario painelConfiguracoesAlterarUsuario;

    private PainelTruckSystemBotoes painelTruckSystemBotoes;
    private PainelViagens painelViagens;
    private PainelPedidos painelPedidos;

    private JSplitPane splitPaneInicio;
    private JSplitPane splitPaneClientes;
    private JSplitPane splitPaneProdutos;
    private JSplitPane splitPaneMercado;
    private JSplitPane splitPaneVendas;
    private JSplitPane splitPaneSac;
    private JSplitPane splitPaneMidiasSociais;
    private JSplitPane splitPaneConfiguracoes;
    private JSplitPane splitPaneTruckSystem;

    public TelaPrincipal(Usuario usuario) {

        this.usuario = usuario;
        this.departamento = usuario.getCargo();

        setTitle("Bem vindo, " + usuario.getNome());
        try {
            BuildComponentes(departamento);
            AdicionarEventos(departamento);
            AdicionarDescricaoBotoes(departamento);

            switch (departamento) {
                case "SAC":
                    AddAba("SAC", splitPaneSac);
                    break;

                case "INFORMATICA":
                case "ADMIN":
                    AddAba("Início", splitPaneInicio);
                    AddAba("Clientes", splitPaneClientes);
                    AddAba("Mercado", splitPaneMercado);
                    AddAba("Vendas", splitPaneVendas);
                    AddAba("Produtos", splitPaneProdutos);
                    AddAba("Mídias Sociais", splitPaneMidiasSociais);
                    AddAba("SAC", splitPaneSac);
                    AddAba("Configurações", splitPaneConfiguracoes);
                    AddAba("Caminhão", splitPaneTruckSystem);

                    break;
                case "FINANCEIRO":
                    AddAba("Mercado", splitPaneMercado);
                    AddAba("Vendas", splitPaneVendas);
                    AddAba("Produtos", splitPaneProdutos);

                    break;
                case "PRODUCAO":
                    AddAba("Produtos", splitPaneProdutos);

                    break;

                case "LOGISTICA":
                    AddAba("Caminhão", splitPaneTruckSystem);

                    break;
            }

            BuildSplitPane(departamento);

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "OPS, falha na criação dos componentes!");
            exception.printStackTrace(); //Alterar JOptionPane seguindo modelo dos comentarios da classe AcaoListener da classe TelaLogin
        }

        setSize(1120, 810);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void BuildComponentes(String usuario) {
        abaTela = new JTabbedPane();

        acaoListener = new AcaoListener();

        switch (usuario) {
            case "SAC":
                painelSacBotoes = new PainelSacBotoes();

                splitPaneSac = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

                break;

            case "INFORMATICA":
            case "ADMIN":
                painelInicioBotoes = new PainelInicioBotoes();

                painelClienteBotoes = new PainelClienteBotoes();

                painelMercadoBotoes = new PainelMercadoBotoes();

                painelVendasBotoes = new PainelVendasBotoes();

                painelProdutosBotoes = new PainelProdutosBotoes();

                painelMidiasSociaisBotoes = new PainelMidiasSociaisBotoes();
                painelMidiasSociaisCitacoes = new PainelMidiasSociaisCitacoes();

                painelSacBotoes = new PainelSacBotoes();

                painelConfiguracoesBotoes = new PainelConfiguracoesBotoes();
                painelConfiguracoesAdicionarUsuario = new PainelConfiguracoesAdicionarUsuario();

                painelTruckSystemBotoes = new PainelTruckSystemBotoes();
                painelPedidos = new PainelPedidos();

                splitPaneInicio = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneClientes = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneMercado = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneVendas = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneProdutos = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneMidiasSociais = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneSac = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneConfiguracoes = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneTruckSystem = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

                break;
            case "FINANCEIRO":
                painelClienteBotoes = new PainelClienteBotoes();

                painelMercadoBotoes = new PainelMercadoBotoes();

                painelVendasBotoes = new PainelVendasBotoes();

                splitPaneClientes = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneMercado = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                splitPaneVendas = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

            case "PRODUCAO":
                painelProdutosBotoes = new PainelProdutosBotoes();

                splitPaneProdutos = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

                break;

            case "LOGISTICA":
                painelTruckSystemBotoes = new PainelTruckSystemBotoes();
                painelPedidos = new PainelPedidos();

                splitPaneTruckSystem = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        }
    }

    private void AdicionarEventos(String usuario) {
        addKeyListener(acaoListener);

        switch (usuario) {
            case "SAC":
                painelSacBotoes.getBotaoSacAnaliseAtual().addActionListener(acaoListener);
                painelSacBotoes.getBotaoSacGrauSatisfacao().addActionListener(acaoListener);
                painelSacBotoes.getBotaoSacGerarAtendimento().addActionListener(acaoListener);
                painelSacBotoes.getBotaoSacAlterarAtendimento().addActionListener(acaoListener);

                break;

            case "INFORMATICA":
            case "ADMIN":
                painelInicioBotoes.getBotaoInicioHoje().addActionListener(acaoListener);
                painelInicioBotoes.getBotaoInicioOportunidades().addActionListener(acaoListener);
                painelInicioBotoes.getBotaoInicioAmeacas().addActionListener(acaoListener);

                painelClienteBotoes.getBotaoClienteHoje().addActionListener(acaoListener);
                painelClienteBotoes.getBotaoClientesLista().addActionListener(acaoListener);
                painelClienteBotoes.getBotaoClientesAdicionar().addActionListener(acaoListener);
                painelClienteBotoes.getBotaoClientesAlterar().addActionListener(acaoListener);

                painelMercadoBotoes.getBotaoMercadoHoje().addActionListener(acaoListener);

                painelVendasBotoes.getBotaoVendasHoje().addActionListener(acaoListener);
                painelVendasBotoes.getBotaoVendasOportunidades().addActionListener(acaoListener);
                painelVendasBotoes.getBotaoVendasAmeacas().addActionListener(acaoListener);

                painelProdutosBotoes.getBotaoProdutosOportunidades().addActionListener(acaoListener);
                painelProdutosBotoes.getBotaoProdutosAmeacas().addActionListener(acaoListener);

                painelMidiasSociaisBotoes.getBotaoMidiasSociaisCitacoes().addActionListener(acaoListener);
                painelMidiasSociaisBotoes.getBotaoMidiasSociaisElogios().addActionListener(acaoListener);
                painelMidiasSociaisBotoes.getBotaoMidiasSociaisCriticas().addActionListener(acaoListener);
                painelMidiasSociaisBotoes.getBotaoMidiasSociaisBuscaPersonalizada().addActionListener(acaoListener);

                painelSacBotoes.getBotaoSacAnaliseAtual().addActionListener(acaoListener);
                painelSacBotoes.getBotaoSacGrauSatisfacao().addActionListener(acaoListener);
                painelSacBotoes.getBotaoSacGerarAtendimento().addActionListener(acaoListener);
                painelSacBotoes.getBotaoSacAlterarAtendimento().addActionListener(acaoListener);

                painelConfiguracoesBotoes.getBotaoConfiguracoesAdicionarUsuario().addActionListener(acaoListener);
                painelConfiguracoesBotoes.getBotaoConfiguracoesAlterarUsuario().addActionListener(acaoListener);

                painelTruckSystemBotoes.getBotaoTruckSystemViagens().addActionListener(acaoListener);
                painelTruckSystemBotoes.getBotaoTruckSystemPedidos().addActionListener(acaoListener);

                break;
            case "FINANCEIRO":
                painelClienteBotoes.getBotaoClienteHoje().addActionListener(acaoListener);
                painelClienteBotoes.getBotaoClientesLista().addActionListener(acaoListener);
                painelClienteBotoes.getBotaoClientesAdicionar().addActionListener(acaoListener);
                painelClienteBotoes.getBotaoClientesAlterar().addActionListener(acaoListener);

                painelMercadoBotoes.getBotaoMercadoHoje().addActionListener(acaoListener);

                painelVendasBotoes.getBotaoVendasHoje().addActionListener(acaoListener);
                painelVendasBotoes.getBotaoVendasOportunidades().addActionListener(acaoListener);
                painelVendasBotoes.getBotaoVendasAmeacas().addActionListener(acaoListener);

                break;
            case "PRODUCAO":
                painelProdutosBotoes.getBotaoProdutosOportunidades().addActionListener(acaoListener);
                painelProdutosBotoes.getBotaoProdutosAmeacas().addActionListener(acaoListener);

                break;

            case "LOGISTICA":
                painelTruckSystemBotoes.getBotaoTruckSystemViagens().addActionListener(acaoListener);
                painelTruckSystemBotoes.getBotaoTruckSystemPedidos().addActionListener(acaoListener);

                break;
        }
    }

    private void AdicionarDescricaoBotoes(String usuario) {

        switch (usuario) {
            case "INFORMATICA":
            case "ADMIN":
                painelMidiasSociaisBotoes.getBotaoMidiasSociaisCitacoes().setToolTipText("Exibir as citações das Mídias Sociais");
                painelMidiasSociaisBotoes.getBotaoMidiasSociaisElogios().setToolTipText("Exibir os elogios das Mídias Sociais");
                painelMidiasSociaisBotoes.getBotaoMidiasSociaisCriticas().setToolTipText("Exibir as críticas das Mídias Sociais");
                painelMidiasSociaisBotoes.getBotaoMidiasSociaisBuscaPersonalizada().setToolTipText("Efetuar uma busca personalizada nas Mídias Sociais");

                painelConfiguracoesBotoes.getBotaoConfiguracoesAdicionarUsuario().setToolTipText("Adicionar um usuário ao sistema");
                painelConfiguracoesBotoes.getBotaoConfiguracoesAlterarUsuario().setToolTipText("Alterar os dados de um usuário");

                painelTruckSystemBotoes.getBotaoTruckSystemViagens().setToolTipText("Exibir as viagens do caminhão");
                painelTruckSystemBotoes.getBotaoTruckSystemPedidos().setToolTipText("Exibir os pedidos do caminhão");

                painelInicioBotoes.getBotaoInicioHoje().setToolTipText("Exibir dados atuais da empresa");
                painelInicioBotoes.getBotaoInicioOportunidades().setToolTipText("Exibir oportunidades atuais da empresa");
                painelInicioBotoes.getBotaoInicioAmeacas().setToolTipText("Exibir ameaças atuais da empresa");

            case "FINANCEIRO":
                painelMercadoBotoes.getBotaoMercadoHoje().setToolTipText("Exibir a situação atual do mercado");

                painelVendasBotoes.getBotaoVendasHoje().setToolTipText("Exibir a situação atual das vendas");
                painelVendasBotoes.getBotaoVendasOportunidades().setToolTipText("Exibir as possíveis oportunidades das vendas");
                painelVendasBotoes.getBotaoVendasAmeacas().setToolTipText("Exibir as possíveis ameaças das vendas");

            case "PRODUCAO":
                painelProdutosBotoes.getBotaoProdutosOportunidades().setToolTipText("Exibir as possíveis oportunidades dos produtos");
                painelProdutosBotoes.getBotaoProdutosAmeacas().setToolTipText("Exibir as possíveis ameaças dos produtos");

                break;

            case "SAC":
                painelSacBotoes.getBotaoSacAnaliseAtual().setToolTipText("Exibir análise atual do Sac");
                painelSacBotoes.getBotaoSacGrauSatisfacao().setToolTipText("Exibir o grau de satisfação do Sac");
                painelSacBotoes.getBotaoSacGerarAtendimento().setToolTipText("Gerar um novo atendimento");
                painelSacBotoes.getBotaoSacAlterarAtendimento().setToolTipText("Alterar um atendimento");

                break;
        }
    }

    private void BuildSplitPane(String usuario) {

        switch (usuario) {
            case "SAC":
                splitPaneSac.setTopComponent(painelSacBotoes);
                splitPaneSac.setBottomComponent(new SplitMasterPane(AbaSolicitante.SacAnaliseAtual));
                splitPaneSac.setEnabled(false);

                break;

            case "INFORMATICA":
            case "ADMIN":
                splitPaneInicio.setTopComponent(painelInicioBotoes);
                splitPaneInicio.setBottomComponent(new SplitMasterPane(AbaSolicitante.InicioHoje));
                splitPaneInicio.setEnabled(false);

                splitPaneClientes.setTopComponent(painelClienteBotoes);
                splitPaneClientes.setBottomComponent(new SplitMasterPane(AbaSolicitante.ClienteHoje));
                splitPaneClientes.setEnabled(false);

                splitPaneMidiasSociais.setTopComponent(painelMidiasSociaisBotoes);
                splitPaneMidiasSociais.setBottomComponent(painelMidiasSociaisCitacoes);
                splitPaneMidiasSociais.setEnabled(false);

                splitPaneConfiguracoes.setTopComponent(painelConfiguracoesBotoes);
                splitPaneConfiguracoes.setBottomComponent(painelConfiguracoesAdicionarUsuario);
                splitPaneConfiguracoes.setEnabled(false);

                splitPaneSac.setTopComponent(painelSacBotoes);
                splitPaneSac.setBottomComponent(new SplitMasterPane(AbaSolicitante.SacAnaliseAtual));
                splitPaneSac.setEnabled(false);

                splitPaneTruckSystem.setTopComponent(painelTruckSystemBotoes);
                splitPaneTruckSystem.setBottomComponent(painelPedidos);
                splitPaneTruckSystem.setEnabled(false);

            case "FINANCEIRO":
                splitPaneMercado.setTopComponent(painelMercadoBotoes);
                splitPaneMercado.setBottomComponent(new SplitMasterPane(AbaSolicitante.MercadoHoje));
                splitPaneMercado.setEnabled(false);

                splitPaneVendas.setTopComponent(painelVendasBotoes);
                splitPaneVendas.setBottomComponent(new SplitMasterPane(AbaSolicitante.VendasHoje));
                splitPaneVendas.setEnabled(false);

            case "PRODUCAO":
                splitPaneProdutos.setTopComponent(painelProdutosBotoes);
                splitPaneProdutos.setBottomComponent(new SplitMasterPane(AbaSolicitante.ProdutosOportunidades));
                splitPaneProdutos.setEnabled(false);

                break;

            case "LOGISTICA":
                splitPaneTruckSystem.setTopComponent(painelTruckSystemBotoes);
                splitPaneTruckSystem.setBottomComponent(painelPedidos);
                splitPaneTruckSystem.setEnabled(false);

                break;
        }
    }

    private void AddAba(String titulo, Component component) {
        abaTela.add(titulo, component);
        add(abaTela);
    }

    public class AcaoListener implements ActionListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            switch (departamento) {
                case "INFORMATICA":
                case "ADMIN":
                    if (event.getSource() == painelInicioBotoes.getBotaoInicioHoje()) {
                        splitPaneInicio.setBottomComponent(new SplitMasterPane(AbaSolicitante.InicioHoje));
                    } else if (event.getSource() == painelInicioBotoes.getBotaoInicioOportunidades()) {
                        splitPaneInicio.setBottomComponent(new SplitMasterPane(AbaSolicitante.InicioOportunidades));
                    } else if (event.getSource() == painelInicioBotoes.getBotaoInicioAmeacas()) {
                        splitPaneInicio.setBottomComponent(new SplitMasterPane(AbaSolicitante.InicioAmeacas));
                    } else if (event.getSource() == painelClienteBotoes.getBotaoClienteHoje()) {
                        splitPaneClientes.setBottomComponent(new SplitMasterPane(AbaSolicitante.ClienteHoje));
                    } else if (event.getSource() == painelClienteBotoes.getBotaoClientesLista()) {
                        painelClienteLista = new PainelClienteLista();
                        splitPaneClientes.setBottomComponent(painelClienteLista);
                    } else if (event.getSource() == painelClienteBotoes.getBotaoClientesAdicionar()) {
                        painelClienteAdicionar = new PainelClienteAdicionar();
                        splitPaneClientes.setBottomComponent(painelClienteAdicionar);
                    } else if (event.getSource() == painelClienteBotoes.getBotaoClientesAlterar()) {
                        painelClienteAlterar = new PainelClienteAlterar();
                        splitPaneClientes.setBottomComponent(painelClienteAlterar);
                    } else if (event.getSource() == painelSacBotoes.getBotaoSacAnaliseAtual()) {
                        splitPaneSac.setBottomComponent(new SplitMasterPane(AbaSolicitante.SacAnaliseAtual));
                    } else if (event.getSource() == painelSacBotoes.getBotaoSacGerarAtendimento()) {
                        painelSacGerarAtendimento = new PainelSacGerarAtendimento(usuario);
                        splitPaneSac.setBottomComponent(painelSacGerarAtendimento);
                    } else if (event.getSource() == painelSacBotoes.getBotaoSacAlterarAtendimento()) {
                        painelSacAlterarAtendimento = new PainelSacAlterarAtendimento();
                        splitPaneSac.setBottomComponent(painelSacAlterarAtendimento);
                    } else if (event.getSource() == painelSacBotoes.getBotaoSacGrauSatisfacao()) {
                        painelSacGrauSatisfacao = new PainelSacGrauSatisfacao();
                        splitPaneSac.setBottomComponent(painelSacGrauSatisfacao);
                    } else if (event.getSource() == painelSacBotoes.getBotaoSacAlterarAtendimento()) {
                        painelSacAlterarAtendimento = new PainelSacAlterarAtendimento();
                        splitPaneSac.setBottomComponent(painelSacAlterarAtendimento);
                    } else if (event.getSource() == painelMidiasSociaisBotoes.getBotaoMidiasSociaisCitacoes()) {
                        painelMidiasSociaisCitacoes = new PainelMidiasSociaisCitacoes();
                        splitPaneMidiasSociais.setBottomComponent(painelMidiasSociaisCitacoes);
                    } else if (event.getSource() == painelMidiasSociaisBotoes.getBotaoMidiasSociaisElogios()) {
                        painelMidiasSociaisElogios = new PainelMidiasSociaisElogios();
                        splitPaneMidiasSociais.setBottomComponent(painelMidiasSociaisElogios);
                    } else if (event.getSource() == painelMidiasSociaisBotoes.getBotaoMidiasSociaisCriticas()) {
                        painelMidiasSociaisCriticas = new PainelMidiasSociaisCriticas();
                        splitPaneMidiasSociais.setBottomComponent(painelMidiasSociaisCriticas);
                    } else if (event.getSource() == painelMidiasSociaisBotoes.getBotaoMidiasSociaisBuscaPersonalizada()) {
                        painelMidiasSociaisBuscaPersonalizada = new PainelMidiasSociaisBuscaPersonalizada();
                        splitPaneMidiasSociais.setBottomComponent(painelMidiasSociaisBuscaPersonalizada);
                    } else if (event.getSource() == painelConfiguracoesBotoes.getBotaoConfiguracoesAdicionarUsuario()) {
                        painelConfiguracoesAdicionarUsuario = new PainelConfiguracoesAdicionarUsuario();
                        splitPaneConfiguracoes.setBottomComponent(painelConfiguracoesAdicionarUsuario);
                    } else if (event.getSource() == painelConfiguracoesBotoes.getBotaoConfiguracoesAlterarUsuario()) {
                        painelConfiguracoesAlterarUsuario = new PainelConfiguracoesAlterarUsuario();
                        splitPaneConfiguracoes.setBottomComponent(painelConfiguracoesAlterarUsuario);
                    } else if (event.getSource() == painelTruckSystemBotoes.getBotaoTruckSystemPedidos()) {
                        painelPedidos = new PainelPedidos();
                        splitPaneTruckSystem.setBottomComponent(painelPedidos);
                    } else if (event.getSource() == painelTruckSystemBotoes.getBotaoTruckSystemViagens()) {
                        painelViagens = new PainelViagens();
                        splitPaneTruckSystem.setBottomComponent(painelViagens);
                    }

                case "FINANCEIRO":
                    if (event.getSource() == painelMercadoBotoes.getBotaoMercadoHoje()) {
                        splitPaneMercado.setBottomComponent(new SplitMasterPane(AbaSolicitante.MercadoHoje));
                    } else if (event.getSource() == painelVendasBotoes.getBotaoVendasHoje()) {
                        splitPaneVendas.setBottomComponent(new SplitMasterPane(AbaSolicitante.VendasHoje));
                    } else if (event.getSource() == painelVendasBotoes.getBotaoVendasOportunidades()) {
                        splitPaneVendas.setBottomComponent(new SplitMasterPane(AbaSolicitante.VendasOportunidades));
                    } else if (event.getSource() == painelVendasBotoes.getBotaoVendasAmeacas()) {
                        splitPaneVendas.setBottomComponent(new SplitMasterPane(AbaSolicitante.VendasAmeacas));
                    }

                case "PRODUCAO":
                    if (event.getSource() == painelProdutosBotoes.getBotaoProdutosOportunidades()) {
                        splitPaneProdutos.setBottomComponent(new SplitMasterPane(AbaSolicitante.ProdutosOportunidades));
                    } else if (event.getSource() == painelProdutosBotoes.getBotaoProdutosAmeacas()) {
                        splitPaneProdutos.setBottomComponent(new SplitMasterPane(AbaSolicitante.ProdutosAmeacas));
                    }

                    break;

                case "SAC":
                    if (event.getSource() == painelSacBotoes.getBotaoSacAnaliseAtual()) {
                        splitPaneSac.setBottomComponent(new SplitMasterPane(AbaSolicitante.SacAnaliseAtual));
                    } else if (event.getSource() == painelSacBotoes.getBotaoSacGrauSatisfacao()) {
                        painelSacGrauSatisfacao = new PainelSacGrauSatisfacao();
                        splitPaneSac.setBottomComponent(painelSacGrauSatisfacao);
                    }

                    break;

                case "LOGISTICA":
                    if (event.getSource() == painelTruckSystemBotoes.getBotaoTruckSystemPedidos()) {
                        painelPedidos = new PainelPedidos();
                        splitPaneTruckSystem.setBottomComponent(painelPedidos);
                    } else if (event.getSource() == painelTruckSystemBotoes.getBotaoTruckSystemViagens()) {
                        painelViagens = new PainelViagens();
                        splitPaneTruckSystem.setBottomComponent(painelViagens);
                    }

                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent keyEvent) {
            JOptionPane.showMessageDialog(null, "Typed: " + keyEvent.getKeyCode());
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            JOptionPane.showMessageDialog(null, "Pressed: " + keyEvent.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            JOptionPane.showMessageDialog(null, "Relesed: " + keyEvent.getKeyCode());
        }

    }
}
