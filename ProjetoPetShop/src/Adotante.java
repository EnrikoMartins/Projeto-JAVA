public class Adotante extends Pessoa {
    private  Animal animalAdotado;
    String contato;

    public Adotante(String nome, String profissao, String genero, int idade, String contato) {
        super(nome, profissao, genero, idade);
        this.contato = contato;
    }
    public Animal getAnimalAdotado() {
        return animalAdotado;
    }
     public void setAnimalAdotado(Animal animalAdotado) {
        this.animalAdotado = animalAdotado;
    }
}
