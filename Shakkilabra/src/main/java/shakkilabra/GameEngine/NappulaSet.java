package shakkilabra.GameEngine;

import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Nappula;
import java.util.ArrayList;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Nappulat.Hevonen;
import shakkilabra.Assets.Nappulat.Kuningas;
import shakkilabra.Assets.Nappulat.Kuningatar;
import shakkilabra.Assets.Nappulat.Lahetti;
import shakkilabra.Assets.Nappulat.Sotilas;
import shakkilabra.Assets.Nappulat.Torni;

/**
 * Nappulat lista, jossa kaikki pelilaudalla olevat nappulat
 *
 * Valkoiset "\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659" Mustat
 * "\u265A", "\u265B", "\u265C", "\u265D", "\u265E", "\u265F"
 *
 * @author marko
 */
public class NappulaSet {

    private ArrayList<Nappula> nappulat;

    /**
     * Luo uuden NappulatSetin
     */
    public NappulaSet() {
        nappulat = new ArrayList<>();
    }

    /**
     * Luo nappulat aloitussijainteihin.
     *
     */
    public void luoNappulatLaudalle() {

        System.out.println("Luodaan nappulat...");

        //luodaan valoinen kunngas
        nappulat.add(new Kuningas(EnumVari.VALKOINEN, 7, 4));
        //luodaan valkoinen kuningatar
        nappulat.add(new Kuningatar(EnumVari.VALKOINEN, 7, 3));
        //luodaan valkoinen Lahetti
        nappulat.add(new Lahetti(EnumVari.VALKOINEN, 7, 2));
        nappulat.add(new Lahetti(EnumVari.VALKOINEN, 7, 5));
        //luodaan valoinen Torni
        nappulat.add(new Torni(EnumVari.VALKOINEN, 7, 0));
        nappulat.add(new Torni(EnumVari.VALKOINEN, 7, 7));
        //luodaan valkoiset hevoset
        nappulat.add(new Hevonen(EnumVari.VALKOINEN, 7, 6));
        nappulat.add(new Hevonen(EnumVari.VALKOINEN, 7, 1));
        //luodaan valkoiset Sotilaat
        nappulat.add(new Sotilas(EnumVari.VALKOINEN, 6, 0));
        nappulat.add(new Sotilas(EnumVari.VALKOINEN, 6, 1));
        nappulat.add(new Sotilas(EnumVari.VALKOINEN, 6, 2));
        nappulat.add(new Sotilas(EnumVari.VALKOINEN, 6, 3));
        nappulat.add(new Sotilas(EnumVari.VALKOINEN, 6, 4));
        nappulat.add(new Sotilas(EnumVari.VALKOINEN, 6, 5));
        nappulat.add(new Sotilas(EnumVari.VALKOINEN, 6, 6));
        nappulat.add(new Sotilas(EnumVari.VALKOINEN, 6, 7));

        //luodaan musta kuningas
        nappulat.add(new Kuningas(EnumVari.MUSTA, 0, 4));
        //luodaan Musta kuningatar
        nappulat.add(new Kuningatar(EnumVari.MUSTA, 0, 3));
        //luodaan Musta Lahetti
        nappulat.add(new Lahetti(EnumVari.MUSTA, 0, 2));
        nappulat.add(new Lahetti(EnumVari.MUSTA, 0, 5));
        //luodaan musta Torni
        nappulat.add(new Torni(EnumVari.MUSTA, 0, 0));
        nappulat.add(new Torni(EnumVari.MUSTA, 0, 7));
        //luodaan Mustat Hevoset
        nappulat.add(new Hevonen(EnumVari.MUSTA, 0, 6));
        nappulat.add(new Hevonen(EnumVari.MUSTA, 0, 1));
        //luodaan mustat Sotilaat
        nappulat.add(new Sotilas(EnumVari.MUSTA, 1, 0));
        nappulat.add(new Sotilas(EnumVari.MUSTA, 1, 1));
        nappulat.add(new Sotilas(EnumVari.MUSTA, 1, 2));
        nappulat.add(new Sotilas(EnumVari.MUSTA, 1, 3));
        nappulat.add(new Sotilas(EnumVari.MUSTA, 1, 4));
        nappulat.add(new Sotilas(EnumVari.MUSTA, 1, 5));
        nappulat.add(new Sotilas(EnumVari.MUSTA, 1, 6));
        nappulat.add(new Sotilas(EnumVari.MUSTA, 1, 7));
    }

    /**
     * lisätään nappula listalle
     *
     * @param nappula uusi nappula
     */
    public void lisaaNappula(Nappula nappula) {
        nappulat.add(nappula);
    }

    /**
     * Poistetaan nappula listalta
     *
     * @param nappula poistettava nappula
     */
    public void poistaNappula(Nappula nappula) {
        nappulat.remove(nappula);
    }

    /**
     * Onko ruutu vapaa testi tarkistaa onko annetussa sijainnissa nappula
     *
     * @param x tarkistettava X
     * @param y tarkistettava Y
     * @return Palauttaa true, jos ruutu on vapaa
     */
    public boolean onkoRuuduVapaa(int x, int y) {

        for (Nappula n : nappulat) {
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
     * Nappulalla voi olla Valittu arvo true. Tällöin palautetaan valittu
     * nappula
     *
     * @return valittu nappula
     */
    public Nappula annaValittuNappula() {
        for (Nappula n : nappulat) {
            if (n.isValittu()) {
                return n;
            }
        }
        return null;
    }

    /**
     * Tehjentää nappulatlistan nappuloista
     */
    public void tyhjennaNappulatLista() {
        nappulat.clear();
    }

    /*
     *GETTERI JA SETTERIT
     */
    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Nappula getNappula(int x, int y) {
        for (Nappula n : nappulat) {
            if (n.getKordinaatti().getX() == x && n.getKordinaatti().getY() == y) {
                return n;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public int getNappulatSize() {
        return nappulat.size();
    }

    /**
     * DEBUG // asciipelimoottorin toimintoja, jotka olivat käytössä pelin
     * alkuvaiheen luonnissa.
     *
     * public void tulostaNappulat() { for (Nappula n : nappulat) { if
     * (n.isElossa()) { System.out.println(n + n.getKordinaatti().getXY()); } }
     * System.out.println(""); }
     *
     *
     * public void tulostaMahdollisetSiirrotXY(int x, int y) {
     * System.out.println("Mahdolliset siirrot nappulalle " + getNappula(x, y));
     * for (Kordinaatti k : getNappula(x, y).getMahdollisetSiirrot()) {
     * System.out.print(k.getX() + "," + k.getY() + ", "); }
     * System.out.println(""); System.out.println(""); }
     */
    /**
     *
     */
    public void tulostaValitunNappulanMahdollisetSiirrot() {
        System.out.println("Mahdolliset siirrot nappulalle " + annaValittuNappula());
        for (Kordinaatti k : annaValittuNappula().getMahdollisetSiirrot()) {
            System.out.print(k.getX() + "," + k.getY() + ", ");
        }
        System.out.println("");
        System.out.println("");
    }

    /*
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
     */

    /*
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
     */
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        for (Nappula n : nappulat) {
            s += n.toString();
        }
        return s;
    }

}
