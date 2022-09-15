package Week03;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class ThreeSumFast {
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

    public static void main(String[] args) {
        In in = new In("algs4-data/32KInts.txt");
        int[] a = in.readAllInts();
        System.out.println(threeSumTwoPointers(a));
    }
}
