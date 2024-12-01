import java.sql.SQLException;
import java.util.List;

public class VoluntarioService {
    private final VoluntarioDAO voluntarioDAO;

    public VoluntarioService() {
        this.voluntarioDAO = new VoluntarioDAO();
    }

    /**
     * Adiciona um novo voluntário ao banco de dados.
     * Valida os dados antes de delegar ao DAO.
     */
    public void addVoluntario(String nome, String profissao, String genero, int idade, String funcao) {
        if (nome == null || nome.isEmpty() ||
                profissao == null || profissao.isEmpty() ||
                genero == null || genero.isEmpty() ||
                funcao == null || funcao.isEmpty() ||
                idade < 0) {
            throw new IllegalArgumentException("Todos os campos do voluntário devem ser válidos e não nulos.");
        }

        Voluntario voluntario = new Voluntario(nome, profissao, genero, idade, funcao);
        try {
            voluntarioDAO.create(voluntario);
            System.out.println("Voluntário adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar o voluntário: " + e.getMessage());
        }
    }

    /**
     * Lista todos os voluntários do banco de dados.
     */
    public List<Voluntario> listAllVoluntarios() {
        try {
            return voluntarioDAO.readAll();
        } catch (SQLException e) {
            System.err.println("Erro ao listar voluntários: " + e.getMessage());
            return null;
        }
    }

    /**
     * Atualiza os dados de um voluntário existente.
     */
    public void updateVoluntario(int id, String nome, String profissao, String genero, int idade, String funcao) {
        if (id <= 0 || nome == null || nome.isEmpty() ||
                profissao == null || profissao.isEmpty() ||
                genero == null || genero.isEmpty() ||
                funcao == null || funcao.isEmpty() ||
                idade < 0) {
            throw new IllegalArgumentException("Todos os campos do voluntário devem ser válidos e não nulos.");
        }

        Voluntario voluntario = new Voluntario(nome, profissao, genero, idade, funcao);
        voluntario.setId(id);

        try {
            voluntarioDAO.update(voluntario);
            System.out.println("Voluntário atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o voluntário: " + e.getMessage());
        }
    }

    /**
     * Remove um voluntário do banco de dados pelo ID.
     */
    public void deleteVoluntario(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do voluntário deve ser válido.");
        }

        try {
            voluntarioDAO.delete(id);
            System.out.println("Voluntário removido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao remover o voluntário: " + e.getMessage());
        }
    }
}
