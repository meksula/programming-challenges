package tictactoe.run;

import tictactoe.algorithm.MinMaxImpl;

import java.util.Scanner;

/**
 * @Author
 * Karol Meksuła
 * 29-03-2018
 * */

public class Main {
    public static void main(String[]args) {
        boolean gameOver = false;

        Scanner scanner = new Scanner(System.in);
        MinMaxImpl minMax = new MinMaxImpl();
        minMax.assignFirstMove();

        while (!gameOver) {
            System.out.println("Ruch należy do: " + minMax.move);
            if (minMax.move == 'x') {
                System.out.println("Twój ruch!");
                System.out.println("Wpisz współrzędną 'x' na planszy.");

                int x = scanner.nextInt();
                System.out.println("Wpisz współrzędną 'y' na planszy.");
                int y = scanner.nextInt();
                System.out.println("Twój ruch: " + x + ", " + y);
                minMax.makeMove(x, y);
            }

            else {
                minMax.makeCpuMove();
                System.out.println("Komputer wykonał ruch, teraz Ty.");
            }

            minMax.showCurrentTable();
            gameOver = minMax.gameOver();
        }
        minMax.showCurrentTable();
    }
}
