package binarysearch;

 /**
 * @Author Karol Meksuła
 * 14-03-2018
 * */

public class BinarySearch {
    public static int binarySearchForInteger(int valueNumber, int... values) {
        int center = (values.length / 2);

        System.out.println("Szukam: " + valueNumber);

        while (center >= 0 && center < values.length) {
            System.out.println("Wartość środkowa: " + center);

            if (valueNumber == values[center]) {
                System.out.println("***Szukana wartość znajduje się w indexie = " + center);
                System.out.println(values[center] + " == " + valueNumber);
                return center;
            }
            if (valueNumber > values[center]) {
                center++;
                System.out.println("Szukana wartość jest większa niż wartość środkowa. ");
            } else {
                center--;
                System.out.println("Szukana wartość jest mniejsza niż środkowa wartość.");
            }

        }

        return -1;
    }

}
