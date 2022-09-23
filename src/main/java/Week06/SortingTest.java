package Week06;

import edu.princeton.cs.algs4.*;

public class SortingTest {
    private static final String leftAlignFormat = "| %-15s | %-11s | %-11s | %-11s | %-19s | %-12s |%n";
    interface SortingAlgo {
        void sort(Comparable[] a);
    }

    interface DataGenerator {
        Comparable[] generate(int n);
    }

    public static void main(String[] args) {
        System.out.format("+-----------------+-------------+-------------+-------------+---------------------+--------------+%n");
        System.out.format("| Algorithm       | Test data   | Random data | Sorted data | Reverse-sorted data | Uniform data |%n");
        System.out.format("+-----------------+-------------+-------------+-------------+---------------------+--------------+%n");
        addReportFor(Selection::sort, "SelectionSort");
        addReportFor(Insertion::sort, "InsertionSort");
        addReportFor(Merge::sort, "MergeSort");
        addReportFor(Quick::sort, "QuickSort");
        addReportFor(Shell::sort, "ShellSort");
    }

    private static void addReportFor(SortingAlgo algo, String algoName) {
        long time1 = measureSortingAlgorithm(algo,
                TestDataGenerator::KInts, 32, 3);
        long time2 = measureSortingAlgorithm(algo,
                TestDataGenerator::randomData, 32000, 5);
        long time3 = measureSortingAlgorithm(algo,
                TestDataGenerator::sortedData, 32000, 3);
        long time4 = measureSortingAlgorithm(algo,
                TestDataGenerator::reverseSortedData, 32000, 3);
        long time5 = measureSortingAlgorithm(algo,
                TestDataGenerator::uniformData,32000, 1);
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
