/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Grafiikka;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author marko
 */
public class Taustakuva extends JPanel {

    private Image backgroundImage;

    public Taustakuva(String fileName) {

        try {
            backgroundImage = ImageIO.read(new File(fileName));
            System.out.println("Asetetaan taustakuva.");
        } catch (IOException ex) {
            System.out.println("Kuvaa ei löydy");
            Logger.getLogger(Taustakuva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
