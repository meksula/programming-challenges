package tictactoe.gameAction;

import javafx.scene.control.Button;
import tictactoe.controller.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

public class GameAction {
    private static GameAction ourInstance = new GameAction();

    public static GameAction getInstance() {
        return ourInstance;
    }

    private GameAction() {
    }

    private boolean gameIsOn;

    private Button[] gameBoard;

    public Button[] getGameBoard() {
        return gameBoard;
    }

    private Controller controller;

    public final char PLAYER_X = 'x';
    public final char CPU_O = 'o';

    public char moveNow;

    public void setGameBoard(Button[] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void changeQueue() {
        if (gameIsOn) {
            if (moveNow == PLAYER_X) {
                moveNow = CPU_O;
                cpuMakeMove();
                changeQueue();
            }

            else moveNow = PLAYER_X;
        }
    }

    public char assignFirstMove() {
        gameIsOn = true;
        Random random = new Random();
        int index = random.nextInt(9);
        if (index < 5)
            moveNow = PLAYER_X;
        if (index >= 5)
            moveNow = CPU_O;

        return moveNow;
    }

    private void cpuMakeMove() {
        Random random = new Random();
        ArrayList<Integer> able = assignAbleMoves();

        if (able.size() == 0) {
            gameOver();
            return;
        }

        int index;
        int i = 4;
        if (able.size() > 0) {
            index = random.nextInt(able.size() -1);
            i = able.get(index);
        }

        if (gameBoard[i].isDisable())
            cpuMakeMove();

        else {
            gameBoard[i].setText(String.valueOf(CPU_O));
            gameBoard[i].setDisable(true);

            if (able.size() == 0)
                System.exit(0);
        }
    }

    private ArrayList<Integer> assignAbleMoves() {
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < gameBoard.length; i++) {
            if (!gameBoard[i].isDisable())
                ints.add(i);
        }
        return ints;
    }

    private void gameOver() {
        gameIsOn = false;
        controller.gameOver();
    }
}
