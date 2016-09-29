package fr.ecp.sio.demo.model;

/**
 * A base class for all shapes.
 */
// This class has to be declared abstract because it has at least one abstract method.
// As a consequence, this class cannot be instantiated (new Shape()), it can only be subclassed.
public abstract class Shape {

    // Here we declare properties common to all shapes.
    // Properties are strongly typed (declared with a type) and can optionally be given a default value.
    // Properties are public to be accessible/visible from outside of the package (in Main.main() for instance).
    public int x = 0;
    public int y; // The default value is 0

    /**
     * Compute the area of the shape.
     * @return The area.
     */
    // This method is abstract: is has only a declaration and no implementation (body).
    // The implementation must be provided by each subclass, they will have to @Override this method.
    public abstract double getArea();

}
