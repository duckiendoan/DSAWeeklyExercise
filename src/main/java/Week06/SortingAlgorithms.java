package Week06;

import edu.princeton.cs.algs4.StdRandom;

public class SortingAlgorithms {
    static class Quick {
        public static void sort(Comparable[] a) {
            StdRandom.shuffle(a);
            sort(a, 0, a.length - 1);
            assert isSorted(a);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (lo >= hi) return;
            int j = partition(a, lo, hi);
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
            assert isSorted(a, lo, hi);
        }

        private static int partition(Comparable[] a, int lo, int hi) {
            int i = lo, j = hi + 1;
            while (true)
            {
                while (less(a[++i], a[lo]))
                    if (i == hi) break;
                while (less(a[lo], a[--j]))
                    if (j == lo) break;

                if (i >= j) break;
                exch(a, i, j);
            }
            exch(a, lo, j);
            return j;
        }
    }
    static class Merge {
        public static void sort(Comparable[] a) {
            Comparable[] aux = new Comparable[a.length];
            sort(a, aux, 0, a.length - 1);
        }
        private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
            if (lo >= hi) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }
        private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
            for (int i = lo; i <= hi; i++)
                aux[i] = a[i];
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (aux[i].compareTo(aux[j]) <= 0) a[k] = aux[i++];
                else a[k] = aux[j++];
            }
        }
    }

    static class Selection {
        public static <T extends Comparable<T>> void sort(T[] a) {
            for (int i = 0; i < a.length - 1; i++) {
                int minIndex = i;
                for (int j = i; j < a.length; j++)
                    if (a[j].compareTo(a[minIndex]) < 0)
                        minIndex = j;
                exch(a, minIndex, i);
            }
        }
    }

    static class Insertion {
        public static <T extends Comparable<T>> void sort(T[] a) {
            for (int i = 1; i < a.length; i++) {
                int j = i;
                while (j > 0 && a[j].compareTo(a[j - 1]) < 0) {
                    exch(a, j, j - 1);
                    j--;
                }
            }
        }

        public static <T extends Comparable<T>> void sortRecursive(T[] a) {
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
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++)
            if(a[i].compareTo(a[i-1]) < 0)
                return false;
        return true;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (a[i].compareTo(a[i-1]) < 0)
                return false;
        return true;
    }

    private static <T extends Comparable<T>> void exch(T[] a, int i, int j)
    {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
