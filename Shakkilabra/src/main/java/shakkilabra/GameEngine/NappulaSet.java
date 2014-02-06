/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        /* 
         Valkoiset "\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659"
         Mustat "\u265A", "\u265B", "\u265C", "\u265D", "\u265E", "\u265F"
         Ruudut Color.white Color.gray
         */


package shakkilabra.GameEngine;

import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Nappula;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marko
 */
public class NappulaSet {

    private List<Nappula> nappulat;

    public NappulaSet() {
        this.nappulat = new ArrayList<Nappula>();
    }

    public void lisaaNappula(Nappula nappula) {
        this.nappulat.add(nappula);
    }

    public void poistaNappula(Nappula nappula) {
        this.nappulat.remove(nappula);
    }

    public Nappula getNappula(int x, int y) {
        for (Nappula n : nappulat) {
            if (n.getKordinaatti().getX() == x && n.getKordinaatti().getY() == y) {
                return n;
            }
        }
        return null;
    }

    public boolean onkoRuuduVapaa(int x, int y) {

        for (Nappula n : this.nappulat) {
            if (n.getKordinaatti().getX() == x && n.getKordinaatti().getY() == y) {
                return false;
            }
        }
        return true;
    }

    public int getNappulatSize() {
        return this.nappulat.size();
    }

    //Onko Tämä vielä kesken?? Pelimoottorin tarkistus käyttää tätä
    public boolean onkoRuutuValitunNappulanSiirroissa(int x, int y) {
        for (Kordinaatti k : annaValittuNappula().getMahdollisetSiirrot().keySet()) {
            if (k.getX() == x && k.getY() == y) {
                return true;
            }
        }
        return false;
    }

    //Korjaa tättätä!
    public boolean syokoValittuNappulaSijaintiin(int x, int y) {
        for (Kordinaatti k : annaValittuNappula().getMahdollisetSiirrot().keySet()) {
            if (!onkoRuuduVapaa(k.getX(), k.getY())) {
                System.out.println("sijainnista löytyi nappula");
                if (annaValittuNappula().getMahdollisetSiirrot().get(k)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Nappula annaValittuNappula() {
        for (Nappula n : this.nappulat) {
            if (n.isValittu()) {
                return n;
            }
        }
        return null;
    }

    /*
     * DEBUG // asciipelimoottori
     */
    public void tulostaNappulat() {
        for (Nappula n : this.nappulat) {
            if (n.isElossa()) {
                System.out.println(n);
            }
        }
        System.out.println("");
    }

    public void tulostaMahdollisetSiirrotXY(int x, int y) {
        System.out.println("Mahdolliset siirrot nappulalle " + getNappula(x, y));
        for (Kordinaatti k : getNappula(x, y).getMahdollisetSiirrot().keySet()) {
            System.out.print(k.getX() + "," + k.getY() + ", ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void tulostaValitunNappulanMahdollisetSiirrot() {
        System.out.println("Mahdolliset siirrot nappulalle " + annaValittuNappula());
        for (Kordinaatti k : annaValittuNappula().getMahdollisetSiirrot().keySet()) {
            System.out.print(k.getX() + "," + k.getY() + ", ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void asciiLautaTulostin() {
        System.out.println("Tulostetaan lauta...");
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (getNappula(x, y) != null && getNappula(x, y).isElossa()) {
                    System.out.print(" " + getNappula(x, y).getTyyppi() + "" + getNappula(x, y).getVari());

                } else {
                    System.out.print(" x ");
                }
            }
            System.out.println("");
        }
        System.out.println("");

    }

    public void asciiMahdollisetSiirrot(int xX, int yY) {
        System.out.println("Tulostetaan mahdolliset siirrot nappulalle: " + xX + "," + yY);
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (onkoRuutuValitunNappulanSiirroissa(x, y)) {
                    System.out.print(" o ");
                } else if (getNappula(x, y) != null && getNappula(x, y).isElossa()) {
                    System.out.print(" " + getNappula(x, y).getTyyppi() + "" + getNappula(x, y).getVari());
                } else {
                    System.out.print(" x ");
                }
            }
            System.out.println("");
        }
        System.out.println("");

    }

}
