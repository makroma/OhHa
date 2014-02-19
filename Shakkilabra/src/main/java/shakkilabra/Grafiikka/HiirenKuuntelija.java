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
import shakkilabra.GameEngine.NappulaSet;
import shakkilabra.GameEngine.Pelilogiikka;

/**
 *
 * @author marko
 */
public class HiirenKuuntelija implements MouseListener {

    private Pelilogiikka pelimoottori;
    private NappulaSet nappulat;
    private JLabel jlabel;
    private JLabel valittuRuutu;
    private int x;
    private int y;
    private Color color;
    private Grafiikkamoottori grafiikkamoottori;

    public HiirenKuuntelija(Grafiikkamoottori g, JLabel j, Pelilogiikka p, NappulaSet n, int x, int y) {
        this.jlabel = j;
        this.pelimoottori = p;
        this.nappulat = n;
        this.x = x;
        this.y = y;
        this.color = j.getBackground();
        this.grafiikkamoottori = g;
        this.valittuRuutu = null;
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
            this.jlabel.setBackground(Color.red);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.nappulat.getNappula(x, y) != null && this.nappulat.annaValittuNappula() == null) {
            System.out.println("Nappula valittu " + nappulat.getNappula(x, y));
            this.nappulat.getNappula(x, y).setValittu(true);
            this.grafiikkamoottori.setValittuRuutu(jlabel);
            this.grafiikkamoottori.paivitaValintaVari();

        } else if (this.nappulat.annaValittuNappula() != null) {

            this.nappulat.tulostaValitunNappulanMahdollisetSiirrot();
            System.out.println("Liikutetaan nappulaa " + this.nappulat.annaValittuNappula() + " sijaintiin " + x + ", " + y);

            if (this.pelimoottori.nappulanLiikkumisToiminto(this.nappulat, x, y)) {
                this.grafiikkamoottori.paivita(jlabel, x, y);
            } else {
                this.grafiikkamoottori.getValittuRuutu().setForeground(color.BLACK);
                this.grafiikkamoottori.setValittuRuutu(null);
            }

        }
    }
}
