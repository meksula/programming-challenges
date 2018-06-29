package com.meksula.snake.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @Author
 * Karol Meksuła
 * 29-06-2018
 * */

public class Block {
    private Rectangle rectangle;

    public Block(double x, double y) {
        this.rectangle = new Rectangle();
        rectangle.setHeight(15);
        rectangle.setWidth(15);
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setFill(Color.BLACK);
        rectangle.setStroke(Color.WHITE);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public boolean equals(Object obj) {
        Block foreignBlock = (Block) obj;
        Rectangle foreign = foreignBlock.getRectangle();

        return foreign.getX() == this.rectangle.getX()
                && foreign.getY() == this.rectangle.getY();
    }
}
