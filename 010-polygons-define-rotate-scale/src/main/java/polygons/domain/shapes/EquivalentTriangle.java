package polygons.domain.shapes;


import javafx.scene.shape.Polygon;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class EquivalentTriangle extends AvailableShapes {
    private Polygon polygon;
    private final double[] DEFAULT_POINTS = {200,200, 100,300, 300,300, 200,200};

    @Override
    public Polygon createPolygon() {
        polygon = new Polygon(DEFAULT_POINTS);
        style(polygon);
        return polygon;
    }

    @Override
    public Polygon scale(double scaleFactor) {
        double [] arguments = providePoints();

        arguments[0] =+ scaleFactor;
        arguments[1] =+ scaleFactor;
        arguments[6] =+ scaleFactor;
        arguments[7] =+ scaleFactor;

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
