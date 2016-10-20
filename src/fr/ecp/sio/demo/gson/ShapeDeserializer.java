package fr.ecp.sio.demo.gson;

import com.google.gson.*;
import fr.ecp.sio.demo.InvalidGeometryException;
import fr.ecp.sio.demo.model.Point;
import fr.ecp.sio.demo.model.Shape;
import fr.ecp.sio.demo.ui.DrawablePanel;

import java.lang.reflect.Type;

/**
 * Created by Michaël on 20/10/2016.
 */
public class ShapeDeserializer implements JsonDeserializer<Shape> {

    @Override
    public Shape deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        if (!(jsonElement instanceof JsonObject)) {
            throw new JsonParseException("Invalid item");
        }

        JsonObject def = (JsonObject) jsonElement;
        String shapeType = def.get("type").getAsString();
        Shape shape;
        try {
            Class<? extends Shape> shapeConcreteClass = (Class<? extends Shape>) Class.forName("fr.ecp.sio.demo.model." + shapeType);
            shape = jsonDeserializationContext.deserialize(jsonElement, shapeConcreteClass);
        } catch (ReflectiveOperationException e) {
            throw new JsonParseException("Invalid item", e);
        }

        if (shape.getOrigin() == null) {
            shape.setOrigin(jsonDeserializationContext.deserialize(jsonElement, Point.class));
        }

        return shape;
    }

}
