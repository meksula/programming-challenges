package model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

/**
 * @Author
 * Karol Meksuła
 * 05-07-2018
 * */

public class MoverDefault implements Mover {
    private Court court;
    private Circle ball;
    private Rectangle rocket;
    private double x = 2;
    private double y = 2;
    private Pane pane;
    private Point2D layoutBeforeCutpoint = new Point2D(0,0);
    private boolean gameOn;

    public MoverDefault(Pane pane) {
        this.pane = pane;
    }

    @Override
    public void moveBallAtCourt(Court court, Rocket rocket, Ball ball) {
        this.court = court;
        this.ball = ball.getBall();
        this.rocket = rocket.getRocket();
        this.gameOn = true;

        startThrow();
    }

    private void startThrow() {
        moveExecutor();
    }

    private void moveExecutor() {
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);

        KeyFrame ballMove = new KeyFrame(Duration.seconds(.0050),
                actionEvent -> {
                    if (gameOn) {
                        assignBounds();
                        moveBall();
                        System.out.println(ball.getCenterY() + " | " + ball.getCenterX());
                    }
                });

        timeline.getKeyFrames().add(ballMove);
        timeline.play();
    }

    private void assignBounds() {

        if (ball.getCenterY() >= 430) {

            if (ball.getCenterX() > layoutBeforeCutpoint.getX()) {
                this.x = 2;
                this.y = -2;
            }

            else {
                this.x = - 2;
                this.y = - 2;
            }

        }

        else if (ball.getCenterY() <= 30) {

            if (ball.getCenterX() > layoutBeforeCutpoint.getX()) {
                this.x = 2;
                this.y = 2;
            }

            else {
                this.x = - 2;
                this.y = 2;
            }

        }

        else if (ball.getCenterX() >= 830) {

            if (ball.getCenterY() < layoutBeforeCutpoint.getY()) {
                this.x = - 2;
                this.y = - 2;
            }

            else {
                this.x = - 2;
                this.y = 2;
            }

        }

        else if (ball.getCenterX() < 30) {
            //gameOn = false;
        }

    }

    private void moveBall() {
        this.layoutBeforeCutpoint = new Point2D(ball.getCenterX(), ball.getCenterY());

        if (ball.getCenterX() <= 43) {
            double rocketStart = rocket.getLayoutY();
            double rocketEnd = rocket.getLayoutY() + rocket.getHeight();

            if (ball.getCenterY() > rocketStart && ball.getCenterY() < rocketEnd) {
                rocketBound();
            }

        }

        ball.setCenterX(ball.getCenterX() + x);
        ball.setCenterY(ball.getCenterY() + y);

    }

    private void rocketBound() {
        if (ball.getCenterX() > layoutBeforeCutpoint.getX()) {
            this.x = 6;
            this.y = 2;
        }

        else {
            this.x = 6;
            this.y = - 2;
        }
    }

}
