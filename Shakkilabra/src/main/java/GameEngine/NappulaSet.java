/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import Assets.Nappula;
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
    public void poistaNappula(Nappula nappula){
        this.nappulat.remove(nappula);
    }

    public void tulostaNappulat() {
        for (Nappula n : this.nappulat) {
            System.out.println(n.getVari() + "" + n.getTyyppi() + " " + n.getABC(n.getY()) + n.getX());
        }
    }

    public Nappula getNappula(int x, int y) {
        for (Nappula n : nappulat) {
            if (n.getX() == x && n.getY() == y) {
                return n;
            }
        }
        return null;
    }

    public void asciiLautaTulostin() {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (getNappula(x, y) != null) {
                    System.out.print(" " + getNappula(x, y).getTyyppi() + "" + getNappula(x, y).getVari());

                } else {
                    System.out.print(" x ");
                }
            }
            System.out.println("");
        }

    }

}
