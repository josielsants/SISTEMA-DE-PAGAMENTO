/**
 * Implementação do método de pagamento por crédito
 */
public class PagamentoCredito implements MetodoPagamento {
    private String numeroCartao;
    private String nomeTitular;
    private String bandeira;
    private int parcelas;
    
    public PagamentoCredito(String numeroCartao, String nomeTitular, String bandeira, int parcelas) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.bandeira = bandeira;
        this.parcelas = parcelas;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento por crédito...");
        System.out.println("Cartão: " + mascararCartao(numeroCartao));
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("Parcelas: " + parcelas);
        System.out.println("Valor total: R$ " + String.format("%.2f", valor));
        
        if (parcelas > 1) {
            double valorParcela = valor / parcelas;
            System.out.println("Valor por parcela: R$ " + String.format("%.2f", valorParcela));
        }
        
        // Simula processamento (sempre retorna true para demonstração)
        try {
            Thread.sleep(1500); // Simula tempo de processamento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Pagamento por crédito processado com sucesso!");
        return true;
    }
    
    @Override
    public String getNome() {
        return "Crédito";
    }
    
    @Override
    public boolean enviaNotificacao() {
        return true; // Crédito envia notificação por email
    }
    
    @Override
    public String getInformacoes() {
        return "Crédito - Cartão: " + mascararCartao(numeroCartao) + " | Bandeira: " + bandeira + " | Parcelas: " + parcelas;
    }
    
    private String mascararCartao(String cartao) {
        if (cartao.length() < 4) return cartao;
        return "**** **** **** " + cartao.substring(cartao.length() - 4);
    }
}

