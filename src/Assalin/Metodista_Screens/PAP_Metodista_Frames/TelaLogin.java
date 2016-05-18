package Metodista_Screens.PAP_Metodista_Frames;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Usuario;
import Metodista_BusinessRules.PAP_Metodista_Enum.Ajuda;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoFuncionario;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class TelaLogin extends javax.swing.JFrame {

    private final DaoFuncionario daoFuncionario;
    private final AcaoListener acaoListener;
    private Usuario usuario;
    private String senha = "";
    private JDialog dialog;
    private Timer temporizador;

    public TelaLogin() {
        initComponents();

        acaoListener = new AcaoListener();
        txtLogin.addKeyListener(acaoListener);

        daoFuncionario = new DaoFuncionario();

        setTitle("Milkway CRM");

        setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        PasswordSenha = new javax.swing.JPasswordField();
        botaoEntrar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        labelEsqueciMinhaSenha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(450, 250));
        setResizable(false);

        jLabel1.setText("Login:");

        jLabel2.setText("Senha:");

        txtLogin.setText("PAP");
        txtLogin.setToolTipText("Campo Selecionado? Aperte F1");
        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PasswordSenha.setText("12345");

        botaoEntrar.setText("Entrar");
        botaoEntrar.setToolTipText("Acessar sistema");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });

        botaoSair.setText("Sair");
        botaoSair.setToolTipText("Fechar aplicação");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        labelEsqueciMinhaSenha.setForeground(new java.awt.Color(0, 0, 255));
        labelEsqueciMinhaSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEsqueciMinhaSenha.setText("<html><u>Esqueci minha senha</u></html>");
        labelEsqueciMinhaSenha.setToolTipText("Clique aqui");
        labelEsqueciMinhaSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AcaoLabelEsqueciMinhaSenha(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredOnLabel(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedOnLabel(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel3.setText("Copyright © 2014 ACC - Assistence of Communication with Consumers");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelEsqueciMinhaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordSenha)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoEntrar)
                        .addGap(29, 29, 29)
                        .addComponent(botaoSair)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PasswordSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEntrar)
                    .addComponent(botaoSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEsqueciMinhaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        //Coleta usuário e senha
        try {
            usuario = daoFuncionario.selecionarUsuarioPorLogin(txtLogin.getText());
            for (char letra : PasswordSenha.getPassword()) {
                senha += letra;
            }

            if (txtLogin.getText().equals(usuario.getLogin())
                    && senha.equals(usuario.getSenha())) {

                temporizador = new Timer();

                dialog = new JDialog();

                dialog.setTitle("Carregando...");
                dialog.setModal(false);

                JProgressBar progressBar = new JProgressBar();
                progressBar.setIndeterminate(true);
                progressBar.setSize(200, 20);

                dialog.getContentPane().add(progressBar);
                dialog.pack();

                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

                LoadTimer(5);

            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta");
                PasswordSenha.setText("");
                senha = "";
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            txtLogin.setText("");
            PasswordSenha.setText("");
            senha = "";
        }

    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void AcaoLabelEsqueciMinhaSenha(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcaoLabelEsqueciMinhaSenha
        JOptionPane.showMessageDialog(null, "Senha enviada ao seu e-mail");
    }//GEN-LAST:event_AcaoLabelEsqueciMinhaSenha

    private void MouseEnteredOnLabel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseEnteredOnLabel
        labelEsqueciMinhaSenha.setForeground(Color.RED);
    }//GEN-LAST:event_MouseEnteredOnLabel

    private void MouseExitedOnLabel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseExitedOnLabel
        labelEsqueciMinhaSenha.setForeground(Color.BLUE);
    }//GEN-LAST:event_MouseExitedOnLabel


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordSenha;
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelEsqueciMinhaSenha;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables

    private void LoadTimer(int segundos) {
        temporizador.schedule(new FimDoTempo(), segundos * 1000);
    }

    //Classe que trata do evento que ocorre apos ecerramento do tempo do timer
    public class FimDoTempo extends TimerTask {

        @Override
        public void run() {
            TelaPrincipal telaPrincipal = new TelaPrincipal(usuario);
            dispose();
            dialog.dispose();
        }
    }

    public class AcaoListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == event.VK_F1 && event.getSource() == txtLogin) {
                TelaAjuda tela = new TelaAjuda(Ajuda.LoginAcesso);
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
