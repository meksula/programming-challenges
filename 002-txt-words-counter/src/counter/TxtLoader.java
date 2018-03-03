package counter;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @Author Karol Meksuła
 * 03-03-2018
 **/

public class TxtLoader {

    public TxtLoader() throws IOException {
        System.out.printf("Podaj ścieżkę do pliku tekstowego. \n Liczba wyrazów zostanie policzona.\n >");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        System.out.println(execute(path));
    }

    private String execute(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        long wordsCounter = 0;
        while ((line = bufferedReader.readLine()) != null) {
            wordsCounter = wordsCounter + new StringTokenizer(line).countTokens();
        }
        return "Liczba wyrazów: " + wordsCounter;
    }
}