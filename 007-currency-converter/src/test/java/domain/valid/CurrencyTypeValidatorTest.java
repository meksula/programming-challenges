package domain.valid;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 17-03-2018
 * */

public class CurrencyTypeValidatorTest {
    private CurrencyTypeValidator ctv = new CurrencyTypeValidator();
    private final String VALID_1 = "EUR";
    private final String VALID_2 = "USD";

    private final String INVALID_1 = "CGT";
    private final String INVALID_2 = "PLM";

    @Test
    public void ctvShouldAllowGoNextOrNot() {
        boolean allow = ctv.validate(VALID_1, VALID_2);
        assertTrue(allow);
    }

    @Test
    public void shouldNotAllow() {
        boolean notAllow = ctv.validate(VALID_1, INVALID_1);
        assertFalse(notAllow);
    }

    @Test
    public void ifTwoArgumentsEqualsShouldNotAllow() {
        boolean notAllow = ctv.validate(VALID_1, VALID_1);
        assertFalse(notAllow);
    }

    @Test
    public void currencyShouldExist() {
        ctv.validate(VALID_1, VALID_2);
        boolean allow = ctv.currencyExist();
        assertTrue(allow);
    }

    @Test
    public void currencyNotExist() {
        ctv.validate(VALID_1, INVALID_1);
        boolean notAllow = ctv.currencyExist();
        assertFalse(notAllow);
    }

    @Test
    public void checkVariablesTestAllow() {
        ctv.validate(VALID_1, VALID_2);
        assertTrue(ctv.checkVariables());
    }
}