import java.sql.SQLException;
import java.util.List;

public class AdotanteService {
    private final AdotanteDAO adotanteDAO;

    public AdotanteService() {
        this.adotanteDAO = new AdotanteDAO();
    }

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


    public List<Adotante> listAllAdotantes() {
        try {
            return adotanteDAO.readAll();
        } catch (SQLException e) {
            System.err.println("Erro ao listar os adotantes: " + e.getMessage());
            return null;
        }
    }


    public void updateAdotante(int id, String nome, String profissao, String genero, int idade, String contato) {
        if (id <= 0 || nome == null || nome.isEmpty() ||
                profissao == null || profissao.isEmpty() ||
                genero == null || genero.isEmpty() ||
                contato == null || contato.isEmpty() ||
                idade <= 0) {
            throw new IllegalArgumentException("Todos os campos do adotante devem ser válidos.");
        }

        Adotante adotante = new Adotante(nome, profissao, genero, idade, contato);
        adotante.setId(id);

        try {
            adotanteDAO.update(adotante);
            System.out.println("Adotante atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o adotante: " + e.getMessage());
        }
    }


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
