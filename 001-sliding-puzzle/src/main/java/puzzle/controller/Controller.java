package puzzle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import puzzle.core.PuzzleGenerator;

import javax.security.auth.callback.Callback;

/*
 * @Author Karol Meksuła
 * 24-02-2018
 **/

public class Controller {
    @FXML
    private Pane canvasPattern;
    @FXML
    private Button reset;
    @FXML
    private Pane canvas;

    private PuzzleGenerator generator = PuzzleGenerator.getInstance();

    public void initialize() {
        generator.preparePieces().forEach(puzzle -> {
            canvas.getChildren().add(puzzle.getPiece());
        });
        generator.preparePattern().forEach(puzzle -> {
            canvasPattern.getChildren().add(puzzle.getPiece());
        });
    }

    @FXML
    public void reset(ActionEvent actionEvent) {
        generator.shuffle();
    }

}
