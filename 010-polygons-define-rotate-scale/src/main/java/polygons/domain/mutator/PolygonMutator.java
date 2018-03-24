package polygons.domain.mutator;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import polygons.domain.shapes.AvailableShapes;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class PolygonMutator implements ShapeMutable {
    private static PolygonMutator ourInstance = new PolygonMutator();

    public static PolygonMutator getInstance() {
        return ourInstance;
    }

    private PolygonMutator() {}

    private Polygon shape;
    private AvailableShapes availableShapes;

    public void setAvailableShapes(AvailableShapes availableShapes) {
        this.availableShapes = availableShapes;
    }

    @Override
    public void setShape(Shape shape) {
        this.shape = (Polygon) shape;
    }

    @Override
    public Shape scale(double factor) {
        Shape shape = availableShapes.scale(factor);
        this.shape = (Polygon) shape;
        return shape;
    }

    @Override
    public void rotate(double factor) {
        shape.setRotate(factor);
    }

}
