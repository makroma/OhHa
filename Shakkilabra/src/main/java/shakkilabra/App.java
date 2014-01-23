package shakkilabra;

import Assets.EnumTyyppi;
import GameEngine.Lauta;
import Assets.EnumVari;
import Assets.Sotilas;
import GameEngine.NappulaSet;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        Lauta lauta = new Lauta();
        //NappulatLaudalla = new NappulatLaudalla();
        NappulaSet nappulat = new NappulaSet();
        nappulat.lisaaNappula(new Sotilas(EnumVari.V, 6, 6));
        nappulat.lisaaNappula(new Sotilas(EnumVari.M, 3, 5));
        //nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 7, 7));
        nappulat.tulostaNappulat();
        nappulat.asciiLautaTulostin();
        nappulat.getNappula(6, 6).liiku();
        nappulat.tulostaNappulat();
        nappulat.asciiLautaTulostin();
        nappulat.getNappula(3, 5).liiku();
        nappulat.tulostaNappulat();
        nappulat.asciiLautaTulostin();
    }
}
