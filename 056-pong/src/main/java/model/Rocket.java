package model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * @Author
 * Karol Meksuła
 * 06-07-2018
 * */

public class Rocket {
    private Rectangle rectangle;

    public Rocket(double x, double y) {
        this.rectangle = new Rectangle();
        rectangle.setFill(Paint.valueOf("white"));
        rectangle.setHeight(70);
        rectangle.setWidth(10);
        rectangle.setLayoutX(x);
        rectangle.setLayoutY(y);
    }

    public Rectangle getRocket() {
        return rectangle;
    }

}
