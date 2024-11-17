import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    private Connection connection;

    public Connection getInstance() {
        if (this.connection == null) {
            connection = createConnection();

        }
        return connection;
    }

    private Connection createConnection() {
        String url = "jdbc:postgresql://localhost:5432/petshop";
        String user = "postgres";
        String password = "1234";


        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado no classpath!");
            throw new RuntimeException(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados:");
            throw new RuntimeException(e.getMessage());

        }
    }
}
