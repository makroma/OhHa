/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import Grafiikka.Lauta;

import Assets.EnumTyyppi;
import Assets.EnumVari;
import Assets.Sotilas;
import Grafiikka.Grafiikkamoottori;

/**
 *
 * @author marko
 */
public class Pelimoottori {

    private Lauta lauta;
    private NappulaSet nappulat;

    public Pelimoottori() {

        this.lauta = new Lauta();
        this.nappulat = new NappulaSet();

    }

    public void graafinenPeliRun() {
        System.out.println("luodaan sotilaat");
        luoSotilaatLaudalle();
        System.out.println("Luodaan Graafinen peli");
        Grafiikka.Grafiikkamoottori peli = new Grafiikkamoottori(lauta, this.nappulat);
        System.out.println("Käynnistetään peliä....");
        peli.run();

    }

    public void testipeliRun() {

        luoSotilaatLaudalle();

        nappulat.tulostaNappulat();
        nappulat.asciiLautaTulostin();

        System.out.println("Valitaan musta sotilas...1,5");

        nappulat.tulostaMahdollisetSiirrot(1, 5);
        nappulat.asciiMahdollisetSiirrot(1, 5);

        // nappulat.getNappula(1, 5).liiku(4, 5);
        System.out.println("Musta nappula liikkuu");
        nappulat.getNappula(1, 5).liiku(3, 5);

        nappulat.tulostaNappulat();
        nappulat.asciiLautaTulostin();

        //nappulat.getNappula(5, 6).setElossa();
        nappulat.tulostaNappulat();
        System.out.println("Valkoinen liikkuu");
        nappulat.getNappula(3, 5).liiku(4, 5);
        nappulat.tulostaNappulat();
        nappulat.asciiLautaTulostin();

    }

    public void luoSotilaatLaudalle() {
        //luodaan valkoiset Sotilaat
        nappulat.lisaaNappula(new Sotilas(EnumVari.V, 6, 0));
        nappulat.lisaaNappula(new Sotilas(EnumVari.V, 6, 1));
        nappulat.lisaaNappula(new Sotilas(EnumVari.V, 6, 2));
        nappulat.lisaaNappula(new Sotilas(EnumVari.V, 6, 3));
        nappulat.lisaaNappula(new Sotilas(EnumVari.V, 6, 4));
        nappulat.lisaaNappula(new Sotilas(EnumVari.V, 6, 5));
        nappulat.lisaaNappula(new Sotilas(EnumVari.V, 6, 6));
        nappulat.lisaaNappula(new Sotilas(EnumVari.V, 6, 7));

        //luodaan mustat Sotilaat
        nappulat.lisaaNappula(new Sotilas(EnumVari.M, 1, 0));
        nappulat.lisaaNappula(new Sotilas(EnumVari.M, 1, 1));
        nappulat.lisaaNappula(new Sotilas(EnumVari.M, 1, 2));
        nappulat.lisaaNappula(new Sotilas(EnumVari.M, 1, 3));
        nappulat.lisaaNappula(new Sotilas(EnumVari.M, 1, 4));
        nappulat.lisaaNappula(new Sotilas(EnumVari.M, 1, 5));
        nappulat.lisaaNappula(new Sotilas(EnumVari.M, 1, 6));
        nappulat.lisaaNappula(new Sotilas(EnumVari.M, 1, 7));

    }

    public void liikutaNappulaa(int x, int y, int uusiX, int uusiY) {

        //jos sotilas
        if (nappulat.getNappula(x, y).getTyyppi() == EnumTyyppi.S) {
            if (nappulat.getNappula(x, y).onkoMahdollinenSiirto(uusiX, uusiY)) {
                //jos liikkuu eteenpäin, onko ruutu tyhjä

                //jos liikkuu viistoon, niin syökö silloin
            } else {
                System.out.println("Siirto ei mahdollinen");
            }
        }

        nappulat.getNappula(x, y).liiku(uusiX, uusiY);

    }

}
