import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SistemaPetshop {
    Scanner scanner = new Scanner(System.in);

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

    private void listarAnimais(List<Animal> cachorros,List<Animal> gatos) {
        if (cachorros.isEmpty() || gatos.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {

            System.out.println("Cachorros: \n");

            for (Animal cachorro : cachorros) {
                System.out.println(cachorro.getNome());
            }

            System.out.println("\nGatos: \n");

            for (Animal gato : gatos) {
                System.out.println(gato.getNome());
            }
        }
    }



    public void logicaSistema(int resposta, List<Animal> cachorros,List<Animal> gatos, List<Pessoa> adotantes, List<Pessoa> voluntarios) {
        switch (resposta) {
            case 1: {
                System.out.println("\n=== Sistema de Gerenciamento ===");
                linha();

                System.out.println("1. Cadastrar Animal");
                System.out.println("2. Cadastrar Adotante");
                System.out.println("3. Listar Animais");
                System.out.println("4. Sair");
                linha();

                System.out.print("Escolha uma opção: ");
                resposta = scanner.nextInt();
                scanner.nextLine();

                switch (resposta) {
                    case 1: {
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
                        String tipo = scanner.nextLine().toLowerCase(Locale.ROOT);

                        switch (tipo) {
                            case "gato": {
                                gatos.add(new Animal(nome, raca, idade, genero, tipo));
                                System.out.println("Animal cadastrado com sucesso!");
                                break;
                            }
                            case "cachorro": {
                                cachorros.add(new Animal(nome, raca, idade, genero, tipo));
                                System.out.println("Animal cadastrado com sucesso!");
                                break;
                            }
                            default: {
                                System.out.println("Por favor, digitar apenas \"GATO\" ou \"Cachorro\".");
                                break;
                            }
                        }
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

                        adotantes.add(new Adotante(nome, profissao, genero, idade, contato));
                        System.out.println("Adotante cadastrado com sucesso!");
                        break;
                    }
                    case 3: {
                        listarAnimais(cachorros, gatos);
                        break;
                    }
                    case 4: {
                        //sair
                        return;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                    }
                }

                break;
            }
            case 2: {
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
                        listarAnimais(cachorros, gatos);
                        break;
                    }
                    case 3: {
                        //sair
                        return;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                    }
                }
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
