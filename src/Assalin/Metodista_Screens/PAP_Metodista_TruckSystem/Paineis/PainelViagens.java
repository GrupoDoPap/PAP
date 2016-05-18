package Metodista_Screens.PAP_Metodista_TruckSystem.Paineis;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Funcionario;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Motorista;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Pedido;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Veiculo;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Viagem;
import Metodista_BusinessRules.PAP_Metodista_Enum.Ajuda;
import Metodista_BusinessRules.PAP_Metodista_Validation.ViagemValidation;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoFuncionario;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoPedido;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoVeiculo;
import Metodista_Screens.PAP_Metodista_Frames.TelaAjuda;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PainelViagens extends javax.swing.JPanel {

    private final AcaoListener acaoListener;
    private final DaoFuncionario daoFuncionario;
    private final DaoPedido daoPedido;
    private final DaoVeiculo daoVeiculo;
    private final GerenciadorCarga gerenciadorCarga;
    private final ViagemValidation vv = new ViagemValidation();
    private final ArrayList<Pedido> listaPedidos;
    private Motorista motorista;
    private Veiculo veiculo;
    private Pedido pedido;
    private final ArrayList<Funcionario> listaAjudantes;
    private Stack<Pedido> pilhaPedidos;
    private double capacidadeVeiculo, pesoTotal;
    private final DecimalFormat formato;

    public PainelViagens() {
        acaoListener = new AcaoListener();

        //instancia os objetos
        daoFuncionario = new DaoFuncionario();
        gerenciadorCarga = new GerenciadorCarga();
        daoPedido = new DaoPedido();
        daoVeiculo = new DaoVeiculo();
        listaAjudantes = new ArrayList<>();
        pilhaPedidos = new Stack<>();
        listaPedidos = new ArrayList<>();
        formato = new DecimalFormat("0.00");
        capacidadeVeiculo = 0.01;
        pesoTotal = 0.00;

        initComponents();

        txtCodigoPedido.addKeyListener(acaoListener);
        txtCodigoPedido.setToolTipText("Pressione F1 para listagem dos pedidos");

        //preeche os combobox's
        preencherAjudantes();
        preencherMotoristas();
        preencherVeiculos();
        analiseDePeso();

        btnOrganizarPedidos.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbMotorista = new javax.swing.JComboBox();
        cbbAjudante1 = new javax.swing.JComboBox();
        cbbAjudante2 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbbAjudante3 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        cbbDescricaoVeiculo = new javax.swing.JComboBox();
        lblModeloVeiculo = new javax.swing.JLabel();
        lblAlturaVeiculo = new javax.swing.JLabel();
        lblLarguraVeiculo = new javax.swing.JLabel();
        lblProfundidadeVeiculo = new javax.swing.JLabel();
        lblCapacidadeVeiculo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblTotalPedidosViagem = new javax.swing.JLabel();
        lblPesoViagem = new javax.swing.JLabel();
        btnGerarViagem = new javax.swing.JButton();
        btnOrganizarPedidos = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtCodigoPedido = new javax.swing.JTextField();
        btnInserirPedido = new javax.swing.JButton();
        btnExcluirPedido = new javax.swing.JButton();
        lblPlacaVeiculo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblEspacoVeiculo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel3.setText("Motorista:");

        jLabel4.setText("Ajudante 1:");

        jLabel5.setText("Ajudante 2:");

        cbbMotorista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));
        cbbMotorista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMotoristaItemStateChanged(evt);
            }
        });

        cbbAjudante1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));
        cbbAjudante1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAjudante1ItemStateChanged(evt);
            }
        });

        cbbAjudante2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));
        cbbAjudante2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAjudante2ItemStateChanged(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Índice", "Código", "Cliente", "Prazo de Entrega", "Ítens", "Peso Total"
            }
        ));
        jScrollPane2.setViewportView(tblPedidos);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("PEDIDOS");

        cbbAjudante3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));
        cbbAjudante3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAjudante3ItemStateChanged(evt);
            }
        });

        jLabel2.setText("Ajudante 3:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("FUNCIONÁRIOS");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("DADOS DO VEÍCULO");

        cbbDescricaoVeiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));
        cbbDescricaoVeiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDescricaoVeiculoItemStateChanged(evt);
            }
        });

        lblModeloVeiculo.setText("                    ");

        lblAlturaVeiculo.setText("                    ");

        lblLarguraVeiculo.setText("                    ");

        lblProfundidadeVeiculo.setText("                    ");

        lblCapacidadeVeiculo.setText("                    ");

        jLabel1.setText("Placa:");

        jLabel6.setText("Modelo:");

        jLabel8.setText("Altura:");

        jLabel10.setText("Largura:");

        jLabel11.setText("Profundidade:");

        jLabel12.setText("Capacidade:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("DETALHES DA VIAGEM");

        jLabel21.setText("Peso Total:");

        jLabel22.setText("Total de Pedidos:");

        lblTotalPedidosViagem.setText("                   ");

        lblPesoViagem.setText("                    ");

        btnGerarViagem.setText("Gerar Viagem");
        btnGerarViagem.setEnabled(false);
        btnGerarViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarViagemActionPerformed(evt);
            }
        });

        btnOrganizarPedidos.setText("Organizar Pedidos");
        btnOrganizarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrganizarPedidosActionPerformed(evt);
            }
        });

        jLabel26.setText("Código Pedido:");

        btnInserirPedido.setText("Inserir");
        btnInserirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirPedidoActionPerformed(evt);
            }
        });

        btnExcluirPedido.setText("Excluir");
        btnExcluirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPedidoActionPerformed(evt);
            }
        });

        lblPlacaVeiculo.setText("                    ");

        jLabel7.setText("Descrição:");

        jLabel9.setText("Espaço Disponível:");

        lblEspacoVeiculo.setText("                    ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbbMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(10, 10, 10)
                                                .addComponent(cbbAjudante1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(10, 10, 10)
                                                .addComponent(cbbAjudante2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(10, 10, 10)
                                                .addComponent(cbbAjudante3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel16)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblModeloVeiculo)
                                                    .addComponent(lblCapacidadeVeiculo)
                                                    .addComponent(lblPlacaVeiculo))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel10)
                                                            .addComponent(jLabel8))
                                                        .addGap(33, 33, 33)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lblLarguraVeiculo)
                                                            .addComponent(lblAlturaVeiculo)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel11)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblProfundidadeVeiculo))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbbDescricaoVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblEspacoVeiculo))))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnInserirPedido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnExcluirPedido))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel22)
                                                    .addComponent(jLabel21))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblPesoViagem)
                                                    .addComponent(lblTotalPedidosViagem))))
                                        .addGap(105, 105, 105)
                                        .addComponent(btnOrganizarPedidos)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGerarViagem)))))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(lblPesoViagem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(lblTotalPedidosViagem)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGerarViagem)
                            .addComponent(btnOrganizarPedidos))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(cbbMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(cbbAjudante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5))
                            .addComponent(cbbAjudante2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(cbbAjudante3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbDescricaoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8)
                                    .addComponent(lblAlturaVeiculo)
                                    .addComponent(lblPlacaVeiculo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(lblModeloVeiculo)
                                    .addComponent(jLabel10)
                                    .addComponent(lblLarguraVeiculo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(lblCapacidadeVeiculo)
                                    .addComponent(jLabel11)
                                    .addComponent(lblProfundidadeVeiculo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblEspacoVeiculo))))))
                .addGap(11, 13, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInserirPedido)
                    .addComponent(btnExcluirPedido))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.getAccessibleContext().setAccessibleName("Motorista: \\nhuadsuhfda");
    }// </editor-fold>//GEN-END:initComponents

    //preenche o combobox de motoristas
    private void preencherMotoristas() {
        ArrayList<Motorista> listaMotoristas = daoFuncionario.listarMotoristas();

        for (Motorista driver : listaMotoristas) {
            cbbMotorista.addItem(driver.getNome());
        }
    }

    //preenche os combobox de ajudantes
    private void preencherAjudantes() {
        ArrayList<Funcionario> listaFuncionarios = daoFuncionario.listarAjudantes();

        for (Funcionario ajudante : listaFuncionarios) {
            cbbAjudante1.addItem(ajudante.getNome());
            cbbAjudante2.addItem(ajudante.getNome());
            cbbAjudante3.addItem(ajudante.getNome());
        }
    }

    //preenche o combobox de veículos
    private void preencherVeiculos() {
        ArrayList<Veiculo> listaVeiculos = daoVeiculo.listarVeiculos();

        for (Veiculo car : listaVeiculos) {
            cbbDescricaoVeiculo.addItem(car.getDescricao());
        }
    }

    //analisa se o pedido é mais pesado do que o veículo suporta
    private void analiseDePeso() {
        double percentualPeso = (pesoTotal / capacidadeVeiculo) * 100;

        if (cbbDescricaoVeiculo.getSelectedItem().toString().equals("Selecionar")) {
            return;
        }
        if (percentualPeso <= 60) {
            //se o peso for menor que 60%, label fica preto e botao enabled
            lblPesoViagem.setForeground(Color.BLACK);
            btnOrganizarPedidos.setEnabled(true);
        } else if (percentualPeso > 60 && percentualPeso < 90) {
            //se o peso estiver entre 60% e 90%, label fica laranja e botao enabled
            lblPesoViagem.setForeground(Color.ORANGE);
            btnOrganizarPedidos.setEnabled(true);
        } else if (percentualPeso >= 90 && percentualPeso < 99) {
            //se o peso estiver entre 90% e 99%, label fica vermelho e botao enabled
            lblPesoViagem.setForeground(Color.RED);
            btnOrganizarPedidos.setEnabled(true);
        } else {
            //se o peso for maior que capacidade do caminhão, botao fica disabled e mostra mensagem de erro
            lblPesoViagem.setForeground(Color.RED);
            btnOrganizarPedidos.setEnabled(false);
            JOptionPane.showMessageDialog(this, "A capacidade máxima de carga foi ultrapassada.\n"
                    + " Selecione um veículo maior ou diminua a quantidade de pedidos.",
                    "Limite de peso excedido", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void analiseDeEspaço() {

        if (cbbDescricaoVeiculo.getSelectedItem().toString().equals("Selecionar")) {
            return;
        }

        boolean isFull = gerenciadorCarga.verificarEspacoDisponivel(listaPedidos, veiculo);

        if (isFull == true) {
            lblEspacoVeiculo.setText("OK");
        } else {
            lblEspacoVeiculo.setText("Não OK");
            JOptionPane.showMessageDialog(null, "Este veículo não comporta todas as caixas destes pedidos."
                    + "/nPor favor, remova algum pedido ou altere o veículo", "Espaço insuficiente", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //botao inserir pedido
    private void btnInserirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirPedidoActionPerformed

        try {
            DefaultTableModel model = (DefaultTableModel) tblPedidos.getModel();

            //pesquisa pedido
            pedido = daoPedido.get(Integer.parseInt(txtCodigoPedido.getText()));

            //add no array
            listaPedidos.add(pedido);

            //add no grid
            model.addRow(new Object[]{listaPedidos.size(), pedido.getCodigo(), pedido.getCliente().getNome(),
                pedido.getDataEntrega(), pedido.ListarCaixas().size(), pedido.getPesoPedido()});

            //atualiza total de ítens do pedido
            lblTotalPedidosViagem.setText(String.valueOf(model.getRowCount()));

            //atualiza peso total do pedido
            pesoTotal = pesoTotal + pedido.getPesoPedido();
            lblPesoViagem.setText(formato.format(pesoTotal) + " kg");

            analiseDePeso();
            analiseDeEspaço();

            //atualiza o indice
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(i + 1, i, 0);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Não foi possível localizar o pedido", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            txtCodigoPedido.setText("");
        }
    }//GEN-LAST:event_btnInserirPedidoActionPerformed

    //botao excluir pedido
    private void btnExcluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPedidoActionPerformed
        try {

            int indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o índice do produto a ser removido", "Excluir Pedido", JOptionPane.INFORMATION_MESSAGE));

            DefaultTableModel model = (DefaultTableModel) tblPedidos.getModel();

            //atualiza peso total do pedido
            pesoTotal = pesoTotal - Double.parseDouble(String.valueOf(model.getValueAt(indice - 1, 5)));
            lblPesoViagem.setText(formato.format(pesoTotal) + " kg");

            //remove do grid
            model.removeRow(indice - 1);

            //remove do array
            listaPedidos.remove(indice - 1);

            //atualiza total de ítens do pedido
            lblTotalPedidosViagem.setText(String.valueOf(model.getRowCount()));

            analiseDePeso();
            analiseDeEspaço();

            //atualiza o indice
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(i + 1, i, 0);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Não foi possível excluir o pedido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirPedidoActionPerformed

    //atualiza informações do veículo
    private void cbbDescricaoVeiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDescricaoVeiculoItemStateChanged
        try {
            veiculo = daoVeiculo.buscarVeiculoPorDescricao(String.valueOf(cbbDescricaoVeiculo.getSelectedItem()));
            capacidadeVeiculo = veiculo.getCapacidade();

            //preenche os labels
            lblPlacaVeiculo.setText(veiculo.getPlaca());
            lblModeloVeiculo.setText(veiculo.getModelo());
            lblCapacidadeVeiculo.setText(String.valueOf(veiculo.getCapacidade()) + " kg");
            lblAlturaVeiculo.setText(String.valueOf(veiculo.getAltura()) + " mt");
            lblLarguraVeiculo.setText(String.valueOf(veiculo.getLargura()) + " mt");
            lblProfundidadeVeiculo.setText(String.valueOf(veiculo.getProfundidade()) + " mt");
            analiseDePeso();
            analiseDeEspaço();
        } catch (Exception erro) {

            //limpa os labels
            capacidadeVeiculo = 0;
            lblPlacaVeiculo.setText("");
            lblModeloVeiculo.setText("");
            lblCapacidadeVeiculo.setText("");
            lblAlturaVeiculo.setText("");
            lblLarguraVeiculo.setText("");
            lblProfundidadeVeiculo.setText("");

            JOptionPane.showMessageDialog(this, "Selecione um carro", "Carro inválido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbbDescricaoVeiculoItemStateChanged

    //botao organizar pedidos
    private void btnOrganizarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrganizarPedidosActionPerformed
        pilhaPedidos = gerenciadorCarga.arrumarPedidos(listaPedidos);

        btnGerarViagem.setEnabled(true);

    }//GEN-LAST:event_btnOrganizarPedidosActionPerformed

    //botao gerar nova viagem
    private void btnGerarViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarViagemActionPerformed

        try {
            if ("Selecionar".equals(cbbMotorista.getSelectedItem())
                    || tblPedidos.getRowCount() == 0
                    || "Selecionar".equals(cbbDescricaoVeiculo.getSelectedItem())) {
                JOptionPane.showMessageDialog(this, "Há ítens não preenchidos no painel.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Viagem viagem = new Viagem(pesoTotal, "PENDENTE", veiculo, pilhaPedidos, listaAjudantes, motorista);

            int id = vv.insertViagem(viagem);

            JOptionPane.showMessageDialog(this, "Viagem " + id + " criada com sucesso!",
                    "Viagem criada", JOptionPane.PLAIN_MESSAGE);

            gerenciadorCarga.organizarCarga(viagem);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Não foi possível inserir a viagem",
                    "Erro", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnGerarViagemActionPerformed

    //informações do motorista
    private void cbbMotoristaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMotoristaItemStateChanged
        if (cbbMotorista.getSelectedItem().equals("Selecionar")) {
            motorista = null;
        } else {
            motorista = daoFuncionario.selecionarMotoristaPorNome(String.valueOf(cbbMotorista.getSelectedItem()));
        }
    }//GEN-LAST:event_cbbMotoristaItemStateChanged

    //informações do ajudante 1
    private void cbbAjudante1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAjudante1ItemStateChanged
        if (cbbAjudante1.getSelectedItem().equals("Selecionar")) {
            listaAjudantes.add(0, null);
        } else {
            listaAjudantes.add(0, daoFuncionario.selecionarUsuarioPorNome(String.valueOf(cbbAjudante1.getSelectedItem())));
        }
    }//GEN-LAST:event_cbbAjudante1ItemStateChanged

    //informações do ajudante 2
    private void cbbAjudante2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAjudante2ItemStateChanged
        if (cbbAjudante2.getSelectedItem().equals("Selecionar")) {
            listaAjudantes.add(1, null);
        } else {
            listaAjudantes.add(1, daoFuncionario.selecionarUsuarioPorNome(String.valueOf(cbbAjudante2.getSelectedItem())));
        }
    }//GEN-LAST:event_cbbAjudante2ItemStateChanged

    //informações do ajudante 3
    private void cbbAjudante3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAjudante3ItemStateChanged
        if (cbbAjudante3.getSelectedItem().equals("Selecionar")) {
            listaAjudantes.add(2, null);
        } else {
            listaAjudantes.add(2, daoFuncionario.selecionarUsuarioPorNome(String.valueOf(cbbAjudante3.getSelectedItem())));
        }
    }//GEN-LAST:event_cbbAjudante3ItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluirPedido;
    private javax.swing.JButton btnGerarViagem;
    private javax.swing.JButton btnInserirPedido;
    private javax.swing.JButton btnOrganizarPedidos;
    private javax.swing.JComboBox cbbAjudante1;
    private javax.swing.JComboBox cbbAjudante2;
    private javax.swing.JComboBox cbbAjudante3;
    private javax.swing.JComboBox cbbDescricaoVeiculo;
    private javax.swing.JComboBox cbbMotorista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAlturaVeiculo;
    private javax.swing.JLabel lblCapacidadeVeiculo;
    private javax.swing.JLabel lblEspacoVeiculo;
    private javax.swing.JLabel lblLarguraVeiculo;
    private javax.swing.JLabel lblModeloVeiculo;
    private javax.swing.JLabel lblPesoViagem;
    private javax.swing.JLabel lblPlacaVeiculo;
    private javax.swing.JLabel lblProfundidadeVeiculo;
    private javax.swing.JLabel lblTotalPedidosViagem;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtCodigoPedido;
    // End of variables declaration//GEN-END:variables

    public class AcaoListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == event.VK_F1 && event.getSource() == txtCodigoPedido) {
                TelaAjuda tela = new TelaAjuda(Ajuda.Viagens_Codigo_Pedido);
            }
        }

        //DEMAIS MÉTODOS NÃO UTILIZADOS...
        @Override
        public void keyTyped(KeyEvent event) {

        }

        @Override
        public void keyReleased(KeyEvent event) {

        }

    }

}
