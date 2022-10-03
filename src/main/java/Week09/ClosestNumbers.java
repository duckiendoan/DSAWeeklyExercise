package Week09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumbers {
    public static void mergeSort(List<Integer> arr, int[] aux, int i, int j) {
        if (i >= j) return;
        int mid = i + (j - i) / 2;
        mergeSort(arr, aux, i, mid);
        mergeSort(arr, aux, mid + 1, j);
        merge(arr, aux, i, mid, j);
    }

    private static void merge(List<Integer> arr, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++)
            aux[i] = arr.get(i);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr.set(k, aux[j++]);
            else if (j > hi) arr.set(k, aux[i++]);
            else if (aux[i] <= aux[j]) arr.set(k, aux[i++]);
            else arr.set(k, aux[j++]);
        }
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        int[] aux = new int[arr.size()];
        mergeSort(arr, aux, 0, arr.size() - 1);

        int midDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++)
            if (arr.get(i) - arr.get(i - 1) < midDiff)
                midDiff = arr.get(i) - arr.get(i - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) == midDiff) {
                res.add(arr.get(i-1));
                res.add(arr.get(i));
            }
        }
        return res;
    }
}
