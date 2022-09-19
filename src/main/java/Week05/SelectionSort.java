package Week05;

import edu.princeton.cs.algs4.*;

public class SelectionSort {
    public static void main(String[] args) {
        int N = 100;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniformInt(N);
        selectionSort(a);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            swap(a, i, findMinIndex(a, i));
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int findMinIndex(int[] a, int start) {
        int min = a[start];
        int minIndex = start;
        for (int i = start + 1; i < a.length; i++) {
            if (a[i] <= min) {
                min = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
