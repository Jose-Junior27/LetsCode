import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Corrida interlagos01 = corrida();
        Thread.currentThread().sleep(2000);
        interlagos01.ranking();

    }

    public static Corrida corrida(){
        List<Carro> carros = List.of(
                new Carro(1, "Ferrary", "Rubens Barrichello"),
                new Carro(2,"Mclaren", "Ayrton Senna"),
                new Carro(3, "Renault", "Felipe Massa")
        );

        Corrida interlagos = new Corrida("Interlagos", 5, carros);
        interlagos.iniciaCorrida();
        return interlagos;
    }
}