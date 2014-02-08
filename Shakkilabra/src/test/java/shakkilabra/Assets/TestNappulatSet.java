/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Assets;

import shakkilabra.Assets.Nappulat.Sotilas;
import shakkilabra.GameEngine.NappulaSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marko
 */
public class TestNappulatSet {

    NappulaSet nappulaSet;

    public TestNappulatSet() {
        nappulaSet = new NappulaSet();
        nappulaSet.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 3));
        nappulaSet.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 4));
        nappulaSet.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 5));
        nappulaSet.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 6));
        nappulaSet.getNappula(1, 5).setValittu(true);
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
//    
    @Test
    public void nappuloitaSetissaOikeaMaara() {
        assertEquals(4, this.nappulaSet.getNappulatSize());
    }

    @Test
    public void hakeeNappulanSetista() {
        assertEquals(EnumTyyppi.SOTILAS, this.nappulaSet.getNappula(1, 3).getTyyppi());
    }

    @Test
    public void onkoRuutuVapaaToimii() {
        assertEquals(false, this.nappulaSet.onkoRuuduVapaa(1, 4));
        assertEquals(true, this.nappulaSet.onkoRuuduVapaa(3, 3));
    }

    @Test
    public void valittuNappulaOnValittu() {
        assertEquals(true, this.nappulaSet.annaValittuNappula().isValittu());
    }

    @Test
    public void valittuNappulaOnKordinaatissa() {
        assertEquals("1,5", this.nappulaSet.annaValittuNappula().getKordinaatti().getXY());
    }

    @Test
    public void onkoRuutuValitunSiirroissaTrue() {
        assertEquals(true, this.nappulaSet.onkoRuutuValitunNappulanSiirroissa(2, 5));
    }

    @Test
    public void onkoRuutuValitunSiirroissaTrue2() {
        assertEquals(true, this.nappulaSet.onkoRuutuValitunNappulanSiirroissa(2, 6));
    }

    @Test
    public void onkoRuutuValitunSiirroissaFalse() {
        assertEquals(false, this.nappulaSet.onkoRuutuValitunNappulanSiirroissa(6, 5));
        //assertEquals(true, this.nappulaSet.annaValittuNappula().getMahdollisetSiirrot().containsKey(new Kordinaatti(2, 5)));
    }

    @Test
    public void onkoRuutuValitunSiirroissaFalse2() {
        assertEquals(false, this.nappulaSet.onkoRuutuValitunNappulanSiirroissa(3, 6));
        //assertEquals(true, this.nappulaSet.annaValittuNappula().getMahdollisetSiirrot().containsKey(new Kordinaatti(2, 5)));
    }

    @Test
    public void tulostaNappulanSiirrotOikein() {
        //  assertEquals("", this.nappulaSet.tulostaValitunNappulanMahdollisetSiirrot());
    }

}
