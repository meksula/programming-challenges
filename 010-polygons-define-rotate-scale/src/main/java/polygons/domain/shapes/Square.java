package polygons.domain.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class Square extends Polygon implements AvailableShape {
    private Polygon polygon;

    public Square() {
        polygon = new Polygon(100, 100, 100, 200, 200, 200, 200, 100, 100, 100);
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
