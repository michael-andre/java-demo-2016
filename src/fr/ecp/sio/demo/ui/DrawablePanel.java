package fr.ecp.sio.demo.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michaël on 05/10/2016.
 */
public class DrawablePanel extends JPanel {

    private List<Drawable> mDrawables;

    public DrawablePanel(List<Drawable> drawables) {
        mDrawables = drawables;
    }

    public void addDrawable(Drawable drawable) {
        if (mDrawables == null) {
            mDrawables = new ArrayList<>();
        }
        mDrawables.add(drawable);
    }

    public void setDrawables(List<Drawable> drawables) {
        mDrawables = drawables;
    }

    public List<Drawable> getDrawables() {
        return mDrawables;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Drawable d : mDrawables) {
            d.draw(g);
        }
    }

    /**
     * An interface to be implemented by all objects that can be drawn by our program.
     */
    public interface Drawable {
        // No need to add a visibility modifier on a method in an interface: only public makes sense.
        void draw(Graphics g);
    }

}
