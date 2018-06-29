package com.meksula.snake.model;

import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 29-06-2018
 * */

public class Snake {
    private List<Block> snakeBlocks;

    public Snake(List<Block> allBlocks) {
        Block[] snake = {
                allBlocks.get(402),
                allBlocks.get(403),
                allBlocks.get(404)
        };

        snakeBlocks = new ArrayList<>(Arrays.asList(snake));

        for (Block block : snake) {
            block.getRectangle().setFill(Paint.valueOf("white"));
        }
    }

    public List<Block> getSnakeBlocks() {
        return snakeBlocks;
    }

    public void setSnakeBlocks(List<Block> snakeBlocks) {
        this.snakeBlocks = snakeBlocks;
    }

    public void refresh() {
        snakeBlocks.forEach(block -> {
            block.getRectangle().setFill(Paint.valueOf("white"));
        });
    }

    public void enlarge(Block block) {
       snakeBlocks.add(block);
    }

}
