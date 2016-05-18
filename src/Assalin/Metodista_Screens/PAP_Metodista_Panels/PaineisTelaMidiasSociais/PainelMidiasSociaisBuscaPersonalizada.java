package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMidiasSociais;

import Metodista_DataAccess.PAP_Metodista_Dao.DaoOpiniao;
import java.awt.GridLayout;
import javax.sql.rowset.CachedRowSet;

public class PainelMidiasSociaisBuscaPersonalizada extends javax.swing.JPanel {

    DaoOpiniao dop = new DaoOpiniao();
    PainelCitacao[] citacoes = new PainelCitacao[12];

    public PainelMidiasSociaisBuscaPersonalizada() {
        initComponents();

        pnlCitacoes.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 12; i++) {
            citacoes[i] = new PainelCitacao();
            pnlCitacoes.add(citacoes[i]);
        }

        atualizarCitacoes();
    }

    public void atualizarCitacoes() {

        CachedRowSet resultado = (dop.buscaPersonalizada("%" + txtPalavra.getText().toUpperCase() + "%"));

        for (int i = 0; i < 12; i++) {
            citacoes[i].setNome("");
            citacoes[i].setOpiniao("");
            citacoes[i].setData("");
        }

        try {
            int i = 0;
            while (resultado.next()) {
                citacoes[i].setNome(resultado.getString(1));
                citacoes[i].setOpiniao(resultado.getString(2));
                citacoes[i].setData(resultado.getString(3));

                i++;
            }
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        pnlCitacoes = new javax.swing.JPanel();
        txtPalavra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1120, 810));
        setMinimumSize(new java.awt.Dimension(1120, 810));
        setPreferredSize(new java.awt.Dimension(1120, 810));

        jLabel2.setText("Palavra - Chave");

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCitacoesLayout = new javax.swing.GroupLayout(pnlCitacoes);
        pnlCitacoes.setLayout(pnlCitacoesLayout);
        pnlCitacoesLayout.setHorizontalGroup(
            pnlCitacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1135, Short.MAX_VALUE)
        );
        pnlCitacoesLayout.setVerticalGroup(
            pnlCitacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        txtPalavra.setText("     ");

        jLabel4.setText("Mídias Sociais - Busca Personalizada");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCitacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAtualizar)
                        .addGap(339, 339, 339)))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnAtualizar)
                    .addComponent(txtPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlCitacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizarCitacoes();
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnlCitacoes;
    private javax.swing.JTextField txtPalavra;
    // End of variables declaration//GEN-END:variables
}
