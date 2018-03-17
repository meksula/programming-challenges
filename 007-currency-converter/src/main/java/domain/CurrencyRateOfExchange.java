package domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyRateOfExchange {
    private final String DEFAULT_URL = "http://www.nbp.pl/home.aspx?f=/kursy/kursya.html";
    private Document document;
    private Map<String, BigDecimal> currenciesValues;

    public CurrencyRateOfExchange() throws IOException {
        this.document = Jsoup.connect(DEFAULT_URL).get();
        currenciesValues = new HashMap<>();
    }

    public Document loadNewDocFromUrl(String url) throws IOException {
        this.document = Jsoup.connect(url).get();
        return document;
    }

    public Map<String,BigDecimal> getCurrenciesValuesMap() {
        return currenciesValues;
    }

    public String parseDocument() {
        String doc = document.html();

        String [] parts = doc.split("Tabela nr");
        String [] extractCurrencyTable = parts[1].split("SDR");

        return extractCurrencyTable[0];
    }

    public Document getDocument() {
        return document;
    }

    public String[] extractCurrencyAndValue() {
        String parsed = parseDocument();
        Pattern pattern = Pattern.compile("dolar amerykański");
        Matcher matcher = pattern.matcher(parsed);

        String[] splited = parsed.split("<tr>");
        return splited;
    }

    public String extractValue(String[] parsed) {
        String[] arr = parsed[4].split("[0-9]\\,[0-9]{2,}");
        for (String s : arr)
            System.out.println(s);
        return arr[0];
    }
}
