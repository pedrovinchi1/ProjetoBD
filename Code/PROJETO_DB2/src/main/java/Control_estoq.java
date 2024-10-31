import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Control_estoq{

	private Estoque estq;
	private static List<Estoque> controlEstoque = new ArrayList<Estoque>();

        public List<Estoque> getControlEstoque(){
            return controlEstoque;
        }
        
	public Estoque cad_estq(Estoque estq){

		if(cons_estq(estq)== null){
			controlEstoque.add(estq);
			return estq;
		}
		else{
			return null;
		}
	}

	public Estoque cons_estq(Estoque estq){
		for(int i = 0; i < controlEstoque.size(); i++){
			if(estq.getCodigo_prod() == controlEstoque.get(i).getCodigo_prod()){
				return controlEstoque.get(i);
			}
		}
		return null;
	}

	public Estoque exc_estq(Estoque estq){
                estq = cons_estq(estq);
            	if(estq != null){
                    controlEstoque.remove(estq);
                    return null;
		}
		else{
                    return estq;
		}
	}
}