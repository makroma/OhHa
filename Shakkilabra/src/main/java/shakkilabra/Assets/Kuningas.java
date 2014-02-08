/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Assets;

import java.util.ArrayList;

/**
 *
 * @author marko
 */
public class Kuningas extends Nappula {

    public Kuningas(EnumVari vari, int x, int y) {
        super(EnumTyyppi.KUNINGAS, vari, new Kordinaatti(x, y));
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
            s = "\u2654";
        } else {
            s = "\u265A";
        }
        return s;
    }

    @Override
    public ArrayList<Kordinaatti> mahdollisetSiirrot() {
        ArrayList<Kordinaatti> siirrot = new ArrayList<>();
        //Kuninkaan liikkeet
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY()));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() + 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() - 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX(), super.getKordinaatti().getY() - 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX(), super.getKordinaatti().getY() + 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() - 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() + 1));
        siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY()));

        return siirrot;
    }

    @Override
    public boolean syokoSotilas(int x, int y) {
        return true;
    }
}
