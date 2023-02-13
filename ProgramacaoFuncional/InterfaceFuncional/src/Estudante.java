public class Estudante {
    private int idade;
    private float media;

    public Estudante(int idade, float media) {
        this.idade = idade;
        this.media = media;
    }

    public int getIdade(){
        return this.idade;
    }

    public float getMedia(){
        return this.media;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "idade=" + idade +
                ", media=" + media +
                '}';
    }
}
