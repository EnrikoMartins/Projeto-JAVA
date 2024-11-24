import java.sql.SQLException;
import java.util.List;

public class AdotanteService {
    private final AdotanteDAO adotanteDAO;

    public AdotanteService() {
        this.adotanteDAO = new AdotanteDAO();
    }

    /**
     * Adiciona um novo adotante.
     */
    public void addAdotante(String nome, String profissao, String genero, int idade, String contato) {
        if (nome == null || nome.isEmpty() ||
                profissao == null || profissao.isEmpty() ||
                genero == null || genero.isEmpty() ||
                contato == null || contato.isEmpty() ||
                idade <= 0) {
            throw new IllegalArgumentException("Todos os campos do adotante devem ser válidos.");
        }

        Adotante adotante = new Adotante(nome, profissao, genero, idade, contato);
        try {
            adotanteDAO.create(adotante);
            System.out.println("Adotante adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar o adotante: " + e.getMessage());
        }
    }

    /**
     * Lista todos os adotantes.
     */
    public List<Adotante> listAllAdotantes() {
        try {
            return adotanteDAO.readAll();
        } catch (SQLException e) {
            System.err.println("Erro ao listar os adotantes: " + e.getMessage());
            return null;
        }
    }

    /**
     * Atualiza os dados de um adotante.
     */
    public void updateAdotante(int id, String nome, String profissao, String genero, int idade, String contato) {
        if (id <= 0 || nome == null || nome.isEmpty() ||
                profissao == null || profissao.isEmpty() ||
                genero == null || genero.isEmpty() ||
                contato == null || contato.isEmpty() ||
                idade <= 0) {
            throw new IllegalArgumentException("Todos os campos do adotante devem ser válidos.");
        }

        try {
            Adotante adotante = adotanteDAO.findById(id);
            if (adotante == null) {
                System.err.println("Adotante com ID " + id + " não encontrado.");
                return;
            }

            adotante.setNome(nome);
            adotante.setProfissao(profissao);
            adotante.setGenero(genero);
            adotante.setIdade(idade);
            adotante.setContato(contato);

            adotanteDAO.update(adotante);
            System.out.println("Adotante atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o adotante: " + e.getMessage());
        }
    }

    /**
     * Remove um adotante pelo ID.
     */
    public void deleteAdotante(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do adotante deve ser válido.");
        }

        try {
            adotanteDAO.delete(id);
            System.out.println("Adotante removido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao remover o adotante: " + e.getMessage());
        }
    }
}
