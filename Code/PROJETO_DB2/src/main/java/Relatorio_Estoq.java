/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**
 *
 * @author yigor
 */
import java.sql.*;
import br.com.projetoapoo.dal.ModuloConexao;
import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import javax.swing.table.DefaultTableModel;

public class Relatorio_Estoq extends javax.swing.JInternalFrame {

    /**
     * Creates new form Relatoro_Prod
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public static Relatorio_Estoq relEstoq;
    
    public void ShowTable() {
        String sql = "select idRelEst, prod_caddate, prod_codigo, prod_nome, est_quantidadeprod, est_codigo, ger_codigo, ger_nome from tbrelatorioestoque";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) tabRelProd.getModel();

            String numero_alteracao, data_alteracao, codigo_prod, nome_prod, est_quantidadeprod, est_codigo, codigo_ger, nome_ger;
            while (rs.next()) {
                numero_alteracao = rs.getString(1);
                data_alteracao = rs.getString(2);
                codigo_prod = rs.getString(3);
                nome_prod = rs.getString(4);
                est_quantidadeprod = rs.getString(5);
                est_codigo = rs.getString(6);
                codigo_ger = rs.getString(7);
                nome_ger = rs.getString(8);
                String[] row = {numero_alteracao, data_alteracao, codigo_prod, nome_prod, est_quantidadeprod, est_codigo, codigo_ger, nome_ger};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public Relatorio_Estoq() {
        initComponents();
        conexao = ModuloConexao.conector();
        ShowTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabRelProd = new javax.swing.JTable();
        ctCodProd = new javax.swing.JTextField();
        btConsProd = new javax.swing.JButton();
        btConsAll = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ctCodGer = new javax.swing.JTextField();
        btConsGer = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("RELATÓRIO DE ESTOQUE");

        tabRelProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Atualização", "Data Atualização", "Código Prod.", "Nome Prod.", "Quant. Prod.", "Nº Estoque", "Cód. Gerente", "Nome Gerente"
            }
        ));
        jScrollPane1.setViewportView(tabRelProd);

        ctCodProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctCodProdActionPerformed(evt);
            }
        });

        btConsProd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btConsProd.setText("Consultar");
        btConsProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsProdActionPerformed(evt);
            }
        });

        btConsAll.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btConsAll.setText("Consultar Todo o Estoque");
        btConsAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsAllActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Código do Produto:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Código do Gerente:");

        ctCodGer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctCodGerActionPerformed(evt);
            }
        });

        btConsGer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btConsGer.setText("Consultar");
        btConsGer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsGerActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSair.setText("Sair");
        btSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(btSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(ctCodProd))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(ctCodGer)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btConsGer, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btConsProd, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btConsAll)))))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(359, 359, 359))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ctCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsProd)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ctCodGer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsGer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btConsAll)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(btSair))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ctCodProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctCodProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctCodProdActionPerformed

    private void btConsAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsAllActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabRelProd.getModel();
        model.setRowCount(0);
        ShowTable();
        limpar();
    }//GEN-LAST:event_btConsAllActionPerformed

    private void btConsProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsProdActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabRelProd.getModel();
        model.setRowCount(0);
        TableCodProd();
        limpar();
    }//GEN-LAST:event_btConsProdActionPerformed

    private void ctCodGerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctCodGerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctCodGerActionPerformed

    private void btConsGerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsGerActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabRelProd.getModel();
        model.setRowCount(0);
        TableCodGer();
        limpar();
    }//GEN-LAST:event_btConsGerActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        sair();
    }//GEN-LAST:event_btSairActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed

    public void limpar() {
        ctCodGer.setText("");
        ctCodProd.setText("");
        ctCodProd.requestFocus();
    }

    public void sair() {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Saída", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0) {
            this.dispose();
        }
    }

    public void TableCodProd() {
        String sql = "select idRelEst, prod_caddate, prod_codigo, prod_nome, est_quantidadeprod, est_codigo, ger_codigo, ger_nome from tbrelatorioestoque where prod_codigo = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(ctCodProd.getText()));
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) tabRelProd.getModel();

            String numero_alteracao, data_alteracao, codigo_prod, nome_prod, est_quantidadeprod, est_codigo, codigo_ger, nome_ger;
            while (rs.next()) {
                numero_alteracao = rs.getString(1);
                data_alteracao = rs.getString(2);
                codigo_prod = rs.getString(3);
                nome_prod = rs.getString(4);
                est_quantidadeprod = rs.getString(5);
                est_codigo = rs.getString(6);
                codigo_ger = rs.getString(7);
                nome_ger = rs.getString(8);
                String[] row = {numero_alteracao, data_alteracao, codigo_prod, nome_prod, est_quantidadeprod, est_codigo, codigo_ger, nome_ger};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void TableCodGer() {
        String sql = "select idRelEst, prod_caddate, prod_codigo, prod_nome, est_quantidadeprod, est_codigo, ger_codigo, ger_nome from tbrelatorioestoque where ger_codigo = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(ctCodGer.getText()));
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) tabRelProd.getModel();

            String numero_alteracao, data_alteracao, codigo_prod, nome_prod, est_quantidadeprod, est_codigo, codigo_ger, nome_ger;
            while (rs.next()) {
                numero_alteracao = rs.getString(1);
                data_alteracao = rs.getString(2);
                codigo_prod = rs.getString(3);
                nome_prod = rs.getString(4);
                est_quantidadeprod = rs.getString(5);
                est_codigo = rs.getString(6);
                codigo_ger = rs.getString(7);
                nome_ger = rs.getString(8);
                String[] row = {numero_alteracao, data_alteracao, codigo_prod, nome_prod, est_quantidadeprod, est_codigo, codigo_ger, nome_ger};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsAll;
    private javax.swing.JButton btConsGer;
    private javax.swing.JButton btConsProd;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSair;
    private javax.swing.JTextField ctCodGer;
    private javax.swing.JTextField ctCodProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabRelProd;
    // End of variables declaration//GEN-END:variables
}
