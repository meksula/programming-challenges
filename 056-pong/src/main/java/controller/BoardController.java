package controller;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.*;

/**
 * @Author
 * Karol Meksuła
 * 05-07-2018
 * */

public class BoardController {
    private Stage stage;
    private Scene scene;
    private Pane pane;
    private Ball ball;
    private Court court;
    private Rocket rocket;
    private final double BOARD_HEIGHT = 500;
    private final double BOARD_WIDTH = 1000;
    private Mover mover;

    public BoardController(Stage stage) {
        this.stage = stage;
    }

    public void initialize() {
        this.mover = new MoverDefault(pane);
        this.pane = new Pane();
        pane.setMinHeight(BOARD_HEIGHT);
        pane.setMinWidth(BOARD_WIDTH);

        this.scene = new Scene(pane);
        this.stage.setScene(scene);

        stage.show();
        startGame();
    }

    private void startGame() {
        pane.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));

        this.court = new Court();
        this.ball = new Ball(court.getCourt().getLayoutX(), court.getCourt().getLayoutY());
        this.rocket = new Rocket(court.getCourt().getLayoutX(), court.getCourt().getLayoutY());
        rocketMoveable();

        pane.getChildren().add(ball.getBall());
        pane.getChildren().add(court.getCourt());
        pane.getChildren().add(rocket.getRocket());

        mover.moveBallAtCourt(court, rocket, ball);
    }

    private double lastMouseMove = 0;

    private void rocketMoveable() {
        pane.setOnMouseMoved(move -> {
            lastMouseMove = move.getY();

            if (lastMouseMove > 30 && lastMouseMove < 360) {
                rocket.getRocket().setLayoutY(lastMouseMove);
            }

        });
    }

}
