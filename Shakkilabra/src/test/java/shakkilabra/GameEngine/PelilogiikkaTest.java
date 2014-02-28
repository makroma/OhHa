package shakkilabra.GameEngine;

import org.junit.Test;
import static org.junit.Assert.*;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Nappula;
import shakkilabra.Assets.Nappulat.Kuningas;
import shakkilabra.Assets.Nappulat.Kuningatar;
import shakkilabra.Assets.Nappulat.Lahetti;
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

    @Test
    public void testOnkoValitunPelaajanVuoro() {
    }

    @Test
    public void testOnkoMahdollinenSiirto() {
    }

    @Test
    public void OnkoRuutuVapaa() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 5, 5);
        nap.lisaaNappula(Torni);
        nap.getNappula(5, 5).setValittu(true);
        assertTrue(nap.onkoRuuduVapaa(6, 5));
        assertTrue(nap.onkoRuuduVapaa(4, 5));
        assertFalse(nap.onkoRuuduVapaa(5, 5));
        Nappula Sotilas = new Sotilas(EnumVari.MUSTA, 2, 2);
        nap.lisaaNappula(Sotilas);
        assertFalse(nap.onkoRuuduVapaa(2, 2));

    }

    @Test
    public void testTorniLiikkuuSotilaanYliFalse() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 5, 5);
        nap.lisaaNappula(Torni);
        nap.getNappula(5, 5).setValittu(true);
        Nappula Sotilas = new Sotilas(EnumVari.MUSTA, 6, 5);
        nap.lisaaNappula(Sotilas);
        assertFalse(p.nappulaTyypinTarkistusjaLiikkuminen(nap, 7, 5));

    }

    @Test
    public void testTorniSyoSotilaan() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 5, 5);
        nap.lisaaNappula(Torni);
        nap.getNappula(5, 5).setValittu(true);
        Nappula Sotilas = new Sotilas(EnumVari.VALKOINEN, 6, 5);
        nap.lisaaNappula(Sotilas);
        assertTrue(p.nappulaSyoTarkistus(nap, 6, 5));
    }

    @Test
    public void testlähettiLiikkuuTorninYliFalse() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 6, 6);
        nap.lisaaNappula(Torni);
        Nappula Lahetti = new Lahetti(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Lahetti);
        nap.getNappula(5, 5).setValittu(true);
        assertFalse(p.nappulaTyypinTarkistusjaLiikkuminen(nap, 7, 7));
    }

    @Test
    public void testlähettiSyoTornin() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 6, 6);
        nap.lisaaNappula(Torni);
        Nappula Lahetti = new Lahetti(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Lahetti);
        nap.getNappula(5, 5).setValittu(true);
        assertTrue(p.nappulaSyoTarkistus(nap, 6, 6));
    }

    @Test
    public void testKuningatarLiikkuuuTorninYliFalse() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 6, 5);
        nap.lisaaNappula(Torni);
        Nappula Kuningatar = new Kuningatar(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Kuningatar);
        nap.getNappula(5, 5).setValittu(true);
        assertFalse(p.nappulaTyypinTarkistusjaLiikkuminen(nap, 7, 5));
    }

    @Test
    public void testKuningatarLiikkuuuTorninYliDiagonaaliinFalse() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 6, 6);
        nap.lisaaNappula(Torni);
        Nappula Kuningatar = new Kuningatar(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Kuningatar);
        nap.getNappula(5, 5).setValittu(true);
        assertFalse(p.nappulaTyypinTarkistusjaLiikkuminen(nap, 7, 7));
    }

    @Test
    public void testKuningatarSyoTorninPystyssa() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 6, 5);
        nap.lisaaNappula(Torni);
        Nappula Kuningatar = new Kuningatar(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Kuningatar);
        nap.getNappula(5, 5).setValittu(true);
        assertTrue(p.nappulaSyoTarkistus(nap, 6, 5));
    }

    @Test
    public void testKuningatarSyoTorninDiagonaalissa() {
        Nappula Torni = new Torni(EnumVari.MUSTA, 6, 6);
        nap.lisaaNappula(Torni);
        Nappula Kuningatar = new Kuningatar(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Kuningatar);
        nap.getNappula(5, 5).setValittu(true);
        assertTrue(p.nappulaSyoTarkistus(nap, 6, 6));
    }

    @Test
    public void testLiikutaKuningatartaTarkistaEsteetFalse() {
        Nappula Kuningatar = new Kuningatar(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Kuningatar);
        Nappula Torni = new Torni(EnumVari.MUSTA, 6, 6);
        nap.lisaaNappula(Torni);
        Nappula Torni2 = new Torni(EnumVari.MUSTA, 6, 5);
        nap.lisaaNappula(Torni2);
        Nappula Torni3 = new Torni(EnumVari.MUSTA, 6, 5);
        nap.lisaaNappula(Torni3);

        nap.getNappula(5, 5).setValittu(true);
        assertFalse(p.liikutaKuningatarta(nap, 7, 7));
        assertFalse(p.liikutaKuningatarta(nap, 7, 5));

    }

    @Test
    public void testLiikutaKuningatartaTrue() {
        Nappula Kuningatar = new Kuningatar(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Kuningatar);
        nap.getNappula(5, 5).setValittu(true);
        assertTrue(p.liikutaKuningatarta(nap, 6, 6));
        assertTrue(p.liikutaKuningatarta(nap, 4, 5));
        assertTrue(p.liikutaKuningatarta(nap, 5, 2));

    }

    @Test
    public void testLiikutaTorniaTarkistaEsteetFalse() {
        Nappula Torni = new Kuningatar(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Torni);
        Nappula Torni1 = new Torni(EnumVari.MUSTA, 4, 5);
        nap.lisaaNappula(Torni1);
        Nappula Torni2 = new Torni(EnumVari.MUSTA, 6, 5);
        nap.lisaaNappula(Torni2);
        Nappula Torni3 = new Torni(EnumVari.MUSTA, 5, 4);
        nap.lisaaNappula(Torni3);
        nap.getNappula(5, 5).setValittu(true);
        assertFalse(p.liikutaTornia(nap, 3, 5));
        assertFalse(p.liikutaTornia(nap, 7, 5));
        assertFalse(p.liikutaTornia(nap, 5, 3));
    }

    @Test
    public void testLiikutaTorniaTRUE() {
        Nappula Torni = new Kuningatar(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(Torni);
        nap.getNappula(5, 5).setValittu(true);
        assertTrue(p.liikutaTornia(nap, 3, 5));
        assertTrue(p.liikutaTornia(nap, 7, 5));
        assertTrue(p.liikutaTornia(nap, 5, 3));
    }

    @Test
    public void testLiikutaLahettiaEsteenYliFalse() {
        Nappula lahetti = new Lahetti(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(lahetti);
        nap.getNappula(5, 5).setValittu(true);
        Nappula Torni1 = new Torni(EnumVari.MUSTA, 4, 4);
        nap.lisaaNappula(Torni1);
        Nappula Torni2 = new Torni(EnumVari.MUSTA, 6, 6);
        nap.lisaaNappula(Torni2);
        Nappula Torni3 = new Torni(EnumVari.MUSTA, 4, 6);
        nap.lisaaNappula(Torni3);

        assertFalse(p.liikutaLahettia(nap, 3, 3));
        assertFalse(p.liikutaLahettia(nap, 7, 7));
        assertFalse(p.liikutaLahettia(nap, 3, 7));
    }

    @Test
    public void testLiikutaLahettiaTrue() {
        Nappula lahetti = new Lahetti(EnumVari.VALKOINEN, 5, 5);
        nap.lisaaNappula(lahetti);
        nap.getNappula(5, 5).setValittu(true);

        assertTrue(p.liikutaLahettia(nap, 3, 3));
        assertTrue(p.liikutaLahettia(nap, 7, 7));
        assertTrue(p.liikutaLahettia(nap, 3, 7));
    }

    @Test
    public void testLiikutaSotilastaRuutuun() {
        Nappula sotilas = new Sotilas(EnumVari.MUSTA, 3, 3);
        nap.lisaaNappula(sotilas);
        nap.getNappula(3, 3).setValittu(true);

        assertFalse(p.liikutaSotilasta(nap, 4, 4));
        assertTrue(p.liikutaSotilasta(nap, 4, 3));

    }

    @Test
    public void testTarkistaEsteteetXakselillaFALSE() {
        Nappula sotilas = new Sotilas(EnumVari.MUSTA, 3, 3);
        Nappula sotilas1 = new Sotilas(EnumVari.MUSTA, 5, 3);
        nap.lisaaNappula(sotilas);
        nap.lisaaNappula(sotilas1);

        Nappula Torni1 = new Torni(EnumVari.MUSTA, 4, 3);
        nap.lisaaNappula(Torni1);
        nap.getNappula(4, 3).isValittu();

        assertFalse(p.tarkistaEsteetXakselilla(4, 2, nap, 3));
        assertFalse(p.tarkistaEsteetXakselilla(4, 6, nap, 3));
    }

    @Test
    public void testTarkistaEsteteetXakselillTRUE() {
        Nappula Torni1 = new Torni(EnumVari.MUSTA, 4, 3);
        nap.lisaaNappula(Torni1);
        nap.getNappula(4, 3).isValittu();

        assertTrue(p.tarkistaEsteetXakselilla(4, 2, nap, 3));
        assertTrue(p.tarkistaEsteetXakselilla(4, 6, nap, 3));
    }

    @Test
    public void testTarkistaEsteteetYakselillaFALSE() {
        Nappula sotilas = new Sotilas(EnumVari.MUSTA, 5, 6);
        Nappula sotilas1 = new Sotilas(EnumVari.MUSTA, 5, 4);
        nap.lisaaNappula(sotilas);
        nap.lisaaNappula(sotilas1);

        Nappula Torni1 = new Torni(EnumVari.MUSTA, 5, 5);
        nap.lisaaNappula(Torni1);
        nap.getNappula(5, 5).isValittu();

        assertFalse(p.tarkistaEsteetYakselilla(5, 2, nap, 5));
        assertFalse(p.tarkistaEsteetYakselilla(5, 7, nap, 5));
    }
        @Test
    public void testTarkistaEsteteetYakselillaTRUE() {

        Nappula Torni1 = new Torni(EnumVari.MUSTA, 5, 5);
        nap.lisaaNappula(Torni1);
        nap.getNappula(5, 5).isValittu();

        assertTrue(p.tarkistaEsteetYakselilla(5, 2, nap, 5));
        assertTrue(p.tarkistaEsteetYakselilla(5, 7, nap, 5));
    }

}
