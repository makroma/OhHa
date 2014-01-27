/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafiikka;

import Assets.EnumVari;
import GameEngine.NappulaSet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author marko
 */
public class Grafiikkamoottori {

    static Font font = new Font("Sans-Serif", Font.PLAIN, 64);
    private final Lauta lauta;
    private final NappulaSet nappulatSet;

    public Grafiikkamoottori(Lauta lauta, NappulaSet nappulat) {
        this.lauta = lauta;
        this.nappulatSet = nappulat;
    }

    public void run() {
        JFrame frame = new JFrame("TopLevelDemo");
        frame.setPreferredSize(new Dimension(900, 800));
        // JPanel p = new JPanel(new BorderLayout());
        JPanel gui = new JPanel(new GridLayout(9, 10, 4, 4));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* 
         Valkoiset "\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659"
         Mustat "\u265A", "\u265B", "\u265C", "\u265D", "\u265E", "\u265F"
         Ruudut Color.white Color.gray
         */
     
        piirraGraafinenRuudukko(gui);
        /*   JLabel l = new JLabel("rai rai rai");
         l.setFont(font);
         l.setOpaque(true);
         p.add(l);
         p.add(gui);
         frame.getContentPane().add(p);*/

        frame.getContentPane().add(gui);
        frame.pack();
        frame.setVisible(true);

        JOptionPane.getDesktopPaneForComponent(gui);

        // JOptionPane.showMessageDialog(null, gui);
    }

    private void piirraGraafinenRuudukko(JPanel gui) {
        // tulostaVaakaKordinaatti(gui);

        for (int i = 0; i < 8; i++) {
            tulostaPystyKordinaatti(i, gui);
            for (int j = 0; j < 8; j++) {
                if (this.lauta.getRuutu(i, j).getVari() == EnumVari.V) {
                    if (this.nappulatSet.getNappula(i, j) != null) {
                        piirraRuutu(this.nappulatSet.getNappula(i, j).uCodeNappula(), gui, Color.white);
                    } else {
                        piirraRuutu("   ", gui, Color.white);
                    }
                } else {
                    if (this.nappulatSet.getNappula(i, j) != null) {
                        piirraRuutu(this.nappulatSet.getNappula(i, j).uCodeNappula(), gui, Color.gray);
                    } else {
                        piirraRuutu("   ", gui, Color.gray);
                    }
                }
            }
             tulostaPystyKordinaatti(i, gui);
        }
        tulostaVaakaKordinaatti(gui);
    }

    public static void piirraRuutu(String s, Container c, Color d) {

        JLabel l = new JLabel(s);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(font);
        l.setOpaque(true);
        l.setBackground(d);
        

        c.add(l);
    }

    public void tulostaPystyKordinaatti(int i, JPanel gui) {
        piirraRuutu(Integer.toString(8 - i), gui, null);

    }

    public void tulostaVaakaKordinaatti(JPanel gui) {
        String kord = " ABCDEFGH  ";
        for (int i = 0; i < 9; i++) {
            piirraRuutu("" + kord.charAt(i), gui, null);
        }
    }

}
