package fr.ecp.sio.demo.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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

    public Point(JsonElement config) {
        if (config instanceof JsonArray) {
            this.x = ((JsonArray) config).get(0).getAsInt();
            this.y = ((JsonArray) config).get(1).getAsInt();
        } else if (config instanceof JsonObject) {
            this.x = ((JsonObject) config).get("x").getAsInt();
            this.y = ((JsonObject) config).get("y").getAsInt();
        }
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
