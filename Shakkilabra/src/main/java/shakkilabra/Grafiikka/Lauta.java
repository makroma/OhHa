/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Grafiikka;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import shakkilabra.Assets.EnumVari;
import static shakkilabra.Grafiikka.Grafiikkamoottori.font;

public final class Lauta {

    private Ruutu[][] ruutu;

    public Lauta() {
        this.ruutu = new Ruutu[8][8];
        luoRuudukko();
        //asciiRuutuTulostin();
    }

    public void luoRuudukko() {

        boolean valkoinen = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (valkoinen) {
                    this.ruutu[i][j] = new Ruutu(EnumVari.VALKOINEN);
                    valkoinen = false;
                } else {
                    //Pelilauta ruutu = new Pelilauta(new Ruutu(Vari.MUSTA));
                    this.ruutu[i][j] = new Ruutu(EnumVari.MUSTA);
                    valkoinen = true;
                }
            }
            valkoinen = !valkoinen;
        }
        System.out.println("Ruudukko luotu.");
    }
    
   

    public Ruutu[][] getRuudukko() {
        return ruutu;
    }

    public Ruutu getRuutu(int x, int y) {
        return ruutu[x][y];
    }

    //DEBUG   
    public void asciiRuutuTulostin() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.ruutu[i][j].getVari() == EnumVari.VALKOINEN) {
                    System.out.print("\u2591");
                }
                if (this.ruutu[i][j].getVari() == EnumVari.MUSTA) {
                    System.out.print("\u2593");
                }

            }
            System.out.println();
        }

    }
}
