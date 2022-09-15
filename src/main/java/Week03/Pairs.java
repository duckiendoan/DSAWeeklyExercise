package Week03;

import java.util.Collections;
import java.util.List;

// https://www.hackerrank.com/challenges/pairs
public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        // Two Sum on [-arr arr]
        Collections.sort(arr);
        int count = 0;
        int l = arr.size() - 1, r = l;
        while (l >= 0 && r >= 0) {
            int diff = arr.get(r) - arr.get(l);
            if (diff == k)
            {
                count++;
                l--;
                r--;
            }
            else if (diff < k) {
                l--;
            } else  {
                r--;
            }
        }
        return count;
    }
}
