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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marko
 */
public class TestNappulat {

    Nappula nappula;

    public TestNappulat() {
        nappula = new Sotilas(EnumVari.M, 1, 1);
    }

//    @BeforeClass
//    public static void luoNappula() {
//         
//    }
    @Test
    public void sotilasOnElossa() {
        assertEquals(true, this.nappula.isElossa());
    }

    @Test
    public void sotilasOnOikeassaKordinaatissa() {
        assertEquals(new Kordinaatti(1, 1).getX(), nappula.getKordinaatti().getX());
        assertEquals(new Kordinaatti(1, 1).getY(), nappula.getKordinaatti().getY());
    }

    @Test
    public void siirtojaNollaKunNappulaLuotu() {
        assertEquals(0, this.nappula.getSiirtojenMaara());
    }

    @Test
    public void sotilasOnValkoinenSotilas() {
        assertEquals(EnumTyyppi.S, this.nappula.getTyyppi());
        assertEquals(EnumVari.M, this.nappula.getVari());
    }

    @Test
    public void sotilasLiikkuuYhdenEteenpain() {
        this.nappula.liiku(2, 1);
        assertEquals(2, this.nappula.getKordinaatti().getX());
        assertEquals(1, this.nappula.getKordinaatti().getY());

    }

    @Test
    public void sotilaanSiirtojenMaaraKasvoiyhdella() {
        this.nappula.liiku(2, 1);
        assertEquals(1, this.nappula.getSiirtojenMaara());
    }

    public void sotilasPalauttaaUKoodin() {
        assertEquals("\u2659", this.nappula.uCodeNappula());
    }

    @Test
    public void sotilaallaOikeaMaaraMahdollisetLiikkeetKunSiirtojaNolla() {
        assertEquals(4, this.nappula.getMahdollisetSiirrot().keySet().size());
    }

    @Test
    public void sotilaallaOikeaMaaraMahdollisetLiikkeetKunSiirtojaYksi() {
        this.nappula.kasvataSiirtojenMaaraaYhdella();
        assertEquals(3, this.nappula.getMahdollisetSiirrot().keySet().size());
    }
}
