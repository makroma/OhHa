package shakkilabra.Grafiikka;

import javax.swing.JLabel;
import shakkilabra.Assets.EnumVari;

/**
 * Ruutu luokka. Jokaisessa ruudussa on JLabel ja väri. 
 * @author marko
 */

public class Ruutu extends JLabel {

    private final EnumVari vari;
    private final JLabel jlabel;

    /**
     * Luo annetun parametrin värisen ruudun
     * @param vari
     */
    public Ruutu(EnumVari vari) {
        this.vari = vari;
        jlabel = new JLabel();
    }

    /**
     *
     * @return
     */
    public EnumVari getVari() {
        return vari;
    }

    /**
     *
     * @return
     */
    public JLabel getJLabel() {
        return jlabel;
    }
}
