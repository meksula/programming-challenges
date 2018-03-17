package run;

import domain.CurrencyRateOfExchange;

import java.io.IOException;

public class Main {
    public static void main(String[]args) throws IOException {
        CurrencyRateOfExchange currencyRateOfExchange = new CurrencyRateOfExchange();

        String[] tab = currencyRateOfExchange.extractCurrencyAndValue();
        System.out.println(tab[5]);
        System.out.println("size: " + tab.length);

        System.out.println("Value: " + currencyRateOfExchange.extractValue(tab));
    }
}
