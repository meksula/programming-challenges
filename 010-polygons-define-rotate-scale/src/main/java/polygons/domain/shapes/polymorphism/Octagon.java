package polygons.domain.shapes.polymorphism;

import javafx.scene.shape.Polygon;

public class Octagon extends AvailableShapes {
    private double[] points = {100, 100, 100, 200, 200, 200, 200, 100, 100, 100};

    public Polygon createPolygon() {
        return super.createPolygon(points);
    }
}
