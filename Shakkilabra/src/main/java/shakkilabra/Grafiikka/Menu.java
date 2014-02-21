package shakkilabra.Grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Menu extends JFrame implements ActionListener {

    private Grafiikkamoottori gr;

    public Menu(Grafiikkamoottori gr) {
        this.gr = gr;
    }

    public JMenuBar createMenuBar() {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }

        JMenuBar menuBar = new JMenuBar();

        JMenu Game = new JMenu("Peli");
        menuBar.add(Game);

        JMenuItem newGame = new JMenuItem("Uusi Peli");
        Game.add(newGame);

        JMenuItem exit = new JMenuItem("Poistu");
        Game.add(exit);

        newGame.addActionListener(this);
        exit.addActionListener(this);

        JMenu Nayta = new JMenu("Näytä");
        menuBar.add(Nayta);

        JRadioButtonMenuItem siirrot = new JRadioButtonMenuItem("Tehdyt siirrot");
        Nayta.add(siirrot);

        siirrot.addActionListener(this);

        return menuBar;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("" + e.getActionCommand());
        if (e.getActionCommand().equals("Uusi Peli")) {
            Grafiikkamoottori peli = new Grafiikkamoottori();
            peli.luoPeli();
            peli.run();

        }
        if (e.getActionCommand().equals("Poistu")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("Tehdyt siirrot")) {
            this.gr.naytaSiirtoNaytto();
        }
    }

}
