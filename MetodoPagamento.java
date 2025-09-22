/**
 * Interface que define o contrato para métodos de pagamento
 */
public interface MetodoPagamento {
    
    /**
     * Processa o pagamento de uma compra
     * @param valor Valor a ser pago
     * @return true se o pagamento foi processado com sucesso, false caso contrário
     */
    boolean processarPagamento(double valor);
    
    /**
     * Retorna o nome do método de pagamento
     * @return Nome do método de pagamento
     */
    String getNome();
    
    /**
     * Verifica se este método de pagamento envia notificação por email
     * @return true se envia notificação, false caso contrário
     */
    boolean enviaNotificacao();
    
    /**
     * Retorna informações específicas do método de pagamento
     * @return String com informações do método
     */
    String getInformacoes();
}

