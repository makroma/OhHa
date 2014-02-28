/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.Assets;

/**
 * Jokaisella nappulalla oleva XY kordinaatti
 * @author marko
 */
public class Kordinaatti {

    private int x;
    private int y;

    /**
     * Kordinaatti konstruktori 
     * @param x Xkordinaatti
     * @param y Ykordinaatti
     */
    public Kordinaatti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *  
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public String getXY() {
        return this.x + "," + this.y;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

}
