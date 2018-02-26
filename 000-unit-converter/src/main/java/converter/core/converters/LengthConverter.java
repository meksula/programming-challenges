package converter.core.converters;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Karol Meksuła
 * 26-02-2018
 **/

public class LengthConverter implements Converter {
    private static LengthConverter ourInstance = new LengthConverter();
    private BigDecimal value;
    private BigDecimal result;
    private Map<String, Runnable> commands = new HashMap<>();

    public static LengthConverter getInstance() {
        return ourInstance;
    }

    private LengthConverter() {
        /*milimeters*/
        commands.put("mm-cm", () -> {
            result = value.divide(BigDecimal.valueOf(10));
        });
        commands.put("mm-dm", () -> {
            result = value.divide(BigDecimal.valueOf(100));
        });
        commands.put("mm-m", () -> {
            result = value.divide(BigDecimal.valueOf(1000));
        });
        commands.put("mm-km", () -> {
            result = value.divide(BigDecimal.valueOf(1000000));
        });

        /*centimeters*/
        commands.put("cm-mm", () -> {
            result = value.multiply(BigDecimal.valueOf(10));
        });
        commands.put("cm-dm", () -> {
            result = value.divide(BigDecimal.valueOf(10));
        });
        commands.put("cm-m", () -> {
            result = value.divide(BigDecimal.valueOf(100));
        });
        commands.put("cm-km", () -> {
            result = value.divide(BigDecimal.valueOf(100000));
        });

        /*decimeters*/
        commands.put("dm-mm", () -> {
            result = value.multiply(BigDecimal.valueOf(100));
        });
        commands.put("dm-cm", () -> {
            result = value.multiply(BigDecimal.valueOf(10));
        });
        commands.put("dm-m", () -> {
            result = value.divide(BigDecimal.valueOf(10));
        });
        commands.put("dm-km", () -> {
            result = value.divide(BigDecimal.valueOf(10000));
        });

        /*meters*/
        commands.put("m-mm", () -> {
            result = value.multiply(BigDecimal.valueOf(1000));
        });
        commands.put("m-cm", () -> {
            result = value.multiply(BigDecimal.valueOf(100));
        });
        commands.put("m-dm", () -> {
            result = value.multiply(BigDecimal.valueOf(10));
        });
        commands.put("m-km", () -> {
            result = value.divide(BigDecimal.valueOf(1000));
        });

        /*kilometers*/
        commands.put("km-mm", () -> {
            result = value.multiply(BigDecimal.valueOf(100000));
        });
        commands.put("km-cm", () -> {
            result = value.multiply(BigDecimal.valueOf(10000));
        });
        commands.put("km-dm", () -> {
            result = value.divide(BigDecimal.valueOf(10000));
        });
        commands.put("km-m", () -> {
            result = value.multiply(BigDecimal.valueOf(1000));
        });

        /*weight - grams*/
        commands.put("g-dk", () -> {
            result = value.divide(BigDecimal.valueOf(10));
        });
        commands.put("g-kg", () -> {
            result = value.divide(BigDecimal.valueOf(1000));
        });
        commands.put("g-t", () -> {
            result = value.divide(BigDecimal.valueOf(1000000));
        });

        /*weight - dk*/
        commands.put("dk-g", () -> {
            result = value.multiply(BigDecimal.valueOf(10));
        });
        commands.put("dk-kg", () -> {
            result = value.divide(BigDecimal.valueOf(100));
        });
        commands.put("dk-t", () -> {
            result = value.divide(BigDecimal.valueOf(100000));
        });

        /*weight - kg*/
        commands.put("kg-g", () -> {
            result = value.multiply(BigDecimal.valueOf(1000));
        });
        commands.put("kg-dk", () -> {
            result = value.multiply(BigDecimal.valueOf(100));
        });
        commands.put("kg-t", () -> {
            result = value.divide(BigDecimal.valueOf(1000));
        });

        /*weight - t*/
        commands.put("t-g", () -> {
            result = value.multiply(BigDecimal.valueOf(1000000));
        });
        commands.put("t-dk", () -> {
            result = value.multiply(BigDecimal.valueOf(100000));
        });
        commands.put("t-kg", () -> {
            result = value.multiply(BigDecimal.valueOf(1000));
        });

        /*area - mm2*/
        commands.put("mm2-cm2", () -> {
            result = value.divide(BigDecimal.valueOf(100));
        });
        commands.put("mm2-dm2", () -> {
            result = value.divide(BigDecimal.valueOf(10000));
        });
        commands.put("mm2-m2", () -> {
            result = value.divide(BigDecimal.valueOf(1000000));
        });
        commands.put("mm2-km2", () -> {
            result = value.divide(BigDecimal.valueOf(1E12));
        });

        /*area - cm2*/
        commands.put("cm2-mm2", () -> {
            result = value.multiply(BigDecimal.valueOf(100));
        });
        commands.put("cm2-dm2", () -> {
            result = value.divide(BigDecimal.valueOf(100));
        });
        commands.put("cm2-m2", () -> {
            result = value.divide(BigDecimal.valueOf(10000));
        });
        commands.put("cm2-km2", () -> {
            result = value.divide(BigDecimal.valueOf(1E10));
        });

        /*area - dm2*/
        commands.put("dm2-mm2", () -> {
            result = value.multiply(BigDecimal.valueOf(10000));
        });
        commands.put("dm2-cm2", () -> {
            result = value.multiply(BigDecimal.valueOf(100));
        });
        commands.put("dm2-m2", () -> {
            result = value.divide(BigDecimal.valueOf(100));
        });
        commands.put("dm2-km2", () -> {
            result = value.divide(BigDecimal.valueOf(1E8));
        });

        /*area - m2*/
        commands.put("m2-mm2", () -> {
            result = value.multiply(BigDecimal.valueOf(1000000));
        });
        commands.put("m2-cm2", () -> {
            result = value.multiply(BigDecimal.valueOf(10000));
        });
        commands.put("m2-dm2", () -> {
            result = value.multiply(BigDecimal.valueOf(100));
        });
        commands.put("m2-km2", () -> {
            result = value.divide(BigDecimal.valueOf(1000000));
        });

        /*area - m2*/
        commands.put("km2-mm2", () -> {
            result = value.multiply(BigDecimal.valueOf(1E12));
        });
        commands.put("km2-cm2", () -> {
            result = value.multiply(BigDecimal.valueOf(1E10));
        });
        commands.put("km2-dm2", () -> {
            result = value.multiply(BigDecimal.valueOf(1E8));
        });
        commands.put("km2-m2", () -> {
            result = value.multiply(BigDecimal.valueOf(1000000));
        });

    }

    @Override
    public BigDecimal convertUnits(String query, BigDecimal value) {
        this.value = value;
        if (!commands.containsKey(query)){
            System.out.println("Nie możesz przekonwertować jednostek różnych typów!");
            return BigDecimal.valueOf(0);
        }
        commands.get(query).run();

        return result;
    }
}
