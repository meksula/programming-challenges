package domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 16-03-2018
 * */

public class BmiCalculatorTest {
    private final double WEIGHT = 68.7;
    private final double HEIGHT = 1.77;

    @Test
    public void bmiShouldGiveExpectedValue() {
        String bmi = BmiCalculator.computeBmi(HEIGHT, WEIGHT);
        assertEquals("19,41", bmi);
    }

}