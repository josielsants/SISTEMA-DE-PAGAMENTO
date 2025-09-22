import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Sistema responsável por enviar notificações de promoções por email
 */
public class SistemaNotificacoes {
    private List<String> emailsClientes;
    
    public SistemaNotificacoes() {
        this.emailsClientes = new ArrayList<>();
    }
    
    /**
     * Adiciona um email à lista de notificações
     * @param email Email do cliente
     */
    public void adicionarEmail(String email) {
        if (!emailsClientes.contains(email)) {
            emailsClientes.add(email);
            System.out.println("Email " + email + " adicionado à lista de notificações.");
        }
    }
    
    /**
     * Remove um email da lista de notificações
     * @param email Email do cliente
     */
    public void removerEmail(String email) {
        if (emailsClientes.remove(email)) {
            System.out.println("Email " + email + " removido da lista de notificações.");
        } else {
            System.out.println("Email " + email + " não encontrado na lista.");
        }
    }
    
    /**
     * Envia notificação de promoção para todos os clientes cadastrados
     * @param titulo Título da promoção
     * @param descricao Descrição da promoção
     * @param desconto Percentual de desconto
     * @param dataValidade Data de validade da promoção
     */
    public void enviarPromocao(String titulo, String descricao, double desconto, String dataValidade) {
        System.out.println("\n=== ENVIANDO NOTIFICAÇÕES DE PROMOÇÃO ===");
        System.out.println("Título: " + titulo);
        System.out.println("Desconto: " + String.format("%.0f%%", desconto));
        System.out.println("Válido até: " + dataValidade);
        System.out.println("Clientes notificados: " + emailsClientes.size());
        System.out.println();
        
        for (String email : emailsClientes) {
            enviarEmailPromocao(email, titulo, descricao, desconto, dataValidade);
        }
        
        System.out.println("=== NOTIFICAÇÕES ENVIADAS ===");
    }
    
    /**
     * Envia email de promoção para um cliente específico
     * @param email Email do cliente
     * @param titulo Título da promoção
     * @param descricao Descrição da promoção
     * @param desconto Percentual de desconto
     * @param dataValidade Data de validade da promoção
     */
    private void enviarEmailPromocao(String email, String titulo, String descricao, double desconto, String dataValidade) {
        System.out.println("--- ENVIANDO EMAIL DE PROMOÇÃO ---");
        System.out.println("Para: " + email);
        System.out.println("Assunto: " + titulo);
        System.out.println("Mensagem:");
        System.out.println("Olá!");
        System.out.println("Temos uma promoção especial para você:");
        System.out.println();
        System.out.println("🎉 " + titulo + " 🎉");
        System.out.println(descricao);
        System.out.println("Desconto de " + String.format("%.0f%%", desconto) + " em todos os produtos!");
        System.out.println("Válido até: " + dataValidade);
        System.out.println();
        System.out.println("Não perca essa oportunidade!");
        System.out.println("Acesse nosso site e aproveite!");
        System.out.println();
        System.out.println("Atenciosamente,");
        System.out.println("Equipe de Vendas");
        System.out.println("Data: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("--- EMAIL ENVIADO ---\n");
    }
    
    /**
     * Lista todos os emails cadastrados
     */
    public void listarEmails() {
        System.out.println("=== LISTA DE EMAILS CADASTRADOS ===");
        if (emailsClientes.isEmpty()) {
            System.out.println("Nenhum email cadastrado.");
        } else {
            for (int i = 0; i < emailsClientes.size(); i++) {
                System.out.println((i + 1) + ". " + emailsClientes.get(i));
            }
        }
        System.out.println("Total: " + emailsClientes.size() + " emails");
        System.out.println();
    }
    
    /**
     * Retorna o número de emails cadastrados
     * @return Número de emails
     */
    public int getTotalEmails() {
        return emailsClientes.size();
    }
}

