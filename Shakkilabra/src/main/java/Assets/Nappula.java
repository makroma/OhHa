package Assets;


public abstract class Nappula {

    private EnumTyyppi tyyppi;
    private EnumVari vari;
    private int x;
    private int y;
    private int siirtojenMaara;
    private boolean elossa;

    public Nappula(EnumTyyppi nappulat, EnumVari vari, int x, int y) {
        this.tyyppi = nappulat;
        this.vari = vari;
        this.x = x;
        this.y = y;
        this.siirtojenMaara = 0;
        this.elossa = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTyyppi(EnumTyyppi tyyppi) {
        this.tyyppi = tyyppi;
    }

    public void setVari(EnumVari vari) {
        this.vari = vari;
    }

    public EnumTyyppi getTyyppi() {
        return this.tyyppi;
    }

    public EnumVari getVari() {
        return this.vari;
    }

    public String getABC(int x) {
        
        String ABC = "ABCDEFGH";        
        return ABC.charAt(x-1)+"";
    }

    public abstract void liiku();
    public abstract int[][] mahdollisetSiirrot();
}
