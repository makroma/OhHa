
package shakkilabra.Grafiikka;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * AlphaLaatikko toimii läpinäkyvien kerroksien luokkana, joka asettaa sen
 * komponenteille Opaque false.
 *
 * @author marko
 */
public class AlphaLaatikko extends JPanel {

    private final JComponent component;

    /**
     *
     * @param component
     */
    public AlphaLaatikko(JComponent component) {
        this.component = component;
        setLayout(new BorderLayout());
        setOpaque(false);
        component.setOpaque(false);
        add(component);
    }

    /**
     * Piirtää taustavärin käyttäen componentin taustaväriä
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(component.getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
