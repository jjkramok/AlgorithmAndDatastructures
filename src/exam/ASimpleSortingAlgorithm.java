package exam;

import java.util.Random;

/**
 * Created by Tim H on 29/3/2017.
 */
public class ASimpleSortingAlgorithm {

    public static double[] sort(double[] list) {
        boolean swapped = true;
        if (list.length < 2)
            return list;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i + 1] > list[i]) {
                    double temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return list;
    }

    public static double[] createUnsorted() {
        Random rng = new Random();
        double[] unsorted = new double[10];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = rng.nextInt() % 100;
        }
        return unsorted;
    }
}
