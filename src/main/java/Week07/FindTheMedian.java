package Week07;

import java.util.List;

public class FindTheMedian {
    private static int partition(List<Integer> arr, int lo, int hi) {
        int pivot = arr.get(lo);
        int i = lo, j = hi + 1;
        while (true) {
            while (arr.get(++i) < pivot) if (i == hi) break;
            while (arr.get(--j) > pivot) if (j == lo) break;

            if (i >= j) break;
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
        }

        int tmp2 = arr.get(lo);
        arr.set(lo, arr.get(j));
        arr.set(j, tmp2);
        return j;
    }

    public static int find(List<Integer> arr, int lo, int hi, int k) {
        // Write your code here
        int j = partition(arr, lo, hi);
        if (k == j) return arr.get(j);
        else if (k > j) return find(arr, j + 1, hi, k);
        return find(arr, lo, j - 1, k);
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        return find(arr, 0, arr.size() - 1, arr.size() / 2);
    }
}
