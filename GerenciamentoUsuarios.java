import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GerenciamentoUsuarios {
    
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        usuarios.put("professor", new Professor("prof123"));
        usuarios.put("aluno", new Aluno("aluno123"));

        while (true) {
            System.out.println("Bem-vindo ao sistema de gerenciamento de usuários!");
            System.out.print("Digite seu usuário (professor/aluno): ");
            String usuario = scanner.nextLine().toLowerCase();

            if (usuarios.containsKey(usuario)) {
                System.out.print("Digite sua senha: ");
                String senha = scanner.nextLine();

        
                if (usuarios.get(usuario).verificarSenha(senha)) {
                    System.out.println("Login bem-sucedido!");
                    usuarios.get(usuario).realizarAcoes();
                } else {
                    System.out.println("Senha incorreta.");
                }
            } else {
                System.out.println("Usuário não encontrado.");
            }

            System.out.print("Deseja continuar? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }
    }
}


abstract class Usuario {
    private String nome;
    private String senha;
    boolean executar = false;

    public Usuario(String senha) {
        this.senha = senha;
    }

    
    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }

    
    public abstract void realizarAcoes();
}


class Professor extends Usuario {
    private String materia;
    private Map<String, String> tarefasEnviadas; 
    boolean executar = false;

    public Professor(String senha) {
        super(senha);
        this.tarefasEnviadas = new HashMap<>();
    }

    @Override
    public void realizarAcoes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a matéria que você ensina: ");
        materia = scanner.nextLine();

        while (!executar) {
            System.out.println("\nOpções:");
            System.out.println("1. Enviar tarefa para aluno");
            System.out.println("2. Ver tarefas recebidas dos alunos");
            System.out.println("3. Marcar tarefa como feita por aluno");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String aluno = scanner.nextLine();
                    System.out.print("Digite a tarefa a ser enviada: ");
                    String tarefa = scanner.nextLine();
                    tarefasEnviadas.put(aluno, tarefa);
                    System.out.println("Tarefa enviada com sucesso para o aluno " + aluno);
                    break;
                case 2:
                    System.out.println("Tarefas recebidas dos alunos:");
                    for (Map.Entry<String, String> entry : tarefasEnviadas.entrySet()) {
                        System.out.println("Aluno: " + entry.getKey() + " - Tarefa: " + entry.getValue());
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do aluno: ");
                    aluno = scanner.nextLine();
                    if (tarefasEnviadas.containsKey(aluno)) {
                        tarefasEnviadas.remove(aluno);
                        System.out.println("Tarefa marcada como feita pelo aluno " + aluno);
                    } else {
                        System.out.println("Nenhuma tarefa encontrada para o aluno " + aluno);
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    executar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}


class Aluno extends Usuario {
    private Map<String, String> atividadesRecebidas;
    boolean executar = false; 

    public Aluno(String senha) {
        super(senha);
        this.atividadesRecebidas = new HashMap<>();
    }

    @Override
    public void realizarAcoes() {
        Scanner scanner = new Scanner(System.in);

        while (!executar) {
            System.out.println("\nOpções:");
            System.out.println("1. Enviar atividade para o professor");
            System.out.println("2. Ver atividades enviadas pelo professor");
            System.out.println("3. Marcar atividade como feita");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite a atividade a ser enviada: ");
                    String atividade = scanner.nextLine();
                    atividadesRecebidas.put(atividade, "pendente");
                    System.out.println("Atividade enviada com sucesso para o professor");
                    break;
                case 2:
                    System.out.println("Atividades recebidas do professor:");
                    for (Map.Entry<String, String> entry : atividadesRecebidas.entrySet()) {
                        System.out.println("Atividade: " + entry.getKey() + " - Status: " + entry.getValue());
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome da atividade a ser marcada como feita: ");
                    atividade = scanner.nextLine();
                    if (atividadesRecebidas.containsKey(atividade)) {
                        atividadesRecebidas.put(atividade, "feita");
                        System.out.println("Atividade marcada como feita com sucesso");
                    } else {
                        System.out.println("Atividade não encontrada");
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    executar = true;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
