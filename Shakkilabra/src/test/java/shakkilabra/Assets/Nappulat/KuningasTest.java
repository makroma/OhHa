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
public class KuningasTest {

    Kuningas k1;
    Kuningas k2;

    public KuningasTest() {
        k1 = new Kuningas(EnumVari.MUSTA, 3, 3);
        k2 = new Kuningas(EnumVari.VALKOINEN, 3, 4);
    }

    @Test
    public void testLiiku() {
        k1.liiku(3, 4);
        assertEquals(new Kordinaatti(3, 4).getXY(), k1.getKordinaatti().getXY());
    }

    @Test
    public void testUCodeNappula() {
    }

    @Test
    public void testMahdollisetSiirrot() {
        assertEquals(8, k1.getMahdollisetSiirrot().size());
        assertEquals(new Kordinaatti(4, 3).getXY(), k1.getMahdollisetSiirrot().get(0).getXY());
        assertEquals(new Kordinaatti(4, 4).getXY(), k1.getMahdollisetSiirrot().get(1).getXY());
        assertEquals(new Kordinaatti(4, 2).getXY(), k1.getMahdollisetSiirrot().get(2).getXY());
        assertEquals(new Kordinaatti(3, 2).getXY(), k1.getMahdollisetSiirrot().get(3).getXY());
        assertEquals(new Kordinaatti(2, 2).getXY(), k1.getMahdollisetSiirrot().get(5).getXY());

        assertEquals(8, k2.getMahdollisetSiirrot().size());
        assertEquals(new Kordinaatti(4,3).getXY(), k1.getMahdollisetSiirrot().get(0).getXY());
        assertEquals(new Kordinaatti(4, 4).getXY(), k1.getMahdollisetSiirrot().get(1).getXY());
        assertEquals(new Kordinaatti(4, 2).getXY(), k1.getMahdollisetSiirrot().get(2).getXY());
        assertEquals(new Kordinaatti(3, 2).getXY(), k1.getMahdollisetSiirrot().get(3).getXY());
        assertEquals(new Kordinaatti(2, 2).getXY(), k1.getMahdollisetSiirrot().get(5).getXY());

    }

    @Test
    public void testSyokoNappula() {
        assertEquals(true, k1.syokoNappula(3, 3));
    }

}
