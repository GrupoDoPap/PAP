package Metodista_Screens.PAP_Metodista_Panels.PaineisTelaMidiasSociais;

public class PainelCitacao extends javax.swing.JPanel {

    public PainelCitacao() {
        initComponents();
    }

    public void setNome(String nome) {
        lblNome.setText(nome);
    }

    public void setData(String data) {
        lblData.setText(data);
    }

    public void setOpiniao(String opiniao) {
        lblOpiniao.setText(opiniao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblOpiniao = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNome.setText("_Nome");
        add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        lblData.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblData.setText("_Data");
        add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 300, -1));

        lblOpiniao.setBackground(new java.awt.Color(255, 255, 255));
        lblOpiniao.setText("opnião");
        lblOpiniao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblOpiniao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOpiniao.setOpaque(true);
        add(lblOpiniao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 300, 55));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOpiniao;
    // End of variables declaration//GEN-END:variables
}
