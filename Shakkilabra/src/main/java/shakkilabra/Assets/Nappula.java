package shakkilabra.Assets;

import java.util.ArrayList;

/**
 * Abstrakti Nappulat yläluokka
 *
 * @author marko
 */
public abstract class Nappula {

    private EnumTyyppi tyyppi;
    private EnumVari vari;
    private Kordinaatti kordinaatti;
    private int siirtojenMaara;
    private boolean elossa;
    private boolean valittu;

    /**
     * Nappulat konstruktori
     *
     * @param tyyppi Nappulan EnumTyyppi
     * @param vari Nappulan Väri
     * @param kord Nappulan kordinaatti
     */
    public Nappula(EnumTyyppi tyyppi, EnumVari vari, Kordinaatti kord) {
        this.tyyppi = tyyppi;
        this.vari = vari;
        this.kordinaatti = kord;
        this.siirtojenMaara = 0;
        this.elossa = true;
        this.valittu = false;
    }

    /**
     * *Abstraktit luokat, jotka jokainen nappula toteuttaa
     *
     * @param x Xkordinaatti
     * @param y YKordinaatti
     */
    public abstract void liiku(int x, int y);

    /**
     * Palauttaa nappulan graafisen ulkomuodon
     *
     * @return
     */
    public abstract String uCodeNappula();

    /**
     * Palauttaa nappulan mahdolliset siirrot listan
     *
     * @return
     */
    public abstract ArrayList<Kordinaatti> mahdollisetSiirrot();

    /**
     * Syökönappula tähän sijaintiin. Tätä käytetään vain sotilaalla, joka syö
     * vain viistoihin. Muilla true.
     *
     * @param x XKordinaatti
     * @param y YKordinaatti
     * @return Palattaa boolean
     */
    public abstract boolean syokoNappula(int x, int y);

    /**
     * Pitää sisällään jokaisen nappulan mahdolliset siirrot
     *
     * @return palauttaa ArrayListin jossa kordinaatteja
     */
    public ArrayList<Kordinaatti> getMahdollisetSiirrot() {
        return mahdollisetSiirrot();
    }

    /**
     * Kasvattaa tehtyjen siirtojen määrää
     */
    public void kasvataSiirtojenMaaraaYhdella() {
        this.siirtojenMaara++;
    }

    /**
     * Tarkistaa, onko annattu kordinaatti nappulan mahdolliset siirrot -
     * listalla
     *
     * @param kord tarkistettava kordinaatti
     * @return palauttaa true, jos arvo on listalla
     */
    public boolean onkoMahdollinenSiirto(Kordinaatti kord) {
        System.out.println("Tarkistetaan siirron mahdollisuus...");
        if (getMahdollisetSiirrot().contains(kord)) {
            return true;
        }
        System.out.println("False");
        return false;
    }

    /*
     *   Getterit ja Setterit ja toString
     */
    /**
     *
     * @param tyyppi
     */
    public void setTyyppi(EnumTyyppi tyyppi) {
        this.tyyppi = tyyppi;
    }

    /**
     *
     * @param vari
     */
    public void setVari(EnumVari vari) {
        this.vari = vari;
    }

    /**
     *
     * @return
     */
    public EnumTyyppi getTyyppi() {
        return this.tyyppi;
    }

    /**
     *
     * @return
     */
    public EnumVari getVari() {
        return this.vari;
    }

    /**
     *
     * @return
     */
    public int getSiirtojenMaara() {
        return this.siirtojenMaara;
    }

    /**
     *
     * @return
     */
    public Kordinaatti getKordinaatti() {
        return kordinaatti;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setKordinaatti(int x, int y) {
        this.kordinaatti = new Kordinaatti(x, y);
    }

    /**
     *
     * @return
     */
    public boolean isElossa() {
        return this.elossa;
    }

    /**
     *
     */
    public void setElossa() {
        this.elossa = false;
    }

    @Override
    public String toString() {
        return this.vari + " " + this.tyyppi + " ";
    }

    /**
     *
     * @return
     */
    public boolean isValittu() {
        return valittu;
    }

    /**
     *
     * @param valittu
     */
    public void setValittu(boolean valittu) {
        this.valittu = valittu;
    }

    /**
     *
     * @return
     */
    public Nappula getNappula() {
        return this;
    }

}
