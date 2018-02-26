package converter.core;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author Karol Meksuła
 * 26-02-2018
 **/

public class Dialog {
    public static String from = "init";
    public static String to;
    private BigDecimal value;
    UnitsCenter units = UnitsCenter.getInstance();

    public void conversationFlow() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Wybierz jednostkę, którą chcesz konwertować: \n>");
        from = scanner.next();
        if (units.search(from)){
            System.out.printf("Wybrano " + from + "\nWybierz jednostkę docelową: \n>");
            to = scanner.next();
            if (units.search(to)){
                System.out.printf("Wpisz wartość: \n>");
                value = scanner.nextBigDecimal();
                BigDecimal result = units.execute(from, to, value);
                System.out.printf("Wynik: " + result + " " + to + "\n");
                Thread.sleep(3000);
                return;
            }

        }

        if (from.equals("--help"))
            Help.show();

        else {
            System.out.print("Komenda nieznana.\n" +
                    "Wpisz --help w celu wyświetlenia dostępnych opcji.\n>");
        }
    }

}
