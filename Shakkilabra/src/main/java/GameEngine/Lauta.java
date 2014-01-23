/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import Assets.EnumVari;
import Assets.Ruutu;

public final class Lauta {

    private Ruutu[][] ruutu;

    public Lauta() {
        this.ruutu = new Ruutu[8][8];
        luoRuudukko();
        asciiRuutuTulostin();
        //asciiLautaTulostin();
    }

    public void luoRuudukko() {

        boolean valkoinen = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (valkoinen) {
                    this.ruutu[i][j] = new Ruutu(EnumVari.V);
                    valkoinen = false;
                } else {
                    //Pelilauta ruutu = new Pelilauta(new Ruutu(Vari.MUSTA));
                    this.ruutu[i][j] = new Ruutu(EnumVari.M);
                    valkoinen = true;
                }
            }
            valkoinen = !valkoinen;
        }
        System.out.println("Ruudukko luotu.");
    }
    //DEBUG   


    public void asciiRuutuTulostin() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.ruutu[i][j].getVari() == EnumVari.V) {
                    System.out.print("\u2591");
                }
                if (this.ruutu[i][j].getVari() == EnumVari.M) {
                    System.out.print("\u2593");
                }

            }
            System.out.println();
        }

    }
}
