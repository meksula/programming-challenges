package puzzle.core;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/*
 * @Author Karol Meksuła
 * 24-02-2018
 **/

public class Puzzle {
    private Rectangle piece;
    private static final double WIDTH = 100;
    private static final double HEIGHT = 100;

    public Puzzle(double x, double y, Paint paint) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException();

        piece = new Rectangle(x, y, WIDTH, HEIGHT);
        piece.setFill(paint);
    }

    public Puzzle(double x, double y, double customWidth, double customHeight, Paint paint) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException();

        piece = new Rectangle(x, y, customWidth, customHeight);
        piece.setFill(paint);
    }

    public Rectangle getPiece() {
        return piece;
    }

    public static double getHEIGHT() {
        return HEIGHT;
    }

    public static double getWIDTH() {
        return WIDTH;
    }

    public void changeColor(Paint paint) {
        piece.setFill(paint);
    }

    public String puzzleInfo() {
        return piece.fillProperty().toString();
    }
}
