/**
 * Enum que representa os tipos de produtos disponíveis no sistema
 */
public enum TipoProduto {
    ELETRONICOS("Eletrônicos"),
    ROUPAS("Roupas"),
    LIVROS("Livros"),
    CASA("Casa e Decoração"),
    ESPORTES("Esportes"),
    ALIMENTOS("Alimentos");
    
    private final String descricao;
    
    TipoProduto(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}

