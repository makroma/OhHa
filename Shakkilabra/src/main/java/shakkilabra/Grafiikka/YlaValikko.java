package shakkilabra.Grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import shakkilabra.CoverageIgnore;

/**
 * Luo ylävalikon peliin
 *
 * @author marko
 */
@CoverageIgnore
public class YlaValikko extends JFrame implements ActionListener {

    private Grafiikkamoottori gr;

    public YlaValikko(Grafiikkamoottori gr) {
        this.gr = gr;
    }

    /**
     * Luodaan ylävalikko ikkunalla. Tarkistaa alussa Mac yhteen sopivuuden ja
     * siirtää menu yläpalkkiin.
     *
     * @return
     */
    public JMenuBar luoYlaValikko() {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }

        JMenuBar ylaValikko = new JMenuBar();

        JMenu Arkisto = new JMenu("Arkisto");
        ylaValikko.add(Arkisto);

        JMenuItem uusiPeli = new JMenuItem("Uusi Peli");
        Arkisto.add(uusiPeli);
        JMenuItem exit = new JMenuItem("Poistu");
        Arkisto.add(exit);

        JMenu Nayta = new JMenu("Näytä");
        ylaValikko.add(Nayta);

        JRadioButtonMenuItem siirrot = new JRadioButtonMenuItem("Tehdyt siirrot");
        Nayta.add(siirrot);

        //ActionListeners
        uusiPeli.addActionListener(this);
        exit.addActionListener(this);
        siirrot.addActionListener(this);

        return ylaValikko;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("" + e.getActionCommand());
        if (e.getActionCommand().equals("Uusi Peli")) {
            gr.luoNappulatAlkuTilanteeseen();
            gr.paivitaKokoLauta();
        }
        if (e.getActionCommand().equals("Poistu")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("Tehdyt siirrot")) {
            this.gr.naytaSiirtoNaytto();
        }
    }

}
