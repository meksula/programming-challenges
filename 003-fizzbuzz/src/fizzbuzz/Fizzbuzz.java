package fizzbuzz;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author Karol Meksuła
 * 05-03-2018
 **/

public class Fizzbuzz {
    private int counter = 0;

    public Fizzbuzz() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                fizzbuzz();
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    private void fizzbuzz() {
        counter++;
        if (counter % 3 == 0)
            System.out.println(counter + " - fizz");
        else if (counter % 5 == 0)
            System.out.println(counter + " - buzz");
        else System.out.println(counter);
    }
}
