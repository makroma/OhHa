/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.GameEngine;

import shakkilabra.Grafiikka.Lauta;

import shakkilabra.Assets.EnumTyyppi;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Sotilas;
import shakkilabra.Grafiikka.Grafiikkamoottori;

/**
 *
 * @author marko
 */
public class Pelimoottori {

    public Pelimoottori() {

    }

    public void graafinenPeliRun() {
        System.out.println("luodaan sotilaat");
        // luoSotilaatLaudalle();
        System.out.println("Luodaan Graafinen peli");
        // Grafiikka.Grafiikkamoottori peli = new Grafiikkamoottori(lauta, this.nappulat);
        System.out.println("Käynnistetään peliä....");
        //peli.run();

    }

    public void testipeliRun() {

//        luoSotilaatLaudalle();
//
//        nappulat.tulostaNappulat();
//        nappulat.asciiLautaTulostin();
//
//        System.out.println("Valitaan musta sotilas...1,5");
//
//        nappulat.tulostaMahdollisetSiirrot(1, 5);
//        nappulat.asciiMahdollisetSiirrot(1, 5);
//
//        // nappulat.getNappula(1, 5).liiku(4, 5);
//        System.out.println("Musta nappula liikkuu");
//        nappulat.getNappula(1, 5).liiku(3, 5);
//
//        nappulat.tulostaNappulat();
//        nappulat.asciiLautaTulostin();
//
//        //nappulat.getNappula(5, 6).setElossa();
//        nappulat.tulostaNappulat();
//        System.out.println("Valkoinen liikkuu");
//        nappulat.getNappula(3, 5).liiku(4, 5);
//        nappulat.tulostaNappulat();
//        nappulat.asciiLautaTulostin();
    }

    public void luoSotilaatLaudalle(NappulaSet nappulat) {
        System.out.println("Luodaan Sotilaat...");
        //luodaan valkoiset Sotilaat
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 0));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 1));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 2));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 3));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 4));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 5));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 6));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 7));

        //luodaan mustat Sotilaat
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 0));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 1));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 2));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 3));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 4));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 5));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 6));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 7));

    }

    public void liikutaNappulaa(NappulaSet nappulat, int x, int y) {
        //jos sotilas
        if (nappulat.annaValittuNappula().getTyyppi() == EnumTyyppi.SOTILAS) {
            liikutaValittuaSotilasta(nappulat, x, y);
        }

        //Nappulan liikuttamisen jälkeen muutetaan valinta False
        nappulat.annaValittuNappula().setValittu(false);
    }

    private void liikutaValittuaSotilasta(NappulaSet nappulat, int x, int y) {

        System.out.println("Tyyppi Sotilas: " + nappulat.annaValittuNappula());

        if (nappulat.onkoRuutuValitunNappulanSiirroissa(x, y)) {

            System.out.println("Siirto mahdollinen " + x + "," + y);

            //jos liikkuu eteenpäin, onko ruutu tyhjä
            if (nappulat.onkoRuuduVapaa(x, y)) {
                System.out.println("Ruutu on vapaa");

                //Jos ruutu on vapaa, niin onko se nappulan boolean "syö tähän" ruuduissa 
                if (!nappulat.syokoValittuNappulaSijaintiin(x, y)) {
                    System.out.println("Syökö Nappula tähän sijaintiin vai liikkuuko se testi: liikkuu");
                    nappulat.annaValittuNappula().liiku(x, y);
                } else {
                    System.out.println("Voit liikkua vain syödessä tähän suuntaan");
                }

            } else {
                //jos liikkuu viistoon, niin syökö silloin
                System.out.println("Syödään nappula");
                if (nappulat.syokoValittuNappulaSijaintiin(x, y)) {
                    System.out.println("Valittu Nappula syö sijaintiin. Poistetaan nappulaa: " + nappulat.getNappula(x, y));
                    
                    nappulat.poistaNappula(nappulat.getNappula(x, y));
                    System.out.println("Nappula poistettu");
                    
                    nappulat.annaValittuNappula().liiku(x, y);
                    System.out.println("Liikutetaan valittu nappula sijaintiin..");
                }
            }

        } else {
            System.out.println("Siirto ei mahdollinen" + x + "," + y);
        }

    }


    /*
     * GETTERTI JA SETTERIT
     */
//    public Lauta getLauta() {
//        return this.lauta;
//    }

//    public NappulaSet getNappulatSet() {
//        return this.nappulat;
//    }
}
