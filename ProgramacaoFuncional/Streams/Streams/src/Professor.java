import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private float avaliacao;
    private List<Estudante> listaAlunos = new ArrayList<>();

    public Professor(String nome, float avaliacao, List<Estudante> listaAlunos) {
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.listaAlunos = listaAlunos;
    }

    public String getNome() {
        return nome;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public List<Estudante> getListaAlunos() {
        return listaAlunos;
    }

    @Override
    public String toString() {
        return "Professores{" +
                "nome='" + nome + '\'' +
                ", avaliacao=" + avaliacao +
                '}';
    }
}
