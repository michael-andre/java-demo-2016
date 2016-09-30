package fr.ecp.sio.demo.model;

/**
 * A rectangular shape
 */
// This class inherits from Shape (all properties and methods from Shape are available).
// It is NOT abstract, as a consequence it has to implement all abstract methods from Shape.
public class Rectangle extends Shape {

    // Here we only need to declare additional properties specific to a Rectangle.
    private int width = 10;
    private int height = 10;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // The getArea() method is an declared in Shape as an abstract method.
    // We re-declare is here with the @Override annotation to provide the implementation for a Rectangle.
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void draw() {

    }

}
