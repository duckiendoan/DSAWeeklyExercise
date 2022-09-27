package Week06;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class SortingTest {
    // Colors from https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static final String leftAlignFormat = "| %-15s | %-11s | %-11s | %-11s | %-19s | %-12s |%n";
    interface SortingAlgo {
        void sort(Comparable[] a);
    }

    interface DataGenerator {
        Comparable[] generate(int n);
    }

    public static void main(String[] args) {
        System.out.format(ANSI_BLUE + "+-----------------+-------------+-------------+-------------+---------------------+--------------+%n");
        System.out.format("| Algorithm       | algs4-data  | Random data | Sorted data | Reverse-sorted data | Uniform data |%n");
        System.out.format("+-----------------+-------------+-------------+-------------+---------------------+--------------+%n" + ANSI_RESET);
        addReportFor(Selection::sort, "SelectionSort");
        addReportFor(Insertion::sort, "InsertionSort");
        addReportFor(Merge::sort, "MergeSort");
        addReportFor(Quick::sort, "QuickSort");
    }

    private static void addReportFor(SortingAlgo algo, String algoName) {
        long time1 = measureSortingAlgorithm(algo,
                TestDataGenerator::KInts, 16, 3);
        long time2 = measureSortingAlgorithm(algo,
                TestDataGenerator::randomData, 16000, 5);
        long time3 = measureSortingAlgorithm(algo,
                TestDataGenerator::sortedData, 16000, 3);
        long time4 = measureSortingAlgorithm(algo,
                TestDataGenerator::reverseSortedData, 16000, 3);
        long time5 = measureSortingAlgorithm(algo,
                TestDataGenerator::uniformData,16000, 1);
        System.out.format(leftAlignFormat, algoName, time1 + "ms", time2 + "ms", time3 + "ms", time4 + "ms", time5 + "ms");
        System.out.format("+-----------------+-------------+-------------+-------------+---------------------+--------------+%n");
    }
    private static long measureSortingAlgorithm(SortingAlgo algo, Comparable[] data) {
        long start = System.currentTimeMillis();
        algo.sort(data);
        long end = System.currentTimeMillis();  // thời gian chạy bằng end - start
        return end - start;
    }

    private static long measureSortingAlgorithm(SortingAlgo algo, DataGenerator gen, int n, int k) {
        long totalTime = 0;
        for (int i = 0; i < k; i++) {
            Comparable[] data = gen.generate(n);
            totalTime += measureSortingAlgorithm(algo, data);
        }
        return totalTime / k;
    }
}
