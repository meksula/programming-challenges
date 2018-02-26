package converter.core;

import converter.core.converters.LengthConverter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Karol Meksuła
 * 26-02-2018
 **/

public class UnitsCenter {
    private static UnitsCenter ourInstance = new UnitsCenter();

    public static UnitsCenter getInstance() {
        return ourInstance;
    }

    ArrayList<String> allUnits = new ArrayList<>();

    List<String> length = new ArrayList<>();
    ArrayList<String> weight = new ArrayList<>();
    ArrayList<String> area = new ArrayList<>();

    private UnitsCenter() {
        length.add("mm");
        length.add("cm");
        length.add("dm");
        length.add("m");
        length.add("km");

        weight.add("g");
        weight.add("dk");
        weight.add("kg");
        weight.add("t");

        area.add("mm2");
        area.add("cm2");
        area.add("dm2");
        area.add("m2");
        area.add("km2");

        allUnits.addAll(length);
        allUnits.addAll(weight);
        allUnits.addAll(area);
    }

    public boolean search(String from) {
        return allUnits.contains(from);
    }

    public BigDecimal execute(String from, String to, BigDecimal value) {
        LengthConverter converter = LengthConverter.getInstance();
        StringBuilder builder = new StringBuilder();
        String query = builder.append(from).append("-").append(to).toString();

        if (from.equals(to)) {
            System.out.println("Dwie identyczne jednostki!");
            return BigDecimal.valueOf(0);
        }

        return converter.convertUnits(query, value);
    }
}