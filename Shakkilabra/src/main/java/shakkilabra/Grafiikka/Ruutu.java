/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Grafiikka;

import javax.swing.JLabel;
import shakkilabra.Assets.EnumVari;

/**
 *
 * @author marko
 */
public class Ruutu extends JLabel{

    private EnumVari vari;
    private JLabel label;
    public Ruutu(EnumVari vari) {
        this.vari = vari;
        this.label = new JLabel();
    }

    public EnumVari getVari() {
        return vari;
    }
    public JLabel getLabel(){
        return this.label;
    }

}
