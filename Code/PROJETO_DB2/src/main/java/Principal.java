import java.sql.*;
import br.com.projetoapoo.dal.ModuloConexao_assistente;
import javax.swing.*;
import java.awt.*;

public class Principal extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void logar(){
        String sql = "select * from tbassistente where ass_codigo = ? and ass_senha = ?";
        try {
            //as linhas abaixo preparam a consulta ao banco em função do que foi
            //digitado nas caixas de texto. O ? é substituido pelos conteúdos das variáveis
            pst = conexao.prepareStatement(sql);
            String captura = new String(TxtSenha.getPassword());
            pst.setString(2, captura);
            try{
                pst.setInt(1, Integer.parseInt(TxtLogin.getText()));
            }catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Digite apenas os números do campo Código!", "ERRO de Código", 0);
            }
            
            //a linha abaixo executa a query
            rs = pst.executeQuery();
            //se existir usuario e senha correspondente
            if(rs.next()){
                Tela_InicialAss inicial = new Tela_InicialAss(rs.getInt(1));
                inicial.setVisible(true);
                View_Inicial view = new View_Inicial();
                view.setVisible(true);
                view.pnlMenu.setSize(185, 60);
                view.lstMenu.setSize(0, 0);
                inicial.desktop.add(view);
                Tela_InicialAss.lblUsuario.setText(rs.getString(2));
                this.dispose();
                conexao.close();
            } else{
                JOptionPane.showMessageDialog(null, "Login e/ou senha inválido(s)");
                limpar();
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            limpar();
            //this.dispose();
        }
    }
    
    public Principal() {
        initComponents();
        conexao = ModuloConexao_assistente.conector();
        System.out.println(conexao);
        if(conexao != null){
            lblStatus.setText("Conectado");
            lblStatus.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\icones\\dbok.png"));
        } else{
            lblStatus.setText("Não Conectado");
            lblStatus.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\icones\\dberror.png"));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu2 = new javax.swing.JLabel();
        menu3 = new javax.swing.JLabel();
        TxtLogin = new javax.swing.JTextField();
        BtLogin = new javax.swing.JButton();
        TxtSenha = new javax.swing.JPasswordField();
        lblStatus = new javax.swing.JLabel();
        menu4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        LoginGer = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projeto - Login");
        setResizable(false);

        menu2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menu2.setText("Login:");

        menu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menu3.setText("Senha:");

        TxtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLoginActionPerformed(evt);
            }
        });

        BtLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtLogin.setText("Login");
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

        menu4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menu4.setText("Assistente");

        jMenu2.setText("Gerência");

        LoginGer.setSelected(true);
        LoginGer.setText("Acessar Gerência");
        LoginGer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginGerActionPerformed(evt);
            }
        });
        jMenu2.add(LoginGer);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(menu2)
                                    .addComponent(menu3)
                                    .addComponent(lblStatus))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(TxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(menu4)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(menu4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu2)
                    .addComponent(TxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu3)
                    .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtLogin)
                    .addComponent(lblStatus))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(495, 280));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLoginActionPerformed
        //chamando o método logar()
        logar();
    }//GEN-LAST:event_BtLoginActionPerformed

    private void TxtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSenhaActionPerformed

    private void LoginGerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginGerActionPerformed
        abreBoundary_ger();
        limpar();
    }//GEN-LAST:event_LoginGerActionPerformed

    private void TxtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLoginActionPerformed

    public void limpar(){
        TxtLogin.setText("");
        TxtSenha.setText("");
        TxtLogin.requestFocus();
    }
    
    public void abreBoundary_ger(){
        Login_ger.getLogin_ger().setVisible(true);
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtLogin;
    private javax.swing.JRadioButtonMenuItem LoginGer;
    private javax.swing.JTextField TxtLogin;
    private javax.swing.JPasswordField TxtSenha;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel menu2;
    private javax.swing.JLabel menu3;
    private javax.swing.JLabel menu4;
    // End of variables declaration//GEN-END:variables
}
