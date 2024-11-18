import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List <Animal> animais = new ArrayList<>();
        List <Pessoa> adotantes = new ArrayList<>();
        List <Pessoa> voluntarios = new ArrayList<>();

        System.out.println("Bem vindo ao Petshop com Jesus!\n");

        SistemaPetshop sistemaPetshop = new SistemaPetshop();
        sistemaPetshop.logicaSistema(sistemaPetshop.menuPrincipal(), animais, adotantes, voluntarios);
    }
}
