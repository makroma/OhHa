/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Assets;

import Assets.EnumTyyppi;
import Assets.EnumVari;
import Assets.Kordinaatti;
import Assets.Nappula;
import Assets.Sotilas;
import java.util.HashMap;
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
public class TestKordinaatti {

    Nappula nappula;

    public TestKordinaatti() {
        nappula = new Sotilas(EnumVari.V, 2, 1);
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
    public void onkoOikeatKordinaatit() {
        assertEquals(new Kordinaatti(2, 1).getXY(), this.nappula.getKordinaatti().getXY());
    }

    @Test
    public void onkoOikeatKordinaattiX() {
        assertEquals(2, this.nappula.getKordinaatti().getX());
    }

    @Test
    public void onkoOikeatKordinaattiY() {
        assertEquals(1, this.nappula.getKordinaatti().getY());
    }

    @Test
    public void muuttuukoKordinaattiX() {
        this.nappula.setKordinaatti(3, 1);
        assertEquals(3, this.nappula.getKordinaatti().getX());
    }

    @Test
    public void muuttuukoKordinaattiY() {
        this.nappula.setKordinaatti(3, 2);
        assertEquals(2, this.nappula.getKordinaatti().getY());
    }
}
