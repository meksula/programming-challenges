package domain.valid;

import domain.data.CurrencyIndex;

/**
 * @Author Karol Meksuła
 * 17-03-2018
 * */

public class CurrencyTypeValidator {
    private String from;
    private String to;

    public boolean validate(String from, String to) {
        this.from = from.toUpperCase();
        this.to = to.toUpperCase();
        return checkVariables();
    }

    protected  boolean checkVariables() {
        if (from.equals(to))
            return false;
        if (!currencyExist())
            return false;
        else return true;
    }

    protected boolean currencyExist() {
        try {
            CurrencyIndex.valueOf(from);
            CurrencyIndex.valueOf(to);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong argument! There is no such currency!");
            return false;
        }
    }
}
