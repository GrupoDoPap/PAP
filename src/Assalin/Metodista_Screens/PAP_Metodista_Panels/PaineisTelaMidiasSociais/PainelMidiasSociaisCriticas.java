package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMidiasSociais;

import Metodista_DataAccess.PAP_Metodista_Dao.DaoOpiniao;
import java.awt.GridLayout;
import javax.sql.rowset.CachedRowSet;

public class PainelMidiasSociaisCriticas extends javax.swing.JPanel {

    DaoOpiniao dop = new DaoOpiniao();
    PainelCitacao[] citacoes = new PainelCitacao[12];

    public PainelMidiasSociaisCriticas() {
        initComponents();

        pnlCitacoes.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 12; i++) {
            citacoes[i] = new PainelCitacao();
            pnlCitacoes.add(citacoes[i]);
        }

        atualizarCitacoes();
    }

    public void atualizarCitacoes() {

        CachedRowSet resultado = (dop.atualizarCriticas(cbbFontes.getSelectedItem().toString()));

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbFontes = new javax.swing.JComboBox();
        pnlCitacoes = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(1120, 810));
        setMinimumSize(new java.awt.Dimension(1120, 810));

        jLabel1.setText("Mídias Sociais - Críticas recentes");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Fonte:");

        cbbFontes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FACEBOOK", "TWITTER", "RECLAME AQUI", " " }));
        cbbFontes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbFontesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlCitacoesLayout = new javax.swing.GroupLayout(pnlCitacoes);
        pnlCitacoes.setLayout(pnlCitacoesLayout);
        pnlCitacoesLayout.setHorizontalGroup(
            pnlCitacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        pnlCitacoesLayout.setVerticalGroup(
            pnlCitacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCitacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbbFontes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(442, 442, 442))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbFontes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlCitacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbFontesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbFontesItemStateChanged
        atualizarCitacoes();
    }//GEN-LAST:event_cbbFontesItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbbFontes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlCitacoes;
    // End of variables declaration//GEN-END:variables
}
