package domain.converter;

import domain.data.CurrencyIndex;
import domain.data.CurrencyRateOfExchange;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Map;

/**
 * @Author Karol Meksuła
 * 17-03-2018
 * */

public class CurrencyConverter {
    private Map<CurrencyIndex, Double> currencyAndRate;

    public CurrencyConverter() throws IOException, ParseException {
        CurrencyRateOfExchange currencyRateOfExchange = new CurrencyRateOfExchange();
        currencyAndRate = currencyRateOfExchange.getCurrenciesValuesMap();
    }

    private BigDecimal result;
    private BigDecimal fromRate;
    private BigDecimal toRate;

    private String from;
    private String to;
    private BigDecimal amount;

    public void convertCurrency(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;

        establishExhangeRates();
        result = count();
        showResult();
    }

    private void establishExhangeRates() {
        from = from.toUpperCase();
        to = to.toUpperCase();
        fromRate = BigDecimal.valueOf(currencyAndRate.get(CurrencyIndex.valueOf(from)));
        toRate = BigDecimal.valueOf(currencyAndRate.get(CurrencyIndex.valueOf(to)));
    }

    private BigDecimal count() {
        BigDecimal plnAmount = amount.multiply(fromRate);
        return plnAmount.divide(toRate, 2, RoundingMode.HALF_UP);
    }

    private void showResult() {
        System.out.printf(System.lineSeparator() + "%.2f %s equals %.2f %s"
                + System.lineSeparator() , amount, from, result, to);
        System.out.println();
    }

}
