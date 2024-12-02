import java.util.Locale;
import java.util.Scanner;

public class SistemaPetshop {
    Scanner scanner = new Scanner(System.in);
    AnimalService animalService = new AnimalService();
    AdotanteService adotanteService = new AdotanteService();
    VoluntarioService voluntarioService = new VoluntarioService();

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

    public void menuGerenciamento() {
        int resposta;

        do {
            System.out.println("\n=== Sistema de Gerenciamento ===");
            linha();
            System.out.println("1. Área de Animal");
            System.out.println("2. Área de Adotante");
            System.out.println("3. Área de voluntário");
            System.out.println("4. Sair");

            linha();

            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();
            scanner.nextLine();

            switch (resposta) {
                case 1: {
                    int respostaAreaAnimal;

                    do {
                        linha();
                        System.out.println("1. Cadastrar Animal");
                        System.out.println("2. Listar Animais");
                        System.out.println("3. Atualizar dados de Animal");
                        System.out.println("4. Remover Animal");
                        System.out.println("5. sair");
                        linha();

                        System.out.print("Resposta:");
                        respostaAreaAnimal = scanner.nextInt();
                        scanner.nextLine();
                        switch (respostaAreaAnimal) {
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
                                listarAnimais(true);
                                break;
                            }

                            case 3: {
                                boolean verificacao = false;
                                listarAnimais();

                                System.out.println("Digite o número do ANIMAL a ser atualizado: ");
                                int idAtualizacao = scanner.nextInt();

                                for (Animal animal: animalService.listAllAnimals()) {
                                    if (animal.getId() == idAtualizacao) {
                                        verificacao = true;
                                    }
                                }

                                if (verificacao) {
                                    linha();
                                    listarDadosAnimaisEspecifico(idAtualizacao);
                                    linha();

                                    System.out.println("1. Nome");
                                    System.out.println("2. Raca");
                                    System.out.println("3. Idade");
                                    System.out.println("4. Genero");
                                    System.out.println("5. Tipo");
                                    System.out.println("6. Adotado");
                                    linha();

                                    System.out.print("O que deseja alterar? ");
                                    int alteracao = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (alteracao) {
                                        case 1: {
                                            System.out.println("Novo nome: ");
                                            String novoNome = scanner.nextLine();

                                            for (Animal animal : animalService.listAllAnimals()) {
                                                if (animal.getId() == idAtualizacao) {
                                                    animalService.updateAnimal(idAtualizacao, novoNome, animal.getRaca(),
                                                            animal.getIdade(), animal.getGenero(), animal.getTipo(), animal.isAdotado());
                                                }
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Nova Raça: ");
                                            String novaRaca = scanner.nextLine();

                                            for (Animal animal : animalService.listAllAnimals()) {
                                                if (animal.getId() == idAtualizacao) {
                                                    animalService.updateAnimal(idAtualizacao, animal.getNome(), novaRaca,
                                                            animal.getIdade(), animal.getGenero(), animal.getTipo(), animal.isAdotado());
                                                }
                                            }
                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Nova Idade: ");
                                            int novaIdade = scanner.nextInt();

                                            for (Animal animal : animalService.listAllAnimals()) {
                                                if (animal.getId() == idAtualizacao) {
                                                    animalService.updateAnimal(idAtualizacao, animal.getNome(), animal.getRaca(),
                                                            novaIdade, animal.getGenero(), animal.getTipo(), animal.isAdotado());
                                                }
                                            }
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("Novo Gênero: ");
                                            String novoGenero = scanner.nextLine();

                                            for (Animal animal : animalService.listAllAnimals()) {
                                                if (animal.getId() == idAtualizacao) {
                                                    animalService.updateAnimal(idAtualizacao, animal.getNome(), animal.getRaca(),
                                                            animal.getIdade(), novoGenero, animal.getTipo(), animal.isAdotado());
                                                }
                                            }
                                            break;
                                        }
                                        case 5: {
                                            System.out.println("Novo Tipo de animal: ");
                                            String novoTipo = scanner.nextLine();

                                            for (Animal animal : animalService.listAllAnimals()) {
                                                if (animal.getId() == idAtualizacao) {
                                                    animalService.updateAnimal(idAtualizacao, animal.getNome(), animal.getRaca(),
                                                            animal.getIdade(), animal.getGenero(), novoTipo, animal.isAdotado());
                                                }
                                            }
                                            break;
                                        }
                                        case 6: {
                                            for (Animal animal : animalService.listAllAnimals()) {
                                                if (animal.getId() == idAtualizacao) {
                                                    animalService.updateAnimal(idAtualizacao, animal.getNome(), animal.getRaca(),
                                                            animal.getIdade(), animal.getGenero(), animal.getTipo(), !animal.isAdotado());
                                                }
                                            }
                                            break;
                                        }
                                        default: {
                                            System.out.println("Valor inválido!");
                                        }
                                    }
                                } else {
                                    System.out.println("Animal não encontrado");
                                }
                                break;
                            }

                            case 4: {
                                listarAnimais();
                                linha();
                                System.out.println("Qual o id do animal a ser removido? ");
                                int idRemovido = scanner.nextInt();
                                animalService.deleteAnimal(idRemovido);
                                break;
                            }

                            case 5: {
                                linha();
                                System.out.println("voltando para o sistema de gerenciamento");
                                linha();

                                break;
                            }
                            default: {
                                System.out.println("Valor inválido!");
                            }
                        }
                    } while (respostaAreaAnimal != 5);
                    break;
                }

                case 2: {
                    int respostaAreaAdotante;

                    do {
                        linha();
                        System.out.println("1. Cadastrar Adotante");
                        System.out.println("2. Listar Adotantes");
                        System.out.println("3. Atualizar Adotante ");
                        System.out.println("4. Remover Adotante");
                        System.out.println("5. Sair");
                        linha();

                        System.out.print("Escolha uma opção: ");
                        respostaAreaAdotante = scanner.nextInt();
                        scanner.nextLine();

                        switch (respostaAreaAdotante) {
                            case 1: {
                                System.out.print("Nome do Adotante: ");
                                String nome = scanner.nextLine();

                                System.out.print("Profissão: ");
                                String profissao = scanner.nextLine();

                                System.out.print("Gênero: ");
                                String genero = scanner.nextLine();

                                System.out.print("Idade: ");
                                int idade = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Contato: ");
                                String contato = scanner.nextLine();

                                adotanteService.addAdotante(nome, profissao, genero, idade, contato);
                                break;
                            }
                            case 2: {
                                listarAdotantes(true);
                                break;
                            }
                            case 3: {
                                boolean verificacao = false;

                                listarAdotantes();
                                System.out.println("Digite o número do ADOTANTE a ser atualizado: ");
                                int idAtualizacao = scanner.nextInt();

                                for (Adotante adotante : adotanteService.listAllAdotantes()) {
                                    if (idAtualizacao == adotante.getId()) {
                                        verificacao = true;
                                    }
                                }

                                if (verificacao) {
                                    linha();
                                    listarDadosAdotanteEspecifico(idAtualizacao);
                                    linha();

                                    System.out.println("1. Nome");
                                    System.out.println("2. Profissão");
                                    System.out.println("3. Gênero");
                                    System.out.println("4. Idade");
                                    System.out.println("5. Contato");
                                    linha();

                                    System.out.println("O que deseja alterar? ");
                                    int alteracao = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (alteracao) {
                                        case 1: {
                                            System.out.println("Novo Nome: ");
                                            String novoNome = scanner.nextLine();

                                            for (Adotante adotante : adotanteService.listAllAdotantes()) {
                                                if (adotante.getId() == idAtualizacao) {
                                                    adotanteService.updateAdotante(idAtualizacao, novoNome, adotante.getProfissao(),
                                                            adotante.getGenero(), adotante.getIdade(), adotante.getContato());
                                                }
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Nova Profissão: ");
                                            String novaProfissao = scanner.nextLine();

                                            for (Adotante adotante : adotanteService.listAllAdotantes()) {
                                                if (adotante.getId() == idAtualizacao) {
                                                    adotanteService.updateAdotante(idAtualizacao, adotante.getNome(), novaProfissao,
                                                            adotante.getGenero(), adotante.getIdade(), adotante.getContato());
                                                }
                                            }

                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Novo nome: ");
                                            String novoGenero = scanner.nextLine();

                                            for (Adotante adotante : adotanteService.listAllAdotantes()) {
                                                if (adotante.getId() == idAtualizacao) {
                                                    adotanteService.updateAdotante(idAtualizacao, adotante.getNome(), adotante.getProfissao(),
                                                            novoGenero, adotante.getIdade(), adotante.getContato());
                                                }
                                            }
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("Nova Idade: ");
                                            int novaIdade = scanner.nextInt();

                                            for (Adotante adotante : adotanteService.listAllAdotantes()) {
                                                if (adotante.getId() == idAtualizacao) {
                                                    adotanteService.updateAdotante(idAtualizacao, adotante.getNome(), adotante.getProfissao(),
                                                            adotante.getGenero(), novaIdade, adotante.getContato());
                                                }
                                            }
                                            break;
                                        }
                                        case 5: {
                                            System.out.println("Novo Contato (e-mail): ");
                                            String novoContato = scanner.nextLine();

                                            for (Adotante adotante : adotanteService.listAllAdotantes()) {
                                                if (adotante.getId() == idAtualizacao) {
                                                    adotanteService.updateAdotante(idAtualizacao, adotante.getNome(), adotante.getProfissao(),
                                                            adotante.getGenero(), adotante.getIdade(), novoContato);
                                                }
                                            }
                                            break;
                                        }

                                        default: {
                                            System.out.println("Valor inválido!");
                                        }
                                    }
                                } else {
                                    System.out.println("Adotante não encontrado!");
                                }
                                break;
                            }
                            case 4: {
                                listarAdotantes();
                                linha();

                                System.out.println("Qual o id da Adotante a ser removido? ");
                                int idRemovido = scanner.nextInt();

                                adotanteService.deleteAdotante(idRemovido);

                                break;
                            }
                            case 5: {
                                menuGerenciamento();
                                break;
                            }
                            default: {
                                System.out.println("valor inválido!");
                            }
                        }
                    } while (respostaAreaAdotante != 5);
                    break;
                }

                case 3: {
                    int respostaAreaVoluntario;

                    do {
                        linha();
                        System.out.println("1. Cadastrar Voluntário");
                        System.out.println("2. Listar Voluntário");
                        System.out.println("3. Atualizar Voluntário ");
                        System.out.println("4. Remover Voluntário");
                        System.out.println("5. Sair");
                        linha();

                        System.out.print("Escolha uma opção: ");
                        respostaAreaVoluntario = scanner.nextInt();
                        scanner.nextLine();

                        switch (respostaAreaVoluntario) {
                            case 1: {
                                System.out.print("Nome do Voluntario: ");
                                String nome = scanner.nextLine();

                                System.out.print("Profissão: ");
                                String profissao = scanner.nextLine();

                                System.out.print("Gênero: ");
                                String genero = scanner.nextLine();

                                System.out.print("Idade: ");
                                int idade = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Função: ");
                                String funcao = scanner.nextLine();

                                voluntarioService.addVoluntario(nome, profissao, genero, idade, funcao);
                                break;
                            }
                            case 2: {
                                listarVoluntarios(true);
                                break;
                            }
                            case 3: {
                                boolean verificacao = false;

                                listarVoluntarios();
                                System.out.println("Digite o número do VOLUNTÁRIO a ser atualizado: ");
                                int idAtualizacao = scanner.nextInt();

                                for (Voluntario voluntario: voluntarioService.listAllVoluntarios()) {
                                    if (idAtualizacao == voluntario.getId()) {
                                        verificacao = true;
                                    }
                                }

                                if (verificacao) {
                                    linha();
                                    listarDadosVoluntarioEspecifico(idAtualizacao);
                                    linha();

                                    System.out.println("1. Nome");
                                    System.out.println("2. Profissão");
                                    System.out.println("3. Gênero");
                                    System.out.println("4. Idade");
                                    System.out.println("5. Função");
                                    linha();

                                    System.out.println("O que deseja alterar? ");
                                    int alteracao = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (alteracao) {
                                        case 1: {
                                            System.out.println("Novo Nome: ");
                                            String novoNome = scanner.nextLine();

                                            for (Voluntario voluntario: voluntarioService.listAllVoluntarios()) {
                                                if (voluntario.getId() == idAtualizacao) {
                                                    voluntarioService.updateVoluntario(idAtualizacao, novoNome, voluntario.getProfissao(),
                                                            voluntario.getGenero(), voluntario.getIdade(), voluntario.getFuncao());
                                                }
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Nova Profissão: ");
                                            String novaProfissao = scanner.nextLine();

                                            for (Voluntario voluntario: voluntarioService.listAllVoluntarios()) {
                                                if (voluntario.getId() == idAtualizacao) {
                                                    voluntarioService.updateVoluntario(idAtualizacao, voluntario.getNome(), novaProfissao,
                                                            voluntario.getGenero(), voluntario.getIdade(), voluntario.getFuncao());
                                                }
                                            }

                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Novo nome: ");
                                            String novoGenero = scanner.nextLine();

                                            for (Voluntario voluntario: voluntarioService.listAllVoluntarios()) {
                                                if (voluntario.getId() == idAtualizacao) {
                                                    voluntarioService.updateVoluntario(idAtualizacao, voluntario.getNome(), voluntario.getProfissao(),
                                                            novoGenero, voluntario.getIdade(), voluntario.getFuncao());
                                                }
                                            }
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("Nova Idade: ");
                                            int novaIdade = scanner.nextInt();

                                            for (Voluntario voluntario: voluntarioService.listAllVoluntarios()) {
                                                if (voluntario.getId() == idAtualizacao) {
                                                    adotanteService.updateAdotante(idAtualizacao, voluntario.getNome(), voluntario.getProfissao(),
                                                            voluntario.getGenero(), novaIdade, voluntario.getFuncao());
                                                }
                                            }
                                            break;
                                        }
                                        case 5: {
                                            System.out.println("Nova Função: ");
                                            String novaFuncao = scanner.nextLine();

                                            for (Voluntario voluntario: voluntarioService.listAllVoluntarios()) {
                                                if (voluntario.getId() == idAtualizacao) {
                                                    adotanteService.updateAdotante(idAtualizacao, voluntario.getNome(), voluntario.getProfissao(),
                                                            voluntario.getGenero(), voluntario.getIdade(), novaFuncao);
                                                }
                                            }
                                            break;
                                        }

                                        default: {
                                            System.out.println("Valor inválido!");
                                        }
                                    }
                                } else {
                                    System.out.println("Voluntário não encontrado!");
                                }
                                break;
                            }
                            case 4: {
                                listarVoluntarios();
                                linha();

                                System.out.println("Qual o id da VOLUNTARIO a ser removido? ");
                                int idRemovido = scanner.nextInt();

                                voluntarioService.deleteVoluntario(idRemovido);

                                break;
                            }
                            case 5: {
                                menuGerenciamento();
                                break;
                            }
                            default: {
                                System.out.println("valor inválido!");
                            }
                        }
                    } while (respostaAreaVoluntario != 5);
                    break;
                }

                case 4: {
                    logicaSistema(menuPrincipal());
                    break;
                }
                default: {
                    System.out.println("Opção inválida.");
                }
            }

        } while (resposta != 4);
    }

    public void menuAdotante() {
        int resposta;

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
                    listarAnimais();

                    System.out.print("Qual o animal que você deseja adotar (digite o número)? ");
                    int adocao = scanner.nextInt();
                    scanner.nextLine();

                    for (Animal animal : animalService.listAllAnimals())
                        if (adocao == animal.getId() && !animal.isAdotado()) {
                            animal.setAdotado(true);
                        } else {
                            System.out.println("Esse animal já foi adotado!");
                        }
                    break;
                }
                case 2: {
                    listarAnimais(true);
                    break;
                }
                case 3: {
                    logicaSistema(menuPrincipal());
                    return;
                }
                default: {
                    System.out.println("Opção inválida.");
                }
            }
        } while (resposta != 3);
    }

    public void listarAnimais() {
        linha();
        for (Animal animal : animalService.listAllAnimals()) {
            System.out.println(animal.getId() + " - " + animal.getNome() + " - Adotado: " + (animal.isAdotado() ? "Sim" : "Não"));
        }
        linha();
    }

    public void listarAnimais(boolean pedirPorMaisInformacoes) {
        boolean animalEncontrado = false;

        listarAnimais();

        System.out.print("Ver mais informções de qual animal (digite o número)? ");
        int maisInformacoes = scanner.nextInt();
        linha();

        for (Animal animal : animalService.listAllAnimals()) {
            if (animal.getId() == maisInformacoes) {
                animalEncontrado = true;
                break;
            }
        }

        if (animalEncontrado) {
            for (Animal animal : animalService.listAllAnimals()) {
                if (animal.getId() == maisInformacoes) {
                    System.out.println(animal);
                }
            }
            System.out.println();
        } else {
            System.out.println("Animal não encontrado!");
        }
    }

    public void listarDadosAnimaisEspecifico(int idDeanimal) {
        for (Animal animal : animalService.listAllAnimals()) {
            if (animal.getId() == idDeanimal) {
                System.out.println(animal);
            }
        }
    }

    public void listarAdotantes() {
        linha();
        System.out.println("Lista de Adotantes:");
        for (Adotante adotante : adotanteService.listAllAdotantes()) {
            System.out.println(adotante.getId() + " - " + adotante.getNome() + " - Contato: " + adotante.getContato());
        }
        linha();
    }

    public void listarAdotantes(boolean pedirParaMostararMaisInformacoes) {
        boolean adotanteEncontrado = false;
        listarAdotantes();

        System.out.println("Mostrar mais informações sobre qual adotante (digite o número)? ");
        int idDeAdotante = scanner.nextInt();

        for (Adotante adotante : adotanteService.listAllAdotantes()) {
            if (idDeAdotante == adotante.getId()) {
                adotanteEncontrado = true;
                break;
            }
        }

        if (adotanteEncontrado) {
            for (Adotante adotante : adotanteService.listAllAdotantes()) {
                if (adotante.getId() == idDeAdotante) {
                    System.out.println(adotante);
                }
            }
            System.out.println();
        } else {
            System.out.println("Adotante não encontrado!");
        }
    }

    public void listarVoluntarios() {
        linha();
        System.out.println("Lista de Voluntários:");
        for (Voluntario voluntario: voluntarioService.listAllVoluntarios()) {
            System.out.println(voluntario.getId() + " - " + voluntario.getNome() + " - Contato: " + voluntario.getFuncao());
        }
        linha();
    }

    public void listarVoluntarios(boolean pedirPorMaisInformacoes) {
        boolean voluntarioEncontrado = false;

        listarVoluntarios();

        System.out.print("Ver mais informções de qual volurario (digite o número)? ");
        int maisInformacoes = scanner.nextInt();
        linha();

        for (Voluntario voluntario: voluntarioService.listAllVoluntarios()) {
            if (voluntario.getId() == maisInformacoes) {
                voluntarioEncontrado = true;
                break;
            }
        }

        if (voluntarioEncontrado) {
            for (Voluntario voluntario: voluntarioService.listAllVoluntarios()) {
                if (voluntario.getId() == maisInformacoes) {
                    System.out.println(voluntario);
                }
            }
            System.out.println();
        } else {
            System.out.println("Voluntário não encontrado!");
        }
    }

    public void listarDadosVoluntarioEspecifico(int idDeVoluntario) {
        for (Voluntario voluntario : voluntarioService.listAllVoluntarios()) {
            if (voluntario.getId() == idDeVoluntario) {
                System.out.println(voluntario);
            }
        }
    }

    public void listarDadosAdotanteEspecifico(int idDeAdotante) {
        for (Adotante adotante : adotanteService.listAllAdotantes()) {
            if (adotante.getId() == idDeAdotante) {
                System.out.println(adotante);
            }
        }
    }

    public void logicaSistema(int respostaDoMenuPrincipal) {
        switch (respostaDoMenuPrincipal) {
            case 1: {
                menuGerenciamento();
                break;
            }

            case 2: {
                menuAdotante();
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