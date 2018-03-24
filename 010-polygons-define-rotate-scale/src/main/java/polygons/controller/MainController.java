package polygons.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import polygons.domain.generator.PolygonGenerator;
import polygons.domain.mutator.PolygonMutator;
import polygons.domain.generator.ShapeGenerator;
import polygons.domain.shapes.AvailableShapes;

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
    private PolygonMutator shapeMutable = PolygonMutator.getInstance();

    public void initialize() {
        rotateSlide.setOnDragDetected(event -> {
            shapeMutable.rotate(rotateSlide.getValue());
        });
    }

    @FXML
    public void chooseShapeType(ActionEvent actionEvent) {
        AvailableShapes availableShapes = polygonGenerator.generateShape(actionEvent);
        Shape shape = availableShapes.createPolygon();
        draw(shape);
        shapeMutable.setAvailableShapes(availableShapes);
    }

    @FXML
    public void mutate(ActionEvent actionEvent) {
        Shape shape = shapeMutable.scale(dataFromSliders());
        draw(shape);
    }

    private void draw(Shape shape) {
        clear();
        drawingArea.getChildren().add(shape);
        shapeMutable.setShape(shape);
    }

    private void clear() {
        drawingArea.getChildren().clear();
    }

    private double dataFromSliders() {
        return Math.round(scaleSlide.getValue());
    }

}