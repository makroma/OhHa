/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Grafiikka;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author marko
 */
public class AlphaContainer extends JPanel {

    private JComponent component;

    public AlphaContainer(JComponent component) {
        this.component = component;
        setLayout(new BorderLayout());
        setOpaque(false);
        component.setOpaque(false);
        add(component);
    }

    /**
     * Paint the background using the background Color of the contained
     * component
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(component.getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}

