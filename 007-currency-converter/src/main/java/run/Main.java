package run;

import domain.data.CurrencyIndex;
import domain.converter.CurrencyConverter;
import domain.valid.CurrencyTypeValidator;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @Author Karol Meksuła
 * 17-03-2018
 * */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String in = "";
    private static int iterator = 0;

    public static void main(String[]args) throws IOException, ParseException {
        while (!in.equals("exit")) {
            conversation();
            iterator++;
        }
    }

    private static void conversation() throws IOException, ParseException {
        if (iterator == 0)
            System.out.println(System.lineSeparator() + "Welcome to Currency Converter!");

        System.out.println("[! Type '--help' if You want see available currencies.]");
        System.out.println("[Type 'exit' to close application]");
        System.out.print(">");
        in = scanner.next();

        if (in.equals("--help"))
            help();
        else if (in.equals("exit"))
            System.exit(0);

        else {
            CurrencyConverter currencyConverter = new CurrencyConverter();
            System.out.printf("Converting %s to ... ", in);
            System.out.println(">");
            String to = scanner.next();
            System.out.printf("Converting %s to %s", in, to + System.lineSeparator());
            CurrencyTypeValidator currencyTypeValidator = new CurrencyTypeValidator();

            BigDecimal amount;

            if (currencyTypeValidator.validate(in, to)){
                System.out.printf("Type amount of %s", in + System.lineSeparator());
                System.out.print(">");
                amount = scanner.nextBigDecimal();
                currencyConverter.convertCurrency(in, to, amount);
            } else System.out.println("Arguments are same or unsupported.");
        }
    }

    private static void help() {
        System.out.println("Available currencies: ");
        System.out.printf("%s - %s", CurrencyIndex.PLN, CurrencyIndex.PLN.getCurrency()+System.lineSeparator());
        System.out.printf("%s - %s", CurrencyIndex.USD, CurrencyIndex.USD.getCurrency()+System.lineSeparator());
        System.out.printf("%s - %s", CurrencyIndex.EUR, CurrencyIndex.EUR.getCurrency()+System.lineSeparator());
        System.out.printf("%s - %s", CurrencyIndex.CHF, CurrencyIndex.CHF.getCurrency()+System.lineSeparator());
        System.out.printf("%s - %s", CurrencyIndex.GBP, CurrencyIndex.GBP.getCurrency()+System.lineSeparator());
        System.out.printf("%s - %s", CurrencyIndex.UAH, CurrencyIndex.UAH.getCurrency()+System.lineSeparator());
        System.out.printf("%s - %s", CurrencyIndex.RUB, CurrencyIndex.RUB.getCurrency()+System.lineSeparator());
    }
}
