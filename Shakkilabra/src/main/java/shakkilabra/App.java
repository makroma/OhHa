package shakkilabra;


import javax.swing.SwingUtilities;
import shakkilabra.Grafiikka.Grafiikkamoottori;

/**
 * Mainn luokka joka käynnistää pelin
 *
 */
public class App {

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        
        Grafiikkamoottori peli = new Grafiikkamoottori();
        SwingUtilities.invokeLater(peli);
    }
}
