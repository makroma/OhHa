package shakkilabra.Assets;

import java.util.HashMap;
import java.util.List;

public abstract class Nappula {

    private EnumTyyppi tyyppi;
    private EnumVari vari;
    private Kordinaatti kordinaatti;
    private int siirtojenMaara;
    private boolean elossa;
    private boolean valittu;
    private HashMap<Kordinaatti, Boolean> mahdollisetSiirrot;

    public Nappula(EnumTyyppi nappulat, EnumVari vari, Kordinaatti kord) {
        this.tyyppi = nappulat;
        this.vari = vari;
        this.kordinaatti = kord;
        this.siirtojenMaara = 0;
        this.elossa = true;
        this.mahdollisetSiirrot = mahdollisetSiirrot();
    }
    /*
     *  Abstraktit luokat
     */

    public abstract void liiku(int x, int y);

    public abstract String uCodeNappula();

    public abstract HashMap<Kordinaatti, Boolean> mahdollisetSiirrot();

    /*getMahdollisetSiirrot palauttaa boolean true, jos voi 
     *syödä kyseisessä kordinaatissa
     *esim sotilas ei syö eteenpäin liikkuessa
     */
    public HashMap<Kordinaatti, Boolean> getMahdollisetSiirrot() {
        return mahdollisetSiirrot();
    }

    public void kasvataSiirtojenMaaraaYhdella() {
        this.siirtojenMaara++;
    }

    public boolean onkoMahdollinenSiirto(Kordinaatti kord) {
        System.out.println("Tarkistetaan siirron mahdollisuus...");
        if(getMahdollisetSiirrot().containsKey(kord)){
            return true;
        }
        
        for (Kordinaatti k : getMahdollisetSiirrot().keySet()) {
            if(k.getX()==kord.getX()&&k.getY()==kord.getY()){
                return true;
            }
        }
        System.out.println("False");
        return false;
    }

    /*
     *   Getterit ja Setterit ja toString
     */
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

    public int getSiirtojenMaara() {
        return this.siirtojenMaara;
    }

    public Kordinaatti getKordinaatti() {
        return kordinaatti;
    }

    public void setKordinaatti(int x, int y) {
        this.kordinaatti = new Kordinaatti(x, y);
    }

    public boolean isElossa() {
        return this.elossa;
    }

    public void setElossa() {
        this.elossa = false;
    }

    public String toString() {
        return this.vari + "" + this.tyyppi + " " + this.kordinaatti.getX() + "," + this.kordinaatti.getY() + " Siirtoja:" + this.siirtojenMaara;
    }

    public boolean isValittu() {
        return valittu;
    }

    public void setValittu(boolean valittu) {
        this.valittu = valittu;
    }

   
}
