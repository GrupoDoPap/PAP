package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaSAC;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Atendimento;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Usuario;
import Metodista_BusinessRules.PAP_Metodista_Enum.Ajuda;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoAtendimento;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoCliente;
import Metodista_Screens.PAP_Metodista_Frames.TelaAjuda;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class PainelSacGerarAtendimento extends javax.swing.JPanel {

    private Usuario usuario;

    private final DaoAtendimento daoAtendimento = new DaoAtendimento();

    private Cliente c;
    private final DateFormat dateFormat;
    private final Date date;

    public PainelSacGerarAtendimento(Usuario usuario) {
        initComponents();

        this.usuario = usuario;

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = new Date();

        labelDataInicio.setText(dateFormat.format(date));

        labelCodigoAtendimento.setText("" + (daoAtendimento.ultimoID() + 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCPF_CNPJ = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        botaoPesquisarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        labelCodigoAtendimento = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelDataInicio = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        comboSatisfacao = new javax.swing.JComboBox();

        jLabel9.setText("CPF/CNPJ do Cliente:");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Novo Atendimento");

        txtCPF_CNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCPF_CNPJKeyPressed(evt);
            }
        });

        jLabel2.setText("Código:");

        botaoSalvar.setText("Salvar Atendimento");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        jLabel6.setText("Status:");

        jLabel5.setText("Motivo:");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Visualizado", "Urgente", "Visualizado", "Concluído" }));

        txtMotivo.setColumns(20);
        txtMotivo.setRows(5);
        jScrollPane1.setViewportView(txtMotivo);

        jLabel7.setText("Descrição:");

        botaoPesquisarCliente.setText("Pesquisar Cliente");
        botaoPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarClienteActionPerformed(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        jLabel8.setText("Nome do Cliente:");

        labelCodigoAtendimento.setText("jLabel3");

        jLabel3.setText("Data Início:");

        labelDataInicio.setText("jLabel4");

        comboSatisfacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Insatisfeito", "Pouco Satisfeito", "Satisfeito", "Muito Satisfeito", "Satisfeitíssimo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCodigoAtendimento)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDataInicio)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCPF_CNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                            .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboSatisfacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(botaoPesquisarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(568, 568, 568))
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigoAtendimento)
                    .addComponent(jLabel3)
                    .addComponent(labelDataInicio)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarCliente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(labelNome)
                    .addComponent(comboSatisfacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(botaoSalvar)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        DaoCliente daoCliente = new DaoCliente();

        c = daoCliente.pesquisarClientePorCpfCnpj(txtCPF_CNPJ.getText());

        boolean isOk = daoAtendimento.registrarAtendimento(
                new Atendimento(
                        Integer.parseInt(labelCodigoAtendimento.getText()),
                        labelDataInicio.getText(),
                        null,
                        (String) comboSatisfacao.getSelectedItem(),
                        (String) comboStatus.getSelectedItem(),
                        txtMotivo.getText(),
                        txtDescricao.getText(),
                        c,
                        null),
                usuario);

        if (isOk == true) {
            JOptionPane.showMessageDialog(null, "Atendimento registrado com sucesso!");

            labelDataInicio.setText(dateFormat.format(date));
            labelCodigoAtendimento.setText("" + (daoAtendimento.ultimoID() + 1));
            comboStatus.setSelectedIndex(0);
            txtMotivo.setText("");
            txtDescricao.setText("");
            txtCPF_CNPJ.setText("");
            comboSatisfacao.setSelectedIndex(0);
            labelNome.setText("");
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarClienteActionPerformed
        DaoCliente daoCliente = new DaoCliente();
        c = daoCliente.pesquisarClientePorCpfCnpj(txtCPF_CNPJ.getText());

        labelNome.setText(c.getNome());
    }//GEN-LAST:event_botaoPesquisarClienteActionPerformed

    private void txtCPF_CNPJKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPF_CNPJKeyPressed
        if (evt.getKeyCode() == evt.VK_F1 && evt.getSource() == txtCPF_CNPJ) {
            TelaAjuda tela = new TelaAjuda(Ajuda.Cliente_Cnpj_CPF);
        }
    }//GEN-LAST:event_txtCPF_CNPJKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoPesquisarCliente;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JComboBox comboSatisfacao;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCodigoAtendimento;
    private javax.swing.JLabel labelDataInicio;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTextField txtCPF_CNPJ;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables
}
