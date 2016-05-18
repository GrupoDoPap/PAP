/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodista_Screens.PAP_Metodista_Frames;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Cliente;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Pedido;
import Metodista_BusinessRules.PAP_Metodista_Enum.Ajuda;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoCliente;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoPedido;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo Assalin
 */
public class TelaAjuda extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;

    /**
     * Creates new form TelaAjuda
     */
    public TelaAjuda(Ajuda ajuda) {
        initComponents();

        BuildTabelaAjuda(ajuda);

        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void BuildTabelaAjuda(Ajuda ajuda) {
        defaultTableModel = (DefaultTableModel) tabelaAjuda.getModel();

        DaoCliente daoCliente;
        ArrayList<Cliente> arrayClientes;

        switch (ajuda) {
            case LoginAcesso:
                defaultTableModel.addColumn("Login Permitido");
                defaultTableModel.addColumn("Necessario Senha?");

                defaultTableModel.addRow(
                        new Object[] {
                    "Admin", "Não",
                });
                
                defaultTableModel.addRow(
                        new Object[] {
                    "Informatica", "Não",
                });
                
                defaultTableModel.addRow(
                        new Object[] {
                    "Producao", "Não",
                });
                
                defaultTableModel.addRow(
                        new Object[] {
                    "Financeiro", "Não",
                });
                
                defaultTableModel.addRow(
                        new Object[] {
                    "Admin", "Não",
                });
                
                defaultTableModel.addRow(
                        new Object[] {
                    "Logistica", "Não",
                });

                break;

            case Cliente_Cnpj_CPF:

                daoCliente = new DaoCliente();
                arrayClientes = daoCliente.listarClientes();

                defaultTableModel.addColumn("CPF/CNPJ");
                defaultTableModel.addColumn("Nome");

                for (Cliente c : arrayClientes) {
                    defaultTableModel.addRow(
                            new Object[]{
                                c.getCpf_cnpj(),
                                c.getNome()
                            }
                    );
                }

                break;

            case Configuracao_ID:
//                DaoFuncionario daoFuncionario = new DaoFuncionario();
//                
//                ArrayList<Funcionario> arrayFuncionario = daoFuncionario.listarFuncionarios();
//
//                defaultTableModel.addColumn("ID");
//                defaultTableModel.addColumn("Nome");
//                defaultTableModel.addColumn("Cargo");
//                
//                for (Funcionario f : arrayFuncionario) {
//                    defaultTableModel.addRow(
//                            new Object[]{
//                                f.getCodigo(),
//                                f.getNome(),
//                                f.getCargo(),
//                            }
//                    );
//                }

                break;

            case Pedidos_Codigo_Cliente:
                daoCliente = new DaoCliente();

                arrayClientes = daoCliente.listarClientes();

                defaultTableModel.addColumn("Código");
                defaultTableModel.addColumn("Nome");
                defaultTableModel.addColumn("Email");

                for (Cliente c : arrayClientes) {
                    defaultTableModel.addRow(
                            new Object[]{
                                c.getCodigo(),
                                c.getNome(),
                                c.getEmail()
                            }
                    );
                }

                break;

            case Viagens_Codigo_Pedido:
                DaoPedido daoPedido = new DaoPedido();

                ArrayList<Pedido> arrayPedido = daoPedido.listarPedidos();

                defaultTableModel.addColumn("Código");
                defaultTableModel.addColumn("Cliente");
                defaultTableModel.addColumn("Data de Entrega");

                for (Pedido p : arrayPedido) {
                    defaultTableModel.addRow(
                            new Object[]{
                                p.getCodigo(),
                                p.getCliente().getNome(),
                                p.getDataEntrega()
                            }
                    );
                }

                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelRolagem = new javax.swing.JScrollPane();
        tabelaAjuda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        tabelaAjuda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        painelRolagem.setViewportView(tabelaAjuda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane painelRolagem;
    private javax.swing.JTable tabelaAjuda;
    // End of variables declaration//GEN-END:variables
}
