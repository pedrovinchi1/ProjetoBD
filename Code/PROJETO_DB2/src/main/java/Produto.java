public class Produto {

	private int codigo_prod;
	private String nome_prod;  
	private double preco_prod;
        private String descricao_prod;
        private String marca_prod;
        private String categoria_prod;
        private String modelo_prod;
        private String fornecedor_prod;
        
        public Produto(){
            codigo_prod = 0;
            nome_prod = "";
            preco_prod = 0;
            descricao_prod = "";
            marca_prod = "";
            categoria_prod = "";
            modelo_prod = "";
            fornecedor_prod = "";
        }

        public int getCodigo_prod(){
            return codigo_prod;
        }
        
        public String getNome_prod(){
            return nome_prod;
        }
        
        public double getPreco_prod(){
            return preco_prod;
        }
        
        public void setCodigo_prod(int codigo_prod){
            this.codigo_prod = codigo_prod;
	}
        
        public void setNome_prod(String nome_prod){
		this.nome_prod = nome_prod;
	}
        
        public void setPreco_prod(double preco_prod){
            this.preco_prod = preco_prod;
	}
        
        public String getDescricao_prod(){
            return descricao_prod;
        }
        
        public void setDescricao_prod(String descricao_prod){
            this.descricao_prod = descricao_prod;
	}
        
        public String getMarca_prod(){
            return marca_prod;
        }
        
        public void setMarca_prod(String marca_prod){
            this.marca_prod = marca_prod;
	}
        
        public String getCategoria_prod(){
            return categoria_prod;
        }
        
        public void setCategoria_prod(String categoria_prod){
            this.categoria_prod = categoria_prod;
	}
        
        public String getModelo_prod(){
            return modelo_prod;
        }
        
        public void setModelo_prod(String modelo_prod){
            this.modelo_prod = modelo_prod;
	}
        
        public String getFornecedor_prod(){
            return fornecedor_prod;
        }
        
        public void setFornecedor_prod(String fornecedor_prod){
            this.fornecedor_prod = fornecedor_prod;
	}
}
