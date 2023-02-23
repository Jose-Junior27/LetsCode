import java.sql.Array;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

        /*1. Dado um array de inteiros, retorne a soma de todos os números pares

        2. Dado uma lista de strings, selecione apenas as palavras que começam com 'C' e
        retorne a quantidade de elementos que possuem mais de 5 caracteres.

        3. Dado uma lista de Pessoas, retorne uma lista de nomes dos que possuem mais de 30 anos.

        4. Dado uma lista de números inteiros, retorne a média dos números maiores que 10.

        5. Dado uma lista de Professores, identifique os que possuem avaliação superior a 80 e retorne uma lista com nome de seus
        estudantes, por ordem alfabetica e sem repetição.*/

public class Main {
    public static void main(String[] args) {
        //exercicio 1
        soma();
        //exercicio 2
        //qtdElementos();
        //exercico 3
        //maisDe30();
        //exercicio 4
        //mediaMaior10();
        //exercicio 5
        //listaProfessores();
    }

    public static void soma (){

        Integer arr[] = new Integer[] {10,1,57,8,78,0,12};
        Stream<Integer> stream =  Arrays.stream(arr);
        int soma = stream.filter(inteiro -> (inteiro % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(soma);
    }

    public static void qtdElementos(){

        List<String> lista = List.of("Jose", "Carlos", "Caroline", "marcel", "Celina");
        long qtd = lista.stream()
                .filter(nome -> (nome.charAt(0) == 'C' && nome.length() > 5) )
                .map(valor -> lista.size())
                .count();
        System.out.println(qtd);

    }

    public static void maisDe30(){

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa( "Jose",12, EstadoCivil.SOLTEIRO));
        pessoas.add(new Pessoa("Joao",40, EstadoCivil.CASADO));
        pessoas.add(new Pessoa("Marcos",30, EstadoCivil.DIVORCIADO));
        pessoas.add(new Pessoa("Maria",55, EstadoCivil.SOLTEIRO));
        pessoas.add(new Pessoa("Matheus",60, EstadoCivil.CASADO));

        pessoas.stream()
                .filter(m30 -> m30.getIdade() > 30)
                .forEach(list -> System.out.println(list));

    }

    public static void mediaMaior10(){
        List<Integer> listaInteiro = List.of(10, 15, 20, 30);
        double media = listaInteiro.stream()
                .filter(value -> value > 10)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        System.out.println(String.format("%.2f",media));

    }

    public static void listaProfessores(){
        Estudante estudante1 = new Estudante("Carlos", 15);
        Estudante estudante2 = new Estudante("Maria", 16);
        Estudante estudante3 = new Estudante("Fabio", 16);

        List<Estudante> listEstudantes1 = List.of(estudante1, estudante2);
        List<Estudante> listEstudantes2 = List.of(estudante1, estudante2, estudante3);
        List<Estudante> listEstudantes3 = List.of(estudante2);

        Professor professor1 = new Professor("Marcio", 92F, listEstudantes1);
        Professor professor2 = new Professor("Pedro", 50F, listEstudantes2);
        Professor professor3 = new Professor("Decio", 91F, listEstudantes3);

        List<Professor> listaProfessores = List.of(professor1, professor2, professor3);

        List<String> listaAlunos = listaProfessores.stream()
                .filter(media -> media.getAvaliacao() > 80)
                .flatMap(valor -> valor.getListaAlunos().stream())
                .map(valor -> valor.getNome())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        listaAlunos.forEach(System.out::println);

    }
}