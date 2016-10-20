package fr.ecp.sio.demo.gson;

import com.google.gson.*;
import fr.ecp.sio.demo.model.Point;

import java.lang.reflect.Type;

/**
 * Created by Michaël on 20/10/2016.
 */
public class PointDeserializer implements JsonDeserializer<Point> {

    @Override
    public Point deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement instanceof JsonArray) {
            return new Point(
                    ((JsonArray) jsonElement).get(0).getAsInt(),
                    ((JsonArray) jsonElement).get(1).getAsInt()
            );
        } else if (jsonElement instanceof JsonObject) {
            //return jsonDeserializationContext.deserialize(jsonElement, Point.class);
            return new Point(
                ((JsonObject) jsonElement).get("x").getAsInt(),
                ((JsonObject) jsonElement).get("y").getAsInt()
            );
        } else {
            throw new JsonParseException("Invalid point");
        }
    }

}
