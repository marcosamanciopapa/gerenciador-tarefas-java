import java.util.Scanner;

public class Main {
    public static void exibirMenu(){
        System.out.println("===== Gerenciador de tarefas =====");
        System.out.println();
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Concluir tarefa");
        System.out.println("4 - Remover tarefa");
        System.out.println("0 - Sair");
        System.out.println();
        System.out.println("Escolha uma opção:");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao;
        do{
            exibirMenu();
            opcao = scan.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Tarefa adicionada");
                    break;
                case 2:
                    System.out.println("Listar tarefas");
                    break;
                case 3:
                    System.out.println("Concluir tarefa");
                    break;
                case 4:
                    System.out.println("Remover tarefa");
                    break;
                case 0:
                     System.out.println("Sair");
                     break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao != 0);
        scan.close();
    }
}
