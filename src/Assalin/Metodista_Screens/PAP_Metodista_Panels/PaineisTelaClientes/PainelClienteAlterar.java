package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaClientes;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import Metodista_BusinessRules.PAP_Metodista_Enum.Ajuda;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoCliente;
import Metodista_Screens.PAP_Metodista_Frames.TelaAjuda;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class PainelClienteAlterar extends javax.swing.JPanel {

    private AcaoListener acaoListener;

    private DaoCliente daoCliente;

    /**
     * Creates new form PainelClienteAlterar
     */
    public PainelClienteAlterar() {
        initComponents();

        acaoListener = new AcaoListener();

        daoCliente = new DaoCliente();

        txtBuscaCPF_CNPJ.addKeyListener(acaoListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscaCPF_CNPJ = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_CPF_CNPF_Encontrado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboBelt = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNomeEncontrado = new javax.swing.JTextField();
        txtEnderecoEncontrado = new javax.swing.JTextField();
        txtBairroEncontrado = new javax.swing.JTextField();
        txtEmailEncontrado = new javax.swing.JTextField();
        txtCidadeEncontrado = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUFEncontrado = new javax.swing.JComboBox();
        txtCepEncontrado = new javax.swing.JFormattedTextField();
        txtTelefoneEncontrado = new javax.swing.JFormattedTextField();
        txtCelularEncontrado = new javax.swing.JFormattedTextField();

        setMaximumSize(new java.awt.Dimension(1120, 810));
        setMinimumSize(new java.awt.Dimension(1120, 810));
        setPreferredSize(new java.awt.Dimension(1120, 810));

        jLabel1.setText("Alterar Clientes");

        jLabel2.setText("CPF/CNPJ:");

        txtBuscaCPF_CNPJ.setToolTipText("");
        txtBuscaCPF_CNPJ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        jLabel4.setText("CPF/CNPJ:");

        txt_CPF_CNPF_Encontrado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_CPF_CNPF_Encontrado.setEnabled(false);

        jLabel5.setText("Belt:");

        comboBelt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "WHITE", "GRAY", "BLUE", "YELLOW", "ORANGE", "GREEN", "PURPLE", "BROWN", "BLACK" }));

        jLabel6.setText("Nome:");

        jLabel7.setText("Endereço:");

        jLabel8.setText("Bairro:");

        jLabel9.setText("CEP:");

        jLabel10.setText("Telefone:");

        jLabel11.setText("E-mail:");

        jLabel12.setText("Cidade:");

        jLabel13.setText("UF:");

        jLabel14.setText("Celular:");

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        jLabel3.setText("____________________________________________________________________________________________________________________________________________________________________________________________________________________________");

        txtUFEncontrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        try {
            txtCepEncontrado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtTelefoneEncontrado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefoneEncontrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneEncontradoActionPerformed(evt);
            }
        });

        try {
            txtCelularEncontrado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtBuscaCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEnderecoEncontrado))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomeEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_CPF_CNPF_Encontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(comboBelt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBairroEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtCepEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTelefoneEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCelularEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCidadeEncontrado)
                                            .addComponent(txtUFEncontrado, 0, 150, Short.MAX_VALUE)))))
                            .addComponent(txtEmailEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(307, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtBuscaCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboBelt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_CPF_CNPF_Encontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNomeEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEnderecoEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBairroEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCidadeEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCepEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtUFEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefoneEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(txtCelularEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(50, 50, 50)
                .addComponent(botaoSalvar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        Cliente c = daoCliente.pesquisarClientePorCpfCnpj(txt_CPF_CNPF_Encontrado.getText());

        c.setEmail(txtEmailEncontrado.getText());
        c.setCpf_cnpj(txt_CPF_CNPF_Encontrado.getText());
        c.setCep(txtCepEncontrado.getText());
        c.setRua(txtEnderecoEncontrado.getText());
        c.setBairro(txtBairroEncontrado.getText());
        c.setCidade(txtCidadeEncontrado.getText());
        c.setUf(txtUFEncontrado.getSelectedItem().toString());
        c.setClassificacao((String) comboBelt.getSelectedItem());
        c.setDistanciaFilial(0.0);
        c.setNome(txtNomeEncontrado.getText());
        c.setTelefone(txtTelefoneEncontrado.getText());
        c.setCelular(txtCelularEncontrado.getText());

        boolean isOk = daoCliente.update(c);

        if (isOk == true) {
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");

            txtBuscaCPF_CNPJ.setText("");
            txt_CPF_CNPF_Encontrado.setText("");
            comboBelt.setSelectedIndex(0);
            txtNomeEncontrado.setText("");
            txtEnderecoEncontrado.setText("");
            txtBairroEncontrado.setText("");
            txtCidadeEncontrado.setText("");
            txtCepEncontrado.setText("");
            txtUFEncontrado.setSelectedIndex(0);
            txtTelefoneEncontrado.setText("");
            txtCelularEncontrado.setText("");
            txtEmailEncontrado.setText("");
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        Cliente clienteEncontrado = daoCliente.pesquisarClientePorCpfCnpj(txtBuscaCPF_CNPJ.getText());

        txt_CPF_CNPF_Encontrado.setText(clienteEncontrado.getCpf_cnpj());
        comboBelt.setSelectedItem(clienteEncontrado.getClassificacao());
        txtNomeEncontrado.setText(clienteEncontrado.getNome());
        txtEnderecoEncontrado.setText(clienteEncontrado.getRua());
        txtBairroEncontrado.setText(clienteEncontrado.getBairro());
        txtCepEncontrado.setText(clienteEncontrado.getCep());
        txtTelefoneEncontrado.setText(clienteEncontrado.getTelefone());
        txtEmailEncontrado.setText(clienteEncontrado.getEmail());
        txtCidadeEncontrado.setText(clienteEncontrado.getCidade());
        txtUFEncontrado.setSelectedItem(clienteEncontrado.getUf());
        txtCelularEncontrado.setText(clienteEncontrado.getCelular());
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void txtTelefoneEncontradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneEncontradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneEncontradoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JComboBox comboBelt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBairroEncontrado;
    private javax.swing.JTextField txtBuscaCPF_CNPJ;
    private javax.swing.JFormattedTextField txtCelularEncontrado;
    private javax.swing.JFormattedTextField txtCepEncontrado;
    private javax.swing.JTextField txtCidadeEncontrado;
    private javax.swing.JTextField txtEmailEncontrado;
    private javax.swing.JTextField txtEnderecoEncontrado;
    private javax.swing.JTextField txtNomeEncontrado;
    private javax.swing.JFormattedTextField txtTelefoneEncontrado;
    private javax.swing.JComboBox txtUFEncontrado;
    private javax.swing.JTextField txt_CPF_CNPF_Encontrado;
    // End of variables declaration//GEN-END:variables

    public class AcaoListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == event.VK_F1 && event.getSource() == txtBuscaCPF_CNPJ) {
                TelaAjuda tela = new TelaAjuda(Ajuda.Cliente_Cnpj_CPF);
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
