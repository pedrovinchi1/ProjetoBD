import java.sql.*;
import br.com.projetoapoo.dal.ModuloConexao;
import javax.swing.*;
import java.awt.*;

public class Login_ger extends javax.swing.JFrame {

    private static Login_ger gerLogin;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void logar(){
        String sql = "select * from tbgerente where ger_codigo = ? and ger_senha = ?";
        try {
            //as linhas abaixo preparam a consulta ao banco em função do que foi
            //digitado nas caixas de texto. O ? é substituido pelos conteúdos das variáveis
            pst = conexao.prepareStatement(sql);
            String captura = new String(TxtSenha.getPassword());
            pst.setString(2, captura);
            try{
                pst.setInt(1, Integer.parseInt(TxtCodigo.getText()));
            }catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Digite apenas os números do campo Código!", "ERRO de Código", 0);
            }
            //a linha abaixo executa a query
            rs = pst.executeQuery();
            //se existir usuario e senha correspondente
            if(rs.next()){
                Tela_InicialGer inicial_ger = new Tela_InicialGer(rs.getInt(1));
                inicial_ger.setVisible(true);
                Tela_InicialGer.lblUsuario.setText(rs.getString(2));
                View_Inicial view = new View_Inicial();
                view.setVisible(true);
                view.pnlMenu.setSize(185, 60);
                view.lstMenu.setSize(0, 0);
                inicial_ger.desktop.add(view);
                this.dispose();
                conexao.close();
            } else{
                JOptionPane.showMessageDialog(null, "Código e/ou senha inválido(s)");
                limpar();
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            limpar();
            //this.dispose();
        }
    }

    public Login_ger() {
        initComponents();
        conexao = ModuloConexao.conector();
        System.out.println(conexao);
        if(conexao != null){
            lblStatus.setText("Conectado");
            lblStatus.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\icones\\dbok.png"));
        } else{
            lblStatus.setText("Não Conectado");
            lblStatus.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\icones\\dberror.png"));
        }
    }

    public static Login_ger getLogin_ger(){
        if(gerLogin == null){
            gerLogin = new Login_ger();
        }
        return gerLogin;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu2 = new javax.swing.JLabel();
        menu3 = new javax.swing.JLabel();
        TxtCodigo = new javax.swing.JTextField();
        BtLogin = new javax.swing.JButton();
        TxtSenha = new javax.swing.JPasswordField();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Gerente");
        setResizable(false);

        menu2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menu2.setText("Login:");

        menu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menu3.setText("Senha:");

        BtLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtLogin.setText("Entrar");
        BtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLoginActionPerformed(evt);
            }
        });

        TxtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSenhaActionPerformed(evt);
            }
        });

        lblStatus.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\icones\\dbok.png"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(menu3)
                            .addComponent(menu2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtCodigo)
                            .addComponent(TxtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(BtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu2)
                    .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu3)
                    .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtLogin)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLoginActionPerformed
        //chamando o método logar()
        logar();
    }//GEN-LAST:event_BtLoginActionPerformed

    private void TxtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSenhaActionPerformed
    
    public void limpar(){
        TxtCodigo.setText("");
        TxtSenha.setText("");
        TxtCodigo.requestFocus();
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_ger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtLogin;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JPasswordField TxtSenha;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel menu2;
    private javax.swing.JLabel menu3;
    // End of variables declaration//GEN-END:variables
}
