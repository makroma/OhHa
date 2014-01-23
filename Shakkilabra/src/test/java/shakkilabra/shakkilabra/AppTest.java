package shakkilabra.shakkilabra;

import Assets.EnumVari;
import Assets.Sotilas;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    Sotilas s = new Sotilas(EnumVari.M, 4, 4);

    public void luotuSotilasOikeassaKordinaatissa() {
        int x = s.getX();

        assertEquals(4, x);
    }
}
