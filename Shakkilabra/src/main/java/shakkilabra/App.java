package shakkilabra;


import javax.swing.SwingUtilities;
import shakkilabra.Grafiikka.Grafiikkamoottori;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        
        Grafiikkamoottori peli = new Grafiikkamoottori();
        SwingUtilities.invokeLater(peli);
    }
}
