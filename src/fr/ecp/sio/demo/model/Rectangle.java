package fr.ecp.sio.demo.model;

/**
 * A rectangular shape
 */
// This class inherits from Shape (all properties and methods from Shape are available).
// It is NOT abstract, as a consequence it has to implement all abstract methods from Shape.
public class Rectangle extends Shape {

    // Here we only need to declare additional properties specific to a Rectangle.
    public int width = 10;
    public int height = 10;

    // The getArea() method is an declared in Shape as an abstract method.
    // We re-declare is here with the @Override annotation to provide the implementation for a Rectangle.
    @Override
    public double getArea() {
        return width * height;
    }

}
