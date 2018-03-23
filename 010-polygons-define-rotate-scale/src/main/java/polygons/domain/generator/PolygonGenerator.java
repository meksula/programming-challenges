package polygons.domain.generator;

import javafx.event.ActionEvent;
import javafx.scene.shape.Shape;
import polygons.domain.shapes.AvailableShape;
import polygons.domain.shapes.Shapes;
import polygons.domain.shapes.polymorphism.AvailableShapes;
import polygons.domain.shapes.polymorphism.Octagon;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class PolygonGenerator implements ShapeGenerator {
    private static PolygonGenerator ourInstance = new PolygonGenerator();

    public static PolygonGenerator getInstance() {
        return ourInstance;
    }

    private PolygonGenerator() {
    }

    @Override
    public Shape generateShape(ActionEvent actionEvent) {
        /*String name = ShapeTypeExtracter.extract(actionEvent);
        AvailableShape polygon = (AvailableShape) Shapes.valueOf(name).create();
        return polygon.getPolygon();*/

        Octagon shape = new Octagon();
        return shape.createPolygon();
    }

}
