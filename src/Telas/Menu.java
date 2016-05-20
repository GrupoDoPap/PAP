/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Sanches
 */
public class Menu extends javax.swing.JFrame {
 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Creates new form menu1
     */
    public Menu() {
        super("Menu");
      
        initComponents();
        // obtém o tamanho da tela
   
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Jmn = new javax.swing.JMenu();
        JmniLogoff = new javax.swing.JMenuItem();
        JmnSac = new javax.swing.JMenu();
        JmniConsultaCliente = new javax.swing.JMenuItem();
        JmniCadastroCliente = new javax.swing.JMenuItem();
        jmnUsuario = new javax.swing.JMenu();
        JmniCriarUsuario = new javax.swing.JMenuItem();
        JmniDeletarUsuario = new javax.swing.JMenuItem();
        JmniConsultaUsuario = new javax.swing.JMenuItem();
        JmnOpcoes = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        JmniRanking = new javax.swing.JMenuItem();
        JmniRelatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(getMaximumSize());

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        jMenuBar1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMenuBar1FocusGained(evt);
            }
        });

        Jmn.setText("Arquivos");

        JmniLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/Imagens/icon pequeno.png"))); // NOI18N
        JmniLogoff.setText("Logoff");
        JmniLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmniLogoffActionPerformed(evt);
            }
        });
        Jmn.add(JmniLogoff);

        jMenuBar1.add(Jmn);

        JmnSac.setText("SAC");

        JmniConsultaCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        JmniConsultaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/Imagens/Sac.png"))); // NOI18N
        JmniConsultaCliente.setText("Consulta Cliente");
        JmnSac.add(JmniConsultaCliente);

        JmniCadastroCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        JmniCadastroCliente.setText("Cadastro de Cliente");
        JmniCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmniCadastroClienteActionPerformed(evt);
            }
        });
        JmnSac.add(JmniCadastroCliente);

        jMenuBar1.add(JmnSac);

        jmnUsuario.setText("Usuário");

        JmniCriarUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        JmniCriarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/Imagens/Add user.png"))); // NOI18N
        JmniCriarUsuario.setText("Criar Usuário");
        JmniCriarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmniCriarUsuarioActionPerformed(evt);
            }
        });
        jmnUsuario.add(JmniCriarUsuario);

        JmniDeletarUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        JmniDeletarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/Imagens/delete User.png"))); // NOI18N
        JmniDeletarUsuario.setText("Deletar Usuário");
        jmnUsuario.add(JmniDeletarUsuario);

        JmniConsultaUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        JmniConsultaUsuario.setBackground(java.awt.Color.white);
        JmniConsultaUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmniConsultaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/Imagens/people.png"))); // NOI18N
        JmniConsultaUsuario.setText("Consulta Usuário");
        JmniConsultaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmniConsultaUsuarioActionPerformed(evt);
            }
        });
        jmnUsuario.add(JmniConsultaUsuario);

        jMenuBar1.add(jmnUsuario);

        JmnOpcoes.setText("Opções");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setBackground(java.awt.Color.white);
        jMenuItem5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/Imagens/arrow.png"))); // NOI18N
        jMenuItem5.setText("Gráficos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        JmnOpcoes.add(jMenuItem5);

        JmniRanking.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        JmniRanking.setBackground(java.awt.Color.white);
        JmniRanking.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmniRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/Imagens/ranking.png"))); // NOI18N
        JmniRanking.setText("Ranking");
        JmniRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmniRankingActionPerformed(evt);
            }
        });
        JmnOpcoes.add(JmniRanking);

        JmniRelatorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        JmniRelatorio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmniRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/Imagens/Relatório.png"))); // NOI18N
        JmniRelatorio.setText("Relatório");
        JmniRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmniRelatorioActionPerformed(evt);
            }
        });
        JmnOpcoes.add(JmniRelatorio);

        jMenuBar1.add(JmnOpcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JmniLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmniLogoffActionPerformed

    }//GEN-LAST:event_JmniLogoffActionPerformed

    private void JmniCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmniCadastroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JmniCadastroClienteActionPerformed

    private void JmniCriarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmniCriarUsuarioActionPerformed

    }//GEN-LAST:event_JmniCriarUsuarioActionPerformed

    private void JmniConsultaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmniConsultaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JmniConsultaUsuarioActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void JmniRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmniRankingActionPerformed

    }//GEN-LAST:event_JmniRankingActionPerformed

    private void JmniRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmniRelatorioActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_JmniRelatorioActionPerformed

    private void jMenuBar1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMenuBar1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1FocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Jmn;
    private javax.swing.JMenu JmnOpcoes;
    private javax.swing.JMenu JmnSac;
    private javax.swing.JMenuItem JmniCadastroCliente;
    private javax.swing.JMenuItem JmniConsultaCliente;
    private javax.swing.JMenuItem JmniConsultaUsuario;
    private javax.swing.JMenuItem JmniCriarUsuario;
    private javax.swing.JMenuItem JmniDeletarUsuario;
    private javax.swing.JMenuItem JmniLogoff;
    private javax.swing.JMenuItem JmniRanking;
    private javax.swing.JMenuItem JmniRelatorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jmnUsuario;
    // End of variables declaration//GEN-END:variables
}
