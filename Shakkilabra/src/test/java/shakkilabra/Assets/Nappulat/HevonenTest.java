/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Assets.Nappulat;

import org.junit.Test;
import static org.junit.Assert.*;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Kordinaatti;

/**
 *
 * @author marko
 */
public class HevonenTest {

    Hevonen h1;
    Hevonen h2;

    public HevonenTest() {
        h1 = new Hevonen(EnumVari.MUSTA, 3, 3);
        h2 = new Hevonen(EnumVari.VALKOINEN, 3, 4);
    }

    @Test
    public void testLiiku() {

    }

    @Test
    public void testUCodeNappula() {
        assertEquals("\u265E", h1.uCodeNappula());
        assertEquals("\u2658", h2.uCodeNappula());

    }

    @Test
    public void testMahdollisetSiirrot() {
        assertEquals(8, h1.getMahdollisetSiirrot().size());
        assertEquals(new Kordinaatti(5, 4).getXY(), h1.getMahdollisetSiirrot().get(0).getXY());
        assertEquals(new Kordinaatti(5, 2).getXY(), h1.getMahdollisetSiirrot().get(1).getXY());
        assertEquals(new Kordinaatti(4, 1).getXY(), h1.getMahdollisetSiirrot().get(2).getXY());
        assertEquals(new Kordinaatti(2, 1).getXY(), h1.getMahdollisetSiirrot().get(3).getXY());
        assertEquals(new Kordinaatti(2, 5).getXY(), h1.getMahdollisetSiirrot().get(5).getXY());
    }

    @Test
    public void testSyokoNappula() {
        assertEquals(true, h1.syokoNappula(5, 6));
    }

}
