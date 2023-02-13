public class Funcionario {
    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Funcionarios{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
