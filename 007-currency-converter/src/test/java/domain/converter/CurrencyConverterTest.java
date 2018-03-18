package domain.converter;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 17-03-2018
 * */

//TODO dokończ te testy
public class CurrencyConverterTest {
    private CurrencyConverter currencyConverter;
    private final String FROM = "UAH";
    private final String TO = "USD";
    private final BigDecimal AMOUNT = new BigDecimal(100);

    @Before
    public void setUp() throws IOException, ParseException {
        currencyConverter = new CurrencyConverter();
    }

    @Test
    public void afterInvokeConstructorMapShouldBeInitialized() {

    }

    @Test
    public void instanceComponentsShouldBeInitialized() {
        currencyConverter.convertCurrency(FROM, TO, AMOUNT);

    }

}