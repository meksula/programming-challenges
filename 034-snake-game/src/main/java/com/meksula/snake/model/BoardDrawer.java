package com.meksula.snake.model;

import javafx.stage.Stage;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 29-06-2018
 * */

public interface BoardDrawer {
    void drawMainBoard(Stage stage);

    Snake getSnake();

    List<Block> getBlocks();

    Block getFood();

}
