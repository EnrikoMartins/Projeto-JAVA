import java.sql.SQLException;
import java.util.List;

public class AnimalService {
    private final AnimalDAO animalDAO;

    public AnimalService() {
        this.animalDAO = new AnimalDAO();
    }

    /**
     * Adiciona um novo animal ao banco de dados.
     * Verifica se os dados são válidos antes de delegar ao DAO.
     */
    public void addAnimal(String nome, String raca, int idade, String genero, String tipo) {
        if (nome == null || nome.isEmpty() ||
                raca == null || raca.isEmpty() ||
                genero == null || genero.isEmpty() ||
                tipo == null || tipo.isEmpty() ||
                idade < 0) {
            throw new IllegalArgumentException("Todos os campos do animal devem ser válidos e não nulos.");
        }

        Animal animal = new Animal(nome, raca, idade, genero, tipo);
        try {
            animalDAO.create(animal);
            System.out.println("Animal adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar o animal: " + e.getMessage());
        }
    }

    /**
     * Lista todos os animais do banco de dados.
     */
    public List<Animal> listAllAnimals() {
        try {
            return animalDAO.readAll();
        } catch (SQLException e) {
            System.err.println("Erro ao listar animais: " + e.getMessage());
            return null;
        }
    }

    /**
     * Atualiza os dados de um animal existente.
     */
    public void updateAnimal(int id, String nome, String raca, int idade, String genero, String tipo, boolean adotado) {
        if (id <= 0 || nome == null || nome.isEmpty() ||
                raca == null || raca.isEmpty() ||
                genero == null || genero.isEmpty() ||
                tipo == null || tipo.isEmpty() ||
                idade < 0) {
            throw new IllegalArgumentException("Todos os campos do animal devem ser válidos e não nulos.");
        }

        Animal animal = new Animal(nome, raca, idade, genero, tipo);
        animal.getId();
        animal.setId(id);
        animal.setAdotado(adotado);

        try {
            animalDAO.update(animal);
            System.out.println("Animal atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o animal: " + e.getMessage());
        }
    }

    /**
     * Remove um animal do banco de dados pelo ID.
     */
    public void deleteAnimal(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do animal deve ser válido.");
        }

        try {
            animalDAO.delete(id);
            System.out.println("Animal removido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao remover o animal: " + e.getMessage());
        }
    }

    /**
     * Atualiza o status de adoção de um animal pelo ID.
     */
    public void updateAdoptionStatus(int id, boolean adotado) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do animal deve ser válido.");
        }

        try {
            // Obtém a lista de todos os animais para encontrar o que deve ser atualizado
            List<Animal> animals = animalDAO.readAll();
            Animal animalToUpdate = animals.stream()
                    .filter(animal -> animal.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (animalToUpdate == null) {
                System.err.println("Animal com ID " + id + " não encontrado.");
                return;
            }

            animalToUpdate.setAdotado(adotado);
            animalDAO.update(animalToUpdate);
            System.out.println("Status de adoção atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o status de adoção: " + e.getMessage());
        }
    }
}
