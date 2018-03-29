package tictactoe.algorithm;

import java.util.Random;

/**
 * @Author
 * Karol Meksuła
 * 29-03-2018
 * */

public class MinMaxImpl {
    public final char PLAYER_X = 'x';
    public final char PLAYER_O = 'o';
    /*When move is 'true' playerX is making move
    * When move is 'false' playerO is making move*/
    public char move;

    public void changeQueue() {
        if (move == 'x')
            move = PLAYER_O;
        else move = PLAYER_X;
    }

    public void assignFirstMove() {
        Random random = new Random();
        int index = random.nextInt(9);
        System.out.println(index);
        if (index < 5)
            move = PLAYER_O;
        if (index >= 5)
            move = PLAYER_X;
    }

    public char[][] gameBoard = {{'.', '.', '.'},
                                 {'.', '.', '.'},
                                 {'.', '.', '.'}};

    public void makeMove(int x, int y) {
        if (fieldIsAvailable(x, y)) {
            if (move == 'x')
                gameBoard[x][y] = 'x';
            else gameBoard[x][y] = 'o';
        }

        changeQueue();
    }

    public boolean fieldIsAvailable(int x, int y) {
        if (gameBoard[0][0] == '.')
            return true;
        else return false;
    }

    public void makeCpuMove() {

        int x = 1;
        int y = 1;



        if (fieldIsAvailable(x, y))
            makeMove(x, y);


        else if (moveLeft()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; i < 3; i++) {
                    makeMove(i, j);
                }
            }
        }
    }

    public void showCurrentTable() {
        System.out.println(gameBoard[0][0] + " " + gameBoard[0][1] + " " + gameBoard[0][2]);
        System.out.println(gameBoard[1][0] + " " + gameBoard[1][1] + " " + gameBoard[1][2]);
        System.out.println(gameBoard[2][0] + " " + gameBoard[2][1] + " " + gameBoard[2][2]);
    }

    public boolean gameOver() {
        boolean b = evaluationFunction() != 0;
        if (b)
            System.out.println("Koniec gry!");

        return b;
    }

    public boolean moveLeft() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (gameBoard[i][j]=='.')
                    return true;
        return false;
    }

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
