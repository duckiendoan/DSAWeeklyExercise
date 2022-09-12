package Week02;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ThreeSum {
    private static int binarySearch(int[] a, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == target)
                return mid;
            else if (a[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        In in = new In("algs4-data/8KInts.txt");
        int[] a = in.readAllInts();

        System.out.println(threeSumTwoPointer(a));
        System.out.println(threeSumBinarySearch(a));
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

    private static int threeSumTwoPointer(int[] a) {
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
}
