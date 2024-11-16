public abstract class Pessoa {

   private int id;
   private String nome;
   private String profissao;
   private String genero;
   private int idade;

   public Pessoa(String nome, String profissao, String genero ,int idade){
    this.id = id;
    this.nome = nome;
    this.profissao = profissao;
    this.genero = genero;
    this.idade = idade;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void mostrarDados() {

        System.out.println("Nome: " + nome);
        System.out.println("Profissão: " + profissao);
        System.out.println("Idade :" + idade);
        System.out.println("Gênero: " + genero);
    }


    


}
