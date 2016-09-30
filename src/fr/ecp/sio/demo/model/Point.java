package fr.ecp.sio.demo.model;

/**
 * Created by Michaël on 30/09/2016.
 */
public class Point /*extends Object*/ {

    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{ x=" + x + "; y=" + y + " }";
    }

}
