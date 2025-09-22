/**
 * Implementação do método de pagamento via PIX
 */
public class PagamentoPix implements MetodoPagamento {
    private String chavePix;
    private String tipoChave;
    private String banco;
    
    public PagamentoPix(String chavePix, String tipoChave, String banco) {
        this.chavePix = chavePix;
        this.tipoChave = tipoChave;
        this.banco = banco;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento via PIX...");
        System.out.println("Chave PIX: " + mascararChavePix(chavePix));
        System.out.println("Tipo de chave: " + tipoChave);
        System.out.println("Banco: " + banco);
        System.out.println("Valor: R$ " + String.format("%.2f", valor));
        
        // Simula processamento (sempre retorna true para demonstração)
        try {
            Thread.sleep(500); // PIX é mais rápido
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Pagamento via PIX processado com sucesso!");
        return true;
    }
    
    @Override
    public String getNome() {
        return "PIX";
    }
    
    @Override
    public boolean enviaNotificacao() {
        return false; // PIX não envia notificação por email (geralmente)
    }
    
    @Override
    public String getInformacoes() {
        return "PIX - Chave: " + mascararChavePix(chavePix) + " | Tipo: " + tipoChave + " | Banco: " + banco;
    }
    
    private String mascararChavePix(String chave) {
        if (chave.length() < 4) return chave;
        return chave.substring(0, 4) + "****" + chave.substring(chave.length() - 4);
    }
}

