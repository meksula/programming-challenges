package domain;

import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;

public class CurrencyRateOfExchangeTest {
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
    public void shouldGetMapWithCurrencyAndValue() {
        Map<String, BigDecimal> curencies = currencyRateOfExchange.getCurrenciesValuesMap();
        assertEquals(0, curencies.size());
    }

    @Test
    public void parseDocumentShouldReturnCollectionOfString() {
        String extracted = currencyRateOfExchange.parseDocument();
        assertNotNull(extracted);
        assertTrue(extracted.length() > 30);
    }

    @Test
    public void extractCurrencyNameAndValueFromString() {
        assertEquals(5, currencyRateOfExchange.getCurrenciesValuesMap().size());
    }
}