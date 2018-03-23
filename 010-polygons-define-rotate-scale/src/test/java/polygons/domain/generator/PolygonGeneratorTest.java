package polygons.domain.generator;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class PolygonGeneratorTest {
    private PolygonGenerator shapeGenerator = PolygonGenerator.getInstance();
    private final int VALID_AMOUNT = 3;
    private final double VALID_LENGTH = 20.0;

    private final int INVALID_AMOUNT = 2;
    private final double INVALID_LENGTH = 0;

    @Test
    public void shouldCreateNewShapeDependsOnArguments() {
        Shape shape = shapeGenerator.generateShape(VALID_AMOUNT, VALID_LENGTH);
        assertNotNull(shape);
    }

    private Shape createPolygon() {
        return shapeGenerator.generateShape(VALID_AMOUNT, VALID_LENGTH);
    }

    @Test
    public void amountIsValidShouldReturnTrue() {
        assertTrue(shapeGenerator.amountIsValid());
    }

    @Test
    public void amountIsValidShouldRetunrFalse() {
        assertFalse(shapeGenerator.amountIsValid());
    }
}