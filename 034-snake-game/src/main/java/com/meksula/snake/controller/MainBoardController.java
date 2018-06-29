package com.meksula.snake.controller;

import com.meksula.snake.model.Block;
import com.meksula.snake.model.BoardDrawer;
import com.meksula.snake.model.MainBoard;
import com.meksula.snake.model.Snake;
import com.sun.javafx.scene.traversal.Direction;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author
 * Karol Meksuła
 * 29-06-2018
 * */

public class MainBoardController {
    private int snakeSpeed = 500;
    private Stage primaryStage;
    private BoardDrawer boardDrawer;
    private Snake snake;
    private Direction direction = Direction.RIGHT;
    private Block food;

    public MainBoardController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.boardDrawer = new MainBoard();

        boardDrawer.drawMainBoard(primaryStage);
        this.snake = boardDrawer.getSnake();
        this.food = boardDrawer.getFood();
        addActions();
    }

    private void addActions() {
        snakeMoves();
        snakeConstantMovement();
    }

    private void snakeMoves() {
        primaryStage.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                this.direction = Direction.UP;
            }
            if (event.getCode() == KeyCode.DOWN) {
                this.direction = Direction.DOWN;
            }
            if (event.getCode() == KeyCode.LEFT) {
                this.direction = Direction.LEFT;
            }
            if (event.getCode() == KeyCode.RIGHT) {
                this.direction = Direction.RIGHT;
            }
        });
    }

    private Timer timer;

    private void snakeConstantMovement() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                snakeMove(direction);
            }
        };

        timer = new Timer();

        timer.schedule(timerTask, this.snakeSpeed, this.snakeSpeed);
    }

    private List<Block> allBlocks;
    private List<Block> snakeBlocks;

    private void snakeMove(Direction direction) {
        allBlocks = boardDrawer.getBlocks();
        snakeBlocks = snake.getSnakeBlocks();
        int length = snakeBlocks.size() - 1;

        Block lastBlock = snakeBlocks.get(0);
        Block head = snakeBlocks.get(length);
        int headIndex = allBlocks.indexOf(head);

        if (head.equals(food)) {
            enlargeSnake();
        }

        if (direction == Direction.LEFT) {
            goLeft(headIndex, lastBlock);
        }
        else if (direction == Direction.RIGHT) {
            goRight(headIndex, lastBlock);
        }
        else if (direction == Direction.DOWN) {
            goDown(headIndex, lastBlock);
        }
        else if (direction == Direction.UP) {
            goUp(headIndex, lastBlock);
        }

        snake.setSnakeBlocks(snakeBlocks);
        snake.refresh();
    }

    private void goDown(int headIndex, Block lastBlock) {
        snakeBlocks.remove(lastBlock);
        lastBlock.getRectangle().setFill(Paint.valueOf("black"));

        try {
            snakeBlocks.add(allBlocks.get(headIndex + 40));
        } catch (IndexOutOfBoundsException e) {
            snakeBlocks.add(allBlocks.get(headIndex - 680));
        }

    }

    private void goUp(int headIndex, Block lastBlock) {
        snakeBlocks.remove(lastBlock);
        lastBlock.getRectangle().setFill(Paint.valueOf("black"));

        try {
            snakeBlocks.add(allBlocks.get(headIndex - 40));
        } catch (IndexOutOfBoundsException e) {
            snakeBlocks.add(allBlocks.get(headIndex + 680));
        }

    }

    private void goRight(int headIndex, Block lastBlock) {
        snakeBlocks.remove(lastBlock);
        lastBlock.getRectangle().setFill(Paint.valueOf("black"));

        try {
            snakeBlocks.add(allBlocks.get(headIndex + 1));
        } catch (IndexOutOfBoundsException e) {
            snakeBlocks.add(allBlocks.get(1));
        }

    }

    private void goLeft(int headIndex, Block lastBlock) {
        snakeBlocks.remove(lastBlock);
        lastBlock.getRectangle().setFill(Paint.valueOf("black"));

        try {
            snakeBlocks.add(allBlocks.get(headIndex - 1));
        } catch (IndexOutOfBoundsException e) {
            snakeBlocks.add(allBlocks.get(1));
        }

    }

    public void stopGame() {
        timer.cancel();
    }

    private void enlargeSnake() {
        Block bottomSnake = snakeBlocks.get(snakeBlocks.size() - 1);
        int index = allBlocks.indexOf(bottomSnake);

        Block append = allBlocks.get(index - 1);

        this.snake.enlarge(append);
        this.food = boardDrawer.getFood();
        restartMovement();
    }

    private void restartMovement() {
        if (snakeSpeed > 101) {
            this.snakeSpeed -= 100;
            timer.cancel();
            snakeConstantMovement();
        }

    }

}
