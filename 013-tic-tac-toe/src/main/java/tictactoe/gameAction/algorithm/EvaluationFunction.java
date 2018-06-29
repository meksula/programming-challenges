package tictactoe.gameAction.algorithm;

import javafx.scene.control.Button;
import tictactoe.gameAction.GameAction;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

public class EvaluationFunction {
    private GameAction gameAction = GameAction.getInstance();
    private Button[] gameBoard;
    private final String PLAYER_X;
    private final String CPU_O;

    /*Mam tutaj sprawdzić wszystkie wiersze, kolumny i przekątne*/
    /*rows = 0,1,2    3,4,5   6,7,8
    * columns = 0,3,6   1,4,7,   2,5,8
    * diagonals = 0,4,8   2,4,6
    * */

    public EvaluationFunction(Button[]gameBoard, char player, char cpu) {
        this.gameBoard = gameBoard;
        this.PLAYER_X = String.valueOf(player);
        this.CPU_O = String.valueOf(cpu);
    }

    public void evaluate() {
        int checkIndexPlayer = 0;
        int checkIndexCpu = 0;
        int iterations = 0;
        int[]scorePlayer = new int[3];
        int[]scoreCpu = new int[3];

        for (int rows = 0; rows < 3; rows++) {
            checkIndexCpu = 0;
            checkIndexPlayer = 0;
            for (int i = 0; i < 3; i++) {
                if (gameBoard[iterations].getText().equals(PLAYER_X)) {
                    checkIndexPlayer++;
                    scorePlayer[rows]++;
                }

                if (gameBoard[iterations].getText().equals(CPU_O)) {
                    checkIndexCpu++;
                    scoreCpu[rows]++;
                }

                iterations++;

            }

        }

        for (int i = 0; i < 3; i++) {
            if (scoreCpu[i] == 3) {
                System.out.println("Zwycięstwo CPU! /row");
                gameAction.gameOver();
            }

            if (scorePlayer[i] == 3) {
                System.out.println("Twoje zwycięstwo! /row");
                gameAction.gameOver();
            }

        }

        System.out.println("Masz " + checkIndexPlayer + " ,a CPU ma " + checkIndexCpu);


        int columnFactor = 0;
        int checkColumnPlayer = 0;
        int checkColumnCpu = 0;
        int[]scorePlayerCol = new int[3];
        int[]scoreCpuCol = new int[3];

        for (int column = 0; column < 3; column++) {
            columnFactor = column;
            for (int i = 0; i < 3; i++) {
                if (gameBoard[(i * 3) + column].getText().equals(PLAYER_X)) {
                    checkColumnPlayer++;
                    scorePlayerCol[column]++;
                }

                if (gameBoard[(i * 3) + column].getText().equals(CPU_O)) {
                    checkColumnCpu++;
                    scoreCpuCol[column]++;
                }
                columnFactor =+ 3;
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("CPU: " + scoreCpuCol[i]);
            System.out.println("Player: " + scorePlayerCol[i]);

            if (scoreCpuCol[i] == 3) {
                System.out.println("Zwycięstwo CPU! /col");
                gameAction.gameOver();
            }

            if (scorePlayerCol[i] == 3) {
                System.out.println("Twoje zwycięstwo! /col");
                gameAction.gameOver();
            }
        }


        int diagonalSecPlayer = 0;
        int diagonalSecCpu = 0;
        int index = 2;
        for (int x = 0; x < 3; x++) {
            if (gameBoard[(x * 2) + 2].getText().equals(PLAYER_X))
                diagonalSecPlayer++;
            if (gameBoard[(x * 2) + 2].getText().equals(CPU_O))
                diagonalSecCpu++;
        }

        if (diagonalSecPlayer == 3)
            System.out.println("Wygrałeś! /diagonal");

        if (diagonalSecCpu == 3)
            System.out.println("Przegrałeś :( /diagonal");



        int diagonalPlayer = 0;
        int diagonalCpu = 0;
        int inde = 2;
        for (int x = 0; x < 3; x++) {
            if (gameBoard[x * 4].getText().equals(PLAYER_X))
                diagonalPlayer++;
            if (gameBoard[(x * 4)].getText().equals(CPU_O))
                diagonalCpu++;
        }

        if (diagonalPlayer == 3)
            System.out.println("Wygrałeś! /diagonal");

        if (diagonalCpu == 3)
            System.out.println("Przegrałeś :( /diagonal");

    }
}
