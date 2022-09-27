package Week07;

import java.util.ArrayList;
import java.util.List;

public class CountingSort01 {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] freq = new int[100];
        List<Integer> res = new ArrayList<>();
        for (Integer a: arr)
            freq[a]++;
        for (int a: freq)
            res.add(a);
        return res;
    }
}
