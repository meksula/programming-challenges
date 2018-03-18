package domain.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 /**
 * @Author Karol Meksuła
 * 17-03-2018
 * */

 public class CurrencyRateOfExchange {
     private final String DEFAULT_URL = "http://www.nbp.pl/home.aspx?f=/kursy/kursya.html";
     private Document document;
     private Map<CurrencyIndex, Double> currenciesValues;

     public CurrencyRateOfExchange() throws IOException {
         this.document = Jsoup.connect(DEFAULT_URL).get();
         currenciesValues = new HashMap<>();
     }

     public Map<CurrencyIndex, Double> getCurrenciesValuesMap() throws ParseException {
         assignKeyAndValue();
         return currenciesValues;
     }

     public void assignKeyAndValue() throws ParseException {
         List<Double> values = extractValue();

         currenciesValues.put(CurrencyIndex.PLN, 1D);
         currenciesValues.put(CurrencyIndex.USD, values.get(CurrencyIndex.USD.getIndex()));
         currenciesValues.put(CurrencyIndex.EUR, values.get(CurrencyIndex.EUR.getIndex()));
         currenciesValues.put(CurrencyIndex.CHF, values.get(CurrencyIndex.CHF.getIndex()));
         currenciesValues.put(CurrencyIndex.GBP, values.get(CurrencyIndex.GBP.getIndex()));
         currenciesValues.put(CurrencyIndex.UAH, values.get(CurrencyIndex.UAH.getIndex()));
         currenciesValues.put(CurrencyIndex.RUB, values.get(CurrencyIndex.RUB.getIndex()));
     }

     public List<Double> extractValue() throws ParseException {
         final String VALUE_PATTERN = "([0-9]{1}\\,{1}[0-9]{3})+";
         String [] parsed = splitStringToCurrencyInfo();
         Pattern pattern = Pattern.compile(VALUE_PATTERN);

         ArrayList<Double> currencyValues = new ArrayList<>();

         for (int i = 0; i < parsed.length; i++) {
             Matcher matcher = pattern.matcher(parsed[i]);
             if (matcher.find()) {
                 String value = matcher.group();
                 currencyValues.add(parseStringToDouble(value));
             }
         }
         return currencyValues;
     }

     public String[] splitStringToCurrencyInfo() {
         String parsed = parseDocument();
         return parsed.split("<tr>");
     }

     public String parseDocument() {
         String doc = document.html();

         String[] parts = doc.split("Tabela nr");
         String[] extractCurrencyTable = parts[1].split("SDR");

         return extractCurrencyTable[0];
     }

     public double parseStringToDouble(String toParse) throws ParseException {
         NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRANCE);
         Number number = numberFormat.parse(toParse);
         return number.doubleValue();
     }

     public Document loadNewDocFromUrl(String url) throws IOException {
         this.document = Jsoup.connect(url).get();
         return document;
     }
 }

