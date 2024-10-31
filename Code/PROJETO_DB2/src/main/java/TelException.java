import javax.swing.JOptionPane;

public class TelException extends Exception{
    
    public void impTel(){
        JOptionPane.showMessageDialog(null,"O telefone deve ter 8 ou 9 digitos!","Erro",-1);
    }
}