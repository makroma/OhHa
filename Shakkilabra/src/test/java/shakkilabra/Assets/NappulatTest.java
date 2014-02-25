/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Assets;

import shakkilabra.Assets.Nappulat.Sotilas;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marko
 */
public class NappulatTest {

    Nappula nappula;

    public NappulatTest() {
        nappula = new Sotilas(EnumVari.MUSTA, 1, 1);
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
        assertEquals(EnumTyyppi.SOTILAS, this.nappula.getTyyppi());
        assertEquals(EnumVari.MUSTA, this.nappula.getVari());
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
        assertEquals(4, this.nappula.getMahdollisetSiirrot().size());
    }

    @Test
    public void sotilaallaOikeaMaaraMahdollisetLiikkeetKunSiirtojaYksi() {
        this.nappula.kasvataSiirtojenMaaraaYhdella();
        assertEquals(3, this.nappula.getMahdollisetSiirrot().size());
    }

    @Test
    public void onkoNappulaValittuFalseAluksi() {

        assertEquals(false, this.nappula.isValittu());
    }

    @Test
    public void onkoNappulaValittuTrue() {
        this.nappula.setValittu(true);
        assertEquals(true, this.nappula.isValittu());
    }

//    @Test
//    public void onkoMahdotonSiirtoFalse() {
//        assertEquals(false, this.nappula.onkoMahdollinenSiirto(new Kordinaatti(3, 3)));
//
//    }

//    @Test
//    public void onkoValitunNappulanMahdollinenSiirtoTrue() {
//        this.nappula.setValittu(true);
//        assertEquals(true, this.nappula.isValittu());
//        assertEquals(true, this.nappula.onkoMahdollinenSiirto(new Kordinaatti(2, 1)));
//    }

}
