package sample;

import javafx.geometry.Point2D;

import java.util.Random;

public class PointsCreator {
    private int pointsAmount;
    private Random random = new Random();

    private final static int PANE_WIDTH = 414;
    private final static int PANE_HEIGHT = 341;

    //private

    public PointsCreator(){
        pointsAmount = random.nextInt(20);
        pointsAmount =+ 20;
    }

    public Point2D[] fillTabPoints(){
        Point2D[] points = new Point2D[pointsAmount];
        for (int i = 0; i < points.length; i++){
            double x = (double) random.nextInt(PANE_WIDTH);
            double y = (double) random.nextInt(PANE_HEIGHT);

            points[i] = new Point2D(x, y);
        }
        return points;
    }

}
