package polygons.domain.generator;

import javafx.event.ActionEvent;
import polygons.domain.shapes.Shapes;
import polygons.domain.shapes.AvailableShapes;

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
    public AvailableShapes generateShape(ActionEvent actionEvent) {
        String name = ShapeTypeExtracter.extract(actionEvent);
        AvailableShapes polygon = Shapes.valueOf(name).createOne();
        return polygon;
    }

}
