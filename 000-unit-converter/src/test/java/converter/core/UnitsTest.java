package converter.core;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class UnitsTest {
    private UnitsCenter units = UnitsCenter.getInstance();
    String from = "from";
    String to = "to";

    @Test
    public void shouldCreateCorrectlyQuery(){
        units.execute(from, to, BigDecimal.valueOf(1000));
    }
}
