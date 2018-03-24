package polygons.domain.shapes;

import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class Rectangle extends AvailableShapes {
    private Polygon polygon;
    private final double[] DEFAULT_POINTS = {100, 100, 300, 100, 300, 200, 100, 200, 100, 100};

    @Override
    public Polygon createPolygon() {
        polygon = new Polygon(DEFAULT_POINTS);
        style(polygon);
        return polygon;
    }

    @Override
    public Polygon scale(double scaleFactor) {
        double [] arguments = providePoints();

        arguments[4] =+ scaleFactor;
        arguments[6] =+ scaleFactor;

        return new Polygon(arguments);
    }

    private double[] providePoints() {
        Object[] scaledPoints = polygon.getPoints().toArray();
        double[] arguments = new double[scaledPoints.length];

        for (int i = 0; i < scaledPoints.length; i++)
            arguments[i] = (double) scaledPoints[i];

        return arguments;
    }

}
