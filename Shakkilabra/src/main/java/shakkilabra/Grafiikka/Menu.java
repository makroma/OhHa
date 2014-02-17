package shakkilabra.Grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame implements ActionListener {

    public Menu() {
    }

    public JMenuBar createMenuBar() { //Create the menu bar.

        JMenuBar menuBar = new JMenuBar();

        //Add a JMenu
        JMenu Game = new JMenu("Game");
        menuBar.add(Game);

        JMenuItem newGame = new JMenuItem("New Game");
        Game.add(newGame);
        
        JMenuItem exit = new JMenuItem("Exit");
        Game.add(exit);
        
        newGame.addActionListener(new Menu());
        exit.addActionListener(new Menu());
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(""+e.getActionCommand());
        if (e.getActionCommand().equals("New Game")) {
            Grafiikkamoottori peli = new Grafiikkamoottori();
            peli.luoPeli();
            peli.run();
        }
        if (e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
    }

}
