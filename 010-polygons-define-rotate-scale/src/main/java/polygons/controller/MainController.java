package polygons.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import polygons.domain.generator.PolygonGenerator;
import polygons.domain.mutator.PolygonMutator;
import polygons.domain.generator.ShapeGenerator;
import polygons.domain.mutator.ShapeMutable;
import polygons.domain.shapes.Shapes;

import java.text.NumberFormat;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class MainController {

    @FXML
    private Button executeButton;

    @FXML
    private MenuItem equiventalTriangle, square, rectangle;

    @FXML
    private Slider rotateSlide, scaleSlide;

    @FXML
    private Pane drawingArea;

    private ShapeGenerator polygonGenerator = PolygonGenerator.getInstance();
    private ShapeMutable shapeMutable = PolygonMutator.getInstance();

    @FXML
    public void chooseShapeType(ActionEvent actionEvent) {
        clear();
        Shape shape = polygonGenerator.generateShape(actionEvent);
        draw(shape);
        shapeMutable.setShape(shape);
    }

    private void draw(Shape shape) {
        drawingArea.getChildren().add(shape);
    }

    private void clear() {
        drawingArea.getChildren().clear();
    }

    public void mutate(ActionEvent actionEvent) {
        double rotate = Math.round(rotateSlide.getValue());
        double scale = Math.round(scaleSlide.getValue());
    }
}