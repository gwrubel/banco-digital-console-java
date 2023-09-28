
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean executando = true;
        Scanner scanner = new Scanner(System.in);
        

        while (executando) {
            System.out.println("Olá, bem-vindo ao banco digital\n"+
                    "--------------------------------\n"+
                    "Digite a operação que deseja fazer:\n" +
                    "(1)- Abertura de conta\n" +
                    "(2)- Fazer login\n" +
                    "(3)- Sair");

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                   Banco.abrirConta(scanner, Banco.getContas());
                    break;
                case 2:
                    Banco.fazerLogin(scanner, Banco.getContas());
                    break;
                case 3:
                    System.out.println("Saindo...");
                    executando = false;
                    break;
                default:
                System.out.println("Operação invalida!");
                    break;
            }
        }
    }

 

  
}
