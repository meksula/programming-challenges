package polygons.domain.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class Rectangle extends Polygon implements AvailableShape {
    private Polygon polygon;

    public Rectangle() {
        polygon = new Polygon(100, 100, 300, 100, 300, 200, 100, 200, 100, 100);
        style(polygon);
    }

    @Override
    public Polygon getPolygon() {
        return polygon;
    }

    private void style(Shape shape) {
        shape.setFill(Color.WHITE);
        shape.setStroke(Color.BLACK);
    }
}
