
package shakkilabra.Grafiikka;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author marko
 */
public class Pelinaytto {

    private JTextArea tietokentta;
    private JPanel naytto;
    private String teksti;

    public Pelinaytto() {

        this.naytto = new JPanel();
        this.tietokentta = new JTextArea(10, 1);
        this.teksti = "";
    }

    public void piirraPelinaytto() {

        this.tietokentta.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.tietokentta);
        scrollPane.setPreferredSize(new Dimension(290, 400));
        this.naytto.add(scrollPane);
    }

    public void kirjoitaPeliNayttoon(String s) {

        this.teksti += s + "\n";
        this.tietokentta.setText(this.teksti);

    }

    public JPanel getNaytto() {
        return naytto;
    }

}
