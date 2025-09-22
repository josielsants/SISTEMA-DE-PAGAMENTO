import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe que representa uma compra no sistema
 */
public class Compra {
    private static int contadorCompras = 1;
    
    private int id;
    private TipoProduto tipoProduto;
    private double valor;
    private MetodoPagamento metodoPagamento;
    private LocalDateTime dataCompra;
    private boolean pagamentoProcessado;
    
    public Compra(TipoProduto tipoProduto, double valor, MetodoPagamento metodoPagamento) {
        this.id = contadorCompras++;
        this.tipoProduto = tipoProduto;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.dataCompra = LocalDateTime.now();
        this.pagamentoProcessado = false;
    }
    
    /**
     * Processa o pagamento da compra
     * @return true se o pagamento foi processado com sucesso
     */
    public boolean processarPagamento() {
        System.out.println("\n=== PROCESSANDO COMPRA #" + id + " ===");
        System.out.println("Produto: " + tipoProduto.getDescricao());
        System.out.println("Valor: R$ " + String.format("%.2f", valor));
        System.out.println("Método: " + metodoPagamento.getNome());
        System.out.println("Data: " + dataCompra.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println();
        
        boolean sucesso = metodoPagamento.processarPagamento(valor);
        
        if (sucesso) {
            this.pagamentoProcessado = true;
            System.out.println("Compra #" + id + " processada com sucesso!");
            
            // Envia notificação se o método de pagamento suporta
            if (metodoPagamento.enviaNotificacao()) {
                enviarNotificacaoEmail();
            }
        } else {
            System.out.println("Falha ao processar pagamento da compra #" + id);
        }
        
        return sucesso;
    }
    
    /**
     * Envia notificação por email sobre o pagamento
     */
    private void enviarNotificacaoEmail() {
        System.out.println("\n--- ENVIANDO NOTIFICAÇÃO POR EMAIL ---");
        System.out.println("Para: cliente@email.com");
        System.out.println("Assunto: Confirmação de Pagamento - Compra #" + id);
        System.out.println("Mensagem:");
        System.out.println("Olá! Seu pagamento foi processado com sucesso.");
        System.out.println("Detalhes da compra:");
        System.out.println("- Produto: " + tipoProduto.getDescricao());
        System.out.println("- Valor: R$ " + String.format("%.2f", valor));
        System.out.println("- Método: " + metodoPagamento.getNome());
        System.out.println("- Data: " + dataCompra.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("- Informações do pagamento: " + metodoPagamento.getInformacoes());
        System.out.println("Obrigado pela sua compra!");
        System.out.println("--- EMAIL ENVIADO ---\n");
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }
    
    public double getValor() {
        return valor;
    }
    
    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }
    
    public LocalDateTime getDataCompra() {
        return dataCompra;
    }
    
    public boolean isPagamentoProcessado() {
        return pagamentoProcessado;
    }
    
    @Override
    public String toString() {
        return String.format("Compra #%d - %s - R$ %.2f - %s - %s", 
            id, 
            tipoProduto.getDescricao(), 
            valor, 
            metodoPagamento.getNome(),
            pagamentoProcessado ? "Processada" : "Pendente"
        );
    }
}

