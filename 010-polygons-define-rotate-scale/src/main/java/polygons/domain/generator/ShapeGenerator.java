package polygons.domain.generator;

import javafx.event.ActionEvent;
import polygons.domain.shapes.AvailableShapes;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public interface ShapeGenerator {
    AvailableShapes generateShape(ActionEvent actionEvent);
}
