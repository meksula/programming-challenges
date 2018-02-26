package puzzle.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {
    private Controller controller;

    @Before
    public void setUp() {
        this.controller = new Controller();
    }

    @Test
    public void shouldInitCorrectly(){
        assertNotNull(controller);
    }
}