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

    public boolean sairSistema() {
        return false;
    }

    public void listarAnimais(List<Animal> animais) {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (Animal animal : animais) {
                System.out.println(animal.getNome() + " " + animal.getTipo());
            }
        }
    }

    public void logicaSistema(int resposta, List<Animal> animais, List<Pessoa> adotantes, List<Pessoa> voluntarios) {
        //private static void ExibirSisitema() { // Tentaiva de criar um metodo recursivo

            boolean loopDeValidacao = true;
            do {
                switch (resposta) {
                    case 1: {
                        do {
                            System.out.println("\n=== Sistema de Gerenciamento ===");
                            linha();

                            System.out.println("1. Cadastrar Animal");
                            System.out.println("2. Cadastrar Adotante");
                            System.out.println("3. Sair");
                            linha();

                            System.out.print("Escolha uma opção: ");
                            resposta = scanner.nextInt();
                            scanner.nextLine();
                        } while (resposta > 4 || resposta < 1);

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

                                animais.add(new Animal(nome, raca, idade, genero, tipo));
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
                                listarAnimais(animais);
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
                        } while (resposta > 3 || resposta < 1);

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
                                listarAnimais(animais);
                                break;
                            }
                            case 3: {
                                System.out.println("Estou aqui");
                                //Tentando chamar o metodo, ainda n deu certo mas está quase
                                //ExibirSisitema();
                                break;
                            }
                            default: {
                                System.out.println("Opção inválida.");
                                logicaSistema(0, null, null, null);
                            }
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Saindo do sistema...");
                        loopDeValidacao = false;
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida.");
                        break;
                    }
                }
            } while (loopDeValidacao);
        //}
    }
}
