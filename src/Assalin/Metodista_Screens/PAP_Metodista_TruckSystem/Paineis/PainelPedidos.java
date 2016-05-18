package Metodista_Screens.PAP_Metodista_TruckSystem.Paineis;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Caixa;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Pedido;
import Metodista_BusinessRules.PAP_Metodista_Enum.Ajuda;
import Metodista_BusinessRules.PAP_Metodista_Validation.PedidoValidation;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoCaixa;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoCliente;
import Metodista_Screens.PAP_Metodista_Frames.TelaAjuda;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PainelPedidos extends javax.swing.JPanel {

    private final AcaoListener acaoListener;
    private final DaoCaixa daoCaixa = new DaoCaixa();
    private final DaoCliente daoCliente = new DaoCliente();
    private final PedidoValidation pv = new PedidoValidation();
    private Pedido pedido = null;
    private int totalCaixas = 0;
    private double pesoTotal = 0;
    private final DecimalFormat formato = new DecimalFormat("0.00");

    public PainelPedidos() {
        initComponents();

        acaoListener = new AcaoListener();

        txtCodigoCliente.addKeyListener(acaoListener);
        txtCodigoCliente.setToolTipText("Pressione F1 para listagem dos clientes");

        carregarCbbCaixas(daoCaixa.list());//carrega o grid de caixas
        lblTotalCaixas.setText(String.valueOf(totalCaixas));
        lblPesoTotal.setText(String.valueOf(pesoTotal) + " kg");
    }

    private void carregarCbbCaixas(ArrayList<Caixa> listaCaixas) {
        //carrega o JComboBox com as informações das caixas
        for (Caixa box : listaCaixas) {
            cbbCaixas.addItem(box.getNome());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        btnPEsquisarCliente = new javax.swing.JButton();
        lblTelefoneCliente = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        lblCepCliente = new javax.swing.JLabel();
        lblBairroCliente = new javax.swing.JLabel();
        lblCidadeCliente = new javax.swing.JLabel();
        lblUfCliente = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbbCaixas = new javax.swing.JComboBox();
        btnInserirCaixa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCaixas = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        btnGerarPedido = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ftxtPrazoEntrega = new javax.swing.JFormattedTextField();
        lblTotalCaixas = new javax.swing.JLabel();
        lblPesoTotal = new javax.swing.JLabel();
        btnExcluirCaixa = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblRuaCliente = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCodigoCliente = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDistanciaFilial = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblEmailCliente = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblCpfCnpjCliente = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblClassificacaoCliente = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblCelularCliente = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CLIENTE");

        jLabel2.setText("Código:");

        jLabel3.setText("Nome:");
        jLabel3.setMinimumSize(null);

        jLabel4.setText("Telefone:");
        jLabel4.setMinimumSize(null);

        jLabel5.setText("CEP:");
        jLabel5.setMinimumSize(null);

        jLabel6.setText("Bairro:");
        jLabel6.setMinimumSize(null);

        jLabel7.setText("Cidade:");
        jLabel7.setMinimumSize(null);

        jLabel8.setText("UF:");
        jLabel8.setMinimumSize(null);

        txtCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoClienteActionPerformed(evt);
            }
        });

        btnPEsquisarCliente.setText("Pesquisar");
        btnPEsquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPEsquisarClienteActionPerformed(evt);
            }
        });

        lblTelefoneCliente.setText("                    ");

        lblNomeCliente.setText("                    ");

        lblCepCliente.setText("                    ");

        lblBairroCliente.setText("                    ");

        lblCidadeCliente.setText("                    ");

        lblUfCliente.setText("                    ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("CAIXAS");

        jLabel15.setText("Tipo:");

        cbbCaixas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));

        btnInserirCaixa.setText("Inserir");
        btnInserirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirCaixaActionPerformed(evt);
            }
        });

        tblCaixas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Descrição", "Peso", "Altura", "Largura", "Profundidade"
            }
        ));
        jScrollPane1.setViewportView(tblCaixas);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("DETALHES DO PEDIDO");

        btnGerarPedido.setText("Gerar Pedido");
        btnGerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarPedidoActionPerformed(evt);
            }
        });

        jLabel17.setText("Prazo de Entrega:");

        jLabel18.setText("Total de Caixas:");

        jLabel19.setText("Peso Total:");

        try {
            ftxtPrazoEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblTotalCaixas.setText("                     ");

        lblPesoTotal.setText("                    ");

        btnExcluirCaixa.setText("Excuir");
        btnExcluirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCaixaActionPerformed(evt);
            }
        });

        jLabel9.setText("Rua:");

        lblRuaCliente.setText("                    ");

        jLabel10.setText("Código:");

        lblCodigoCliente.setText("                    ");

        jLabel11.setText("Distância da Filial:");

        lblDistanciaFilial.setText("                    ");

        jLabel12.setText("E-mail:");

        lblEmailCliente.setText("                    ");

        jLabel21.setText("CPF / CNPJ:");

        lblCpfCnpjCliente.setText("                     ");

        jLabel23.setText("Classificação:");

        lblClassificacaoCliente.setText("                    ");

        jLabel13.setText("Celular:");

        lblCelularCliente.setText("                    ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGerarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(27, 27, 27)
                                .addComponent(lblTotalCaixas)
                                .addGap(18, 253, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ftxtPrazoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblPesoTotal)))))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnInserirCaixa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluirCaixa)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPEsquisarCliente)
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCpfCnpjCliente)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(lblClassificacaoCliente))
                                                    .addComponent(lblCodigoCliente)
                                                    .addComponent(lblEmailCliente))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCepCliente)
                                                    .addComponent(lblTelefoneCliente)
                                                    .addComponent(lblDistanciaFilial)
                                                    .addComponent(lblCelularCliente))
                                                .addGap(53, 53, 53)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblUfCliente)
                                                    .addComponent(lblRuaCliente)
                                                    .addComponent(lblCidadeCliente)
                                                    .addComponent(lblBairroCliente)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblNomeCliente)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(38, 38, 38))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtPrazoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblTotalCaixas)
                    .addComponent(jLabel19)
                    .addComponent(lblPesoTotal))
                .addGap(18, 18, 18)
                .addComponent(btnGerarPedido)
                .addGap(9, 9, 9)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnPEsquisarCliente)
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCliente))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(lblRuaCliente)
                            .addComponent(lblCodigoCliente)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCepCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(lblCpfCnpjCliente))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(lblEmailCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUfCliente)
                                    .addComponent(jLabel23)
                                    .addComponent(lblClassificacaoCliente)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBairroCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCidadeCliente))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cbbCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInserirCaixa)
                            .addComponent(btnExcluirCaixa)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblCelularCliente))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblDistanciaFilial))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //botao inserir caixa
    private void btnInserirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirCaixaActionPerformed
        try {
            DefaultTableModel gridCaixas = (DefaultTableModel) tblCaixas.getModel();

            //pesquisa dados da caixa selecionada
            Caixa caixa = daoCaixa.pesquisarCaixaPorNome(cbbCaixas.getSelectedItem().toString());
            tblCaixas.setEnabled(false);

            //populando tabela de caixas
            gridCaixas.addRow(new Object[]{caixa.getCod(), caixa.getNome(),
                caixa.getDescricao(), caixa.getPeso(), caixa.getAltura(),
                caixa.getLargura(), caixa.getProfundidade()});

            //atualiza o total de caixas do pedido
            totalCaixas = gridCaixas.getRowCount();
            lblTotalCaixas.setText(String.valueOf(totalCaixas));

            //atualiza o peso total de caixas do pedido
            pesoTotal = pesoTotal + caixa.getPeso();
            lblPesoTotal.setText(formato.format(pesoTotal) + " kg");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Selecione um ítem para adicionar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirCaixaActionPerformed

    //botão pesquisar cliente
    private void btnPEsquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPEsquisarClienteActionPerformed
        Cliente cliente;

        try {
            cliente = daoCliente.pesquisarClientePorCodigo(Integer.parseInt(txtCodigoCliente.getText()));

            //populando os labels com as informações do cliente
            lblEmailCliente.setText(cliente.getEmail());
            lblCpfCnpjCliente.setText(cliente.getCpf_cnpj());
            lblCepCliente.setText(cliente.getCep());
            lblRuaCliente.setText(cliente.getRua());
            lblBairroCliente.setText(cliente.getBairro());
            lblCidadeCliente.setText(cliente.getCidade());
            lblUfCliente.setText(cliente.getUf());
            lblClassificacaoCliente.setText(cliente.getClassificacao());
            lblDistanciaFilial.setText(String.valueOf(cliente.getDistanciaFilial()) + " km");
            lblCodigoCliente.setText(String.valueOf(cliente.getCodigo()));
            lblNomeCliente.setText(cliente.getNome());
            lblTelefoneCliente.setText(cliente.getTelefone());
            lblCelularCliente.setText(cliente.getCelular());

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);

            //limpa os labels
            lblEmailCliente.setText("");
            lblCpfCnpjCliente.setText("");
            lblCepCliente.setText("");
            lblRuaCliente.setText("");
            lblBairroCliente.setText("");
            lblCidadeCliente.setText("");
            lblUfCliente.setText("");
            lblClassificacaoCliente.setText("");
            lblDistanciaFilial.setText("");
            lblCodigoCliente.setText("");
            lblNomeCliente.setText("");
            lblTelefoneCliente.setText("");
            lblCelularCliente.setText("");
        }
    }//GEN-LAST:event_btnPEsquisarClienteActionPerformed

    //botao gerar pedido
    private void btnGerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarPedidoActionPerformed

        //verifica se todos os dados foram inseridos
        if (ftxtPrazoEntrega.getText().equals("")
                || lblCodigoCliente.getText().equals("") || tblCaixas.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Existem dados em branco no pedido", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Caso tudo tenha sido preenchido
        try {
            Vector<Caixa> vetorCaixas;
            ArrayList<Caixa> arrayCaixas = new ArrayList<>();
            DefaultTableModel gridCaixas = (DefaultTableModel) tblCaixas.getModel();
            vetorCaixas = gridCaixas.getDataVector();

            //cria um novo cliente
            Cliente cliente = daoCliente.pesquisarClientePorCodigo(Integer.parseInt(lblCodigoCliente.getText()));

            //cria um array de caixas
            for (int i = 0; i < vetorCaixas.size(); i++) {
                Caixa box = daoCaixa.pesquisarCaixaPorNome(String.valueOf(gridCaixas.getValueAt(i, 1)));

                //add no array
                arrayCaixas.add(box);
            }

            //cria um novo pedido
            pedido = new Pedido(pesoTotal, ftxtPrazoEntrega.getText(), arrayCaixas, cliente);

            //armazena o novo pedido no banco
            int numPed = pv.insertPedido(pedido);

            JOptionPane.showMessageDialog(this, "Pedido " + numPed
                    + " gerado com sucesso!", "Pedido gerado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao criar o pedido", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(erro);
        }
    }//GEN-LAST:event_btnGerarPedidoActionPerformed

    //botao excluir caixa -- excluir sempre a ultima caixa da lista
    private void btnExcluirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCaixaActionPerformed
        try {
            DefaultTableModel gridCaixas = (DefaultTableModel) tblCaixas.getModel();

            //atualiza o peso total
            pesoTotal = pesoTotal - Double.parseDouble(String.valueOf(gridCaixas.getValueAt(gridCaixas.getRowCount() - 1, 3)));
            lblPesoTotal.setText(formato.format(pesoTotal) + " kg");

            //remove a caixa da lista
            gridCaixas.removeRow(gridCaixas.getRowCount() - 1);

            //atualiza total de caixas
            totalCaixas = gridCaixas.getRowCount();
            lblTotalCaixas.setText(String.valueOf(totalCaixas));

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Nenhuma caixa para excluir", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnExcluirCaixaActionPerformed

    private void txtCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoClienteActionPerformed

    }//GEN-LAST:event_txtCodigoClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluirCaixa;
    private javax.swing.JButton btnGerarPedido;
    private javax.swing.JButton btnInserirCaixa;
    private javax.swing.JButton btnPEsquisarCliente;
    private javax.swing.JComboBox cbbCaixas;
    private javax.swing.JFormattedTextField ftxtPrazoEntrega;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBairroCliente;
    private javax.swing.JLabel lblCelularCliente;
    private javax.swing.JLabel lblCepCliente;
    private javax.swing.JLabel lblCidadeCliente;
    private javax.swing.JLabel lblClassificacaoCliente;
    private javax.swing.JLabel lblCodigoCliente;
    private javax.swing.JLabel lblCpfCnpjCliente;
    private javax.swing.JLabel lblDistanciaFilial;
    private javax.swing.JLabel lblEmailCliente;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblPesoTotal;
    private javax.swing.JLabel lblRuaCliente;
    private javax.swing.JLabel lblTelefoneCliente;
    private javax.swing.JLabel lblTotalCaixas;
    private javax.swing.JLabel lblUfCliente;
    private javax.swing.JTable tblCaixas;
    private javax.swing.JTextField txtCodigoCliente;
    // End of variables declaration//GEN-END:variables

    public class AcaoListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == event.VK_F1 && event.getSource() == txtCodigoCliente) {
                TelaAjuda tela = new TelaAjuda(Ajuda.Pedidos_Codigo_Cliente);
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
