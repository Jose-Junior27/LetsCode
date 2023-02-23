import java.util.Random;

public class Carro implements Comparable<Carro>, Runnable {

    private static int MAX_RANDOM = 1000;
    private int numero;
    private String marca;
    private String piloto;
    private int voltas;
    private long tempo;

    private Random tempoRamdom = new Random();

    public Carro(int numero, String marca, String piloto) {
        this.numero = numero;
        this.marca = marca;
        this.piloto = piloto;
        this.voltas = 0;
        this.tempo = 0;

    }

    public int getNumero() {
        return numero;
    }

    public long getTempo() {
        return tempo;
    }

    public int getVoltas() {
        return voltas;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }

    @Override
    public String toString() {
        return marca + '\'' +
                " -> " + piloto + '\'' +
                ", tempo='" + tempo + '\'' + " min.";
    }

    private void registraVolta(long tempo){
        this.tempo += tempo;
    }

    public void acelera(){
        for ( int i = 0; i < getVoltas(); i++ ) {
            registraVolta( tempoRamdom.nextInt(MAX_RANDOM) );
        }
        System.out.println(toString());

    }

    @Override
    public void run() {

        acelera();
    }

    @Override
    public int compareTo(Carro carro) {
        if (carro.getTempo() > this.getTempo()){
            return -1;
        } else if (carro.getTempo() < this.getTempo()){
            return 1;
        } else {
            return 0;
        }

    }
}
