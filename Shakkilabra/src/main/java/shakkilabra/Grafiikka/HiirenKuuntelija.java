/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Grafiikka;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import shakkilabra.Assets.Kordinaatti;
import shakkilabra.GameEngine.NappulaSet;
import shakkilabra.GameEngine.Pelimoottori;

/**
 *
 * @author marko
 */
public class HiirenKuuntelija implements MouseListener {

    private Pelimoottori pelimoottori;
    private NappulaSet nappulat;
    private JLabel jlabel;
    private int x;
    private int y;
    private Color color;
    private Grafiikkamoottori grafiikkamoottori;

    public HiirenKuuntelija(Grafiikkamoottori g, JLabel j, Pelimoottori p, NappulaSet n, int x, int y) {
        this.jlabel = j;
        this.pelimoottori = p;
        this.nappulat = n;
        this.x = x;
        this.y = y;
        this.color = j.getBackground();
        this.grafiikkamoottori = g;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.jlabel.setBackground(color);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (this.nappulat.getNappula(x, y) != null) {
            // System.out.println("Nappula! " + this.nappulat.getNappula(x, y).getTyyppi());
            this.jlabel.setBackground(Color.red);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
//       if (this.nappulat.getNappula(x, y) != null) {
//            System.out.println(this.nappulat.getNappula(x, y).getKordinaatti().getX()+","+this.nappulat.getNappula(x, y).getKordinaatti().getY());
//            
//        } else {
//            System.out.println(x+","+y);
//        }
        if (this.nappulat.getNappula(x, y) != null) {
            System.out.println("Nappula valittu " + nappulat.getNappula(x, y));
            this.nappulat.tulostaMahdollisetSiirrot(x, y);
            this.nappulat.getNappula(x, y).setValittu(true);
        } else if (this.nappulat.annaValittuNappula() != null) {
            System.out.println("Liikutetaan nappulaa " + this.nappulat.annaValittuNappula() + " sijaintiin " + x + ", " + y);
            this.pelimoottori.liikutaNappulaa(nappulat, x, y);
            //this.nappulat.annaValittuNappula().liiku(x, y);
            this.nappulat.annaValittuNappula().setValittu(false);
            grafiikkamoottori.run();
        }
    }
}
