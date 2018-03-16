package domain;

import java.text.DecimalFormat;

/**
 * @Author Karol Meksuła
 * 16-03-2018
 * */

public class BmiCalculator {

    public static String computeBmi(double heightByMeters, double weightByKilometers) {
        double result = weightByKilometers / (heightByMeters * 2);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(result);
    }
}
