package shakkilabra.Grafiikka;

import shakkilabra.Assets.EnumVari;
import shakkilabra.GameEngine.NappulaSet;
import shakkilabra.GameEngine.Pelilogiikka;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import shakkilabra.CoverageIgnore;

/**
 * Grafiikkamoottori vastaa pelin grafiikasta
 *
 * @author marko
 */
@CoverageIgnore
public final class Grafiikkamoottori implements Runnable {

    static Font font = new Font("Lucida Grande", Font.PLAIN, 64);
    private final Pelilogiikka pelilogiikka;
    private final Lauta lauta;
    private final NappulaSet nappulatSet;
    private JFrame frame;
    private JPanel ruudukko;
    private JLabel valittuRuutu;
    private final SiirrotNaytto siirrotNaytto;
    private final Color valkoinen;
    private final Color musta;

    public Grafiikkamoottori() {
        this.valkoinen = new Color(243, 255, 255, 100);
        this.musta = new Color(0, 100, 200, 70);
        this.siirrotNaytto = new SiirrotNaytto();
        this.pelilogiikka = new Pelilogiikka(this.siirrotNaytto);
        this.nappulatSet = new NappulaSet();
        this.lauta = new Lauta();
        this.valittuRuutu = null;
    }

    /**
     * Käynnistää Pelin
     */
    @Override
    public void run() {
        luoUusiIkkuna();
        luoNappulatAlkuTilanteeseen();
        luoUusiGraafinenRuudukko();
        luoUusiPeliJaKaynnista();
    }

    /**
     * luo tällä Peli-ikkunan, menun,
     *
     */
    private void luoUusiIkkuna() {

        frame = new JFrame("ShakkiLabra 2014");
        //Dimension naytonKoko = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setPreferredSize(new Dimension(1300, 900));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Luo ylävalikon
        frame.setJMenuBar(new YlaValikko(this).luoYlaValikko());
        //Luodaan laudan Grid
        ruudukko = new JPanel(new GridLayout(9, 9, 4, 4));
        ruudukko.setPreferredSize(new Dimension(900, 800));
        ruudukko.setBackground(new Color(0, 0, 0, 0));
        //piirretään peliNäyttö
        siirrotNaytto.luoSiirrotNaytto();
    }

    /**
     * asettaa nappulat alkutilanteeseen. Voidaan käyttä myös luodessa uutta
     * peliä, jolloin lauta ensin tyhjennetään ja asetetaan vuoro valkoiselle
     *
     */
    public void luoNappulatAlkuTilanteeseen() {
        System.out.println("Tyhjennetään lista");
        nappulatSet.tyhjennaNappulatLista();
        nappulatSet.luoNappulatLaudalle();
        pelilogiikka.setValkoisenVuoro(true);
    }

    /**
     * Luodaan taustakerros, johon lisätään kuva. Kuvakerrokseen lisätään lauta
     * ja SiirrotNäyttö elementit. TaustaKerros lisätään Frameen.
     */
    public void luoUusiPeliJaKaynnista() {
        //luodaan tausta johon liitetään lauta ja sivupaneeli
        TaustaKerros taustaKerros = new TaustaKerros("PuuTausta.jpg");
        taustaKerros.add(new AlphaLaatikko(ruudukko), BorderLayout.WEST);
        taustaKerros.add(new AlphaLaatikko(this.siirrotNaytto.getSiirrotNaytto()), BorderLayout.BEFORE_LINE_BEGINS);
        taustaKerros.setBorder(new EmptyBorder(20, 0, 0, 0));

        frame.getContentPane().add(taustaKerros, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
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
    public void paivitaRuutu(JLabel l, int x, int y) {
        valittuRuutu.setText(null);
        valittuRuutu.setOpaque(false);
        valittuRuutu = null;
        l.setText(nappulatSet.getNappula(x, y).uCodeNappula());

    }

    /**
     * Koko laudan läpikäyvä päivitys Tyhjentää ruudun ja jos ruutu sisältää
     * nappulan asetetaan nappula ruutuun
     */
    public void paivitaKokoLauta() {
        System.out.println("Päivitetään nappulat...");
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                lauta.getRuutu(x, y).getJLabel().setText(null);
                if (nappulatSet.getNappula(x, y) != null) {
                    lauta.getRuutu(x, y).getJLabel().setText(nappulatSet.getNappula(x, y).uCodeNappula());
                }
            }
        }
    }

    /**
     * Päivittää valitun nappulan värin
     */

    public void paivitaValintaVari() {
        valittuRuutu.setForeground(new Color(150, 0, 0, 255));
    }

    /**
     * Ruudukon luontitoimnnot. Käytetään luotaessa uutta lautaa.
     *
     */
    public void luoUusiGraafinenRuudukko() {

        for (int i = 0; i < 8; i++) {
            tulostaPystyKordinaatti(i);
            for (int j = 0; j < 8; j++) {
                if (lauta.getRuutu(i, j).getVari() == EnumVari.VALKOINEN) {
                    luoValkoinenRuutu(i, j, lauta.getRuutu(i, j).getJLabel());
                } else if (lauta.getRuutu(i, j).getVari() == EnumVari.MUSTA) {
                    luoMustaRuutu(i, j, lauta.getRuutu(i, j).getJLabel());
                }
            }
        }
        tulostaVaakaKordinaatti();
    }

    /**
     * jos ruutu on musta
     *
     * @param i X kordinaatti
     * @param j Y kordinaatti
     */
    private void luoMustaRuutu(int i, int j, JLabel jlabel) {

        if (nappulatSet.getNappula(i, j) != null) {
            luoRuutu(nappulatSet.getNappula(i, j).uCodeNappula(), musta, i, j, jlabel);
        } else {
            luoRuutu(" ", musta, i, j, jlabel);
        }
    }

    /**
     * jos ruutu on Valkoinen
     *
     * @param i X kordinaatti
     * @param j Y kordinaatti
     */
    private void luoValkoinenRuutu(int i, int j, JLabel jlabel) {

        if (nappulatSet.getNappula(i, j) != null) {
            luoRuutu(nappulatSet.getNappula(i, j).uCodeNappula(), valkoinen, i, j, jlabel);
        } else {
            luoRuutu(" ", valkoinen, i, j, jlabel);
        }
    }

    /**
     * Luo jokaiseen ruutuun uuden JLabelin, asettaa sille fonttina nappulan,
     * keskittää sen, asettaa oikean fontin, luo taustan ja hiirenkuuntelijan
     *
     * @param s Nappula
     * @param d Väri
     * @param x X kordinaatti
     * @param y Y kordinaatti
     * @param jlabel
     */
    public void luoRuutu(String s, Color d, int x, int y, JLabel jlabel) {

        JLabel l = jlabel;
        l.setText(s);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(font);
        l.setBackground(d);
        if (d != null) {
            //Jos ShakkiRuutu niin aseta HiirenKuuntelija
            l.addMouseListener(new HiirenKuuntelija(this, l, pelilogiikka, nappulatSet, x, y));
        } else {
            l.setForeground(new Color(0, 0, 0, 180));
            l.setBackground(new Color(0, 0, 0, 0));
        }
        ruudukko.add(new AlphaLaatikko(l));
    }

    /**
     * Kordinaatiston luonti
     *
     * @param i
     */
    private void tulostaPystyKordinaatti(int i) {
        luoRuutu(Integer.toString(8 - i), null, 10, 10, new JLabel());
    }

    private void tulostaVaakaKordinaatti() {
        String kord = " ABCDEFGH  ";
        for (int i = 0; i < 9; i++) {
            luoRuutu("" + kord.charAt(i), null, 10, 10, new JLabel());
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

    /**
     * Siirtonäytto setVisible true/false
     */
    public void naytaSiirtoNaytto() {
        this.siirrotNaytto.piilotaSiirrotNaytto();
    }

    public boolean isSiirrotNayttoNakyvissa() {
        return this.siirrotNaytto.isVisible();
    }

}
