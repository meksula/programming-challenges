package polygons.domain.generator;

import javafx.event.ActionEvent;
import javafx.scene.shape.Shape;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public interface ShapeGenerator {
    Shape generateShape(ActionEvent actionEvent);
}
