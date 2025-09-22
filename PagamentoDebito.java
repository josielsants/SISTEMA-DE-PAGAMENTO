/**
 * Implementação do método de pagamento por débito
 */
public class PagamentoDebito implements MetodoPagamento {
    private String numeroCartao;
    private String nomeTitular;
    private String banco;
    
    public PagamentoDebito(String numeroCartao, String nomeTitular, String banco) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.banco = banco;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento por débito...");
        System.out.println("Cartão: " + mascararCartao(numeroCartao));
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Banco: " + banco);
        System.out.println("Valor: R$ " + String.format("%.2f", valor));
        
        // Simula processamento (sempre retorna true para demonstração)
        try {
            Thread.sleep(1000); // Simula tempo de processamento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Pagamento por débito processado com sucesso!");
        return true;
    }
    
    @Override
    public String getNome() {
        return "Débito";
    }
    
    @Override
    public boolean enviaNotificacao() {
        return true; // Débito envia notificação por email
    }
    
    @Override
    public String getInformacoes() {
        return "Débito - Cartão: " + mascararCartao(numeroCartao) + " | Banco: " + banco;
    }
    
    private String mascararCartao(String cartao) {
        if (cartao.length() < 4) return cartao;
        return "**** **** **** " + cartao.substring(cartao.length() - 4);
    }
}

