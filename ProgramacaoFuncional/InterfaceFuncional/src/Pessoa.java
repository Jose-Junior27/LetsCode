import java.util.Objects;
import java.util.function.Predicate;

public class Pessoa {

    private String nome;
    private int idade;
    private EstadoCivil estadoCivil;

    public Pessoa(String nome, int idade, EstadoCivil estadoCivil) {
        this.nome = nome;
        this.idade = idade;
        this.estadoCivil = estadoCivil;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return idade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome= " + nome +
                ", idade= " + idade +
                ", estadoCivil= " + estadoCivil +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        return ((Pessoa)obj).getNome() == this.getNome();
    }
}
