package shakkilabra.Grafiikka;

import shakkilabra.Assets.EnumVari;

/**
 * Lauta Sisältää ruutu olioita
 * @author marko
 */
public final class Lauta {

    private final Ruutu[][] ruutu;

    /**
     * Luodaan kaksiulotteinen taulukko ruuduille.
     */
    public Lauta() {
        this.ruutu = new Ruutu[8][8];
        luoRuudukko();
    }

    /**
     * Luo laudalle ruudukon. 
     */
    public void luoRuudukko() {

        boolean valkoinen = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (valkoinen) {
                    ruutu[i][j] = new Ruutu(EnumVari.VALKOINEN);
                    valkoinen = false;
                } else {
                    ruutu[i][j] = new Ruutu(EnumVari.MUSTA);
                    valkoinen = true;
                }
            }
            valkoinen = !valkoinen;
        }
        System.out.println("Ruudukko luotu.");
    }

    /**
     *
     * @return
     */
    public Ruutu[][] getRuudukko() {
        return ruutu;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Ruutu getRuutu(int x, int y) {
        return ruutu[x][y];
    }

    //DEBUG

    /**
     * Debuggas ruututulostin
     */
        public void asciiRuutuTulostin() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ruutu[i][j].getVari() == EnumVari.VALKOINEN) {
                    System.out.print("\u2591");
                }
                if (ruutu[i][j].getVari() == EnumVari.MUSTA) {
                    System.out.print("\u2593");
                }
            }
            System.out.println();
        }
    }
}
