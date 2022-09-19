package Week05;

import java.util.List;
import java.util.Stack;

// https://www.hackerrank.com/challenges/equal-stacks
public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int s1 = 0, s2 = 0, s3 = 0;
        int i1 = 0, i2 = 0, i3 = 0;

        for (Integer integer : h1) s1 += integer;
        for (Integer integer : h2) s2 += integer;
        for (Integer integer : h3) s3 += integer;
        int maxHeight = Math.max(s1, Math.max(s2, s3));
        while (s1 != s2 || s2 != s3) {
            if (s1 == maxHeight) {
                s1 -= h1.get(i1);
                i1++;
            } else if (s2 == maxHeight) {
                s2 -= h2.get(i2);
                i2++;
            } else if (s3 == maxHeight) {
                s3 -= h3.get(i3);
                i3++;
            }
            maxHeight = Math.max(s1, Math.max(s2, s3));
        }
        return s1;
    }
}
