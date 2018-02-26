package converter.core.converters;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Karol Meksuła
 * 26-02-2018
 *
 * Converter must conatain HashMap for put "query" and
 * method which is invoking in converterUnits()
 **/

public interface Converter {
    Map<String, Runnable> commands = new HashMap<>();

    BigDecimal convertUnits(String query, BigDecimal value);
}
