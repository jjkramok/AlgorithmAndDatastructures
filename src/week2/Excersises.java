package week2;

import static java.lang.System.arraycopy;
import static java.lang.System.currentTimeMillis;

/**
 * Created by Tim H on 13-2-2017.
 */
public class Excersises {
    public static long fibCallsCounter = 0;
    static int[] testArray = {1, 3, 5, 7, 9, 11};

    public static void main(String args[]) {
        long time = currentTimeMillis();
        System.out.println(triangleNumber(4));
        //method
        System.out.println("running time " + String.valueOf(currentTimeMillis() - time));
        //System.out.println("Amount of fib calls: " + fibCallsCounter);
    }

    //ex2
    public static long factorial(int x) {
        int res = 1;
        for (int i = 1; i <= x; i++) {
            res = res * i;
        }
        return res;
    }

    //ex2
    public static long factorialRec(int x) {
        if (x <= 1) {
            return 1;
        }
        return factorialRec(x - 1) * x;
    }

    //ex3
    public static long fib(int x) {
        fibCallsCounter++;
        if (x <= 1)
            return 1;
        return fib(x-1) + fib(x-2);
    }

    //ex4
    public static long skipSum(int x) {
        if (x <= 0) {
            return 0;
        }
        return x + skipSum(x-2);
    }

    //ex5
    public static long sumOfArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] newArray = new int[array.length - 1];
        arraycopy(array, 0, newArray, 0, array.length - 1);
        return array[array.length - 1] + sumOfArray(newArray);
    }

    //ex6
    public static long triangleNumber(int x) {
        if (x == 1) {
            return 1;
        }
        return x + triangleNumber(x - 1);
    }
}
