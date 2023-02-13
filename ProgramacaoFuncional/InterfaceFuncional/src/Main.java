import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        exercicio1Predicate();
    }

    public static void exercicio1Predicate(){
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa( "Jose",12, EstadoCivil.SOLTEIRO));
        pessoas.add(new Pessoa("Joao",40, EstadoCivil.CASADO));
        pessoas.add(new Pessoa("Marcos",30, EstadoCivil.DIVORCIADO));
        pessoas.add(new Pessoa("Maria",55, EstadoCivil.SOLTEIRO));
        pessoas.add(new Pessoa("Matheus",60, EstadoCivil.CASADO));

        List<Pessoa> pessoas2 = new ArrayList<>();
        pessoas2.add(new Pessoa( "Jonas",12, EstadoCivil.SOLTEIRO));
        pessoas2.add(new Pessoa("Joao",40, EstadoCivil.CASADO));
        pessoas2.add(new Pessoa("Celso",30, EstadoCivil.DIVORCIADO));
        pessoas2.add(new Pessoa("Carlos",55, EstadoCivil.SOLTEIRO));
        pessoas2.add(new Pessoa("Marcos",60, EstadoCivil.CASADO));

        List<Estudante> estudantes = new ArrayList<>();
        estudantes.add(new Estudante(10, 90.20F));
        estudantes.add(new Estudante(19, 86F));


        //Forma tradicional
       /* Predicate<Pessoa> verifica60Anos = new Predicate<Pessoa>() {
            @Override
            public boolean test(Pessoa pessoa) {
                return  (pessoa.getIdade() > 60);
            }
        };
        System.out.println(verifica60Anos.test(new Pessoa(80,EstadoCivil.CASADO)));*/

        //exercicio 1 - 2
        Predicate<Pessoa> verificaSolteiro = pessoa -> (pessoa.getEstadoCivil() == EstadoCivil.SOLTEIRO);
        Predicate<Pessoa> verificaCasada = pessoa -> (pessoa.getEstadoCivil() == EstadoCivil.CASADO);
        Predicate<Pessoa> verifica50Anos = pessoa -> (pessoa.getIdade() > 50);

        //exercicio 3
        Predicate<Estudante> verificaMaior18 = estudante -> (estudante.getIdade() > 18);
        Predicate<Estudante> verificaMedia85 = estudante -> (estudante.getMedia() > 85);

        //exercicio 4
        BiPredicate<Pessoa, Pessoa> comparaString = (p1 , p2) -> p1.equals(p2);

        System.out.println("Exercício 1: " + filtro(pessoas, verificaSolteiro.and(verifica50Anos)).toString());
        System.out.println("Exercício 2: " + filtro(pessoas, verificaCasada.and(verifica50Anos)).toString());

        System.out.println("Exercício 3: " + filtro(estudantes, verificaMaior18.and(verificaMedia85)).toString());

        System.out.println("Exercício 4: " + filtroBi(pessoas, pessoas2, comparaString));

    }

    public static <T> List<T> filtro(List<T> list, Predicate<T> condicional){
        List<T> listaFiltro = new ArrayList<>();
        for (T t : list){
            if(condicional.test(t))
                listaFiltro.add(t);
        }
        return listaFiltro;
    }

    public static <T,U> List<T> filtroBi(List<T> list1, List<U> list2, BiPredicate<T, U> condicional){
        List<T> listaFiltro = new ArrayList<>();
        U l2;

        for(int i = 0; i < list1.size(); i++ ){
            if(condicional.test(list1.get(i), list2.get(i)))
                listaFiltro.add(list1.get(i));
        }

        return listaFiltro;
    }

}