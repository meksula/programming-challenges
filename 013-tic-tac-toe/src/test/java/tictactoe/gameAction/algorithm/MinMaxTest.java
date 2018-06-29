package tictactoe.gameAction.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 29-03-2018
 * */

public class MinMaxTest {
    private MinMax minMax = new MinMax();

    @Test
    public void shouldHave2Players() {
        assertEquals('x', minMax.PLAYER_X);
        assertEquals('o', minMax.PLAYER_O);
    }

    @Test
    public void moveShouldBeNull() {
        assertTrue(minMax.move != 'x' && minMax.move != 'o');
    }

    @Test
    public void moveShouldBeRandomChanged() {
        minMax.assignFirstMove();
        assertTrue(minMax.move == 'x' || minMax.move == 'o');
    }

    @Test
    public void changeQueueTest() {
        minMax.move = 'x';
        minMax.changeQueue();
        assertTrue(minMax.move == 'o');
    }

    @Test
    public void gameBoardHas9FieldsTest() {
        assertEquals(9, minMax.gameBoard.length * 3);
    }

    @Test
    public void makeMove() {
        minMax.makeMove(0, 0);
        assertTrue(minMax.gameBoard[0][0] == 'o');
        assertTrue(minMax.move == 'x');
    }

    @Test
    public void fieldAvailableTest() {
        assertTrue(minMax.fieldIsAvailable(0, 0));

        makeMove();

        assertFalse(minMax.fieldIsAvailable(0,0));
    }

    @Test
    public void makeBestMove() {
        minMax.makeCpuMove();
    }

}