
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {

    private static List<Conta> contas = new ArrayList<>();

    public static List<Conta> getContas() {
        return contas;
    }

    public static void setContas(List<Conta> contas) {
        Banco.contas = contas;
    }

    public static void abrirConta(Scanner scanner, List<Conta> contas) {
        System.out.println("Para a abertura de conta, forneça os seguintes itens:");

        System.out.println("Digite seu nome completo:");
            String nome = scanner.nextLine();

        System.out.println("Digite o número do seu CPF:");
            String documento = scanner.nextLine();

        System.out.println("Digite seu telefone:");
            String tel = scanner.nextLine();

        System.out.println("Digite seu E-mail:");
            String email = scanner.nextLine();

        System.out.println("Digite sua senha:");
            String senha = scanner.nextLine();
        
        System.out.println("Você deseja realizar um primeiro deposito?\n"+
        "1 Sim \n"+
        "2 Não");
            String validaPrimeiroDp = scanner.nextLine();
            double saldo;
        
            if(validaPrimeiroDp.equals("1")){
                System.out.println("Digite seu saldo inicial:");
                    saldo = scanner.nextDouble();
                    scanner.nextLine();
            }
            else if (validaPrimeiroDp.equals("2")){
                System.out.println("Nenhum saldo foi creditado na sua conta!");
                saldo = 0;
            }
            else{
                System.out.println("Operação inválida, nenhum saldo foi creditado na sua conta!");
                saldo = 0;
            }
           

       

        Conta novaConta = new Conta(nome, documento, tel, email, senha, saldo);
        contas.add(novaConta);

        System.out.println("Carregando...");
        System.out.println("Conta criada com sucesso!!");
    }

    public static void fazerLogin(Scanner scanner, List<Conta> contas) {
        System.out.println("Área de login:");
        System.out.println("------------------------------------");

        System.out.println("Digite seu login (CPF):");
        String login = scanner.nextLine();
        System.out.println("------------------------------------");

        System.out.println("Digite sua senha:");
        String senhaTeste = scanner.nextLine();
        System.out.println("------------------------------------");

        System.out.println("Carregando...");

        if (contas.isEmpty()) {
            System.out.println("Não existem contas cadastradas");
        } else {
            boolean loginSucesso = false;
            boolean sairLogin = false;
            for (Conta contaAtual : contas) {
                if (contaAtual.getDocumento().equals(login) && contaAtual.getSenha().equals(senhaTeste)) {
                    System.out.println("------------------------------------");
                    System.out.println("Bem-vindo " + contaAtual.getNome());
                    loginSucesso = true;
                    while (loginSucesso) {
                        
                        System.out.println("------MENU------\n" +
                            "(1)- Ver saldo\n" +
                            "(2)- Depositar\n" +
                            "(3)- Consultar boleto\n" +
                            "(4)- Pagar boleto\n" +
                            "(5)- Sair da conta");
                        String op = scanner.nextLine();

                        switch (op) {
                            case "1":
                                System.out.println(contaAtual.getNome() + " seu saldo é de:\n" + contaAtual.getSaldo() + " reais");
                                break;

                            case "2":
                                System.out.println(contaAtual.getNome() + " qual é o valor que você deseja depositar?");
                                    double deposito = scanner.nextDouble();
                                    scanner.nextLine();

                                if (deposito <= 0) {
                                    System.out.println("Valor invalido !!");

                                }
                                else {
                                    contaAtual.depositar(deposito);
                                    System.out.println("Deposito concluido com sucesso!");
                                    System.out.println("Seu saldo agora é de: " + contaAtual.getSaldo() + " reais.");

                                }
                                break;

                            case "3":
                                System.out.println("Digite a linha digitavel do seu boleto:");
                                    String boleto = scanner.nextLine();
                                    double valor = lerBoleto(boleto);

                                if (valor != 0) {
                                    System.out.println("O valor do seu boleto é de: " + valor + " reais.");

                                }
                                break;

                            case "4":
                                System.out.println("Digite a linha digitavel do seu boleto:");
                                    boleto = scanner.nextLine();
                                    valor = lerBoleto(boleto);

                                if (valor != 0) {
                                    System.out.println("O valor do seu boleto é de: " + valor + " reais, deseja realizar o pagamento?\n" +
                                            "1- Ok\n" +
                                            "2- Cancelar");
                                    String resposta = scanner.nextLine();

                                        if (resposta.equals("1")) {
                                            System.out.println("Processando.....");
                                                if (contaAtual.getSaldo() >= valor) {
                                                    contaAtual.debitar(valor);
                                                    System.out.println("------------------------------------");
                                                    System.out.println("Boleto pago com sucesso");
                                                } else {
                                                    System.out.println("Saldo insuficiente!!");
                                                }
                                        } else if (resposta.equals("2")) {
                                            System.out.println("Cancelando...");

                                        } else {
                                            System.out.println("Operação inválida!!");
                                        }
                                }
                                break;

                            case "5":
                                loginSucesso = false;
                                sairLogin = true;
                                break;

                            default:
                                System.out.println("Operação inválida!!");
                                break;
                        }
                    }

                    break;
                }
            }
            if (!loginSucesso) {
                if (sairLogin){
                    System.out.println("Saindo...");
                    sairLogin = false;
                }
                else{
                    System.out.println("Login ou senha inválidos!");
                }
            }
        }
    }

    public static double lerBoleto(String boleto) {
        if (boleto.length() >= 47 && boleto.length() > 49) {
            String parteInteiraStr = boleto.substring(boleto.length() - 10);

            try {
                double parteInteira = Double.parseDouble(parteInteiraStr);
                double valorDouble = parteInteira / 100.00;
                return valorDouble;
            } catch (NumberFormatException e) {
                System.out.println("Boleto Inválido!");
                return 0;
            }
        } else {
            System.out.println("Boleto Inválido!");
            return 0;
        }
    }

}
