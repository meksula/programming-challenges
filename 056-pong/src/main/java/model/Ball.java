package model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * @Author
 * Karol Meksuła
 * 05-07-2018
 * */

public class Ball {
    private Circle ball;

    public Ball(double x, double y) {
        this.ball = new Circle();
        ball.setRadius(5);
        ball.setFill(Paint.valueOf("white"));
        ball.setCenterX(x);
        ball.setCenterY(y);
    }

    public Circle getBall() {
        return this.ball;
    }

    public double layoutX() {
        return this.ball.getCenterX();
    }

    public double layoutY() {
        return this.ball.getCenterY();
    }

}
