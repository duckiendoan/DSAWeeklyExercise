package Week06;

public class SortingAlgorithms {
    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < a.length; j++)
                if (a[j].compareTo(a[minIndex]) < 0)
                    minIndex = j;
            exch(a, minIndex, i);
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j].compareTo(a[j - 1]) < 0) {
                exch(a, j, j - 1);
                j--;
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSortRecursive(T[] a) {
        insertionSortRecursive(a, a.length - 1);
    }

    private static <T extends Comparable<T>> void insertionSortRecursive(T[] a, int i) {
        if (i > 0) {
            // Sort array a from 0 to i - 1
            insertionSortRecursive(a, i - 1);
            // Insert element a[i] to the sorted list
            insertSorted(a, i);
        }
    }

    private static <T extends Comparable<T>> void insertSorted(T[] a, int i) {
        if (i > 0 && a[i].compareTo(a[i - 1]) < 0) {
            // Exchange i and i - 1
            exch(a, i ,i - 1);
            // Insert element into array
            insertSorted(a, i - 1);
        }
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++)
            if(a[i].compareTo(a[i-1]) < 0)
                return false;
        return true;
    }

    private static <T extends Comparable<T>> void exch(T[] a, int i, int j)
    {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
