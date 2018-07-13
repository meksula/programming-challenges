package model.conc;

import javafx.scene.Node;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author
 * Karol Meksuła
 * 12-07-2018
 * */

public class GameTimer {
    private Timer timer;
    private double unit;
    private double acc = 14;
    private double startY;

    public void jump(Node node, double maxUnit) {
        startY = node.getLayoutY();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                unit += 1;

                if (unit < (maxUnit / 2)) {
                    node.setLayoutY(node.getLayoutY() - acc);

                    if (acc > 4) {
                        acc--;
                    }

                }

                else if (node.getLayoutY() <= startY) {
                    node.setLayoutY(node.getLayoutY() + acc);

                    if (acc < 14) {
                        acc += 0.5;
                    }
                }

                if (unit >= maxUnit || startY <= node.getLayoutY()) {
                    stopTimer();
                }
            }
        };

        timer = new Timer();
        timer.schedule(timerTask, 0, 30);
    }

    public void stopTimer() {
        timer.cancel();
    }

}
