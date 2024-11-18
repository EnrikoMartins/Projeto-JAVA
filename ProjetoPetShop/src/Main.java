import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        PostgresConnection postgresConnection = new PostgresConnection();
        Connection connection = postgresConnection.getInstance();

    }

}

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animais = new ArrayList<>();
        ArrayList<Adotante> adotantes = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Sistema de Adoção ===");
            System.out.println("1. Cadastrar Animal");
            System.out.println("2. Cadastrar Adotante");
            System.out.println("3. Listar Animais");
            System.out.println("4. Realizar Adoção");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID do Animal: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Gênero (M/F): ");
                    String genero = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Raça: ");
                    String raca = scanner.nextLine();
                    System.out.print("Tipo (Gato ou Cachorro): ");
                    String tipo = scanner.nextLine();

                    animais.add(new Animal(id, nome, raca, idade, genero, tipo));
                    System.out.println("Animal cadastrado com sucesso!");
                }
                case 2 -> {
                    System.out.print("Nome do Adotante: ");
                    String nome = scanner.nextLine();
                    System.out.print("Contato: ");
                    String contato = scanner.nextLine();
                    adotantes.add(new Adotante(nome, contato));
                    System.out.println("Adotante cadastrado com sucesso!");
                }
                case 3 -> {
                    if (animais.isEmpty()) {
                        System.out.println("Nenhum animal cadastrado.");
                    } else {
                        for (Animal animal : animais) {
                            System.out.println(animal);
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Nome do Animal para adoção: ");
                    String nomeAnimal = scanner.nextLine();
                    System.out.print("Nome do Adotante: ");
                    String nomeAdotante = scanner.nextLine();

                    Animal animal = animais.stream()
                            .filter(a -> a.getNome().equalsIgnoreCase(nomeAnimal) && !a.isAdotado())
                            .findFirst()
                            .orElse(null);

                    if (animal == null) {
                        System.out.println("Animal não encontrado ou já adotado.");
                        break;
                    }

                    Adotante adotante = adotantes.stream()
                            .filter(a -> a.getNome().equalsIgnoreCase(nomeAdotante))
                            .findFirst()
                            .orElse(null);

                    if (adotante == null) {
                        System.out.println("Adotante não encontrado.");
                        break;
                    }

                    animal.setAdotado(true);
                    System.out.println("Adoção realizada! " + adotante.getNome() + " adotou " + animal.getNome());
                }
                case 5 -> {
                    System.out.println("Saindo do sistema...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
