/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

/**
 *
 * @author marko
 */
public class Sotilas extends Nappula {

    public Sotilas(EnumVari vari, int x, int y) {
        super(EnumTyyppi.S, vari, x, y);
    }

    @Override
    public void liiku() {
        if (super.getVari().equals(EnumVari.M)) {
            super.setX(super.getX() + 1);
        } else {
            super.setX(super.getX() - 1);
        }
    }

    @Override
    public int[][] mahdollisetSiirrot() {

        //onko tämä hyvä idea näin...
        
        int[][] siirrot = new int [8][8];

        
        return siirrot;
    }

}
