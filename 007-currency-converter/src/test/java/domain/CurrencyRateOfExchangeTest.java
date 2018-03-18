package domain;

import domain.data.CurrencyIndex;
import domain.data.CurrencyRateOfExchange;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 17-03-2018
 * */

public class CurrencyRateOfExchangeTest {
    private final Logger logger = LogManager.getLogger(CurrencyRateOfExchangeTest.class);
    private CurrencyRateOfExchange currencyRateOfExchange = new CurrencyRateOfExchange();
    private final String URL_ADDRESS = "https://pl.wikipedia.org/wiki/Winston_Churchill";

    public CurrencyRateOfExchangeTest() throws IOException {
    }

    @Test
    public void shouldBeAbleToLoadNewDocumentFromUrlAddress() throws IOException {
        Document document = currencyRateOfExchange.loadNewDocFromUrl(URL_ADDRESS);
        assertNotNull(document);
    }

    @Test
    public void shouldGetMapWithCurrencyAndValue() throws ParseException {
        Map<CurrencyIndex, Double> curencies = currencyRateOfExchange.getCurrenciesValuesMap();
        assertEquals(7, curencies.size());
    }

    @Test
    public void parseDocumentShouldReturnCollectionOfString() {
        String extracted = currencyRateOfExchange.parseDocument();
        assertNotNull(extracted);
        assertTrue(extracted.length() > 30);
    }

    @Test
    public void assignValuesWorksCorrectlyAndMapIsFilled() throws ParseException {
        currencyRateOfExchange.assignKeyAndValue();
        Map<CurrencyIndex, Double> map = currencyRateOfExchange.getCurrenciesValuesMap();
        assertEquals(7, map.size());
        logger.info(map.get(CurrencyIndex.UAH));
    }

    private final double DELTA = 1e-15;

    @Test
    public void parseStringToDoubleTest() throws ParseException {
        String toParse = "4,563";
        double value = currencyRateOfExchange.parseStringToDouble(toParse);
        assertEquals(4.563, value, DELTA);
    }

    @Test
    public void extractValuesTest() throws ParseException {
        List<Double> values =  currencyRateOfExchange.extractValue();
        assertEquals(34, values.size());
    }

    @Test
    public void getValueFromMap() throws ParseException {
        final double USD_RATE = currencyRateOfExchange.getCurrenciesValuesMap().get(CurrencyIndex.USD);
        logger.info(USD_RATE);
    }
}