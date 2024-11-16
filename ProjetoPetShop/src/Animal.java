public class Animal {
    private int id;
    private String nome;
    private String raca;
    private int idade;
    private String genero;

    public Animal(String nome, String raca, int idade, String genero) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }


}
