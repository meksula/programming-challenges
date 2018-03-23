package polygons.domain.mutator;

import javafx.scene.shape.Shape;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public interface ShapeMutable {
    void setShape(Shape shape);

    List<Double> rotateLeft();

    void rotateRight();

    void scaleMinus();

    void scalePlus();
}
