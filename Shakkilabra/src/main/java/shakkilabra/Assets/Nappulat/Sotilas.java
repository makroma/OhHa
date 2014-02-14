package shakkilabra.Assets.Nappulat;

import java.util.ArrayList;
import shakkilabra.Assets.EnumTyyppi;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Nappula;

/**
 * SotilasNappula, joka toteuttaa abstraktin Nappulaluokan
 *
 * @author marko
 */
public class Sotilas extends Nappula {

    /**
     * Nappulan tyyppi, väri ja sijainti
     *
     * @param vari Nappulan väri
     * @param x Nappulan X kordinaatti
     * @param y Nappulan Y kordinaatti
     */
    public Sotilas(EnumVari vari, int x, int y) {
        super(EnumTyyppi.SOTILAS, vari, new Kordinaatti(x, y));
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
            s = "\u2659";
        } else {
            s = "\u265F";
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

        //Jos siirtojenmäärä = 0 niin sotilasta voi siirtää yhden tai kaksi eteenpäin
        if (super.getSiirtojenMaara() == 0) {
            if (super.getVari() == EnumVari.MUSTA) {
                siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY()));
                siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 2, super.getKordinaatti().getY()));
            } else if (super.getVari() == EnumVari.VALKOINEN) {
                siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY()));
                siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 2, super.getKordinaatti().getY()));
            }
        }
        // Voi liikkua eteenpäin, (jos edessä ei ole toista nappulaa, mutta sitä ei tässä testata)
        if (super.getSiirtojenMaara() >= 1) {
            if (super.getVari() == EnumVari.MUSTA) {
                siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY()));
            } else if (super.getVari() == EnumVari.VALKOINEN) {
                siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY()));
            }
        }
        //voi syödä viistoihin, eli palauttaa true

        if (super.getVari() == EnumVari.MUSTA) {
            siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() + 1));
            siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() - 1));
        } else if (super.getVari() == EnumVari.VALKOINEN) {
            siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() + 1));
            siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() - 1));
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
        if (super.getVari() == EnumVari.MUSTA) {
            if (super.getKordinaatti().getX() + 1 == x && super.getKordinaatti().getY() + 1 == y) {
                return true;
            } else if (super.getKordinaatti().getX() + 1 == x && super.getKordinaatti().getY() - 1 == y) {
                return true;
            }
        } else if (super.getVari() == EnumVari.VALKOINEN) {
            if (super.getKordinaatti().getX() - 1 == x && super.getKordinaatti().getY() + 1 == y) {
                return true;
            } else if (super.getKordinaatti().getX() - 1 == x && super.getKordinaatti().getY() - 1 == y) {
                return true;
            }
        }
        return false;
    }
}
