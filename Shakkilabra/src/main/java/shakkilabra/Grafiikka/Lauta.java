package shakkilabra.Grafiikka;

import shakkilabra.Assets.EnumVari;
import shakkilabra.CoverageIgnore;
@CoverageIgnore
public final class Lauta {

    private final Ruutu[][] ruutu;

    public Lauta() {
        this.ruutu = new Ruutu[8][8];
        luoRuudukko();
        //asciiRuutuTulostin();
    }

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

    public Ruutu[][] getRuudukko() {
        return ruutu;
    }

    public Ruutu getRuutu(int x, int y) {
        return ruutu[x][y];
    }

    //DEBUG   
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
