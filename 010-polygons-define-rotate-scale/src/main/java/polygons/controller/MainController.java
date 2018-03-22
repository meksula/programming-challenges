package polygons.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class MainController {

    @FXML
    private TextField pointsAmount;

    @FXML
    private TextField sideLength;

    @FXML
    private Button scalePlusButton;

    @FXML
    private Button scaleMinusButton;

    @FXML
    private Button rotatePlusButton;

    @FXML
    private Button rotateMinusButton;

    @FXML
    private Button generateButton;

    @FXML
    private Pane drawingArea;

    @FXML
    void generateNewPolygon(ActionEvent event) {

    }

    @FXML
    void rotateMinus(ActionEvent event) {

    }

    @FXML
    void rotatePlus(ActionEvent event) {

    }

    @FXML
    void scaleMinus(ActionEvent event) {

    }

    @FXML
    void scalePlus(ActionEvent event) {

    }

}