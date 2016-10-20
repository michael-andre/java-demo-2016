package fr.ecp.sio.demo.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A polygon defined by a list of points, relative to the origin.
 */
public class Polygon extends Shape {

    public Polygon() { }

    public Polygon(JsonObject config) {
        super(config);
        JsonArray points = config.get("points").getAsJsonArray();
        for (JsonElement e : points) addPoint(new Point(e));
    }

    // A polygon if defined by a list of points.
    // We declare the field as a List (interface) because we are ony interested in using its capabilities.
    // Be we have to initialize it with a concrete class which implements List (ArrayList).
    // The value of the list won't change after instantiation, it can be declared af 'final'.
    private final List<Point> points = new ArrayList<>();

    // The points are publicly readable.
    public List<Point> getPoints() {
        return points;
    }

    // No setter here, the list of points itself cannot be changed ('final').
    // One can add a point using getPoints().add() thanks to the previous getter.
    // We can also provide a shortcut with an addPoint() method.
    public void addPoint(Point point) {
        points.add(point);
    }

    @Override
    public void draw(Graphics g) {
        // The drawing of the polygon requires a bit of manipulations.
        // The drawPolygon() method on g needs arrays of coordinates, so we need to build them.
        int size = points.size();
        // Create empty arrays with fixed size.
        int[] x = new int[size];
        int[] y = new int[size];
        /*for (int i = 0; i < points.size(); i++) {
            x[i] = points.get(i).getX();
            y[i] = points.get(i).getY();
        }*/
        // Iteration with an index variable declared outside and incremented in the loop.
        int i = 0;
        for (Point p : points) {
            x[i] = p.getX() + getOrigin().getX();
            y[i] = p.getY() + getOrigin().getY();
            i++;
        }
        g.drawPolygon(x, y, size);
    }

    /*
     * Actually, the area computed here is the area of the bounding rectangle.
     */
    @Override
    public double getArea() {
        // Initialize min and max with extreme values.
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        // Iterate over a list (or any Iterable object) with the dedicated syntax.
        // The local variable p will take successively the values in points.
        for (Point p : points) {
            // Compare the current min and max with the current point and update the values.
            minX = Math.min(minX, p.getX());
            maxX = Math.max(maxX, p.getX());
            minY = Math.min(minY, p.getY());
            maxY = Math.max(maxY, p.getY());
        }
        // Finally, we just need the return the area of the rectangle.
        return Math.abs(maxX - minX) * Math.abs(maxY - minY);
    }

}
