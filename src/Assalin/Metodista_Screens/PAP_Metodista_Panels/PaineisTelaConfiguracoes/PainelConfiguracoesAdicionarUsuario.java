package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaConfiguracoes;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Usuario;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoFuncionario;
import javax.swing.JOptionPane;

public class PainelConfiguracoesAdicionarUsuario extends javax.swing.JPanel {

    public PainelConfiguracoesAdicionarUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        labelLogin = new javax.swing.JLabel();
        PasswordSenha = new javax.swing.JPasswordField();
        botaoConfirmar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtCargo = new javax.swing.JComboBox();
        txtTelefone = new javax.swing.JFormattedTextField();

        jLabel1.setText("Adicionar Usuário");

        jLabel2.setText("Nome:");

        jLabel4.setText("Cargo:");

        jLabel6.setText("Login:");

        jLabel7.setText("Senha:");

        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        jLabel8.setText("Telefone:");

        txtCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAC", "INFORMATICA", "ADMIN", "FINANCEIRO", "PRODUCAO", "LOGISTICA", "MOTORISTA", "AJUDANTE", "" }));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
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
                        .addGap(619, 619, 619)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PasswordSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(txtNome)
                            .addComponent(txtLogin)
                            .addComponent(txtCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addComponent(botaoConfirmar)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PasswordSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(botaoConfirmar)
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        String senha = "";

        for (char l : PasswordSenha.getPassword()) {
            senha += l;
        }

        DaoFuncionario daoFuncionario = new DaoFuncionario();

        boolean isOk = daoFuncionario.inserirUsuario(
                new Usuario(
                        txtNome.getText(),
                        txtCargo.getSelectedItem().toString(),
                        txtTelefone.getText(),
                        txtLogin.getText(),
                        senha
                )
        );

        if (isOk == true) {
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso no sistema");

            txtNome.setText("");
            txtCargo.setSelectedIndex(0);
            txtTelefone.setText("");
            txtLogin.setText("");
            PasswordSenha.setText("");
        }
    }//GEN-LAST:event_botaoConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordSenha;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JComboBox txtCargo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
