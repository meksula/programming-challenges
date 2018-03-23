package polygons.domain.generator;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ShapeTypeExtracterTest {
    private final String VALID_NAME = "polygons.domain.shapes.Shapes.MenuItem[id=squareTriangle, styleClass=[menu-item]]";

    @Test
    public void learnTest() {
        Pattern pattern = Pattern.compile("[a-zA-Z]+\\,");
        Matcher matcher = pattern.matcher(VALID_NAME);

        String result = null;
        assertTrue(matcher.find());
        result = matcher.group();
        String [] tabs = result.split("\\,");

        assertEquals("squareTriangle", tabs[0]);
    }

}