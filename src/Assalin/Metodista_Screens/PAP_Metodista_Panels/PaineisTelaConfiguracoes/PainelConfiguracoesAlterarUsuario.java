package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaConfiguracoes;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Usuario;
import Metodista_BusinessRules.PAP_Metodista_Enum.Ajuda;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoFuncionario;
import Metodista_Screens.PAP_Metodista_Frames.TelaAjuda;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class PainelConfiguracoesAlterarUsuario extends javax.swing.JPanel {

    private AcaoListener acaoListener;

    private DaoFuncionario daoFuncionario;

    /**
     * Creates new form PainelConfiguracoesAlterarUsuario
     */
    public PainelConfiguracoesAlterarUsuario() {
        initComponents();

        acaoListener = new AcaoListener();

        daoFuncionario = new DaoFuncionario();

        txtBuscaID.addKeyListener(acaoListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNomeEncontrado = new javax.swing.JTextField();
        labelLogin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBuscaID = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PasswordSenha = new javax.swing.JPasswordField();
        txtCargo = new javax.swing.JComboBox();
        txtTelefoneEncontrado = new javax.swing.JFormattedTextField();

        jLabel1.setText("Alterar Usuário");

        jLabel4.setText("Cargo:");

        jLabel2.setText("Nome:");

        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        jLabel9.setText("__________________________________________________________________________________________________________________________________________________________________________________________________");
        jLabel9.setToolTipText("");

        jLabel10.setText("ID:");

        txtBuscaID.setToolTipText("");
        txtBuscaID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        jLabel8.setText("Telefone:");

        jLabel3.setText("Login:");

        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });

        jLabel5.setText("Senha:");

        txtCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAC", "INFORMATICA", "ADMIN", "FINANCEIRO", "PRODUCAO", "LOGISTICA", "MOTORISTA", "AJUDANTE", "" }));

        try {
            txtTelefoneEncontrado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 147, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(640, 640, 640)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(632, 632, 632)
                        .addComponent(botaoConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomeEncontrado, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                    .addComponent(txtLogin)
                                    .addComponent(PasswordSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTelefoneEncontrado))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBuscaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefoneEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLogin)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PasswordSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(botaoConfirmar)
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        Usuario funcionario = daoFuncionario.selecionarUsuarioPorId(Integer.parseInt(txtBuscaID.getText()));

        txtNomeEncontrado.setText(funcionario.getNome());
        txtCargo.setSelectedItem(funcionario.getCargo());
        txtTelefoneEncontrado.setText(funcionario.getTelefone());
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        boolean isOk = daoFuncionario.atualizarUsuario(
                new Usuario(
                        txtNomeEncontrado.getText(),
                        txtCargo.getSelectedItem().toString(),
                        txtTelefoneEncontrado.getText(),
                        txtLogin.getText(),
                        Arrays.toString(PasswordSenha.getPassword())
                )
        );

        if (isOk == true) {
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso no sistema");

            txtBuscaID.setText("");
            txtNomeEncontrado.setText("");
            txtCargo.setSelectedIndex(0);
            txtTelefoneEncontrado.setText("");
            txtLogin.setText("");
            PasswordSenha.setText("");

        }
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordSenha;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JTextField txtBuscaID;
    private javax.swing.JComboBox txtCargo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNomeEncontrado;
    private javax.swing.JFormattedTextField txtTelefoneEncontrado;
    // End of variables declaration//GEN-END:variables

    public class AcaoListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == event.VK_F1 && event.getSource() == txtBuscaID) {
                TelaAjuda tela = new TelaAjuda(Ajuda.Configuracao_ID);
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
