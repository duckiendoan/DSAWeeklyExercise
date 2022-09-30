package Week07;

import java.util.List;

public class QuicksortPartition {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int pivot = arr.get(0);
        int lo = 0, hi = arr.size() - 1;
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
        return arr;
    }
}