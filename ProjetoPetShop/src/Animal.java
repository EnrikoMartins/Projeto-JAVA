public class Animal {
    private int id;
    private String nome;
    private String raca;
    private int idade;
    private String genero;
    private boolean adotado;
    private String tipo;

    public Animal(String nome, String raca, int idade, String genero, String tipo) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.genero = genero;
        this.tipo = tipo;
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
    
    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
