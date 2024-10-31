import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Control_ger{

	private Gerente ger;
	private static List<Gerente> controlGerente = new ArrayList<Gerente>();

        public List<Gerente> getControlGerente(){
            return controlGerente;
        }
        
	public Gerente cad_ger(Gerente ger){

		if(cons_ger(ger)== null){
			controlGerente.add(ger);
			return ger;
		}
		else{
			return null;
		}
	}

	public Gerente cons_ger(Gerente ger){
		for(int i = 0; i < controlGerente.size(); i++){
			if(ger.getCod() == controlGerente.get(i).getCod()){
				return controlGerente.get(i);
			}
		}
		return null;
	}

	public Gerente exc_ger(Gerente ger){
                ger = cons_ger(ger);
            	if(ger != null){
                    controlGerente.remove(ger);
                    return null;
		}
		else{
                    return ger;
		}
	}

	public Gerente alt_ger(Gerente ger) throws NumNegException{
		for(int i = 0; i < controlGerente.size(); i++){
			if(ger.getCod() == controlGerente.get(i).getCod()){
                            
                                String nome_ger = JOptionPane.showInputDialog(null, "Informe o novo nome do gerente:", "Atualização", JOptionPane.QUESTION_MESSAGE);
                                ger.setNome(nome_ger);
                                try{
                                    int cod_ger = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o novo código do gerente:", "Atualização", JOptionPane.QUESTION_MESSAGE));
                                    ger.setCod(cod_ger);
                                }
                                catch(NumNegException nne){
                                    nne.impNeg();
                                }
                                catch(NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(null, "O codigo deve ser um numero inteiro", "ERRO de codigo", 0);
                                }
                                
				controlGerente.set(i, ger);  
                                return controlGerente.get(i);
			}
		}
                return null;
	}
}