/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Assets;

import Assets.EnumTyyppi;
import Assets.EnumVari;
import Assets.Sotilas;
import GameEngine.NappulaSet;
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
        nappulaSet.lisaaNappula(new Sotilas(EnumVari.M, 1, 3));
        nappulaSet.lisaaNappula(new Sotilas(EnumVari.M, 1, 4));
        nappulaSet.lisaaNappula(new Sotilas(EnumVari.M, 1, 5));
        nappulaSet.lisaaNappula(new Sotilas(EnumVari.M, 1, 6));
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
        assertEquals(EnumTyyppi.S, this.nappulaSet.getNappula(1, 3).getTyyppi());
    }

    @Test
    public void onkoRuutuVapaaToimii() {
        assertEquals(false, this.nappulaSet.onkoRuuduVapaa(1, 4));
        assertEquals(true, this.nappulaSet.onkoRuuduVapaa(3, 3));
    }

 
}
