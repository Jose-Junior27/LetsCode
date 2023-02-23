import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Corrida {

    private String nome;
    private int numeroVoltas;
    private List<Carro> carros = new ArrayList<>();

    public Corrida(String nome, int numeroVoltas, List<Carro> carros) {
        this.nome = nome;
        this.numeroVoltas = numeroVoltas;
        this.carros = carros;
        carros.forEach( carro -> carro.setVoltas(numeroVoltas) );
    }

    public void iniciaCorrida(){

        carros.forEach(carro -> {
            Thread largada = new Thread(carro);
            largada.start();
        });

    }

    public void ranking(){
        System.out.println();
        System.out.println("--------------Ranking--------------- " );
        int index = 0;
        List<Carro> classificacao = carros.stream()
                .sorted()
                .collect(Collectors.toList());

        for (Carro carro: classificacao) {
            System.out.println( (++index) + "º " +  carro.getPiloto() );
        }
    }


}
