package controller;

import com.sun.javafx.scene.traversal.Direction;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Ball;
import model.Court;
import model.Mover;
import model.MoverDefault;

import java.util.Timer;
import java.util.TimerTask;

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
    //private boolean gameOn;
    private final double BOARD_HEIGHT = 500;
    private final double BOARD_WIDTH = 1000;
    private Mover mover;

    public BoardController(Stage stage) {
        this.stage = stage;
    }

    public void initialize() {
        this.mover = new MoverDefault();
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

        pane.getChildren().add(ball.getBall());
        pane.getChildren().add(court.getCourt());

        mover.moveBallAtCourt(court, ball);
    }

}
