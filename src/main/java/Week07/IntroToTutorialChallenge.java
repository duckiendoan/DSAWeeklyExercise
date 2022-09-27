package Week07;

import java.util.List;

public class IntroToTutorialChallenge {
    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        int lo = 0, hi = arr.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) == V) return mid;
            else if (arr.get(mid) < V) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
