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
public class Hevonen extends Nappula {

    public Hevonen(EnumVari vari, int x, int y) {
        super(EnumTyyppi.HEVONEN, vari, new Kordinaatti(x, y));
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
            s = "\u2658";
        } else {
            s = "\u265E";
        }
        return s;
    }

    @Override
    public ArrayList<Kordinaatti> mahdollisetSiirrot() {
        ArrayList<Kordinaatti> siirrot = new ArrayList<>();
        //Kuninkaan liikkeet
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 2, super.getKordinaatti().getY() + 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 2, super.getKordinaatti().getY() - 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() - 2));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() - 2));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() + 2));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() + 2));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 2, super.getKordinaatti().getY() + 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 2, super.getKordinaatti().getY() - 1));

        return siirrot;
    }

    @Override
    public boolean syokoNappula(int x, int y) {
        return true;
    }
}
