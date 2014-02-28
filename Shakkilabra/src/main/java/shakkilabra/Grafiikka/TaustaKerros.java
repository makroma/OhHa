package shakkilabra.Grafiikka;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.*;

/**
 * Määrittää ja ylikirjoittaa piirtokomponentit. 
 * 
 * @author marko
 */

public class TaustaKerros extends JPanel {

    private final Image backgroundImage;

    /**
     *  Parametrinä tuodaan String tiedosto nimeen
     * @param fileName
     */
    public TaustaKerros(String fileName) {

        backgroundImage = (getImage(fileName));
        System.out.println("Asetetaan taustakuva.");
    }

    /**
     * 
     * @param pathAndFileName
     * @return
     */
    public static Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
