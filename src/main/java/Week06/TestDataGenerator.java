package Week06;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class TestDataGenerator {
    public static Integer[] KInts(int k) {
        In in = new In("algs4-data/"+ k + "KInts.txt");
        return Arrays.stream(in.readAllInts()).boxed().toArray(Integer[]::new);
    }

    public static Double[] randomData(int n) {
        Double[] data = new Double[n];
        for (int i = 0; i < n; i++)
            data[i] = StdRandom.uniformDouble();
        return data;
    }

    public static Integer[] sortedData(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++)
            data[i] = i;
        return data;
    }

    public static Integer[] reverseSortedData(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++)
            data[n - i - 1] = i;
        return data;
    }

    public static Double[] uniformData(int n) {
        Double[] data = new Double[n];
        double k = StdRandom.uniformDouble();
        for (int i = 0; i < n; i++)
            data[i] = k;
        return data;
    }
}
