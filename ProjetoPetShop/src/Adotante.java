public class Adotante {
    private int id; // Novo campo
    private String nome;
    private String profissao;
    private String genero;
    private int idade;
    private String contato;

    // Construtores, getters e setters
    public Adotante(String nome, String profissao, String genero, int idade, String contato) {
        this.nome = nome;
        this.profissao = profissao;
        this.genero = genero;
        this.idade = idade;
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getGenero() {
        return genero;
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

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String toString() {
        return "Nome: " + getNome() +
                "\nProfisão: " + getProfissao() +
                "\nGênero: " + getGenero() +
                "\nIdade: " + getIdade() + " anos" +
                "\nContato: " + getContato();
    }
}

