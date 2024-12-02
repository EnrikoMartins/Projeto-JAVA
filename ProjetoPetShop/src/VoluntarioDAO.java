import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoluntarioDAO {

    public void create(Voluntario voluntario) throws SQLException {
        String sql = "INSERT INTO Voluntario (nome, profissao, genero, idade, funcao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, voluntario.getNome());
            stmt.setString(2, voluntario.getProfissao());
            stmt.setString(3, voluntario.getGenero());
            stmt.setInt(4, voluntario.getIdade());
            stmt.setString(5, voluntario.getFuncao());
            stmt.executeUpdate();
        }
    }

    public List<Voluntario> readAll() throws SQLException {
        List<Voluntario> voluntarios = new ArrayList<>();
        String sql = "SELECT * FROM Voluntario";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Voluntario voluntario = new Voluntario(
                        rs.getString("nome"),
                        rs.getString("profissao"),
                        rs.getString("genero"),
                        rs.getInt("idade"),
                        rs.getString("funcao")
                );
                voluntario.setId(rs.getInt("id"));
                voluntarios.add(voluntario);
            }
        }
        return voluntarios;
    }

    public void update(Voluntario voluntario) throws SQLException {
        String sql = "UPDATE Voluntario SET nome = ?, profissao = ?, genero = ?, idade = ?, funcao = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, voluntario.getNome());
            stmt.setString(2, voluntario.getProfissao());
            stmt.setString(3, voluntario.getGenero());
            stmt.setInt(4, voluntario.getIdade());
            stmt.setString(5, voluntario.getFuncao());
            stmt.setInt(6, voluntario.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Voluntario WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

