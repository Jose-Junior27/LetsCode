import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        exerciciosFunction();

    }

    public static void exerciciosFunction() {

        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("Jose"),
                new Funcionario("Junior"),
                new Funcionario("Helena")
        );


        Function<List<Funcionario>, List<String>> function = f -> {
            List<String> lista = new ArrayList<>();
            f.forEach(fun -> lista.add(fun.getNome()));
            return lista;
        };

        List<String> listaNomes = new ArrayList<>();
        listaNomes = function.apply(funcionarios);
        listaNomes.forEach(System.out::println );



    }


}