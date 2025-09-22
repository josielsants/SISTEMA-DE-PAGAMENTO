# Sistema de Pagamento em Java

Este é um sistema completo de pagamento desenvolvido em Java que permite realizar compras e processar diferentes formas de pagamento, incluindo notificações por email.

## Funcionalidades

### ✅ Compra de Produtos
- Suporte a diferentes tipos de produtos (Eletrônicos, Roupas, Livros, Casa e Decoração, Esportes, Alimentos)
- Registro de valor e método de pagamento escolhido
- Controle de data e hora da compra

### 💳 Métodos de Pagamento
- **Débito**: Processamento com cartão de débito
- **Crédito**: Processamento com cartão de crédito (suporte a parcelamento)
- **PIX**: Processamento via PIX (mais rápido)

### 📧 Sistema de Notificações
- Notificações automáticas por email após processamento de pagamento
- Sistema de promoções com envio em massa
- Cadastro de emails para notificações

### 🎯 Características Específicas
- Cada método de pagamento tem suas próprias especificidades
- Débito e Crédito enviam notificações por email
- PIX não envia notificação (comportamento realista)
- Interface interativa para criação de compras
- Processamento em tempo real com simulação de delays

## Estrutura do Projeto

```
sistema-de-pagamento/
├── TipoProduto.java              # Enum para tipos de produtos
├── MetodoPagamento.java          # Interface para métodos de pagamento
├── PagamentoDebito.java          # Implementação do pagamento por débito
├── PagamentoCredito.java         # Implementação do pagamento por crédito
├── PagamentoPix.java             # Implementação do pagamento via PIX
├── Compra.java                   # Classe que representa uma compra
├── SistemaNotificacoes.java      # Sistema de notificações por email
├── SistemaPagamento.java         # Classe principal com menu interativo
└── README.md                     # Este arquivo
```

## Como Executar

### Pré-requisitos
- Java 8 ou superior instalado
- Terminal/Command Prompt

### Passos para Execução

1. **Compile todos os arquivos Java:**
   ```bash
   javac *.java
   ```

2. **Execute o sistema:**
   ```bash
   java SistemaPagamento
   ```

### Execução Alternativa (Windows)
```cmd
# Compilar
javac *.java

# Executar
java SistemaPagamento
```

## Como Usar o Sistema

### 1. Execução Automática
Ao executar o programa, ele automaticamente:
- Cria 4 compras de exemplo
- Processa todas as compras
- Demonstra o sistema de notificações
- Abre o menu interativo

### 2. Menu Interativo
Após a execução automática, você pode:

- **Criar nova compra**: Adicionar compras com diferentes produtos e métodos de pagamento
- **Listar compras**: Ver todas as compras criadas
- **Processar compra específica**: Processar uma compra pendente
- **Adicionar email**: Cadastrar emails para receber notificações
- **Enviar promoção**: Enviar promoções para todos os emails cadastrados
- **Listar emails**: Ver todos os emails cadastrados

### 3. Exemplo de Uso

#### Criando uma Compra
1. Escolha o tipo de produto (1-6)
2. Digite o valor
3. Escolha o método de pagamento (1-3)
4. Preencha os dados específicos do método escolhido
5. Decida se quer processar imediatamente

#### Métodos de Pagamento

**Débito:**
- Número do cartão
- Nome do titular
- Banco

**Crédito:**
- Número do cartão
- Nome do titular
- Bandeira (Visa, Mastercard, etc.)
- Número de parcelas

**PIX:**
- Chave PIX
- Tipo da chave (CPF, Email, Telefone, etc.)
- Banco

## Exemplos de Saída

### Processamento de Compra
```
=== PROCESSANDO COMPRA #1 ===
Produto: Eletrônicos
Valor: R$ 1299,99
Método: Débito
Data: 15/12/2024 14:30:25

Processando pagamento por débito...
Cartão: **** **** **** 3456
Titular: João Silva
Banco: Banco do Brasil
Valor: R$ 1299,99
Pagamento por débito processado com sucesso!
Compra #1 processada com sucesso!

--- ENVIANDO NOTIFICAÇÃO POR EMAIL ---
Para: cliente@email.com
Assunto: Confirmação de Pagamento - Compra #1
...
```

### Notificação de Promoção
```
=== ENVIANDO NOTIFICAÇÕES DE PROMOÇÃO ===
Título: Black Friday 2024!
Desconto: 50%
Válido até: 30/11/2024
Clientes notificados: 3

--- ENVIANDO EMAIL DE PROMOÇÃO ---
Para: cliente1@email.com
Assunto: Black Friday 2024!
Mensagem:
Olá!
Temos uma promoção especial para você:

🎉 Black Friday 2024! 🎉
Aproveite nossa maior promoção do ano!
Desconto de 50% em todos os produtos!
...
```

## Características Técnicas

- **Padrão Strategy**: Diferentes métodos de pagamento implementam a mesma interface
- **Encapsulamento**: Cada classe tem responsabilidades bem definidas
- **Polimorfismo**: Uso de interfaces para diferentes comportamentos
- **Simulação Realista**: Delays e mascaramento de dados sensíveis
- **Interface Amigável**: Menu interativo e mensagens claras

## Extensibilidade

O sistema foi projetado para ser facilmente extensível:

- **Novos tipos de produto**: Adicione novos valores ao enum `TipoProduto`
- **Novos métodos de pagamento**: Implemente a interface `MetodoPagamento`
- **Novos tipos de notificação**: Estenda a classe `SistemaNotificacoes`
- **Persistência**: Adicione camada de banco de dados
- **Interface gráfica**: Crie uma GUI usando Swing ou JavaFX

## Considerações de Segurança

- Números de cartão são mascarados na exibição
- Chaves PIX são parcialmente ocultadas
- Dados sensíveis não são armazenados permanentemente
- Sistema simulado para demonstração (não processa pagamentos reais)

---

**Desenvolvido em Java** | **Sistema de Demonstração** | **2024**

