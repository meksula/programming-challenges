package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

import java.util.Random;

public class Controller {
    @FXML
    private Button button;
    @FXML
    private Pane canvas;

    private PointsCreator creator;
    private Paint[] paints;
    private Random random = new Random();
    Point2D[] points;

    @FXML
    public void reset(ActionEvent actionEvent) {
        canvas.getChildren().clear();
        initialize();
    }

    public void initialize() {
        paints = new Paint[6];
        paints[0] = Color.DARKGREEN;
        paints[1] = Color.LIGHTSKYBLUE;
        paints[2] = Color.BLACK;
        paints[3] = Color.ORANGE;
        paints[4] = Color.SANDYBROWN;
        paints[5] = Color.YELLOW;

        creator = new PointsCreator();
        points = creator.fillTabPoints();

        for (int i = 0; i < points.length - 1; i++) {
            Line line = new Line();
            line.setStartX(points[i].getX());
            line.setStartY(points[i].getY());
            line.setEndX(points[i + 1].getX());
            line.setEndY(points[i + 1].getY());
            line.setStroke(paints[random.nextInt(5)]);
            canvas.getChildren().add(line);
        }
    }
}
