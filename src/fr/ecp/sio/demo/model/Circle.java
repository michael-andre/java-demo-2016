package fr.ecp.sio.demo.model;

import java.awt.*;

/**
 * A circular shape.
 */
public class Circle extends Shape {

    // Specific to a Circle.
    private int radius;

    public Circle() { }

    public Circle(Point origin, int radius) {
        super(origin);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    // Implement getArea() abstract method from Shape.
    @Override
    public double getArea() {
        // The java.lang.Math exposes static methods and constants for maths.
        // Math is a 'helper class': all methods are static and it cannot be instantiated.
        // Classes in java.lang.* package doesn't need an import declaration.
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(getOrigin().getX(), getOrigin().getY(), radius * 2, radius * 2);
    }

    @Override
    public String toString() {
        return "Circle { " + super.toString() + "; radius=" + radius + " }";
    }
}
