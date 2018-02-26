package puzzle.core;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

/*
 * @Author Karol Meksuła
 * 24-02-2018
 **/

public class Swaper {
    private ArrayList<Puzzle> puzzles;
    private ArrayList<Puzzle> pattern;
    private Puzzle blackVoidPiece;

    public Swaper(ArrayList<Puzzle> puzzles, ArrayList<Puzzle> pattern) {
        this.puzzles = puzzles;
        this.pattern = pattern;
        blackVoidPiece = indicateBlack();
        swapAble(puzzles);
    }

    private void swapAble(ArrayList<Puzzle> puzzles) {
        puzzles.forEach(puzzle -> {
            puzzle.getPiece().setOnMouseClicked(event -> {
                swap(puzzle);
            });
        });
    }

    private void swap(Puzzle puzzle) {
        int cord = puzzles.indexOf(puzzle);
        int black = puzzles.indexOf(blackVoidPiece);
        if (cord + 1 == black || cord - 1 == black
                || cord + 4 == black || cord - 4 == black) {
            Paint cordPaint = puzzle.getPiece().getFill();
            Paint blackPaint = blackVoidPiece.getPiece().getFill();

            puzzle.getPiece().setFill(blackPaint);
            blackVoidPiece.getPiece().setFill(cordPaint);
            blackVoidPiece = puzzle;
        }

    }

    protected Puzzle indicateBlack() {
        for (Puzzle puzzle : puzzles) {
            if (puzzle.getPiece().getFill() == Color.BLACK)
                return puzzle;
        }
        return null;
    }

    public void refreshSwaper(ArrayList<Puzzle> puzzles) {
        this.puzzles = puzzles;
        blackVoidPiece = indicateBlack();
        swapAble(puzzles);
    }
}
