package polygons.domain.mutator;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import polygons.domain.generator.PolygonGenerator;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void setShape(Shape shape) {
        this.shape = (Polygon) shape;
    }

    @Override
    public List<Double> rotateLeft() {
        List<Double> points = shape.getPoints();
        List<Double> newPoints = new ArrayList<>();

        for (Double d : points) {
           d = d + 5;
           newPoints.add(d);
        }

        return newPoints;
    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void scaleMinus() {

    }

    @Override
    public void scalePlus() {

    }
}
