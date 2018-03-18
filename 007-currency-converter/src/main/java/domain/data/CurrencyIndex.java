package domain.data;

/**
 * @Author Karol Meksuła
 * 17-03-2018
 * */

public enum CurrencyIndex {
    PLN("Złoty polski", 0), USD("Dolar amerykański", 1), EUR("Euro", 7),
    CHF("Frank Szwajcarski", 9), GBP("Funt brytyjski", 10), UAH("Hrywna", 11), RUB("Rubel", 29);

    private final int index;
    private final String currency;

    CurrencyIndex(String currency, int index) {
        this.index = index;
        this.currency = currency;
    }

    public int getIndex() {
        return index;
    }

    public String getCurrency() {
        return currency;
    }
}