package com.meksula;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class LearnTimer {
    private LocalTime start;
    private LocalTime stop;
    private long seconds = 0;
    private long minutes;
    private Timer timer;

    private boolean run = true;

    public void prompt() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();

        if (command.equals("start")) {
            this.start();
        }

        if (command.equals("log")) {
            this.log();
        }

        if (command.equals("pause") || command.equals("p")) {
            this.pause();
            run = false;
        }

        if (command.equals("stop")) {
            this.stop();
            run = false;
        }

        if (command.equals("exit") || command.equals("x")) {
            System.out.println("Bye!");
            System.exit(0);
        }

    }

    private void start() {
        System.out.println("Timer is counting...");
        this.start = LocalTime.now();
        timerWork();
        prompt();
    }

    private void pause() {
        if (timer != null) {
            System.out.println("Pause...");
            timer.cancel();
        }

        prompt();
    }

    private void stop() {
        this.stop = LocalTime.now();
        System.out.println("Timer shutdown");
        log();
        prompt();
    }

    private void timerWork() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                seconds++;
            }
        };

        timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }

    private void log() {
        LocalTime timeOfDay = LocalTime.ofSecondOfDay(seconds);
        String time = timeOfDay.toString();
        System.out.println("Started at: " + start);
        System.out.println("Learning time: " + time);

        prompt();
    }

}
