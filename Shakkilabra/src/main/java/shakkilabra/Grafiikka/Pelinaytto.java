package shakkilabra.Grafiikka;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author marko
 */
public class Pelinaytto extends JPanel {

    private JTextArea tietokentta;
    private JPanel naytto;
    private String teksti;

    public Pelinaytto() {

        this.naytto = new JPanel();
        this.tietokentta = new JTextArea(10, 1);
        this.teksti = "";
    }

    public void luoSiirtoNaytto() {

        this.tietokentta.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.tietokentta);
        scrollPane.setPreferredSize(new Dimension(350, 400));

        
        this.naytto.add(scrollPane);
        this.naytto.setBackground(new Color(0, 100, 200, 100));
        this.naytto.setBorder(new EmptyBorder(3, 3, 3, 3));
        this.naytto.setVisible(false);

    }

    public void kirjoitaPeliNayttoon(String s) {

        this.teksti += s + "\n";
        this.tietokentta.setText(this.teksti);

    }

    public void piilotaPeliNaytto() {
        if (this.naytto.isVisible()) {
            this.naytto.setVisible(false);
        } else {
            this.naytto.setVisible(true);
        }
    }

    public JPanel getNaytto() {
        return naytto;
    }

}
