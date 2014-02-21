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
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;

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
    private Pelinaytto siirtoNaytto;
    private JPanel syodytNappulat;
    private Color valkoinen;
    private Color musta;

    public Grafiikkamoottori() {
        this.valkoinen = new Color(243, 255, 255, 100);
        this.musta = new Color(0, 100, 200, 70);
        //this.musta = new Color(34, 83, 120, 100);
        this.siirtoNaytto = new Pelinaytto();
        this.pelilogiikka = new Pelilogiikka(this.siirtoNaytto);
        this.nappulatSet = new NappulaSet();
        this.lauta = new Lauta();
        this.menu = new Menu(this);
        this.valittuRuutu = null;

    }

    /**
     * luo tällä Peli-ikkunan, menun,
     *
     */
    public void luoPeli() {

        this.pelilogiikka.luoNappulatLaudalle(this.nappulatSet);

        this.frame = new JFrame("ShakkiLabra 2014");
        Dimension naytonKoko = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setPreferredSize(naytonKoko);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Luo ylävalikon
        frame.setJMenuBar(menu.createMenuBar());
        //Luodaan laudan Grid
        this.gui = new JPanel(new GridLayout(9, 9, 4, 4));
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

        //Siirrytään ruudukon luontiin
        piirraGraafinenRuudukko();

        //piirretään peliNäyttö
        this.siirtoNaytto.luoSiirtoNaytto();

        //luodaan tausta johon liitetään lauta ja sivupaneeli
        Taustakuva kuvaKerros = new Taustakuva("./src/main/java/Image/PuuTausta.jpg");
        kuvaKerros.add(new AlphaLaatikko(gui), BorderLayout.WEST);
        kuvaKerros.add(new AlphaLaatikko(this.siirtoNaytto.getNaytto()), BorderLayout.BEFORE_LINE_BEGINS);
        kuvaKerros.setBorder(new EmptyBorder(20, 0, 0, 0));

        frame.getContentPane().add(kuvaKerros, BorderLayout.CENTER);
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

        this.valittuRuutu.setText(null);
        this.valittuRuutu.setOpaque(false);
        this.valittuRuutu = null;
        l.setText(this.nappulatSet.getNappula(x, y).uCodeNappula());

    }

    public void paivitaValintaVari() {

        this.valittuRuutu.setForeground(new Color(150, 0, 0, 255));
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
            //tulostaPystyKordinaatti(i, gui);
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

        JLabel l = new JLabel();
        l.setText(s);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(font);
        l.setBackground(d);
        if (d != null) {
            l.addMouseListener(new HiirenKuuntelija(this, l, this.pelilogiikka, this.nappulatSet, x, y));
        } else {
            l.setForeground(new Color(0, 0, 0, 180));
            l.setBackground(new Color(0, 0, 0, 0));
        }
        c.add(new AlphaLaatikko(l));
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

    public boolean isSiirrotNayttoNakyvissa() {
        return this.siirtoNaytto.isVisible();
    }

    /**
     * Siirtonäytto setVisible true/false
     */
    public void naytaSiirtoNaytto() {
        this.siirtoNaytto.piilotaPeliNaytto();
    }

}
