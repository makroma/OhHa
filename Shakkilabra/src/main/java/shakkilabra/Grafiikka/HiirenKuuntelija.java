package shakkilabra.Grafiikka;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import shakkilabra.GameEngine.NappulaSet;
import shakkilabra.GameEngine.Pelilogiikka;

/**
 * Hiirenkuuntelija luokka
 *
 * @author marko
 */
public class HiirenKuuntelija implements MouseListener {

    private final Pelilogiikka pelimoottori;
    private final NappulaSet nappulat;
    private final JLabel jlabel;
    private final int x;
    private final int y;
    private final Grafiikkamoottori grafiikkamoottori;

    /**
     *
     * @param g
     * @param j
     * @param p
     * @param n
     * @param x
     * @param y
     */
    public HiirenKuuntelija(Grafiikkamoottori g, JLabel j, Pelilogiikka p, NappulaSet n, int x, int y) {
        this.jlabel = j;
        this.pelimoottori = p;
        this.nappulat = n;
        this.x = x;
        this.y = y;
        this.grafiikkamoottori = g;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Hiiren klikkaus - Jos x-y kordinaatissa on nappula ja nappulaa ei ole
     * valittu, valitaan nappula ja asetetaan ruutu valituksi ja vaihdetaan
     * valitun nappulan väri. - Jos nappula on valittu siirrytään nappulan
     * liikuttamiseen, jos siirto onnistui muutetaan nappulan väri, ja
     * päivitetään grafiikkamoottori, jos epä onnistuu niin nappulan valinta =
     * null ja väri musta
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (nappulat.getNappula(x, y) != null && nappulat.annaValittuNappula() == null) {
            nappulanValinta();
        } else if (nappulat.annaValittuNappula() != null) {
            valitunNappulanLiikuttaminen();
        }
    }
    
    /**
     * Jos jokin nappula on valittu ryhdytään siirtämään kyseistä nappulaa
     */

    private void valitunNappulanLiikuttaminen() {
        nappulat.tulostaValitunNappulanMahdollisetSiirrot();
        System.out.println("Liikutetaan nappulaa " + nappulat.annaValittuNappula() + " sijaintiin " + x + ", " + y);

        if (pelimoottori.testaaNappulanSiirtoJaToteutaSe(nappulat, x, y)) {
            grafiikkamoottori.getValittuRuutu().setForeground(Color.BLACK);
            grafiikkamoottori.paivitaRuutu(jlabel, x, y);

        } else {
            grafiikkamoottori.getValittuRuutu().setForeground(Color.BLACK);
            grafiikkamoottori.setValittuRuutu(null);
        }
    }
/**
 * jos nappulaa ei ole valittu. Valitaan ruudussa oleva nappula.
 */
    private void nappulanValinta() {
        System.out.println("Nappula valittu " + nappulat.getNappula(x, y));
        nappulat.getNappula(x, y).setValittu(true);
        grafiikkamoottori.setValittuRuutu(jlabel);
        grafiikkamoottori.paivitaValintaVari();
    }
}
