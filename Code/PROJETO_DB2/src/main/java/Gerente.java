public class Gerente extends Pessoa {

	private int cod_ger;
        private Produto prod;

        public Gerente(){
            cod_ger = 0;
            prod = new Produto();
        }
        
        public int getCod(){
            return cod_ger;
        }
        
        public Produto getProd(){
            return prod;
        }
        
        public void setCod(int cod_ger) throws NumNegException{
            if(cod_ger > 0){
		this.cod_ger = cod_ger;
            }else{
		throw new NumNegException();
            }
	}
        
        public void setProd(Produto prod){
		this.prod = prod;
	}

}
