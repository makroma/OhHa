package shakkilabra.Grafiikka;

import javax.swing.JLabel;
import shakkilabra.Assets.EnumVari;
import shakkilabra.CoverageIgnore;

/**
 *
 * @author marko
 */
@CoverageIgnore
public class Ruutu extends JLabel {

    private final EnumVari vari;
    private final JLabel jlabel;

    public Ruutu(EnumVari vari) {
        this.vari = vari;
        jlabel = new JLabel();
    }

    public EnumVari getVari() {
        return vari;
    }

    public JLabel getJLabel() {
        return jlabel;
    }
}
