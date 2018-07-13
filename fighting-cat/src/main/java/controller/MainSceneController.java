package controller;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Actions;
import model.conc.BasicActions;
import model.subject.Surface2d;

/**
 * @Author
 * Karol Meksuła
 * 13-07-2018
 * */

public class MainSceneController {
    private Stage stage;
    private Scene scene;
    private Pane pane;
    private Actions actions;
    private ImageView character;
    private Surface2d surface2d;

    public MainSceneController(Stage stage) {
        this.stage = stage;
        actions = new BasicActions();
        character = new ImageView();
        surface2d = new Surface2d();
    }

    public void initialize() {
        pane = new Pane();
        pane.setMinSize(700, 400);
        scene = new Scene(pane);
        scene.getStylesheets().add("styles.css");
        pane.getStyleClass().add("background");
        pane.getChildren().add(surface2d.getLine());

        character.setLayoutX(100);
        character.setLayoutY(200);
        character.setImage(new Image("/cat_ani/cat_idle.gif"));
        character.toBack();

        actions.addCharacterActions(scene, character);

        pane.getChildren().add(character);
        stage.setScene(scene);
        stage.show();
    }

}
