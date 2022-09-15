package Week02;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import Week03.BinarySearch;

public class TwoSum {
    public static void main(String[] args) {
        In in = new In("algs4-data/32KInts.txt");
        int[] a = in.readAllInts();
        Arrays.sort(a);

        long startTime = System.currentTimeMillis();
        System.out.println(twoSumTwoPointers(a));
        long endTime = System.currentTimeMillis();
        System.out.println("Two Pointers: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(twoSumBinarySearch(a));
        endTime = System.currentTimeMillis();
        System.out.println("Binary Search: " + (endTime - startTime) + "ms");
    }

    public static int twoSumSlow(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] + a[j] == 0)
                    count++;
        return count;
    }

    public static int twoSumBinarySearch(int[] a) {
        //Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int index = BinarySearch.binarySearch(a, -a[i], 0, a.length - 1);
            // int index = Arrays.binarySearch(a, -a[i]);
            if (index > i)
                count++;
        }
        return count;
    }

    public static int twoSumTwoPointers(int[] a) {
        // Arrays.sort(a);
        int l = 0, r = a.length - 1;
        int count = 0;
        while (l <= r) {
            if (a[l] + a[r] == 0) {
                count++;
                l++;
                r--;
            } else if (a[l] + a[r] < 0) {
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
