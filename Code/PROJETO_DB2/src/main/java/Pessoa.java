public abstract class Pessoa {

	private String nome_pes;

        public Pessoa(){
            nome_pes = ""; 
        }
        
        public String getNome(){
            return nome_pes;
        }
        
        public void setNome(String nome_pes){
		this.nome_pes = nome_pes;
	}

}
