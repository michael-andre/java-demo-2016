// Any java class file begins with a package declaration.
// The actual location of the Main.java file must match the package declaration.
package fr.ecp.sio.demo;

// All classes referenced in the file that doesn't belong to the same package (strictly) require an import.
// Imported classes can then be referred with their short name.

import com.google.gson.*;
import fr.ecp.sio.demo.gson.PointDeserializer;
import fr.ecp.sio.demo.gson.ShapeDeserializer;
import fr.ecp.sio.demo.model.*;
import fr.ecp.sio.demo.model.Point;
import fr.ecp.sio.demo.model.Polygon;
import fr.ecp.sio.demo.model.Rectangle;
import fr.ecp.sio.demo.model.Shape;
import fr.ecp.sio.demo.ui.DrawablePanel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Everything is object in Java, so the entry point of this console application must be in a class.
// There is always one class per file, and the filename must match the name of the class.
public class Main {

    // The main() method is the entry point of our application.
    // It receives an array of strings as a parameters with optional arguments specified on execution.
    public static void main(String... args) {

        List<DrawablePanel.Drawable> drawables;

        try {
            // This method may throw IOException (see signature), which is a checked Exception.
            // We must deal with the error case by wrapping the call in a tr-catch statement.
            String json = getUrlContent("http://pastebin.com/raw/DX76AJbk");
            //String json = getUrlContent("http://pastebin.com/raw/gFpQEYUM");
            System.out.println(json);

            //drawables = parseDrawablesBasic(json);
            drawables = parseDrawables(json);

        } catch (IOException | InvalidGeometryException e) {
            // We get here if an IOException or a InvalidGeometryException is thrown by the above code.
            // Here we simply log the error and terminate the program.
            e.printStackTrace();
            return;
        }

        // Let's instantiate our custom panel to display drawables.
        DrawablePanel panel = new DrawablePanel(drawables);
        panel.setBackground(Color.WHITE);

        // UI classes are provided in the javax.swing.* package.
        // We create a window, give it a size, add the panel (the default is fullscreen) and display it.
        JFrame window = new JFrame("Photoshop");
        window.setSize(640, 480);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(panel);
        window.setVisible(true);

    }

    /***
     * Download the content of a URL and return it as a string.
     * This version only makes use of builtin stream-manipulation classes.
     * @throws IOException if anything goes wrong with the download process.
     ***/
    public static String getUrlContent(String spec) throws IOException {

        // This constructor may throw MalformedUrlException if the "spec" parameter is not a valid URL.
        // We don't catch the error here, instead it propagates to the calling method since our signature declares it.
        URL url = new URL(spec);
        // 1. Open a connection to the URL.
        // 2. Get an InputStream from which we can read incoming data (low level function, byte per byte).
        // 3. Create an InputStreamReader that is able to consume the InputStream data an process it.
        // 4. Wrap it into a BufferedReader that adds the ability to read the content line by line thanks to a buffer.
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        url.openConnection().getInputStream()
                )
        );
        // It is more efficient to use a StringBuilder rather than String concatenation (+) in a loop.
        StringBuilder builder = new StringBuilder();

        // At this point, no data has been transferred yet.

        // Declare a variable that will hold the content of a line.
        String line;
        // In the same statement, get the next line from the builder, assign it to "line" and check if it is not null.
        // The readLine() call is the one that actually makes the data transfer to happen.
        // This "while" loop will break when the readLine() method will return null (content is all read).
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        // The transfer is done, always close() the readers, streams, etc. that we have used.
        reader.close();
        // Finally, return the content of the StringBuilder.
        return builder.toString();
    }

    public static List<DrawablePanel.Drawable> parseDrawablesBasic(String json) throws InvalidGeometryException {

        List<DrawablePanel.Drawable> drawables = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(json);
        if (!(root instanceof JsonArray)) {
            throw new InvalidGeometryException("Invalid root");
        }
        JsonArray list = (JsonArray) root;
        for (JsonElement e : list) {
            if (!(e instanceof JsonObject)) {
                throw new InvalidGeometryException("Invalid item");
            }
            JsonObject def = (JsonObject) e;
            String type = def.get("type").getAsString();
                /*if ("Rectangle".equalsIgnoreCase(type)) {
                    Rectangle rectangle = new Rectangle();
                } else if ("Circle".equalsIgnoreCase(type)) {

                } else if ("Polygon".equalsIgnoreCase(type)) {

                } else {
                    // Silently ignore unknown shape.
                }*/
                /*switch (type.toLowerCase()) {
                    case "rectangle":
                        drawables.add(new Rectangle(def));
                        break;
                    case "circle":
                        drawables.add(new Circle(def));
                        break;
                    case "polygon":
                        drawables.add(new Polygon(def));
                        break;
                    default:
                        // Silently ignore unknown shape.
                }*/

            try {
                Class<? extends DrawablePanel.Drawable> drawableClass = (Class<? extends DrawablePanel.Drawable>) Class.forName("fr.ecp.sio.demo.model." + type);
                DrawablePanel.Drawable drawable = drawableClass
                        .getConstructor(JsonObject.class)
                        .newInstance(def);
                drawables.add(drawable);
            } catch (ReflectiveOperationException exception) {
                throw new InvalidGeometryException("Unable to instantiate element", exception);
            }
        }

        return drawables;

    }

    public static List<DrawablePanel.Drawable> parseDrawables(String json) throws InvalidGeometryException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Shape.class, new ShapeDeserializer())
                .registerTypeAdapter(Point.class, new PointDeserializer())
                .create();
        Shape[] shape = gson.fromJson(json, Shape[].class);
        return Arrays.asList(shape);
    }

    public static void demos() {
        // Primitive types
        int a = 0;
        long b = 1;
        float c = 2.0f;
        double d = 3.0;
        short e = 4;
        boolean f = true;

        // Implicit casting if no precision loss
        c = a + b;
        // Explicit casting if precision loss
        c = (float) ((a + b) / d);

        // String = transparent type
        String test = " toto";
        // Concatenation
        test = test.trim() + " " + b;

        if (b > 0) {
            System.out.println(test);
        } else {
            System.out.println("This will not be printed");
        }

        // Standard for loop (initialization; break condition; iteration statement)
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // Create as instance of the class Rectangle an assign some properties.
        Rectangle r = new Rectangle();
        r.setWidth(200);
        r.setHeight(100);
        r.setOrigin(new Point(20, 50));
        r = new Rectangle(new Point(40, 60), 200, 300);

        // Thanks to polymorphism, an instance of Rectangle can be the value of a variable declared as Shape.
        // But only properties & methods declared in Shape are available on s, even if the actual value is a Rectangle.
        Shape s = r;
        // x and y are available because they are declared is Shape, but width and height are not.
        System.out.println("Shape: " + s);
        // getArea() is available because it is declared in Shape (abstractly), even is the concrete implementation is in Rectangle.
        System.out.println("Area: " + s.getArea());

        // It is possible to check a variable for a more precise subclass.
        if (s instanceof Rectangle) {
            // Since we checked, we can safely "cast" the variable to a Rectangle an access the specific properties.
            // But this style of coding can lead to runtime errors (vs compile-time errors), so use with caution!
            ((Rectangle) s).setWidth(200);
        }

        // Arrays must be instantiated with a fixed size.
        double[] array = new double[3];
        array = new double[]{1.2, 3.8};
        array[1] = 2;
        System.out.println("Array size is " + array.length);

        // The List interface exposes a generic type parameter.
        // The type parameter defines the signature of methods such as add().
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("toto");
        list.add("true");
        list.remove(1);
        System.out.println("List size is " + list.size());
        list.get(1);

        List<DrawablePanel.Drawable> drawables = new ArrayList<>();
        drawables.add(r);
        drawables.add(new Circle(new Point(300, 150), 70));
        Polygon polygon = new Polygon();
        polygon.setOrigin(new Point(60, 70));
        polygon.addPoint(new Point(200, 100));
        polygon.addPoint(new Point(100, 200));
        polygon.addPoint(new Point(-50, 150));
        drawables.add(polygon);

    }

}
