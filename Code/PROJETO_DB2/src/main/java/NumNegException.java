import javax.swing.JOptionPane;

public class NumNegException extends Exception{

    public void impNeg(){
         JOptionPane.showMessageDialog(null,"O valor inserido deve ser maior que zero!","Erro",-1);
    }
}
