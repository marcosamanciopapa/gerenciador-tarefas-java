import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void cadastrarTarefa(List<Tarefa> list, int id, String descricao) {
        Tarefa t = new Tarefa(id, descricao);
        list.add(t);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public static void exibirMenu() {
        System.out.println("===== Gerenciador de tarefas =====");
        System.out.println();
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Concluir tarefa");
        System.out.println("0 - Sair");
    }

    public static void listarTarefas(List<Tarefa> list) {
        if (list.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada");
            System.out.println();
        } else {
            System.out.println("===== Tarefas =====");
            list.forEach(tarefa -> {
                        System.out.println("ID: " + tarefa.getId());
                        System.out.println("Descrição: " + tarefa.getDescricao());
                        System.out.println("Tarefa concluída? " + tarefa.isConcluida());
                        System.out.println();
                    }
            );
        }

    }

    public static void concluirTarefa(List<Tarefa> list, int id) {
        for (Tarefa t : list) {
            if (t.getId() == id) {
                t.concluir();
                System.out.println("Tarefa com ID: " + t.getId() + " concluída com sucesso!");
                return;
            }
        }
        System.out.println("Nenhuma tarefa com o ID " + id + " encontrada");
    }

    public static void main(String[] args) {
        int contadorId = 1;
        List<Tarefa> tarefas = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            exibirMenu();
            while (!scan.hasNextInt()) {
                System.out.println("Digite apenas números");
                scan.nextLine();
            }
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite a descrição da tarefa: ");
                    String descricao = scan.nextLine();
                    cadastrarTarefa(tarefas, contadorId, descricao);
                    contadorId++;
                    break;
                case 2:
                    listarTarefas(tarefas);
                    break;
                case 3:
                    if (!tarefas.isEmpty()) {
                        System.out.println("Digite o ID da tarefa que deseja concluir:");
                        while (!scan.hasNextInt()) {
                            System.out.println("Digite apenas números inteiros!");
                            scan.nextLine();
                        }
                        int idParaConcluir = scan.nextInt();
                        scan.nextLine();
                        concluirTarefa(tarefas, idParaConcluir);
                    } else {
                        System.out.println("A lista está vazia.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        scan.close();
    }
}
