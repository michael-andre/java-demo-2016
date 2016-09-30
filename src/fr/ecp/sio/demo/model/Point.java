package fr.ecp.sio.demo.model;

/**
 * A simple point class to hold x and y values.
 */
// No need to extend Object, it is the default.
public class Point /*extends Object*/ {

    // Encapsulation: fields are private.
    private int x, y;

    // This will be the only available constructor for a Point, with x and y.
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

    // Let's customize the toString() method of a Point.
    @Override
    public String toString() {
        return "{ x=" + x + "; y=" + y + " }";
    }

}
