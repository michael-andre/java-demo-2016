package fr.ecp.sio.demo.model;

/**
 * An interface to be implemented by all objects that can be drawn by our program.
 */
public interface Drawable {

    // No need to add a visibility modifier on a method in an interface: only public makes sense.
    void draw();

}
