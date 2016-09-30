package fr.ecp.sio.demo.model;

/**
 * A rectangular shape
 */
// This class inherits from Shape (all properties and methods from Shape and its parent are available).
// It is NOT abstract, as a consequence it has to implement all abstract methods from Shape (and Drawable).
public class Rectangle extends Shape {

    // Here we only need to declare additional properties specific to a Rectangle.
    private int width;
    private int height;

    // A no-arg constructor for a Rectangle.
    public Rectangle() {
        // This constructor will implicitly call the no-arg constructor of Shape.
        // It is possible only if the parent class do provide a no-arg constructor!
    }

    // Another constructor for a Rectangle with origin, width and height.
    public Rectangle(Point origin, int width, int height) {
        // We explicitly call the constructor of Shape that takes a Point.
        // super() must be the first statement in a constructor.
        super(origin);
        this.width = width;
        this.height = height;
    }

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
        // TODO
    }

    @Override
    public String toString() {
        // When overriding a method, we can call the parent implementation with 'super'.
        return "Rectangle { " + super.toString() + "; width=" + width + "; height=" + height + " }";
    }

}
