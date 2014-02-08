/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Assets.Nappulat;

import java.util.ArrayList;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Kordinaatti;
import shakkilabra.Assets.Nappula;
import shakkilabra.Assets.EnumTyyppi;

/**
 *
 * @author marko
 */
public class Lahetti extends Nappula {

    public Lahetti(EnumVari vari, int x, int y) {
        super(EnumTyyppi.LAHETTI, vari, new Kordinaatti(x, y));
    }

    @Override
    public void liiku(int x, int y) {
        kasvataSiirtojenMaaraaYhdella();
        super.setKordinaatti(x, y);
    }

    @Override
    public String uCodeNappula() {
        String s;
        if (super.getVari() == EnumVari.VALKOINEN) {
            s = "\u2657";
        } else {
            s = "\u265D";
        }
        return s;
    }

    @Override
    public ArrayList<Kordinaatti> mahdollisetSiirrot() {
        ArrayList<Kordinaatti> siirrot = new ArrayList<>();
        //Kuningattaren liikkeet

        int lX = super.getKordinaatti().getX();
        int lY = super.getKordinaatti().getY();
        int negX = lX + lY;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (x - negX == 0 || (lX - x == lY - y)) {
                    siirrot.add(new Kordinaatti(x, y));
                }
            }
            negX--;
        }
        return siirrot;
    }

    @Override
    public boolean syokoNappula(int x, int y) {
        return true;
    }
}
