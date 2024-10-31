import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Control_prod{

	private Produto prod;
	private static List<Produto> controlProduto = new ArrayList<Produto>();

        public List<Produto> getControlProduto(){
            return controlProduto;
        }
        
	public Produto cad_prod(Produto prod){

		if(cons_prod(prod)== null){
			controlProduto.add(prod);
			return prod;
		}
		else{
			return null;
		}
	}

	public Produto cons_prod(Produto prod){
		for(int i = 0; i < controlProduto.size(); i++){
			if(prod.getCodigo_prod() == controlProduto.get(i).getCodigo_prod()){
				return controlProduto.get(i);
			}
		}
		return null;
	}

	public Produto exc_prod(Produto prod){
                prod = cons_prod(prod);
            	if(prod != null){
                    controlProduto.remove(prod);
                    return null;
		}
		else{
                    return prod;
		}
	}
        
        public Produto alt_prod(Produto prod){
		for(int i = 0; i < controlProduto.size(); i++){
			if(prod.getCodigo_prod() == controlProduto.get(i).getCodigo_prod()){
                            
                                String nome_prod = JOptionPane.showInputDialog(null, "Informe o novo nome do produto:", "Atualização", JOptionPane.QUESTION_MESSAGE);
                                prod.setNome_prod(nome_prod);
                                String descricao_prod = JOptionPane.showInputDialog(null, "Informe a nova descricao do produto:", "Atualização", JOptionPane.QUESTION_MESSAGE);
                                prod.setDescricao_prod(descricao_prod);
                                try{
                                    int codigo_prod = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o novo código do Produto:", "Atualização", JOptionPane.QUESTION_MESSAGE));
                                    prod.setCodigo_prod(codigo_prod);
                                }
                                catch(NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(null, "O codigo deve ser um numero inteiro", "ERRO de codigo", 0);
                                }
                                try{
                                    double preco_prod = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o novo preco do Produto:", "Atualização", JOptionPane.QUESTION_MESSAGE));
                                    prod.setPreco_prod(preco_prod);
                                }
                                catch(NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(null, "O preco deve ser um numero decimal", "ERRO de preco", 0);
                                }
                                try{
                                    String marca_prod = JOptionPane.showInputDialog(null, "Informe a nova unidade do Produto:", "Atualização", JOptionPane.QUESTION_MESSAGE);
                                    prod.setMarca_prod(marca_prod);
                                }
                                catch(NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(null, "A unidade deve ser um numero decimal", "ERRO da unidade", 0);
                                }
                                
				controlProduto.set(i, prod);  
                                return controlProduto.get(i);
			}
		}
                return null;
	}
}