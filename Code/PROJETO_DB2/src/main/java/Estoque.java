public class Estoque {

	private int codigo_prod;
	private int quant_prod;

        public Estoque(){
            codigo_prod = 0;
            quant_prod = 0;
        }
        
        public int getCodigo_prod(){
            return codigo_prod;
        }
        
        public int getQuant_prod(){
            return quant_prod;
        }
        
        public void setCodigo_prod(int codigo_prod) throws NumNegException{
            if(codigo_prod > 0){
		this.codigo_prod = codigo_prod;
            }else{
		throw new NumNegException();
            }
	}
        
        public void setQuant_prod(int quant_prod) throws NumNegException{
            if(quant_prod > 0){
		this.quant_prod = quant_prod;
            }else{
		throw new NumNegException();
            }
	}
        
	public void cons_estoq() {

	}

	public void adic_prod() {

	}

	public void ret_prod() {

	}

}
