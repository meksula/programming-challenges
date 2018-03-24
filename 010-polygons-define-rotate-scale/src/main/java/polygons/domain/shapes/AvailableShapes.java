package polygons.domain.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public abstract class AvailableShapes extends Polygon {

    public abstract Polygon createPolygon();

    protected void style(Shape shape) {
        shape.setFill(Color.WHITE);
        shape.setStroke(Color.BLACK);
    }

    public abstract Shape scale(double factor);

}
