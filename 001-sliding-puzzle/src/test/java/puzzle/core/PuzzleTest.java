package puzzle.core;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @Author Karol Meksuła
 * 24-02-2018
 **/

@RunWith(JUnitParamsRunner.class)
public class PuzzleTest {
    private Puzzle puzzle;

    public final Object[] provideValidData(){
        return new Object[]{
                new Object[]{30.2430, 203.0, Color.WHITESMOKE},
                new Object[]{492.0, 23.0, Color.LIMEGREEN},
                new Object[]{33.4, 23.3, Color.WHEAT},
                new Object[]{23.2, 24.100, Color.THISTLE}
        };
    }

    public final Object[] provideValidDataSecondContructorMethod(){
        return new Object[]{
                new Object[]{123.34, 432.44, 533.66, 65.43, Color.THISTLE},
                new Object[]{492.0, 3433, 533.5 ,23.0, Color.LIMEGREEN},
                new Object[]{33.4, 23.3, 909, 323, Color.WHEAT},
                new Object[]{23.2, 24.100, 0.93, 0.32, Color.THISTLE}
        };
    }

    public final Object[] provideInvalidData(){
        return new Object[]{
                new Object[]{123.34, -432.44, 533.66, 65.43, Color.THISTLE},
                new Object[]{123, -432.44, 533.66, 65.43, Color.THISTLE},

        };
    }

    @Test
    @Parameters(method = "provideValidData")
    public void firstConstructorShouldInitializeObject(double x, double y, Paint paint) {
        puzzle = new Puzzle(x, y, paint);
    }

    @Test
    @Parameters(method = "provideValidDataSecondContructorMethod")
    public void secondConstructorShouldInitializeObject(double x, double y,
                                                        double customX, double customY, Paint paint) {
        new Puzzle(x,y,customX,customY,paint);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "provideInvalidData")
    public void shouldThrowException(double x, double y, double width, double height, Paint paint){
        new Puzzle(x, y, width, height, paint);
    }
}