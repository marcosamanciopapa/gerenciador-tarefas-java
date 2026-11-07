import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
        System.out.println("4 - Remover tarefa");
        System.out.println("5 - Editar tarefa");
        System.out.println("6 - Listar tarefas pendentes");
        System.out.println("7 - Listar tarefas concluídas");
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

    public static void removerTarefa(List<Tarefa> list, int id) {
        Iterator<Tarefa> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                System.out.println("Tarefa com ID " + id + " removida com sucesso!");
                return;
            }
        }
        System.out.println("Nenhuma tarefa com o  ID " + id + " foi encontrada");
    }

    public static void editarTarefa(Tarefa tarefa, String novaDescricao) {
        tarefa.setDescricao(novaDescricao);
        System.out.println("Tarefa editada com sucesso!");
    }

    public static Tarefa buscarTarefaPorId(List<Tarefa> list, int id) {
        for (Tarefa t : list) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public static void listarTarefasPendentes(List<Tarefa> list) {
        boolean peloMenosUmaTarefaPendente = false;
        for (Tarefa t : list) {
            if (!t.isConcluida()) {
                if (!peloMenosUmaTarefaPendente) {
                    System.out.println("===== Tarefas Pendentes =====");
                }
                System.out.println("ID: " + t.getId() + " Descricao: " + t.getDescricao());
                System.out.println();
                peloMenosUmaTarefaPendente = true;
            }
        }
        if (!peloMenosUmaTarefaPendente) {
            System.out.println("Nenhuma tarefa está pendente!");
        }
    }

    public static void listarTarefasConcluidas(List<Tarefa> list) {
        boolean peloMenosUmaTarefaConcluida = false;
        for (Tarefa t : list) {
            if (t.isConcluida()) {
                if (!peloMenosUmaTarefaConcluida) {
                    System.out.println("===== Tarefas Concluidas =====");
                }
                System.out.println("ID: " + t.getId() + " Descricao: " + t.getDescricao());
                System.out.println();
                peloMenosUmaTarefaConcluida = true;
            }
        }
        if (!peloMenosUmaTarefaConcluida) {
            System.out.println("Não há tarefas concluídas!");
        }
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
                case 4:
                    if (tarefas.isEmpty()) {
                        System.out.println("A lista está vazia.");
                        break;
                    }
                    System.out.println("Digite o ID da tarefa que deseja remover:");
                    while (!scan.hasNextInt()) {
                        System.out.println("Digite apenas números inteiros!");
                        scan.nextLine();
                    }
                    int idParaRemover = scan.nextInt();
                    scan.nextLine();
                    removerTarefa(tarefas, idParaRemover);
                    break;
                case 5:
                    if (tarefas.isEmpty()) {
                        System.out.println("A lista de tarefas está vazia");
                        break;
                    }
                    System.out.println("Digite o ID da tarefa que deseja editar:");
                    while (!scan.hasNextInt()) {
                        System.out.println("Digite apenas números inteiros!");
                        scan.nextLine();
                    }
                    int idParaEditar = scan.nextInt();
                    scan.nextLine();
                    Tarefa tarefaEncontrada = buscarTarefaPorId(tarefas, idParaEditar);
                    if (tarefaEncontrada != null) {
                        System.out.println("Digite a nova descrição da tarefa:");
                        String novaDescricao = scan.nextLine();
                        editarTarefa(tarefaEncontrada, novaDescricao);
                        break;
                    }
                    System.out.println("ID não corresponde a nenhuma tarefa da lista!");
                    break;
                case 6:
                    if (tarefas.isEmpty()) {
                        System.out.println("A lista de tarefas está vazia");
                        break;
                    }
                    listarTarefasPendentes(tarefas);
                    break;
                case 7:
                    if (tarefas.isEmpty()) {
                        System.out.println("A lista de tarefas está vazia");
                        break;
                    }
                    listarTarefasConcluidas(tarefas);
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
