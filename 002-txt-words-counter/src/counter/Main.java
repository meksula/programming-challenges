package counter;

import java.io.IOException;

/**
 * @Author Karol Meksuła
 * 03-03-2018
 **/

public class Main {
    public static void main(String[] args) {
        try {
            new TxtLoader();
        } catch (IOException e) {
            System.out.println("Podałeś błędną ścieżkę do pliku .txt");
        }
    }
}
