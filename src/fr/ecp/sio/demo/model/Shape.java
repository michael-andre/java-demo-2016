package fr.ecp.sio.demo.model;

import fr.ecp.sio.demo.ui.DrawablePanel;

/**
 * A base class for all shapes.
 */
// This class has to be declared abstract because it has at least one abstract method.
// As a consequence, this class cannot be instantiated (new Shape()), it can only be subclassed.
// This class also implements Drawable but does not provide an implementation for onDraw(): subclasses will have to do it.
public abstract class Shape implements DrawablePanel.Drawable {

    // Here we declare properties common to all shapes.
    // Properties are strongly typed (declared with a type) and can optionally be given a default value.
    // Properties could be public to be accessible/visible from outside of the package (in Main.main() for instance)...
    // ...but we choose to encapsulate them as private fields with public getters and setters.
    private Point origin;

    // Since we have at least one constructor explicitly defined in Shape, the default implicit public no-arg one is not available.
    // We have to redeclare it here to make it possible for subclasses to instantiate a Shape in their own no-arg constructor.
    public Shape() { }

    // A constructor for Shape that will initialize the origin field with the provided value.
    public Shape(Point origin) {
        // We disambiguation is needed (parameter and field have the same name), 'this' can be used to refer to the current instance.
        this.origin = origin;
    }

    // A getter hides the implementation & storage from the outside (encapsulation).
    public Point getOrigin() {
        return origin;
    }

    // A setter hides the implementation & storage from the outside (encapsulation).
    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    /**
     * Compute the area of the shape.
     * @return The area.
     */
    // This method is abstract: is has only a declaration and no implementation (body).
    // The implementation must be provided by each subclass, they will have to @Override this method.
    public abstract double getArea();

    // This class already have a toString() method, inherited for the implicit parent class Object.
    // But we can redeclare it here to customize the output and make it more meaningful.
    @Override
    public String toString() {
        return "origin=" + origin;
    }

}
