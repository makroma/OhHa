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
import java.awt.BorderLayout;

/**
 * Grafiikkamoottori vastaa pelin grafiikasta
 *
 * @author marko
 */
public final class Grafiikkamoottori implements Runnable {

    static Font font = new Font("Sans-Serif", Font.PLAIN, 64);
    private Pelilogiikka pelilogiikka;
    private Lauta lauta;
    private NappulaSet nappulatSet;
    private JFrame frame;
    private JPanel gui;
    private final Menu menu;
    private JLabel valittuRuutu;
    private Pelinaytto pelinaytto;
    private JPanel syodytNappulat;
    private Color valkoinen;
    private Color musta;

    public Grafiikkamoottori() {
        this.valkoinen = new Color(255, 255, 255, 255);
        this.musta = new Color(0, 100, 200, 255);
        this.pelinaytto = new Pelinaytto();
        this.pelilogiikka = new Pelilogiikka(this.pelinaytto);
        this.nappulatSet = new NappulaSet();
        this.lauta = new Lauta();
        this.menu = new Menu();
        this.valittuRuutu = null;

    }

    /**
     * luo tällä Peli-ikkunan, menun,
     *
     */
    public void luoPeli() {

        this.frame = new JFrame("ShakkiLabra 2014");
        this.frame.setPreferredSize(new Dimension(1200, 830));
        //    this.frame.setBackground(new Color(0, 0, 0, 0));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Luo ylävalikon
        frame.setJMenuBar(menu.createMenuBar());
        //Luodaan laudan Grid
        this.gui = new JPanel(new GridLayout(9, 10, 4, 4));
        this.gui.setPreferredSize(new Dimension(900, 800));
        this.gui.setBackground(new Color(0, 0, 0, 0));
        //Alalaidan syödyt nappulat

//        this.syodytNappulat = new JPanel(new GridLayout(32, 1, 4, 4));
//        this.syodytNappulat.setPreferredSize(new Dimension(1200, 64));
//        
    }

    /**
     * Käynnistää graafiset ominaisuudet
     */
    @Override
    public void run() {
        luoPeli();
        this.pelilogiikka.luoNappulatLaudalle(this.nappulatSet);
//
//        //Siirrytään ruudukon luontiin
        piirraGraafinenRuudukko();
        //  frame.getContentPane().add(gui, BorderLayout.WEST);
//
//        //piirretään peliNäyttö
//        this.pelinaytto.piirraPelinaytto();
//        this.frame.getContentPane().add(this.pelinaytto.getNaytto(), BorderLayout.EAST);
//        
//        
//        JLabel l = new JLabel("X");
//        l.setText("X");
//        this.syodytNappulat.setBackground(Color.red);
//        this.syodytNappulat.add(l);
//        this.frame.getContentPane().add(this.syodytNappulat, BorderLayout.SOUTH);
        Taustakuva taustakuva = new Taustakuva("./src/main/java/Image/wood3.jpg");

        taustakuva.add(gui);
        taustakuva.setBackground(new Color(0, 100, 0, 255));
        frame.getContentPane().add(taustakuva);
        //frame.setLocationRelativeTo(null);

        frame.pack();
        frame.setVisible(true);

        JOptionPane.getDesktopPaneForComponent(gui);

    }

    /**
     * Muutettujen ruutujen päivitysMetodi Hiiren kuuntelija asettaa
     * valittuRuutu = JLabel kun valitaan ruutu. Kun tehdään siirto kutsutaan
     * paivitaMetodia, joka tyhjentää vanhan ruudun, asettaa valinnan null,
     * asettaa uuten ruutuun nappulan. ja päivittää guin.
     *
     * @param l tuo hiirenlukijalta kyseisen JLabel elementin
     * @param x hakee X Y kordinaateilla kyseisen ruuden nappulan
     * @param y
     */
    public void paivita(JLabel l, int x, int y) {

        //this.pelinaytto.kirjoitaPeliNayttoon("Tänne tulee kohta tehdyt siirrot!");
        this.valittuRuutu.setText(null);
        this.valittuRuutu = null;
        //  l.setForeground(Color.BLACK);

        l.setBackground(new Color(255, 255, 255, 255));
        l.setOpaque(true);
        System.out.println(l.isOpaque());
        l.repaint();
        l.setText(this.nappulatSet.getNappula(x, y).uCodeNappula());

    }

    public void paivitaValintaVari() {

        //this.valittuRuutu.setBackground(new Color(100, 0, 0, 255));
        this.valittuRuutu.setForeground(Color.GREEN);
    }

    /**
     * Ruudukon luontitoimnnot
     *
     * @param gui parametrina JPanel
     */
    private void piirraGraafinenRuudukko() {

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
            piirraRuutu(this.nappulatSet.getNappula(i, j).uCodeNappula(), gui, this.musta, i, j);
        } else {
            piirraRuutu(" ", gui, this.musta, i, j);
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
            piirraRuutu(this.nappulatSet.getNappula(i, j).uCodeNappula(), gui, this.valkoinen, i, j);
        } else {
            piirraRuutu(" ", gui, this.valkoinen, i, j);
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
        if (d != null) {
            l.addMouseListener(new HiirenKuuntelija(this, l, this.pelilogiikka, this.nappulatSet, x, y));
        }
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

    public void setValittuRuutu(JLabel valittuRuutu) {
        this.valittuRuutu = valittuRuutu;
    }

    public JLabel getValittuRuutu() {
        return valittuRuutu;
    }

}
