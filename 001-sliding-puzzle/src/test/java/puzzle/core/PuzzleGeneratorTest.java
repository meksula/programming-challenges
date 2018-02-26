package puzzle.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 24-02-2018
 **/

public class PuzzleGeneratorTest {
    private PuzzleGenerator generator;

    @Before
    public void setUp(){
        generator = PuzzleGenerator.getInstance();
    }

    @Test
    public void shouldHaveArrayWithColors(){
        assertNotNull(generator);
    }

    @Test
    public void preparePiecesTest(){

    }

}