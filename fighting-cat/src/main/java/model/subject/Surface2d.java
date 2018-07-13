package model.subject;

import javafx.scene.shape.Line;

/**
 * @Author
 * Karol Meksuła
 * 12-07-2018
 * */

public class Surface2d {
    private Line line;

    public Surface2d() {
        line = new Line(0, 240, 300, 240);
        line.toFront();
    }

    public Line getLine() {
        return line;
    }
}
