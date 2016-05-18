package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaSAC;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Atendimento;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoAtendimento;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoCliente;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class PainelSacAlterarAtendimento extends javax.swing.JPanel {

    private final DaoAtendimento daoAtendimento = new DaoAtendimento();
    private final DaoCliente daoCliente = new DaoCliente();
    private Atendimento a;
    private Cliente c;

    /**
     * Creates new form PainelSacAlterarAtendimento
     */
    public PainelSacAlterarAtendimento() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCPF_CNPJ = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        comboStatus = new javax.swing.JComboBox();
        botaoPesquisar = new javax.swing.JButton();
        labelNome = new javax.swing.JLabel();
        botaoPesquisarCliente = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alterar Atendimento");

        jLabel2.setText("Código:");

        jLabel6.setText("Status:");

        jLabel5.setText("Motivo:");

        txtMotivo.setColumns(20);
        txtMotivo.setRows(5);
        jScrollPane1.setViewportView(txtMotivo);

        jLabel7.setText("Descrição:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        jLabel8.setText("Nome do Cliente:");

        jLabel9.setText("CPF/CNPJ do Cliente:");

        botaoSalvar.setText("Salvar Atendimento");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Visualizado", "Urgente", "Visualizado", "Concluído" }));

        botaoPesquisar.setText("Pesquisar Atendimento");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        botaoPesquisarCliente.setText("Pesquisar Cliente");
        botaoPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCPF_CNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                            .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(53, 53, 53)
                                        .addComponent(botaoPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar))
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarCliente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(labelNome))
                .addGap(48, 48, 48)
                .addComponent(botaoSalvar)
                .addGap(170, 170, 170))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        a.setDescricao(txtDescricao.getText());
        a.setMotivo(txtMotivo.getText());
        a.setStatus((String) comboStatus.getSelectedItem());
        a.setCliente(c);

        if (comboStatus.getSelectedItem() == "Concluido") {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();

            a.setDataFim(dateFormat.format(date));
        }

        daoAtendimento.update(a);
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        if (!txtCodigo.getText().equals("")) {
            a = daoAtendimento.get(Integer.parseInt(txtCodigo.getText()));

            txtDescricao.setText(a.getDescricao());
            txtMotivo.setText(a.getMotivo());
            comboStatus.setSelectedItem(a.getStatus());

            labelNome.setText(a.getCliente().getNome());
            txtCPF_CNPJ.setText(a.getCliente().getCpf_cnpj());
        } else {
            JOptionPane.showMessageDialog(null, "Favor preencher o campo código para realização da pesquisa", "Campo Vazio", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void botaoPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarClienteActionPerformed
        if (!txtCPF_CNPJ.getText().equals("")) {
            c = daoCliente.pesquisarClientePorCpfCnpj(txtCPF_CNPJ.getText());

            labelNome.setText(c.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Favor preencher o campo CPF/CNPJ para realização da pesquisa", "Campo Vazio", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botaoPesquisarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoPesquisarCliente;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTextField txtCPF_CNPJ;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables
}
