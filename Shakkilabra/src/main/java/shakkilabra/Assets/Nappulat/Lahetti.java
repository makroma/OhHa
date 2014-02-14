package shakkilabra.Assets.Nappulat;

import java.util.ArrayList;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Nappula;
import shakkilabra.Assets.EnumTyyppi;

/**
 * LähettiNappula, joka toteuttaa abstraktin Nappulaluokan
 *
 * @author marko
 */
public class Lahetti extends Nappula {

    /**
     * Nappulan tyyppi, väri ja sijainti
     *
     * @param vari Nappulan väri
     * @param x Nappulan X kordinaatti
     * @param y Nappulan Y kordinaatti
     */
    public Lahetti(EnumVari vari, int x, int y) {
        super(EnumTyyppi.LAHETTI, vari, new Kordinaatti(x, y));
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
     *
     * @return utf-8 fonttikoodi
     */
    @Override
    public String uCodeNappula() {
        String s;
        if (super.getVari() == EnumVari.VALKOINEN) {
            s = "\u2657";
        } else {
            s = "\u265D";
        }
        return s;
    }

    /**
     * luo nappulan mahdolliset siirrot listan
     *
     * @return palauttaa listan
     */
    @Override
    public ArrayList<Kordinaatti> mahdollisetSiirrot() {
        ArrayList<Kordinaatti> siirrot = new ArrayList<>();
        //Kuningattaren liikkeet

        int lX = super.getKordinaatti().getX();
        int lY = super.getKordinaatti().getY();
        int negX = lX + lY;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (x - negX == 0 || (lX - x == lY - y)) {
                    siirrot.add(new Kordinaatti(x, y));
                }
            }
            negX--;
        }
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
