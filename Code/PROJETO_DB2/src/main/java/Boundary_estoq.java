
import br.com.projetoapoo.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Boundary_estoq extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Estoque estq;
    public static Control_estoq controlEstq = new Control_estoq();

    public static Boundary_estoq gerEstq;

    public Boundary_estoq() throws NumNegException, SQLException {
        initComponents();
        conexao = ModuloConexao.conector();
        consultarAll();
    }

    public static Boundary_estoq getBoundary_estoq() throws NumNegException, SQLException {
        if (gerEstq == null) {
            gerEstq = new Boundary_estoq();
        }
        return gerEstq;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEstoque = new javax.swing.JLabel();
        lblQtdeProd = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        btAdicionar_prod = new javax.swing.JButton();
        btConsultar_estoque = new javax.swing.JButton();
        btRetirar_prod = new javax.swing.JButton();
        ctQtdeProd = new javax.swing.JTextField();
        ctCodigo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabEstoque = new javax.swing.JTable();
        btSair = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btConsAll = new javax.swing.JButton();
        MnBarGerente = new javax.swing.JMenuBar();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gerenciar Estoque");

        lblEstoque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEstoque.setText("ESTOQUE");

        lblQtdeProd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblQtdeProd.setText("Qtde. de Produto:");

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigo.setText("Código do Produto:");

        btAdicionar_prod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btAdicionar_prod.setText("Adicionar Produto");
        btAdicionar_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionar_prodActionPerformed(evt);
            }
        });

        btConsultar_estoque.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btConsultar_estoque.setText("Consultar Código");
        btConsultar_estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultar_estoqueActionPerformed(evt);
            }
        });

        btRetirar_prod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btRetirar_prod.setText("Retirar Produto");
        btRetirar_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetirar_prodActionPerformed(evt);
            }
        });

        ctQtdeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctQtdeProdActionPerformed(evt);
            }
        });

        ctCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctCodigoActionPerformed(evt);
            }
        });

        TabEstoque = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TabEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO PROD.", "NOME PROD.", "DESCRIÇÃO", "MARCA", "MODELO", "CATEGORIA", "FORNECEDOR", "PREÇO", "QUANT. ESTOQ."
            }
        ));
        TabEstoque.setFocusable(false);
        TabEstoque.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TabEstoque);

        btSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btConsAll.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btConsAll.setText("Consultar Todo Estoque");
        btConsAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsAllActionPerformed(evt);
            }
        });
        setJMenuBar(MnBarGerente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLimpar)
                        .addGap(44, 44, 44)
                        .addComponent(btSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodigo)
                                    .addComponent(lblQtdeProd))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ctQtdeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ctCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btAdicionar_prod)
                                        .addGap(63, 63, 63)
                                        .addComponent(btRetirar_prod))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btConsultar_estoque)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btConsAll)))))))
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEstoque)
                .addGap(407, 407, 407))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblEstoque)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ctCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo)
                    .addComponent(btConsultar_estoque)
                    .addComponent(btConsAll))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ctQtdeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQtdeProd)
                    .addComponent(btAdicionar_prod)
                    .addComponent(btRetirar_prod))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSair)
                    .addComponent(btLimpar))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ctQtdeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctQtdeProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctQtdeProdActionPerformed

    private void ctCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctCodigoActionPerformed

    private void btAdicionar_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionar_prodActionPerformed
        try {
            consultar();
            cadastrar();
            limpar();

        } catch (NumNegException ex) {
            Logger.getLogger(Boundary_ger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Boundary_estoq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAdicionar_prodActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed

    public void limpar() {
        ctQtdeProd.setText("");
        ctCodigo.setText("");
        ctCodigo.requestFocus();
    }

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        sair();
    }//GEN-LAST:event_btSairActionPerformed

    private void btConsultar_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultar_estoqueActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) TabEstoque.getModel();
            model.setRowCount(0);
            consultar();
            limpar();
        } catch (NumNegException ex) {
            Logger.getLogger(Boundary_ger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Boundary_estoq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConsultar_estoqueActionPerformed

    private void btRetirar_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetirar_prodActionPerformed
        try {
            consultar();
            excluir();
            limpar();
        } catch (NumNegException ex) {
            Logger.getLogger(Boundary_ger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Boundary_estoq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRetirar_prodActionPerformed

    private void btConsAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsAllActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) TabEstoque.getModel();
            model.setRowCount(0);
            consultarAll();
        } catch (NumNegException ex) {
            Logger.getLogger(Boundary_estoq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Boundary_estoq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConsAllActionPerformed

    public void sair() {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Saída", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0) {
            this.dispose();
        }
    }

    public void excluir() throws NumNegException, SQLException {
        String sql = "update tbestoque set est_quantidadeprod = est_quantidadeprod - ? where prod_codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(ctQtdeProd.getText()));
            pst.setInt(2, Integer.parseInt(ctCodigo.getText()));
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) TabEstoque.getModel();
            model.setRowCount(0);
            consultarAll();

            JOptionPane.showMessageDialog(null, "Quantidade atualizada", "Update successful", 1);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar", "ERRO de update", 0);
            limpar();
        }
    }

    public void consultar() throws NumNegException, SQLException {
        String sql = "select tbproduto.prod_codigo, prod_nome, prod_descricao, prod_marca, prod_modelo, prod_categoria, prod_fornecedor, prod_preco, est_quantidadeprod from tbproduto, tbestoque where tbproduto.prod_codigo = tbestoque.prod_codigo and tbestoque.prod_codigo = ?";
/*
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ctCodigo.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                TabEstoque.setValueAt(rs.getString(1), 0, 0);
                TabEstoque.setValueAt(rs.getString(2), 0, 1);
                TabEstoque.setValueAt(rs.getString(3), 0, 2);
                TabEstoque.setValueAt(rs.getString(4), 0, 3);
                TabEstoque.setValueAt(rs.getString(5), 0, 4);
                TabEstoque.setValueAt(rs.getString(6), 0, 5);
                TabEstoque.setValueAt(rs.getString(7), 0, 6);
                TabEstoque.setValueAt(rs.getString(8), 0, 7);
                TabEstoque.setValueAt(rs.getString(9), 0, 8);
            } else {
                JOptionPane.showMessageDialog(null, "Nao existe produto com este código", "Código inexistente", 0);

            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "O código deve ser um numero inteiro", "ERRO de código", 0);
            limpar();
        }
        */
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(ctCodigo.getText()));
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) TabEstoque.getModel();

            String prod_codigo, prod_nome, prod_descricao, prod_marca, prod_modelo, prod_categoria, prod_fornecedor, prod_preco, est_quantidadeprod;
            //if (rs.next()) {
                while (rs.next()) {
                    prod_codigo = rs.getString(1);
                    prod_nome = rs.getString(2);
                    prod_descricao = rs.getString(3);
                    prod_marca = rs.getString(4);
                    prod_modelo = rs.getString(5);
                    prod_categoria = rs.getString(6);
                    prod_fornecedor = rs.getString(7);
                    prod_preco = rs.getString(8);
                    est_quantidadeprod = rs.getString(9);
                    String[] row = {prod_codigo, prod_nome, prod_descricao, prod_marca, prod_modelo, prod_categoria, prod_fornecedor, prod_preco, est_quantidadeprod};
                    model.addRow(row);

               }
            //}else{
                //JOptionPane.showMessageDialog(null, "Nao existe produto com este código", "Código inexistente", 0);
                
           // }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "O código deve ser um numero inteiro", "ERRO de código", 0);
            limpar();
        }

    }

    public void consultarAll() throws NumNegException, SQLException {
        String sql = "select tbproduto.prod_codigo, prod_nome, prod_descricao, prod_marca, prod_modelo, prod_categoria, prod_fornecedor, prod_preco, est_quantidadeprod from tbproduto, tbestoque where tbproduto.prod_codigo = tbestoque.prod_codigo";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) TabEstoque.getModel();

            String prod_codigo, prod_nome, prod_descricao, prod_marca, prod_modelo, prod_categoria, prod_fornecedor, prod_preco, est_quantidadeprod;
            while (rs.next()) {
                prod_codigo = rs.getString(1);
                prod_nome = rs.getString(2);
                prod_descricao = rs.getString(3);
                prod_marca = rs.getString(4);
                prod_modelo = rs.getString(5);
                prod_categoria = rs.getString(6);
                prod_fornecedor = rs.getString(7);
                prod_preco = rs.getString(8);
                est_quantidadeprod = rs.getString(9);
                String[] row = {prod_codigo, prod_nome, prod_descricao, prod_marca, prod_modelo, prod_categoria, prod_fornecedor, prod_preco, est_quantidadeprod};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void cadastrar() throws NumNegException, SQLException {
        String sql = "update tbestoque set est_quantidadeprod = est_quantidadeprod + ? where prod_codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(ctQtdeProd.getText()));
            pst.setInt(2, Integer.parseInt(ctCodigo.getText()));
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) TabEstoque.getModel();
            model.setRowCount(0);
            consultarAll();

            JOptionPane.showMessageDialog(null, "Quantidade atualizada", "Update successful", 1);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar", "ERRO de update", 0);
            limpar();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Boundary_estoq().setVisible(true);
                } catch (NumNegException ex) {
                    Logger.getLogger(Boundary_estoq.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Boundary_estoq.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MnBarGerente;
    private javax.swing.JTable TabEstoque;
    private javax.swing.JButton btAdicionar_prod;
    private javax.swing.JButton btConsAll;
    private javax.swing.JButton btConsultar_estoque;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btRetirar_prod;
    private javax.swing.JButton btSair;
    private javax.swing.JTextField ctCodigo;
    private javax.swing.JTextField ctQtdeProd;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblQtdeProd;
    // End of variables declaration//GEN-END:variables
}
