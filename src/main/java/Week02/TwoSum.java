package Week02;
import edu.princeton.cs.algs4.*;

public class TwoSum {
    public static void main(String[] args) {
        In in = new In("algs4-data/4KInts.txt");
        int[] a = in.readAllInts();

        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] + a[j] == 0)
                    System.out.println(a[i] + " " + a[j]);
    }
}
