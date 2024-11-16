

public class Voluntario extends Pessoa{
    
    private String funcao;

    public Voluntario(int id, String nome, String profissao, String genero, int idade, String funcao) {

        super(id, nome, profissao, genero, idade);
        this.funcao = funcao;

    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Função: " + funcao);

    }
}
