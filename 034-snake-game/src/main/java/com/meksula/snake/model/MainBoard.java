package com.meksula.snake.model;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 29-06-2018
 * */

public class MainBoard implements BoardDrawer {
    private final int COLUMN = 40;
    private List<Block> rectangleList;
    private Snake snake;
    private FoodThrower foodThrower;
    private Block food;

    public MainBoard() {
        this.rectangleList = new ArrayList<>();
        this.foodThrower = new DefaultFoodThrower();
    }

    @Override
    public Snake getSnake() {
        return snake;
    }

    @Override
    public List<Block> getBlocks() {
        return rectangleList;
    }

    @Override
    public Block getFood() {
        this.food = foodThrower.giveFood(rectangleList);
        return food;
    }

    @Override
    public void drawMainBoard(Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, Paint.valueOf("black"));

        List<Rectangle> rectangleList = new ArrayList<>();

        for (Block block : drawBlocks()) {
            rectangleList.add(block.getRectangle());
        }

        pane.getChildren().addAll(rectangleList);
        initSnake();
        stage.setScene(scene);
    }

    private List<Block> drawBlocks() {
        int y = 0;

        for (int i = 0; i < 18; i++) {
            drawRow(y);
            y += 15;
        }

        return rectangleList;
    }

    private void drawRow(int y) {
        int x = 0;

        for (int i = 0; i < COLUMN; i++) {
            Block block = new Block(x, y);
            rectangleList.add(block);

            x += 15;
        }

    }

    private void initSnake() {
        this.snake = new Snake(rectangleList);
    }

}
