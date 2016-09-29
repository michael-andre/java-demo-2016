package fr.ecp.sio.demo.model;

/**
 * A circular shape.
 */
public class Circle extends Shape {

    // Specific to a Circle.
    public int radius;

    // Implement getArea() abstract method from Shape.
    @Override
    public double getArea() {
        // The java.lang.Math exposes static methods and constants for maths.
        // Classes in java.lang.* package doesn't need an import declaration.
        return Math.pow(radius, 2) * Math.PI;
    }

}
