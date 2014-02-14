package shakkilabra.GameEngine;

import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Nappula;
import java.util.ArrayList;
import java.util.List;

/**
 * Nappulat lista, jossa kaikki pelilaudalla olevat nappulat
 *
 * Valkoiset "\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659" Mustat
 * "\u265A", "\u265B", "\u265C", "\u265D", "\u265E", "\u265F" Ruudut Color.white
 * Color.gray
 *
 * @author marko
 */
public class NappulaSet {

    private List<Nappula> nappulat;

    public NappulaSet() {
        this.nappulat = new ArrayList<Nappula>();
    }

    /**
     * lisätään nappula listalle
     *
     * @param nappula uusi nappula
     */
    public void lisaaNappula(Nappula nappula) {
        this.nappulat.add(nappula);
    }

    /**
     * Poistetaan nappula listalta
     *
     * @param nappula poistettava nappula
     */
    public void poistaNappula(Nappula nappula) {
        this.nappulat.remove(nappula);
    }

    /**
     * Onko ruutu vapaa testi tarkistaa onko annetussa sijainnissa nappula
     *
     * @param x tarkistettava X
     * @param y tarkistettava Y
     * @return Palauttaa true, jos ruutu on vapaa
     */
    public boolean onkoRuuduVapaa(int x, int y) {

        for (Nappula n : this.nappulat) {
            if (n.getKordinaatti().getX() == x && n.getKordinaatti().getY() == y) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tarkistaa onko ruutu valitun nappulan siirrot listalla
     *
     * @param x tarkistettava X
     * @param y tarkistettava Y
     * @return Palauttaa true jos siirto on mahdollinen
     */
    public boolean onkoRuutuValitunNappulanSiirroissa(int x, int y) {
        for (Kordinaatti k : annaValittuNappula().getMahdollisetSiirrot()) {
            if (k.getX() == x && k.getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Syökö nappula valittuun sijaintii. tämä tarkistus toimii sotilaalla.
     * Muilla nappuloilla arvo on true
     *
     * @param x tarkistettava X
     * @param y tarkistettava Y
     * @return Palauttaa true jos nappula syö sijaintiin
     */
    public boolean syokoValittuNappulaSijaintiin(int x, int y) {
        return annaValittuNappula().syokoNappula(x, y);
    }
/**
 * Nappulalla voi olla Valittu arvo true. Tällöin palautettaan valittu nappula
 * @return valittu nappula
 */
    public Nappula annaValittuNappula() {
        for (Nappula n : this.nappulat) {
            if (n.isValittu()) {
                return n;
            }
        }
        return null;
    }
/**
 * Tämä testi ei käytössä
 * @param n
 * @param x
 * @param y
 * @return 
 */
    public boolean onkoLinjallaMuitaNappuloitaTesti(Nappula n, int x, int y) {

        return false;
    }

    public Nappula getNappula(int x, int y) {
        for (Nappula n : nappulat) {
            if (n.getKordinaatti().getX() == x && n.getKordinaatti().getY() == y) {
                return n;
            }
        }
        return null;
    }

    public int getNappulatSize() {
        return this.nappulat.size();
    }
/**
 * DEBUG // asciipelimoottorin toimintoja, jotka olivat käytössä pelin 
 * alkuvaiheen luonnissa.
 */

    public void tulostaNappulat() {
        for (Nappula n : this.nappulat) {
            if (n.isElossa()) {
                System.out.println(n);
            }
        }
        System.out.println("");
    }

    public void tulostaMahdollisetSiirrotXY(int x, int y) {
        System.out.println("Mahdolliset siirrot nappulalle " + getNappula(x, y));
        for (Kordinaatti k : getNappula(x, y).getMahdollisetSiirrot()) {
            System.out.print(k.getX() + "," + k.getY() + ", ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void tulostaValitunNappulanMahdollisetSiirrot() {
        System.out.println("Mahdolliset siirrot nappulalle " + annaValittuNappula());
        for (Kordinaatti k : annaValittuNappula().getMahdollisetSiirrot()) {
            System.out.print(k.getX() + "," + k.getY() + ", ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void asciiLautaTulostin() {
        System.out.println("Tulostetaan lauta...");
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (getNappula(x, y) != null && getNappula(x, y).isElossa()) {
                    System.out.print(" " + getNappula(x, y).getTyyppi() + "" + getNappula(x, y).getVari());

                } else {
                    System.out.print(" x ");
                }
            }
            System.out.println("");
        }
        System.out.println("");

    }

    public void asciiMahdollisetSiirrot(int xX, int yY) {
        System.out.println("Tulostetaan mahdolliset siirrot nappulalle: " + xX + "," + yY);
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (onkoRuutuValitunNappulanSiirroissa(x, y)) {
                    System.out.print(" o ");
                } else if (getNappula(x, y) != null && getNappula(x, y).isElossa()) {
                    System.out.print(" " + getNappula(x, y).getTyyppi() + "" + getNappula(x, y).getVari());
                } else {
                    System.out.print(" x ");
                }
            }
            System.out.println("");
        }
        System.out.println("");

    }

}
