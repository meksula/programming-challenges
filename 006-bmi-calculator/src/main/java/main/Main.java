package main;

import domain.BmiCalculator;

import java.util.Locale;
import java.util.Scanner;

/**
 * @Author Karol Meksuła
 * 16-03-2018
 * */

public class Main {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Welcome in BMI calculator.");
        System.out.print("Insert your weight:");
        double weight = scanner.nextDouble();
        System.out.println("Now, insert your height [with dot after meter, like: '1.83']");
        double height = scanner.nextDouble();

        String bmi = BmiCalculator.computeBmi(height, weight);
        System.out.println("Your BMI: " + bmi);
    }
}
