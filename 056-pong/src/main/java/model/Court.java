package model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * @Author
 * Karol Meksuła
 * 05-07-2018
 * */

public class Court {
    private Rectangle court;

    public Court() {
        this.court = new Rectangle(800,400);
        court.setFill(Paint.valueOf("transparent"));
        court.setStroke(Paint.valueOf("white"));
        court.setLayoutX(30);
        court.setLayoutY(30);
    }

    public Rectangle getCourt() {
        return court;
    }

}
