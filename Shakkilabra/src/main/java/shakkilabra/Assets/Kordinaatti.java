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

    public Kordinaatti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getXY() {
        return this.x + "," + this.y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
