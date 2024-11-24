import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public void create(Animal animal) throws SQLException {
        String sql = "INSERT INTO Animal (nome, raca, idade, genero, tipo, adotado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setInt(3, animal.getIdade());
            stmt.setString(4, animal.getGenero());
            stmt.setString(5, animal.getTipo());
            stmt.setBoolean(6, animal.isAdotado());
            stmt.executeUpdate();
        }
    }

    public List<Animal> readAll() throws SQLException {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM Animal";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Animal animal = new Animal(
                        rs.getString("nome"),
                        rs.getString("raca"),
                        rs.getInt("idade"),
                        rs.getString("genero"),
                        rs.getString("tipo")
                );
                animal.setId(rs.getInt("id"));
                animal.setAdotado(rs.getBoolean("adotado"));
                animals.add(animal);
            }
        }
        return animals;
    }

    public void update(Animal animal) throws SQLException {
        String sql = "UPDATE Animal SET nome = ?, raca = ?, idade = ?, genero = ?, tipo = ?, adotado = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setInt(3, animal.getIdade());
            stmt.setString(4, animal.getGenero());
            stmt.setString(5, animal.getTipo());
            stmt.setBoolean(6, animal.isAdotado());
            stmt.setInt(7, animal.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Animal WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

