package Week03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.hackerrank.com/challenges/closest-numbers
public class ClosestNumbers {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        List<Integer> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++)
            minDiff = Math.min(minDiff, arr.get(i + 1) - arr.get(i));
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) == minDiff) {
                result.add(arr.get(i));
                result.add(arr.get(i+1));
            }
        }
        return result;
    }
}
