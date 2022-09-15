package Week03;

import java.util.List;

// https://www.hackerrank.com/challenges/new-year-chaos
public class NewYearChaos {
    private static void swap(List<Integer> q, int i, int j) {
        int val = q.get(i);
        q.set(i, q.get(j));
        q.set(j, val);
    }
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        // Suppose that misplaced people need to bribe those who bribed them again
        int bribeTotal = 0;
        int bribes = 0;
        do {
            bribes = 0;
            for (int i = 0; i < q.size(); i++) {
                if (q.get(i) > i + 3) {
                    System.out.println("Too chaotic");
                    return;
                }

                if (q.get(i) < i + 1) {
                    int j = i;
                    while (q.get(j) != j + 1) {
                        swap(q, j, j - 1);
                        j--;
                        bribes++;
                    }
                }
            }
            bribeTotal += bribes;
        } while (bribes > 0);

        System.out.println(bribeTotal);
    }
}
