package shakkilabra.Grafiikka;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * Näyttää tarvittaessa pelaajien tekemät siirrot laudan oikealla puolella
 *
 * @author marko
 */
public class SiirrotNaytto {

    private final JTextArea tietokentta;
    private final JPanel naytto;
    private String teksti;

    /**
     * Luo Jpanelin ja tekstikentän siihen.
     */
    public SiirrotNaytto() {

        naytto = new JPanel();
        tietokentta = new JTextArea(10, 1);
        teksti = "";
    }

    /**
     * Luo uuden siitonäytön
     */
    public void luoSiirrotNaytto() {

        tietokentta.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.tietokentta);
        scrollPane.setPreferredSize(new Dimension(350, 400));

        naytto.add(scrollPane);
        naytto.setBackground(new Color(0, 100, 200, 100));
        naytto.setBorder(new EmptyBorder(3, 3, 3, 3));
        naytto.setVisible(false);

    }

    /**
     * KirjoitaPelinäyttöön metodilla voidaan näyttöön tulostaa toivottu teksti
     *
     * @param s tulostettava teksti
     */
    public void kirjoitaSiirrotNayttoon(String s) {
        teksti += s + "\n";
        tietokentta.setText(teksti);
    }

    /**
     * Ylävalikon näytä/piilota SiirtoNäyttö käyttää tätä
     */
    public void piilotaSiirrotNaytto() {
        if (naytto.isVisible()) {
            naytto.setVisible(false);
        } else {
            naytto.setVisible(true);
        }
    }

    /**
     *
     * @return
     */
    public JPanel getSiirrotNaytto() {
        return naytto;
    }

    public boolean isVisible() {
        return naytto.isVisible();
    }
}
