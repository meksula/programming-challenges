package tictactoe.gameAction.algorithm;

import javafx.scene.control.Button;
import tictactoe.gameAction.GameAction;


/**
 * @Author
 * Karol Meksuła
 * 29-03-2018
 * */

public class MinMaxImpl {

    private GameAction gameAction = GameAction.getInstance();
    private Button[] gameBoard = gameAction.getGameBoard();
    private char PLAYER_X = gameAction.PLAYER_X;
    private char CPU_O = gameAction.CPU_O;

    public int evaluationFunction() {
        for (int row = 0; row < 3; row++) {
            if (gameBoard[row][0] == gameBoard[row][1] &&
                    gameBoard[row][1] == gameBoard[row][2]) {
                if (gameBoard[row][0] == PLAYER_X)
                    return +10;
                else if (gameBoard[row][0] == PLAYER_O)
                    return -10;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (gameBoard[0][col] == gameBoard[1][col] &&
                    gameBoard[1][col] == gameBoard[2][col]) {
                if (gameBoard[0][col]== PLAYER_X)
                    return +10;

                else if (gameBoard[0][col] == PLAYER_O)
                    return -10;
            }
        }

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) {
            if (gameBoard[0][0] == PLAYER_X)
                return +10;
            else if (gameBoard[0][0] == PLAYER_O)
                return -10;
        }

        if (gameBoard[0][2]== gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) {
            if (gameBoard[0][2]== PLAYER_X)
                return +10;
            else if (gameBoard[0][2]== PLAYER_O)
                return -10;
        }

        return 0;
    }
}
