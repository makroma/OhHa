/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Assets;

import shakkilabra.Grafiikka.Lauta;
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
public class TestLauta {

    Lauta lauta;

    public TestLauta() {
        lauta = new Lauta();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void onkoLautaOikeanKokoinen() {
        assertEquals(8, lauta.getRuudukko().length);
    }

    @Test
    public void onkoLautaOikeanKokoinenRuudukonJalkeen() {
        lauta.luoRuudukko();
        assertEquals(8, lauta.getRuudukko().length);
    }

    @Test
    public void onkoLautaOikeanVarinen() {

        for (int i = 0; i < 4; i += 2) {
            assertEquals(EnumVari.V, lauta.getRuudukko()[i][0].getVari());
            assertEquals(EnumVari.M, lauta.getRuudukko()[i][1].getVari());
            assertEquals(EnumVari.V, lauta.getRuudukko()[i][2].getVari());
            assertEquals(EnumVari.M, lauta.getRuudukko()[i][3].getVari());
            assertEquals(EnumVari.V, lauta.getRuudukko()[i][4].getVari());
            assertEquals(EnumVari.M, lauta.getRuudukko()[i][5].getVari());
            assertEquals(EnumVari.V, lauta.getRuudukko()[i][6].getVari());
            assertEquals(EnumVari.M, lauta.getRuudukko()[i][7].getVari());

            assertEquals(EnumVari.M, lauta.getRuudukko()[i + 1][0].getVari());
            assertEquals(EnumVari.V, lauta.getRuudukko()[i + 1][1].getVari());
            assertEquals(EnumVari.M, lauta.getRuudukko()[i + 1][2].getVari());
            assertEquals(EnumVari.V, lauta.getRuudukko()[i + 1][3].getVari());
            assertEquals(EnumVari.M, lauta.getRuudukko()[i + 1][4].getVari());
            assertEquals(EnumVari.V, lauta.getRuudukko()[i + 1][5].getVari());
            assertEquals(EnumVari.M, lauta.getRuudukko()[i + 1][6].getVari());
            assertEquals(EnumVari.V, lauta.getRuudukko()[i + 1][7].getVari());
        }
    }
}
