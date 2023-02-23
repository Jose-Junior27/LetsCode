public class Pessoa implements Comparable  {
    private String nome;
    private int idade;

    public Pessoa(final String nome, final int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "O meu nome é " + this.nome + " e tenho " + this.idade + " anos!";
    }

    @Override
    public int compareTo(Object o) {
        Pessoa pessoa = (Pessoa) o;
        return this.nome.compareTo(pessoa.nome);

    }
}
