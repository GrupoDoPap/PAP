package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaClientes;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoCliente;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class PainelClienteLista extends javax.swing.JPanel {

    private final DaoCliente daoCliente = new DaoCliente();
    private final DefaultTableModel defaultTableModel;
    private ArrayList<Cliente> arrayClientes = new ArrayList<>();

    /**
     * Creates new form PainelClienteLista
     */
    public PainelClienteLista() {
        initComponents();

        botaoHistoricoCompras.setVisible(false);

        defaultTableModel = (DefaultTableModel) tabelaListaClientes.getModel();

        preencherTabelaClientes();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaListaClientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPesquisaCPF_CNPJ = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelTelefoneEncontrado = new javax.swing.JLabel();
        labelEmailEncontrado = new javax.swing.JLabel();
        labelEnderecoEncontrado = new javax.swing.JLabel();
        labelBairroEncontrado = new javax.swing.JLabel();
        labelCPF_CNPJ_Encontrado = new javax.swing.JLabel();
        labelCelularEncontrado = new javax.swing.JLabel();
        labelBeltEncontrado = new javax.swing.JLabel();
        labelCepEncontrado = new javax.swing.JLabel();
        labelCidadeEncontrado = new javax.swing.JLabel();
        botaoHistoricoCompras = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        labelNomeEncontrado = new javax.swing.JLabel();

        jLabel1.setText("Visão Resumida");

        jScrollPane1.setMinimumSize(new java.awt.Dimension(23, 600));

        tabelaListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF / CNPJ", "Nome", "UF", "E-mail", "Telefone", "Belt"
            }
        ));
        tabelaListaClientes.setCellSelectionEnabled(true);
        tabelaListaClientes.setMaximumSize(new java.awt.Dimension(750, 100));
        jScrollPane1.setViewportView(tabelaListaClientes);

        jLabel3.setText("Visão Detalhada");

        jLabel4.setText("CPF/CNPJ:");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome:");

        jLabel6.setText("Telefone:");

        jLabel7.setText("E-mail:");

        jLabel8.setText("Endereço:");

        jLabel9.setText("Bairro:");

        jLabel10.setText("CPF/CNPJ:");

        jLabel11.setText("Celular:");

        jLabel12.setText("Belt");

        jLabel13.setText("CEP:");

        jLabel14.setText("Cidade:");

        botaoHistoricoCompras.setText("Histórico de compras");

        jLabel25.setText("_________________________________________________________________________________________________________________________________________________________________________________________________");
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(870, 870, 870)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1083, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtPesquisaCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNomeEncontrado)
                                    .addComponent(labelBairroEncontrado)
                                    .addComponent(labelEnderecoEncontrado)
                                    .addComponent(labelEmailEncontrado)
                                    .addComponent(labelTelefoneEncontrado))
                                .addGap(241, 241, 241)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCidadeEncontrado)
                                    .addComponent(labelCepEncontrado)
                                    .addComponent(labelBeltEncontrado)
                                    .addComponent(labelCelularEncontrado)
                                    .addComponent(labelCPF_CNPJ_Encontrado)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(botaoHistoricoCompras)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPesquisaCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(labelCPF_CNPJ_Encontrado)
                    .addComponent(labelNomeEncontrado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(labelTelefoneEncontrado)
                    .addComponent(labelCelularEncontrado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(labelEmailEncontrado)
                    .addComponent(labelBeltEncontrado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(labelEnderecoEncontrado)
                    .addComponent(labelCepEncontrado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(labelBairroEncontrado)
                    .addComponent(labelCidadeEncontrado))
                .addGap(26, 26, 26)
                .addComponent(botaoHistoricoCompras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void preencherTabelaClientes() {
        arrayClientes = daoCliente.listarClientes();

        for (Cliente c : arrayClientes) {
            defaultTableModel.addRow(
                    new Object[]{
                        c.getClassificacao(),
                        c.getCpf_cnpj(),
                        c.getNome(),
                        c.getUf(),
                        c.getEmail(),
                        c.getTelefone(),
                        c.getClassificacao()
                    }
            );
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Cliente clienteEncontrado = daoCliente.pesquisarClientePorCpfCnpj(txtPesquisaCPF_CNPJ.getText());

        labelNomeEncontrado.setText(clienteEncontrado.getNome());
        labelTelefoneEncontrado.setText(clienteEncontrado.getTelefone());
        labelEmailEncontrado.setText(clienteEncontrado.getEmail());
        labelEnderecoEncontrado.setText(clienteEncontrado.getRua());
        labelBairroEncontrado.setText(clienteEncontrado.getBairro());
        labelCPF_CNPJ_Encontrado.setText(clienteEncontrado.getCpf_cnpj());
        labelCelularEncontrado.setText(clienteEncontrado.getCelular());
        labelBeltEncontrado.setText(clienteEncontrado.getClassificacao());
        labelCepEncontrado.setText(clienteEncontrado.getCep());
        labelCidadeEncontrado.setText(clienteEncontrado.getCidade());

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoHistoricoCompras;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBairroEncontrado;
    private javax.swing.JLabel labelBeltEncontrado;
    private javax.swing.JLabel labelCPF_CNPJ_Encontrado;
    private javax.swing.JLabel labelCelularEncontrado;
    private javax.swing.JLabel labelCepEncontrado;
    private javax.swing.JLabel labelCidadeEncontrado;
    private javax.swing.JLabel labelEmailEncontrado;
    private javax.swing.JLabel labelEnderecoEncontrado;
    private javax.swing.JLabel labelNomeEncontrado;
    private javax.swing.JLabel labelTelefoneEncontrado;
    private javax.swing.JTable tabelaListaClientes;
    private javax.swing.JTextField txtPesquisaCPF_CNPJ;
    // End of variables declaration//GEN-END:variables
}
