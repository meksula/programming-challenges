package polygons.domain.shapes.polymorphism;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public abstract class AvailableShapes extends Polygon {
    private Polygon polygon;
    private double[] points;

    public Polygon createPolygon(double[] points) {
        this.points = points;
        polygon = new Polygon(points);
        style(polygon);
        return polygon;
    }

    private void style(Shape shape) {
        shape.setFill(Color.WHITE);
        shape.setStroke(Color.BLACK);
    }

    public double[] getPolygonPoints() {
        return points;
    }
}
