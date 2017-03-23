package week7;

/**
 * Created by Tim H on 23/3/2017.
 */
public class GnomeSort {

    public GnomeSort() {}

    //Complexity O(N) = N log N
    public static int kabouter(int[] a) {
        int swaps = 0;
        if (a.length < 2)
            return -1;
        try {
            for (int i = 1;;) {
                if (a[i] < a[i-1]) {
                    int smaller = a[i];
                    a[i] = a[i-1];
                    a[i-1] = smaller;
                    i--; //go left
                    swaps++;
                } else {
                    i++; //go right
                }
                if (i == 0) {
                    i++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException done) {
            return swaps;
        }
    }
}
