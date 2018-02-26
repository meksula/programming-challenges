package puzzle.core;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * @Author Karol Meksuła
 * 24-02-2018
 *
 * Singleton class
 **/

public class PuzzleGenerator {
    private static PuzzleGenerator generator = new PuzzleGenerator();

    private Swaper swaper;
    private ArrayList<Puzzle> puzzles = new ArrayList<>();
    private ArrayList<Puzzle> miniPattern;
    private final static int PIECES_AMOUNT = 16;
    private Paint[] paintSet = {
            Color.BLACK,
            Color.YELLOW,
            Color.PURPLE,
            Color.BLUE,
            Color.ORANGE,
            Color.DARKGREEN,
            Color.DARKGREY,
            Color.HOTPINK,
            Color.MAGENTA,
            Color.RED,
            Color.WHITE,
            Color.SALMON,
            Color.MEDIUMBLUE,
            Color.FIREBRICK,
            Color.DARKKHAKI,
            Color.LIMEGREEN
    };

    private PuzzleGenerator(){}

    public static PuzzleGenerator getInstance() {
        return generator;
    }

    public List<Puzzle> preparePieces() {
        Dimension d = new Dimension(1);
        for (int i = 0; i < PIECES_AMOUNT; i++) {
            puzzles.add(new Puzzle(d.setLayout_X(i), d.setLayout_Y(i) , paintSet[i]));
        }

        swaper = new Swaper(puzzles, miniPattern);
        shuffle();
        return puzzles;
    }

    public void shuffle(){
        Random random = new Random();
        ArrayList<Paint> paintSetTmp = new ArrayList<>();
        paintSetTmp.addAll(Arrays.asList(paintSet));
        int counter = 0;
        for(Puzzle p : puzzles){
            counter++;
            int paintIndex = random.nextInt((PIECES_AMOUNT + 1) - counter);
            p.changeColor(paintSetTmp.get(paintIndex));
            paintSetTmp.remove(paintIndex);
        }

        swaper.indicateBlack();
        swaper.refreshSwaper(puzzles);
    }

    public List<Puzzle> preparePattern() {
        Dimension d = new Dimension(2);
        miniPattern = new ArrayList<>();
        for (int i = 0; i < PIECES_AMOUNT; i++) {
            miniPattern.add(new Puzzle(d.setLayout_X(i), d.setLayout_Y(i), d.width, d.height, paintSet[i]));
        }
        return miniPattern;
    }

    protected class Dimension {
        private double width;
        private double height;

        public Dimension(int div) {
            height = Puzzle.getHEIGHT() / div;
            width = Puzzle.getWIDTH() / div;
        }

        public double setLayout_X(int index) {
            if (index <= 3)
                return index * width;
            if (index >=4 && index <= 7)
                return (width * index) - (width * 4);
            if (index >= 7 && index <= 11)
                return (width * index) - (width * 8);
            else return (width * index) - (width * 12);
        }

        public double setLayout_Y(int index) {
            if (index <= 3)
                return 0;
            if (index >=4 && index <= 7)
                return height;
            if (index >= 7 && index <= 11)
                return height * 2;
            else return height * 3;
        }

    }
}
