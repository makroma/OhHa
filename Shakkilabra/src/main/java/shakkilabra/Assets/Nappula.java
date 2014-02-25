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

    public Nappula(EnumTyyppi nappulat, EnumVari vari, Kordinaatti kord) {
        this.tyyppi = nappulat;
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

    public abstract String uCodeNappula();

    public abstract ArrayList<Kordinaatti> mahdollisetSiirrot();

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
    public void setTyyppi(EnumTyyppi tyyppi) {
        this.tyyppi = tyyppi;
    }

    public void setVari(EnumVari vari) {
        this.vari = vari;
    }

    public EnumTyyppi getTyyppi() {
        return this.tyyppi;
    }

    public EnumVari getVari() {
        return this.vari;
    }

    public int getSiirtojenMaara() {
        return this.siirtojenMaara;
    }

    public Kordinaatti getKordinaatti() {
        return kordinaatti;
    }

    public void setKordinaatti(int x, int y) {
        this.kordinaatti = new Kordinaatti(x, y);
    }

    public boolean isElossa() {
        return this.elossa;
    }

    public void setElossa() {
        this.elossa = false;
    }

    @Override
    public String toString() {
        return this.vari + " " + this.tyyppi + " ";
    }

    public boolean isValittu() {
        return valittu;
    }

    public void setValittu(boolean valittu) {
        this.valittu = valittu;
    }

    public Nappula getNappula() {
        return this;
    }

    
}
