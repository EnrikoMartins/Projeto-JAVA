import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        PostgresConnection postgresConnection = new PostgresConnection();
        Connection connection = postgresConnection.getInstance();

        System.out.println("Bem vindo ao PetShop com Jesus");
        System.out.println();

        System.out.println("Menu: ");
        System.out.println();

        System.out.println("1 - Entrar como Gerente");
        System.out.println("2 - Entrar como Cliente");
        System.out.println("3 - Sair");
        // gerente
        System.out.println("1 - Inscrever Adotante/ Voluntario/ Animal");
        System.out.println("2 - Apagar Adotante/ Voluntario/ Animal");
        System.out.println("3 - Sair");
        // cliente
        System.out.println("1 - Adotar animal");
        System.out.println("2 - Benzer animal");
        System.out.println("3 - Sair");

    }

}