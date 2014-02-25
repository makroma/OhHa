
package shakkilabra.GameEngine;

import org.junit.Test;
import static org.junit.Assert.*;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Nappula;
import shakkilabra.Assets.Nappulat.Sotilas;
import shakkilabra.Assets.Nappulat.Torni;
import shakkilabra.Grafiikka.SiirrotNaytto;

/**
 *
 * @author marko
 */
public class PelilogiikkaTest {

    Pelilogiikka p;
    NappulaSet nap;

    public PelilogiikkaTest() {
        p = new Pelilogiikka(new SiirrotNaytto());
        nap = new NappulaSet();
    }

    @Test
    public void testOnkoOikeanPelaajanVuoro() {
        assertEquals(true, p.isValkoisenVuoro());
        p.setValkoisenVuoro(false);
        assertEquals(false, p.isValkoisenVuoro());

    }

    @Test
    public void testVaihdaPelaajanVuoro() {
        assertEquals(true, p.isValkoisenVuoro());
        p.vaihdaPelaajanVuoro();
        assertEquals(false, p.isValkoisenVuoro());
    }

    @Test
    public void testTestaaNappulanSiirtoJaToteutaSe() {
        Nappula s = new Sotilas(EnumVari.VALKOINEN, 3, 3);
        nap.lisaaNappula(s);
        nap.getNappula(3, 3).setValittu(true);
        p.testaaNappulanSiirtoJaToteutaSe(nap, 2, 3);
        assertEquals(new Kordinaatti(2, 3).getXY(), nap.getNappula(2, 3).getKordinaatti().getXY());
    }

    @Test
    public void testIsValkoisenVuoro() {
        Nappula m = new Sotilas(EnumVari.MUSTA, 2, 2);
        nap.lisaaNappula(m);
        nap.getNappula(2, 2).setValittu(true);
        assertFalse(p.onkoValitunPelaajanVuoro(nap));
    }

    @Test
    public void testSetValkoisenVuoro() {
        Nappula m = new Sotilas(EnumVari.MUSTA, 2, 2);
        nap.lisaaNappula(m);
        nap.getNappula(2, 2).setValittu(true);
        p.vaihdaPelaajanVuoro();
        assertTrue(p.onkoValitunPelaajanVuoro(nap));
    }

    @Test
    public void onkoMahdollinenSiirtoTorni() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 5, 5);
        nap.lisaaNappula(Torni);
        nap.getNappula(5, 5).setValittu(true);
        assertFalse(p.onkoMahdollinenSiirto(nap, 6, 6));
        assertTrue(p.onkoMahdollinenSiirto(nap, 4, 5));
        assertTrue(p.onkoMahdollinenSiirto(nap, 2, 5));
        assertTrue(p.onkoMahdollinenSiirto(nap, 0, 5));
    }

}
