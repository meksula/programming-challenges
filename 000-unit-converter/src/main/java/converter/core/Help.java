package converter.core;

import java.util.Scanner;

/**
 * @Author Karol Meksuła
 * 26-02-2018
 **/

public class Help {
    public static void show(){
        Scanner scanner = new Scanner(System.in);
        String command;
        String[] commands = {
                "Jednostki wagi: g, dk, kg, t",
                "Jednostki powierzchni: mm2, cm2, dm2, m2, km2",
                "Jednostki długości: mm, cm, dm, m, km",
                "(x) cofnij, (q) zakończ"
        };

        for (String s : commands)
            System.out.println(s);

        command = scanner.next();

        if (command.equals("x"))
            new Dialog();
        else if (command.equals("q"))
            System.exit(0);
    }
}
