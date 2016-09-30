package fr.ecp.sio.demo.model;

/**
 * A base class for all shapes.
 */
// This class has to be declared abstract because it has at least one abstract method.
// As a consequence, this class cannot be instantiated (new Shape()), it can only be subclassed.
public abstract class Shape implements Drawable {

    // Here we declare properties common to all shapes.
    // Properties are strongly typed (declared with a type) and can optionally be given a default value.
    // Properties could be public to be accessible/visible from outside of the package (in Main.main() for instance)...
    // ...but we choose to encapsulate them as private fields with public getters and setters.
    // The array must be instantiated with a value to avoid a NullPointerException on access.
    // The value itself will not change (but the content of the array will), we mark it 'final'.
    private final int[] origin = new int[2];

    // Getter hides the implementation from the outside.
    public int getX() {
        return origin[0];
    }

    public int getY() {
        return origin[1];
    }

    // Setter hides the implementation from the outside.
    public void setX(int x) {
        origin[0] = x;
    }

    public void setY(int y) {
        origin[1] = y;
    }

    /**
     * Compute the area of the shape.
     * @return The area.
     */
    // This method is abstract: is has only a declaration and no implementation (body).
    // The implementation must be provided by each subclass, they will have to @Override this method.
    public abstract double getArea();

}
