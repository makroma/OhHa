
package shakkilabra.Assets.Nappulat;

import java.util.ArrayList;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Nappula;
import shakkilabra.Assets.EnumTyyppi;

/**
 * HevosNappula, joka toteuttaa abstraktin Nappulaluokan
 *
 * @author marko
 */
public class Hevonen extends Nappula {

    /**
     * Nappulan tyyppi, väri ja sijainti
     *
     * @param vari Nappulan väri
     * @param x Nappulan X kordinaatti
     * @param y Nappulan Y kordinaatti
     */
    public Hevonen(EnumVari vari, int x, int y) {
        super(EnumTyyppi.HEVONEN, vari, new Kordinaatti(x, y));
    }

    /**
     * Nappulan liikkumisMetodi, joka kasvattaa siirtojen määrää yhdellä
     *
     * @param x uusi X
     * @param y uusi Y
     */
    @Override
    public void liiku(int x, int y) {
        kasvataSiirtojenMaaraaYhdella();
        super.setKordinaatti(x, y);
    }

    /**
     * Nappulan graafiikka UTF-8 fontilla
     * @return utf-8 fonttikoodi
     */
    @Override
    public String uCodeNappula() {
        String s;
        if (super.getVari() == EnumVari.VALKOINEN) {
            s = "\u2658";
        } else {
            s = "\u265E";
        }
        return s;
    }
/**
 * luo nappulan mahdolliset siirrot listan
 * @return palauttaa listan
 */
    @Override
    public ArrayList<Kordinaatti> mahdollisetSiirrot() {
        ArrayList<Kordinaatti> siirrot = new ArrayList<>();
        //Kuninkaan liikkeet
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 2, super.getKordinaatti().getY() + 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 2, super.getKordinaatti().getY() - 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() - 2));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() - 2));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() + 2));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() + 2));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 2, super.getKordinaatti().getY() + 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 2, super.getKordinaatti().getY() - 1));

        return siirrot;
    }
    /**
     * Vain sotilaalla käytössä oleva toiminto (Sotilas syö vain viistoihin)
     *
     * @param x uusi X
     * @param y uusi Y
     * @return true, jos syö sijaintiin, false jos ei syö uuteen sijaintiin
     */

    @Override
    public boolean syokoNappula(int x, int y) {
        return true;
    }
}
