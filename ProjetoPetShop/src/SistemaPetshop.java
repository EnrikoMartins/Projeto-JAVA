import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SistemaPetshop {
    Scanner scanner = new Scanner(System.in);
    AnimalService animalService = new AnimalService();
    AdotanteService adotanteService = new AdotanteService();

    private void linha() {
        System.out.println("-----------------------------------");
    }

    public int menuPrincipal() {
        int resposta;

        System.out.println("Menu: ");
        linha();

        System.out.println("1. Entrar como Gerente");
        System.out.println("2. Entrar como Cliente");
        System.out.println("3. Sair");
        linha();

        System.out.print("Resposta: ");
        resposta = scanner.nextInt();
        scanner.nextLine();

        return resposta;
    }

    public void listarAnimais() {
        for (Animal animal : animalService.listAllAnimals()) {
            System.out.println(animal.getNome() + " - Adotado: " + animal.isAdotado());
        }
    }

    public void logicaSistema(int resposta, List<Pessoa> adotantes, List<Pessoa> voluntarios) {
        switch (resposta) {
            case 1: {
                do {
                    System.out.println("\n=== Sistema de Gerenciamento ===");
                    linha();

                    System.out.println("1. Cadastrar Animal");
                    System.out.println("2. Cadastrar Adotante");
                    System.out.println("3. Listar Adotantes");
                    System.out.println("4. Listar Animais");
                    System.out.println("5. Sair");
                    linha();

                    System.out.print("Escolha uma opção: ");
                    resposta = scanner.nextInt();
                    scanner.nextLine();

                switch (resposta) {
                    case 1: {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Raça: ");
                        String raca = scanner.nextLine();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Gênero (M/F): ");
                        String genero = scanner.nextLine();

                        System.out.print("Tipo: ");
                        String tipo = scanner.nextLine().toLowerCase(Locale.ROOT);

                        animalService.addAnimal(nome, raca, idade, genero, tipo);
                        break;
                    }
                    case 2: {
                        System.out.print("Nome do Adotante: ");
                        String nome = scanner.nextLine();

                        System.out.print("Profissão: ");
                        String profissao = scanner.nextLine();

                        System.out.print("Gênero: ");
                        String genero = scanner.nextLine();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();

                        System.out.print("Contato: ");
                        String contato = scanner.nextLine();

                        adotanteService.addAdotante(nome, profissao, genero, idade, contato);
                        System.out.println("Adotante cadastrado com sucesso!");
                        break;
                    }

                    case 3: {
                        System.out.println("Lista de Adotantes:");
                        adotanteService.listAllAdotantes().forEach(adotante -> {
                            System.out.println(adotante.getNome() + " - Contato: " + adotante.getContato());
                        });
                    }

                    case 4: {
                        listarAnimais();
                        break;
                    }

                    case 5: {
                        logicaSistema(menuPrincipal(), adotantes, voluntarios);
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                        break;
                    }
                }

                } while (resposta != 4 );
                break;
            }
            case 2: {
                do {
                    System.out.println("\n=== Sistema de Adoção ===");
                    linha();

                    System.out.println("1. Realizar Adoção");
                    System.out.println("2. Listar Animais");
                    System.out.println("3. Sair");
                    linha();

                    System.out.print("Escolha uma opção: ");
                    resposta = scanner.nextInt();
                    scanner.nextLine();

                    switch (resposta) {
                        case 1: {
                            System.out.println("Em construção!");
    //                        System.out.print("Nome do Animal para adoção: ");
    //                        String nomeAnimal = scanner.nextLine();
    //
    //                        System.out.print("Nome do Adotante: ");
    //                        String nomeAdotante = scanner.nextLine();
    //
    //                        animais = listarAnimais();
    //                        Animal animal = animais.stream()
    //                                .filter(a -> a.getNome().equalsIgnoreCase(nomeAnimal) && !a.isAdotado())
    //                                .findFirst()
    //                                .orElse(null);
    //
    //                        if (animal == null) {
    //                            System.out.println("Animal não encontrado ou já adotado.");
    //                            break;
    //                        }
    //
    //                        Adotante adotante = adotantes.stream()
    //                                .filter(a -> a.getNome().equalsIgnoreCase(nomeAdotante))
    //                                .findFirst()
    //                                .orElse(null);
    //
    //                        if (adotante == null) {
    //                            System.out.println("Adotante não encontrado.");
    //                            break;
    //                        }
    //
    //                        animal.setAdotado(true);
    //                        System.out.println("Adoção realizada! " + adotante.getNome() + " adotou " + animal.getNome());
    //
                        break;
                    }
                    case 2: {
                        listarAnimais();
                        break;
                    }
                    case 3: {
                        logicaSistema(menuPrincipal(), adotantes, voluntarios);
                        return;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                    }
                }
                } while (resposta != 3);
                break;
            }
            case 3: {
                System.out.println("Saindo do sistema...");
                break;
            }
            default: {
                System.out.println("Opção inválida.");
                break;
            }
        }
    }
}
