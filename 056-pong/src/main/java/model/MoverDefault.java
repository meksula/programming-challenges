package model;

import javafx.scene.shape.Circle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author
 * Karol Meksuła
 * 05-07-2018
 * */

public class MoverDefault implements Mover {
    private Court court;
    private Circle ball;
    private int dir = 0;
    private double x;
    private double y;

    @Override
    public void moveBallAtCourt(Court court, Ball ball) {
        this.court = court;
        this.ball = ball.getBall();

        x = court.getCourt().getLayoutX();
        y = court.getCourt().getScaleY();

        startThrow();
    }

    private void startThrow() {
        moveExecutor();
    }

    private void moveExecutor() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (dir == 0) {
                    ball.setCenterY(ball.getCenterY() + 1);
                    ball.setCenterX(ball.getCenterX() + 1);
                }

                if (dir == 1) {
                    ball.setCenterY(ball.getCenterY() - 1);
                    ball.setCenterX(ball.getCenterX() - 1);
                }

                System.out.println(ball.getCenterY() + " | " + ball.getCenterX());
                assignBounds();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 25, 25);
    }

    private void assignBounds() {
        if (ball.getCenterY() == 430) {
            dir = 1;
        }

        if (ball.getCenterY() == 30 || ball.getCenterX() == 30) {
            dir = 0;
        }
    }

    private void boundBall() {

    }

}
