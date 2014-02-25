/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.GameEngine;

import org.junit.Test;
import static org.junit.Assert.*;
import shakkilabra.Assets.EnumTyyppi;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Nappula;
import shakkilabra.Assets.Nappulat.Sotilas;

/**
 *
 * @author marko
 */
public class NappulaSetTest {

    NappulaSet nappulat;

    public NappulaSetTest() {
        nappulat = new NappulaSet();
    }

    @Test
    public void testLuoNappulatLaudalle() {
        nappulat.luoNappulatLaudalle();
        assertEquals(32, nappulat.getNappulatSize());
        assertEquals(EnumTyyppi.TORNI, nappulat.getNappula(0, 0).getTyyppi());
        assertEquals(EnumTyyppi.HEVONEN, nappulat.getNappula(0, 1).getTyyppi());

        assertEquals(EnumTyyppi.TORNI, nappulat.getNappula(7, 0).getTyyppi());
        assertEquals(EnumTyyppi.HEVONEN, nappulat.getNappula(0, 1).getTyyppi());

        assertEquals(EnumVari.MUSTA, nappulat.getNappula(0, 1).getVari());
        assertEquals(EnumVari.MUSTA, nappulat.getNappula(0, 2).getVari());
        assertEquals(EnumVari.MUSTA, nappulat.getNappula(0, 3).getVari());
        assertEquals(EnumVari.MUSTA, nappulat.getNappula(0, 4).getVari());
        assertEquals(EnumVari.MUSTA, nappulat.getNappula(0, 5).getVari());

        assertEquals(EnumVari.VALKOINEN, nappulat.getNappula(7, 1).getVari());
        assertEquals(EnumVari.VALKOINEN, nappulat.getNappula(7, 2).getVari());
        assertEquals(EnumVari.VALKOINEN, nappulat.getNappula(7, 3).getVari());
        assertEquals(EnumVari.VALKOINEN, nappulat.getNappula(7, 4).getVari());
        assertEquals(EnumVari.VALKOINEN, nappulat.getNappula(7, 5).getVari());
    }

    @Test
    public void testLisaaNappula() {

        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 5, 5));
        assertEquals(EnumTyyppi.SOTILAS, nappulat.getNappula(5, 5).getTyyppi());

    }

    @Test
    public void testPoistaNappula() {
        nappulat.poistaNappula(nappulat.getNappula(0, 0));
        assertEquals(null, nappulat.getNappula(0, 0));
    }

    @Test
    public void testOnkoRuuduVapaa() {
        assertEquals(true, nappulat.onkoRuuduVapaa(5, 5));

    }

    @Test
    public void testOnkoRuutuValitunNappulanSiirroissa() {
    }

    @Test
    public void testSyokoValittuNappulaSijaintiin() {
    }

    @Test
    public void testAnnaValittuNappula() {
    }

    @Test
    public void testTyhjennaNappulatLista() {
    }

    @Test
    public void testGetNappula() {
    }

    @Test
    public void testGetNappulatSize() {
    }

    @Test
    public void testGetNappulaSet() {
    }

    @Test
    public void testSetNappulatSet() {
    }

    @Test
    public void testTulostaNappulat() {
    }

    @Test
    public void testTulostaMahdollisetSiirrotXY() {
    }

    @Test
    public void testTulostaValitunNappulanMahdollisetSiirrot() {
    }

    @Test
    public void testAsciiLautaTulostin() {
    }

    @Test
    public void testAsciiMahdollisetSiirrot() {
    }

    @Test
    public void testToString() {
    }

}
