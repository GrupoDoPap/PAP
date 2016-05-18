package Metodista_Screens.PAP_Metodista_SuperClasses;

import Metodista_BusinessRules.PAP_Metodista_Enum.Aba;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MasterButtons extends JPanel {

    protected JPanel painelMasterButtons;

    protected JButton botoesInicio[];
    protected JButton botoesClientes[];
    protected JButton botoesMercado[];
    protected JButton botoesVendas[];
    protected JButton botoesProdutos[];
    protected JButton botoesMidiasSociais[];
    protected JButton botoesSac[];
    protected JButton botoesComunicacao[];
    protected JButton botoesConfiguracoes[];
    protected JButton botoesMais[];

    public MasterButtons() {

    }

    public MasterButtons(Aba aba) {
        try {
            BuildComponentes(aba);
            add(BuildPainel(aba));
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(painelMasterButtons, "So close :(");
            exception.printStackTrace();
        }
        setVisible(true);
    }

    public final void BuildComponentes(Aba aba) {

        switch (aba) {
            case Inicio:
                botoesInicio = new JButton[3];

                botoesInicio[0] = new JButton("Hoje");
                botoesInicio[1] = new JButton("Oportunidades");
                botoesInicio[2] = new JButton("Ameaças");
                break;

            case Clientes:
                botoesClientes = new JButton[4];

                botoesClientes[0] = new JButton("Hoje");
                botoesClientes[1] = new JButton("Lista de Clientes");
                botoesClientes[2] = new JButton("Adicionar Cliente");
                botoesClientes[3] = new JButton("Alterar Cliente");
                break;

            case Mercado:
                botoesMercado = new JButton[1];

                botoesMercado[0] = new JButton("Hoje");
                break;

            case Vendas:
                botoesVendas = new JButton[3];

                botoesVendas[0] = new JButton("Hoje");
                botoesVendas[1] = new JButton("Oportunidades");
                botoesVendas[2] = new JButton("Ameaças");
                break;

            case Produtos:
                botoesProdutos = new JButton[2];

                botoesProdutos[0] = new JButton("Oportunidades");
                botoesProdutos[1] = new JButton("Ameaças");
                break;

            case MidiasSociais:
                botoesMidiasSociais = new JButton[4];

                botoesMidiasSociais[0] = new JButton("Citações");
                botoesMidiasSociais[1] = new JButton("Elogios");
                botoesMidiasSociais[2] = new JButton("Críticas");
                botoesMidiasSociais[3] = new JButton("Busca Personalizada");
                break;

            case Sac:
                botoesSac = new JButton[4];

                botoesSac[0] = new JButton("Análise Atual");
                botoesSac[1] = new JButton("Gerar Novo Atendimento");
                botoesSac[2] = new JButton("Alterar Atendimento");
                botoesSac[3] = new JButton("Grau de Satisfação");
                break;

            case Comunicacao:
                botoesComunicacao = new JButton[3];

                botoesComunicacao[0] = new JButton("Emails Recabidos");
                botoesComunicacao[1] = new JButton("Novo Email");
                botoesComunicacao[2] = new JButton("Emails Enviados");
                break;

            case Configuracoes:
                botoesConfiguracoes = new JButton[2];

                botoesConfiguracoes[0] = new JButton("Adicionar Usuário");
                botoesConfiguracoes[1] = new JButton("Alterar Usuário");
                break;

            case Mais:
                botoesMais = new JButton[2];
                botoesMais[0] = new JButton("Pedidos");
                botoesMais[1] = new JButton("Viagens");
                break;
        }

        AddDescricao(aba);
    }

    private void AddDescricao(Aba aba) {
        switch (aba) {
            case Inicio:
                botoesInicio[0].setToolTipText("Exibir dados atuais da empresa");
                botoesInicio[1].setToolTipText("Exibir oportunidades atuais da empresa");
                botoesInicio[2].setToolTipText("Exibir ameaças atuais da empresa");
                break;

            case Clientes:
                botoesClientes[0].setToolTipText("Exibir a situação atual sobre seus clientes");
                botoesClientes[1].setToolTipText("Exibir a lista dos clientes");
                botoesClientes[2].setToolTipText("Adicionar um novo cliente");
                botoesClientes[3].setToolTipText("Alterar algum cliente");
                break;

            case Mercado:
                botoesMercado[0].setToolTipText("Exibir a situação atual do mercado");
                break;

            case Vendas:
                botoesVendas[0].setToolTipText("Exibir a situação atual das vendas");
                botoesVendas[1].setToolTipText("Exibir as possíveis oportunidades das vendas");
                botoesVendas[2].setToolTipText("Exibir as possíveis ameaças das vendas");
                break;

            case Produtos:
                botoesProdutos[0].setToolTipText("Exibir as possíveis oportunidades dos produtos");
                botoesProdutos[1].setToolTipText("Exibir as possíveis ameaças dos produtos");
                break;

            case MidiasSociais:
                botoesMidiasSociais[0].setToolTipText("Exibir as citações das Mídias Sociais");
                botoesMidiasSociais[1].setToolTipText("Exibir os elogios das Mídias Sociais");
                botoesMidiasSociais[2].setToolTipText("Exibir as críticas das Mídias Sociais");
                botoesMidiasSociais[3].setToolTipText("Efetuar uma busca personalizada nas Mídias Sociais");
                break;

            case Sac:
                botoesSac[0].setToolTipText("Exibir análise atual do Sac");
                botoesSac[1].setToolTipText("Gerar um novo atendimento");
                botoesSac[2].setToolTipText("Alterar um atendimento");
                botoesSac[3].setToolTipText("Exibir o grau de satisfação do Sac");
                break;

            case Comunicacao:
                botoesComunicacao[0].setToolTipText("Abrir caixa de entrada de email");
                botoesComunicacao[1].setToolTipText("Criar um novo email");
                botoesComunicacao[2].setToolTipText("Abrir caixa de envio de email");
                break;

            case Configuracoes:
                botoesConfiguracoes[0].setToolTipText("Adicionar um usuário ao sistema");
                botoesConfiguracoes[1].setToolTipText("Alterar os dados de um usuário");
                break;

            case Mais:
                botoesMais[0].setToolTipText("Exibir os pedidos do caminhão");
                botoesMais[1].setToolTipText("Exibir as viagens do caminhão");
                break;
        }
    }

    public final JPanel BuildPainel(Aba aba) {
        painelMasterButtons = new JPanel(new GridLayout(1, 3, 5, 0));

        switch (aba) {
            case Inicio:
                for (JButton botao : botoesInicio) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;

            case Clientes:
                for (JButton botao : botoesClientes) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;

            case Mercado:
                for (JButton botao : botoesMercado) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;

            case Vendas:
                for (JButton botao : botoesVendas) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;

            case Produtos:
                for (JButton botao : botoesProdutos) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;

            case MidiasSociais:
                for (JButton botao : botoesMidiasSociais) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;

            case Sac:
                for (JButton botao : botoesSac) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;

            case Comunicacao:
                for (JButton botao : botoesComunicacao) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;

            case Configuracoes:
                for (JButton botao : botoesConfiguracoes) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;

            case Mais:
                for (JButton botao : botoesMais) {
                    painelMasterButtons.add(botao);
                }
                return painelMasterButtons;
        }

        return painelMasterButtons;
    }
}
