package Week02;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.util.HashMap;

public class ThreeSum {
    public static void main(String[] args) {
        In in = new In("algs4-data/8KInts.txt");
        int[] a = in.readAllInts();

        long startTime = System.currentTimeMillis();
        System.out.println(threeSumTwoPointers(a));
        long endTime = System.currentTimeMillis();
        System.out.println("Two Pointers: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(threeSumBinarySearch(a));
        endTime = System.currentTimeMillis();
        System.out.println("Binary Search: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(threeSumHashTable(a));
        endTime = System.currentTimeMillis();
        System.out.println("Hash Table: " + (endTime - startTime) + "ms");
        //System.out.println(threeSumSlow(a));
    }

    private static int threeSumBinarySearch(int[] a) {
        Arrays.sort(a);
        int c = 0;
        int n = a.length - 1;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
            {
                //int thirdIndex = binarySearch(a, -(a[i] + a[j]), 0, n - 1);
                int thirdIndex = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (thirdIndex > j)
                    c++;
            }
        return c;
    }

    private static int threeSumTwoPointers(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            int target = -a[i];

            while (l < r) {
                if (a[l] + a[r] == target)
                {
                    count++;
                    l++;
                    r--;
                }
                else if (a[l] + a[r] < target)
                    l++;
                else
                    r--;
            }

        }

        return count;
    }

    private static int threeSumSlow(int[] a) {
        int c = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                for (int k = j + 1; k < a.length; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        c++;
        return c;
    }

    private static int threeSumHashTable(int[] a) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int count = 0;
        for (int i = 0; i < a.length; i++)
            set.put(a[i], i);

        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (set.getOrDefault(-(a[i] + a[j]), -1) > j)
                    count++;
        return count;
    }
}