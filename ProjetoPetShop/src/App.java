public class App {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao Petshop com Jesus!\n");

        SistemaPetshop sistemaPetshop = new SistemaPetshop();
        sistemaPetshop.logicaSistema(sistemaPetshop.menuPrincipal());
    }
}
