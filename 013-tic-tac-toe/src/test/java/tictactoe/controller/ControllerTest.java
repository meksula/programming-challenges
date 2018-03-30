package tictactoe.controller;

import javafx.scene.layout.Pane;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ControllerTest {
    private Controller controller = new Controller();

    @Test
    public void controllerPaneTest() throws NoSuchFieldException, IllegalAccessException {
        Class<?> ref = controller.getClass();

        Field pane = ref.getDeclaredField("board");
        pane.setAccessible(true);

        assertEquals("Pane", pane.getType().toString());
    }
}