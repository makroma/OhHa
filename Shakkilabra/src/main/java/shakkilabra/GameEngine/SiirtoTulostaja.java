package shakkilabra.GameEngine;

import shakkilabra.Grafiikka.SiirrotNaytto;

/**
 * Siirtotulostaja tulostaa tehtyja siirtoja siirtonäyttöön.
 *
 * @author marko
 */
public class SiirtoTulostaja {

    private final SiirrotNaytto pelinaytto;

    /**
     *
     * @param pelinaytto
     */
    public SiirtoTulostaja(SiirrotNaytto pelinaytto) {
        this.pelinaytto = pelinaytto;
    }

    /**
     * Kortjoittaa siirrto näyttöön annetun stringin
     * @param s String
     */
    public void kirjoitaSiirrotNayttoon(String s) {
        pelinaytto.kirjoitaSiirrotNayttoon(s);
    }

    /**
     * SiirtonäyttöTulostin. Tulostaa tehdyn siirron näyttöön.
     *
     * @param nappulat
     * @param x
     * @param y
     */
    public void tulostetaanSiirtoNayttoon(NappulaSet nappulat, int x, int y) {
        String yKor = "ABCDEFGH";
        int xKor = 8;
        pelinaytto.kirjoitaSiirrotNayttoon(nappulat.annaValittuNappula().toString()
                + " " + yKor.charAt(y) + (xKor - x) + " siirtyi ruutuun "
                + yKor.charAt(nappulat.annaValittuNappula().getKordinaatti().getY())
                + (xKor - nappulat.annaValittuNappula().getKordinaatti().getX()));

    }

    /**
     * Tulostaa syöntitilanteen näyttöön.
     *
     * @param nappulat
     * @param x uusiX
     * @param y uusiY
     */

    public void tulostetaanSyontiNayttoon(NappulaSet nappulat, int x, int y) {
        pelinaytto.kirjoitaSiirrotNayttoon(nappulat.annaValittuNappula().toString()
                + " syö " + nappulat.getNappula(x, y).toString());
    }
}
