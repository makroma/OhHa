package shakkilabra.Grafiikka;

import shakkilabra.Assets.EnumVari;
import shakkilabra.GameEngine.NappulaSet;
import shakkilabra.GameEngine.Pelilogiikka;
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
 * Grafiikkamoottori vastaa pelin grafiikasta
 *
 * @author marko
 */
public final class Grafiikkamoottori {

    static Font font = new Font("Sans-Serif", Font.PLAIN, 64);
    private Pelilogiikka pelilogiikka;
    private Lauta lauta;
    private NappulaSet nappulatSet;
    private JFrame frame;
    private JPanel gui;
    private Menu menu;

    public Grafiikkamoottori() {
        this.pelilogiikka = new Pelilogiikka();
        this.nappulatSet = new NappulaSet();
        this.lauta = new Lauta();
        this.menu = new Menu();

    }

    /**
     * luo tällä hetkellä vain sotilaat laudalle pelilogiikan metodilla
     *
     */
    public void luoPeli() {
        this.pelilogiikka.luoSotilaatLaudalle(this.nappulatSet);

    }

    /**
     * Käynnistää graafiset ominaisuudet
     */
    public void run() {
        this.frame = new JFrame("TopLevelChessInterface");
        this.frame.setPreferredSize(new Dimension(900, 800));
        //Luo ylävalikon
        frame.setJMenuBar(menu.createMenuBar());
        this.gui = new JPanel(new GridLayout(9, 10, 4, 4));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        piirraGraafinenRuudukko(gui);
        frame.getContentPane().add(gui);
        frame.pack();
        frame.setVisible(true);

        JOptionPane.getDesktopPaneForComponent(gui);
    }

    /**
     * Tämä metodi ei vielä käydössä. Tuleva laajennut tarvitsee tätä
     */
    public void paivita() {

        piirraGraafinenRuudukko(this.gui);

    }

    /**
     * Ruudukon luontitoimnnot
     *
     * @param gui parametrina JPanel
     */
    private void piirraGraafinenRuudukko(JPanel gui) {

        for (int i = 0; i < 8; i++) {
            tulostaPystyKordinaatti(i, gui);
            for (int j = 0; j < 8; j++) {
                if (this.lauta.getRuutu(i, j).getVari() == EnumVari.VALKOINEN) {
                    luoValkoinenRuutu(i, j, gui);
                } else if (this.lauta.getRuutu(i, j).getVari() == EnumVari.MUSTA) {
                    luoMustaRuutu(i, j, gui);
                }
            }
            tulostaPystyKordinaatti(i, gui);
        }
        tulostaVaakaKordinaatti(gui);
    }

    /**
     * jos ruutu on musta
     *
     * @param i X kordinaatti
     * @param j Y kordinaatti
     * @param gui JPanel
     */
    private void luoMustaRuutu(int i, int j, JPanel gui) {
        if (this.nappulatSet.getNappula(i, j) != null) {
            piirraRuutu(this.nappulatSet.getNappula(i, j).uCodeNappula(), gui, Color.gray, i, j);
        } else {
            piirraRuutu(" ", gui, Color.gray, i, j);
        }
    }

    /**
     * jos ruutu on Valkoinen
     *
     * @param i X kordinaatti
     * @param j Y kordinaatti
     * @param gui JPanel
     */
    private void luoValkoinenRuutu(int i, int j, JPanel gui) {
        if (this.nappulatSet.getNappula(i, j) != null) {
            piirraRuutu(this.nappulatSet.getNappula(i, j).uCodeNappula(), gui, Color.white, i, j);
        } else {
            piirraRuutu(" ", gui, Color.white, i, j);
        }
    }

    /**
     * Luo jokaiseen ruutuun uuden JLabelin, asettaa sille fonttina nappulan,
     * keskittää sen, asettaa oikean fontin, luo taustan ja hiirenkuuntelijan
     *
     * @param s Nappula
     * @param c JPanel container
     * @param d Väri
     * @param x X kordinaatti
     * @param y Y kordinaatti
     */

    public void piirraRuutu(String s, Container c, Color d, int x, int y) {

        JLabel l = new JLabel(s);
        l.setText(s);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(font);
        l.setOpaque(true);
        l.setBackground(d);
        l.addMouseListener(new HiirenKuuntelija(this, l, this.pelilogiikka, this.nappulatSet, x, y));
        c.add(l);
    }

    /**
     * Kordinaatiston luonti
     *
     * @param i
     * @param gui
     */
    public void tulostaPystyKordinaatti(int i, JPanel gui) {
        piirraRuutu(Integer.toString(8 - i), gui, null, 10, 10);
    }

    public void tulostaVaakaKordinaatti(JPanel gui) {
        String kord = " ABCDEFGH  ";
        for (int i = 0; i < 9; i++) {
            piirraRuutu("" + kord.charAt(i), gui, null, 10, 10);
        }
    }

    /*
     * GETTERIT
     *
     */
    public Pelilogiikka getPelimoottori() {
        return pelilogiikka;
    }

    public Lauta getLauta() {
        return lauta;
    }

    public NappulaSet getNappulatSet() {
        return nappulatSet;
    }

}
