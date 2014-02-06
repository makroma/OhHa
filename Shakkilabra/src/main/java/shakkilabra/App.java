package shakkilabra;


import shakkilabra.Grafiikka.Grafiikkamoottori;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        
        Grafiikkamoottori peli = new Grafiikkamoottori();
        peli.luoPeli();
        peli.run();
    }
}
