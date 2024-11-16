public class Adotante extends Pessoa {
    private  Animal animalAdotado;

    public Adotante(String nome, String profissao, String genero, int idade, Animal animalAdotado) {
        super(nome, profissao, genero, idade);
        this.animalAdotado = animalAdotado;
    }

}