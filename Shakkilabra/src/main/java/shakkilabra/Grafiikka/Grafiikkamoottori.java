    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Grafiikka;

import shakkilabra.Assets.EnumVari;
import shakkilabra.GameEngine.NappulaSet;
import shakkilabra.GameEngine.Pelimoottori;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author marko
 */
public final class Grafiikkamoottori {

    static Font font = new Font("Sans-Serif", Font.PLAIN, 64);
    private Pelimoottori pelimoottori;
    private Lauta lauta;
    private NappulaSet nappulatSet;
    private JFrame frame;
    private JPanel gui;

    public Grafiikkamoottori() {
        this.pelimoottori = new Pelimoottori();
        this.nappulatSet = new NappulaSet();
        this.lauta = new Lauta();

        this.frame = new JFrame("TopLevelDemo");
        this.frame.setPreferredSize(new Dimension(900, 800));
        this.gui = new JPanel(new GridLayout(9, 10, 4, 4));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Lauta lauta, NappulaSet nappulat

    }

    public void luoPeli() {
        this.pelimoottori.luoSotilaatLaudalle(this.nappulatSet);
//        this.pelimoottori.luoSotilaatLaudalle(this.nappulatSet);
//        this.frame = new JFrame("TopLevelDemo");
//        this.frame.setPreferredSize(new Dimension(900, 800));
//        this.gui = new JPanel(new GridLayout(9, 10, 4, 4));
//        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //this.nappulatSet = this.pelimoottori.getNappulatSet(); 
    }

    public void run() {
//        JFrame frame = new JFrame("TopLevelDemo");
//        frame.setPreferredSize(new Dimension(900, 800));
//        // JPanel p = new JPanel(new BorderLayout());
//        JPanel gui = new JPanel(new GridLayout(9, 10, 4, 4));
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        

        this.frame = new JFrame("TopLevelDemo");
        this.frame.setPreferredSize(new Dimension(900, 800));
        this.gui = new JPanel(new GridLayout(9, 10, 4, 4));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        piirraGraafinenRuudukko(gui);
        frame.getContentPane().add(gui);
        frame.pack();
        frame.setVisible(true);

        JOptionPane.getDesktopPaneForComponent(gui);

        // JOptionPane.showMessageDialog(null, gui);
    }

    public void paivita() {

        piirraGraafinenRuudukko(this.gui);

    }

    private void piirraGraafinenRuudukko(JPanel gui) {
        // tulostaVaakaKordinaatti(gui);

        for (int i = 0; i < 8; i++) {
            tulostaPystyKordinaatti(i, gui);
            for (int j = 0; j < 8; j++) {
                if (this.lauta.getRuutu(i, j).getVari() == EnumVari.VALKOINEN) {
                    if (this.nappulatSet.getNappula(i, j) != null) {
                        piirraRuutu(this.nappulatSet.getNappula(i, j).uCodeNappula(), gui, Color.white, i, j);
                    } else {
                        piirraRuutu(" ", gui, Color.white, i, j);
                    }
                } else if (this.lauta.getRuutu(i, j).getVari() == EnumVari.MUSTA) {
                    if (this.nappulatSet.getNappula(i, j) != null) {
                        piirraRuutu(this.nappulatSet.getNappula(i, j).uCodeNappula(), gui, Color.gray, i, j);
                    } else {
                        piirraRuutu(" ", gui, Color.gray, i, j);
                    }
                }
            }
            tulostaPystyKordinaatti(i, gui);
        }
        tulostaVaakaKordinaatti(gui);
    }

    public void piirraRuutu(String s, Container c, Color d, int x, int y) {

        JLabel l = new JLabel(s);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(font);
        l.setOpaque(true);
        l.setBackground(d);
        l.addMouseListener(new HiirenKuuntelija(this, l, this.pelimoottori, this.nappulatSet, x, y));
        c.add(l);
    }

    public void tulostaPystyKordinaatti(int i, JPanel gui) {
        piirraRuutu(Integer.toString(8 - i), gui, null, 10, 10);

    }

    public void tulostaVaakaKordinaatti(JPanel gui) {
        String kord = " ABCDEFGH  ";
        for (int i = 0; i < 9; i++) {
            piirraRuutu("" + kord.charAt(i), gui, null, 10, 10);
        }
    }

    public Pelimoottori getPelimoottori() {
        return pelimoottori;
    }

    public Lauta getLauta() {
        return lauta;
    }

    public NappulaSet getNappulatSet() {
        return nappulatSet;
    }

}
