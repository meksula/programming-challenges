package tictactoe.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import tictactoe.draw.Drawer;
import tictactoe.gameAction.GameAction;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

public class Controller {

    @FXML
    private Pane board;

    @FXML
    private Label moveIndicator;

    private GameAction gameAction = GameAction.getInstance();

    public void initialize() {
        gameAction.setController(this);
        Drawer drawer = new Drawer(board.getPrefHeight(), board.getPrefWidth());
        Button[] buttons = drawer.drawFields();
        board.getChildren().addAll(buttons);

        gameAction.setGameBoard(buttons);

        char move = gameAction.assignFirstMove();
        moveIndicator.setText(String.valueOf(move));

        if (move == gameAction.CPU_O)
            gameAction.changeQueue();
    }

    public void gameOver() {
        board.setDisable(true);
        moveIndicator. setText("GAME OVER!");
    }
}
