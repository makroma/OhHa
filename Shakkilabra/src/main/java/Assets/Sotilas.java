/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author marko
 */
public class Sotilas extends Nappula {

    public Sotilas(EnumVari vari, int x, int y) {
        super(EnumTyyppi.S, vari, new Kordinaatti(x, y));
    }

    @Override
    public void liiku(int x, int y) {
        kasvataSiirtojenMaaraaYhdella();
        super.setKordinaatti(x, y);

//        if (super.getVari().equals(EnumVari.M)) {
//            super.setKordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY());
//        } else {
//            super.setKordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY());
//        }
    }

    @Override
    public String uCodeNappula() {
        String s;
        if (super.getVari() == EnumVari.V) {
            s = "\u2659";
        } else {
            s = "\u265F";
        }
        return s;
    }

    @Override
    public HashMap<Kordinaatti, Boolean> mahdollisetSiirrot() {
        HashMap<Kordinaatti, Boolean> siirrot = new HashMap<>();
       // List<Kordinaatti> siirrot = new ArrayList<>();

        //Jos siirtojenmäärä = 0 niin sotilasta voi siirtää yhden tai kaksi eteenpäin
        if (super.getSiirtojenMaara() == 0) {
            if (super.getVari() == EnumVari.M) {
                siirrot.put(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY()), Boolean.FALSE);
                siirrot.put(new Kordinaatti(super.getKordinaatti().getX() + 2, super.getKordinaatti().getY()), Boolean.FALSE);
                //siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY()));
                //siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 2, super.getKordinaatti().getY()));
            } else {
                siirrot.put(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY()), Boolean.FALSE);
                siirrot.put(new Kordinaatti(super.getKordinaatti().getX() - 2, super.getKordinaatti().getY()), Boolean.FALSE);
                //siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY()));
                //siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 2, super.getKordinaatti().getY()));
            }
        }
        // Voi liikkua eteenpäin, (jos edessä ei ole toista nappulaa, mutta sitä ei tässä testata)
        if (super.getSiirtojenMaara() > 0) {
            if (super.getVari() == EnumVari.M) {
                siirrot.put(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY()), Boolean.FALSE);
                //siirrot.add(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY()));
            } else {
                siirrot.put(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY()), Boolean.FALSE);
                //siirrot.add(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY()));
            }
        }
        //voi syödä viistoihin, eli palauttaa true
        if (super.getVari() == EnumVari.M) {
            siirrot.put(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() + 1), Boolean.TRUE);
            siirrot.put(new Kordinaatti(super.getKordinaatti().getX() + 1, super.getKordinaatti().getY() - 1), Boolean.TRUE);
        } else {
            siirrot.put(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() + 1), Boolean.TRUE);
            siirrot.put(new Kordinaatti(super.getKordinaatti().getX() - 1, super.getKordinaatti().getY() - 1), Boolean.TRUE);
        }

        return siirrot;
    }
}
