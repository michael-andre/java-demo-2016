// Any java class file begins with a package declaration.
// The actual location of the Main.java file must match the package declaration.
package fr.ecp.sio.demo;

// All classes referenced in the file that doesn't belong to the same package (strictly) require an import.
// Imported classes can then be referred with their short name.
import com.sun.org.apache.regexp.internal.RE;
import fr.ecp.sio.demo.model.*;

import java.util.ArrayList;
import java.util.List;

// Everything is object in Java, so the entry point of this console application must be in a class.
// There is always one class per file, and the filename must match the name of the class.
public class Main {

    // The main() method is the entry point of our application.
    // It receives an array of strings as a parameters with optional arguments specified on execution.
    public static void main(String[] args) {

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
            ((Rectangle) s).setWidth(2);
        }

        // Arrays must be instantiated with a fixed size.
        double[] array = new double[3];
        array = new double[] { 1.2, 3.8 };
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

    }
}
