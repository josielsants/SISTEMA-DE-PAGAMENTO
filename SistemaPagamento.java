import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal que demonstra o sistema de pagamento
 */
public class SistemaPagamento {
    private List<Compra> compras;
    private SistemaNotificacoes sistemaNotificacoes;
    private Scanner scanner;
    
    public SistemaPagamento() {
        this.compras = new ArrayList<>();
        this.sistemaNotificacoes = new SistemaNotificacoes();
        this.scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        SistemaPagamento sistema = new SistemaPagamento();
        sistema.executar();
    }
    
    /**
     * Executa o sistema principal
     */
    public void executar() {
        System.out.println("=== SISTEMA DE PAGAMENTO ===");
        System.out.println("Bem-vindo ao sistema de pagamentos!");
        System.out.println();
        
        // Adiciona alguns emails para demonstração
        sistemaNotificacoes.adicionarEmail("cliente1@email.com");
        sistemaNotificacoes.adicionarEmail("cliente2@email.com");
        sistemaNotificacoes.adicionarEmail("cliente3@email.com");
        
        // Cria algumas compras de exemplo
        criarComprasExemplo();
        
        // Processa as compras
        processarCompras();
        
        // Demonstra o sistema de notificações
        demonstrarNotificacoes();
        
        // Menu interativo
        menuInterativo();
        
        scanner.close();
    }
    
    /**
     * Cria algumas compras de exemplo para demonstração
     */
    private void criarComprasExemplo() {
        System.out.println("=== CRIANDO COMPRAS DE EXEMPLO ===");
        
        // Compra 1 - Eletrônicos com débito
        MetodoPagamento debito = new PagamentoDebito("1234567890123456", "João Silva", "Banco do Brasil");
        Compra compra1 = new Compra(TipoProduto.ELETRONICOS, 1299.99, debito);
        compras.add(compra1);
        System.out.println("Compra criada: " + compra1);
        
        // Compra 2 - Roupas com crédito
        MetodoPagamento credito = new PagamentoCredito("9876543210987654", "Maria Santos", "Visa", 3);
        Compra compra2 = new Compra(TipoProduto.ROUPAS, 299.90, credito);
        compras.add(compra2);
        System.out.println("Compra criada: " + compra2);
        
        // Compra 3 - Livros com PIX
        MetodoPagamento pix = new PagamentoPix("joao.silva@email.com", "Email", "Nubank");
        Compra compra3 = new Compra(TipoProduto.LIVROS, 89.90, pix);
        compras.add(compra3);
        System.out.println("Compra criada: " + compra3);
        
        // Compra 4 - Casa e Decoração com crédito
        MetodoPagamento credito2 = new PagamentoCredito("1111222233334444", "Pedro Costa", "Mastercard", 1);
        Compra compra4 = new Compra(TipoProduto.CASA, 450.00, credito2);
        compras.add(compra4);
        System.out.println("Compra criada: " + compra4);
        
        System.out.println("Total de compras criadas: " + compras.size());
        System.out.println();
    }
    
    /**
     * Processa todas as compras pendentes
     */
    private void processarCompras() {
        System.out.println("=== PROCESSANDO COMPRAS ===");
        
        for (Compra compra : compras) {
            compra.processarPagamento();
            System.out.println();
        }
        
        System.out.println("=== TODAS AS COMPRAS FORAM PROCESSADAS ===");
        System.out.println();
    }
    
    /**
     * Demonstra o sistema de notificações
     */
    private void demonstrarNotificacoes() {
        System.out.println("=== DEMONSTRANDO SISTEMA DE NOTIFICAÇÕES ===");
        
        // Lista emails cadastrados
        sistemaNotificacoes.listarEmails();
        
        // Envia promoção
        sistemaNotificacoes.enviarPromocao(
            "Black Friday 2024!",
            "Aproveite nossa maior promoção do ano!",
            50.0,
            "30/11/2024"
        );
        
        // Envia outra promoção
        sistemaNotificacoes.enviarPromocao(
            "Promoção de Natal",
            "Presentes perfeitos para toda a família!",
            30.0,
            "25/12/2024"
        );
    }
    
    /**
     * Menu interativo para o usuário
     */
    private void menuInterativo() {
        int opcao;
        
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Criar nova compra");
            System.out.println("2. Listar compras");
            System.out.println("3. Processar compra específica");
            System.out.println("4. Adicionar email para notificações");
            System.out.println("5. Enviar promoção");
            System.out.println("6. Listar emails cadastrados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                
                switch (opcao) {
                    case 1:
                        criarNovaCompra();
                        break;
                    case 2:
                        listarCompras();
                        break;
                    case 3:
                        processarCompraEspecifica();
                        break;
                    case 4:
                        adicionarEmail();
                        break;
                    case 5:
                        enviarPromocao();
                        break;
                    case 6:
                        sistemaNotificacoes.listarEmails();
                        break;
                    case 0:
                        System.out.println("Obrigado por usar o sistema!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.nextLine(); // Limpa o buffer
                opcao = -1;
            }
        } while (opcao != 0);
    }
    
    /**
     * Cria uma nova compra através do menu interativo
     */
    private void criarNovaCompra() {
        System.out.println("\n=== CRIAR NOVA COMPRA ===");
        
        // Seleciona tipo de produto
        System.out.println("Tipos de produto disponíveis:");
        TipoProduto[] tipos = TipoProduto.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ". " + tipos[i].getDescricao());
        }
        
        System.out.print("Escolha o tipo de produto (1-" + tipos.length + "): ");
        int tipoIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (tipoIndex < 0 || tipoIndex >= tipos.length) {
            System.out.println("Tipo de produto inválido!");
            return;
        }
        
        // Solicita valor
        System.out.print("Digite o valor da compra: R$ ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        // Seleciona método de pagamento
        System.out.println("Métodos de pagamento disponíveis:");
        System.out.println("1. Débito");
        System.out.println("2. Crédito");
        System.out.println("3. PIX");
        System.out.print("Escolha o método (1-3): ");
        int metodoIndex = scanner.nextInt();
        scanner.nextLine();
        
        MetodoPagamento metodo = null;
        
        switch (metodoIndex) {
            case 1:
                System.out.print("Número do cartão: ");
                String numeroCartao = scanner.nextLine();
                System.out.print("Nome do titular: ");
                String nomeTitular = scanner.nextLine();
                System.out.print("Banco: ");
                String banco = scanner.nextLine();
                metodo = new PagamentoDebito(numeroCartao, nomeTitular, banco);
                break;
            case 2:
                System.out.print("Número do cartão: ");
                String numeroCartaoCred = scanner.nextLine();
                System.out.print("Nome do titular: ");
                String nomeTitularCred = scanner.nextLine();
                System.out.print("Bandeira: ");
                String bandeira = scanner.nextLine();
                System.out.print("Número de parcelas: ");
                int parcelas = scanner.nextInt();
                scanner.nextLine();
                metodo = new PagamentoCredito(numeroCartaoCred, nomeTitularCred, bandeira, parcelas);
                break;
            case 3:
                System.out.print("Chave PIX: ");
                String chavePix = scanner.nextLine();
                System.out.print("Tipo da chave: ");
                String tipoChave = scanner.nextLine();
                System.out.print("Banco: ");
                String bancoPix = scanner.nextLine();
                metodo = new PagamentoPix(chavePix, tipoChave, bancoPix);
                break;
            default:
                System.out.println("Método de pagamento inválido!");
                return;
        }
        
        // Cria a compra
        Compra novaCompra = new Compra(tipos[tipoIndex], valor, metodo);
        compras.add(novaCompra);
        
        System.out.println("Compra criada com sucesso!");
        System.out.println(novaCompra);
        
        // Pergunta se quer processar imediatamente
        System.out.print("Deseja processar o pagamento agora? (s/n): ");
        String resposta = scanner.nextLine().toLowerCase();
        if (resposta.equals("s") || resposta.equals("sim")) {
            novaCompra.processarPagamento();
        }
    }
    
    /**
     * Lista todas as compras
     */
    private void listarCompras() {
        System.out.println("\n=== LISTA DE COMPRAS ===");
        if (compras.isEmpty()) {
            System.out.println("Nenhuma compra encontrada.");
        } else {
            for (Compra compra : compras) {
                System.out.println(compra);
            }
        }
    }
    
    /**
     * Processa uma compra específica
     */
    private void processarCompraEspecifica() {
        System.out.println("\n=== PROCESSAR COMPRA ESPECÍFICA ===");
        listarCompras();
        
        if (compras.isEmpty()) {
            return;
        }
        
        System.out.print("Digite o ID da compra para processar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Compra compra = compras.stream()
            .filter(c -> c.getId() == id)
            .findFirst()
            .orElse(null);
        
        if (compra != null) {
            if (compra.isPagamentoProcessado()) {
                System.out.println("Esta compra já foi processada!");
            } else {
                compra.processarPagamento();
            }
        } else {
            System.out.println("Compra não encontrada!");
        }
    }
    
    /**
     * Adiciona um email para notificações
     */
    private void adicionarEmail() {
        System.out.println("\n=== ADICIONAR EMAIL ===");
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        sistemaNotificacoes.adicionarEmail(email);
    }
    
    /**
     * Envia uma promoção
     */
    private void enviarPromocao() {
        System.out.println("\n=== ENVIAR PROMOÇÃO ===");
        System.out.print("Título da promoção: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Percentual de desconto: ");
        double desconto = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Data de validade (dd/mm/aaaa): ");
        String dataValidade = scanner.nextLine();
        
        sistemaNotificacoes.enviarPromocao(titulo, descricao, desconto, dataValidade);
    }
}

