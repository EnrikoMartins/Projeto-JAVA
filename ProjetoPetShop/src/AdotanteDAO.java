import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdotanteDAO {

    public void create(Adotante adotante) throws SQLException {
        String sql = "INSERT INTO Adotante (nome, profissao, genero, idade, contato) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, adotante.getNome());
            stmt.setString(2, adotante.getProfissao());
            stmt.setString(3, adotante.getGenero());
            stmt.setInt(4, adotante.getIdade());
            stmt.setString(5, adotante.getContato());
            stmt.executeUpdate();
        }
    }

    public List<Adotante> readAll() throws SQLException {
        List<Adotante> adotantes = new ArrayList<>();
        String sql = "SELECT * FROM Adotante";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Adotante adotante = new Adotante(
                        rs.getString("nome"),
                        rs.getString("profissao"),
                        rs.getString("genero"),
                        rs.getInt("idade"),
                        rs.getString("contato")
                );
                adotante.setId(rs.getInt("id"));
                adotantes.add(adotante);
            }
        }
        return adotantes;
    }

    public void update(Adotante adotante) throws SQLException {
        String sql = "UPDATE Adotante SET nome = ?, profissao = ?, genero = ?, idade = ?, contato = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, adotante.getNome());
            stmt.setString(2, adotante.getProfissao());
            stmt.setString(3, adotante.getGenero());
            stmt.setInt(4, adotante.getIdade());
            stmt.setString(5, adotante.getContato());
            stmt.setInt(6, adotante.getId()); // Id deve ser implementado na classe Adotante
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Adotante WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
