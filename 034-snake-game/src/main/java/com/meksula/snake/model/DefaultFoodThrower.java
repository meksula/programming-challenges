package com.meksula.snake.model;

import javafx.scene.paint.Paint;

import java.util.List;
import java.util.Random;

/**
 * @Author
 * Karol Meksuła
 * 29-06-2018
 * */

public class DefaultFoodThrower implements FoodThrower {

    @Override
    public Block giveFood(List<Block> rectangleList) {
        Random random = new Random();
        int blockIndex = random.nextInt(718);

        Block block = rectangleList.get(blockIndex);
        block.getRectangle().setFill(Paint.valueOf("green"));

        return block;
    }

}
