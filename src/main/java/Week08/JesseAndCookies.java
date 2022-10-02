package Week08;

import java.util.List;
import java.util.PriorityQueue;

// https://www.hackerrank.com/challenges/jesse-and-cookies/problem
public class JesseAndCookies {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer a: A)
            pq.add(a);
        int n = 0;
        while (pq.peek() < k) {
            int cookie1 = pq.poll();
            if (pq.isEmpty() && cookie1 < k)
                return -1;
            int cookie2 = pq.poll();

            int newCookie = cookie1 + 2 * cookie2;
            pq.add(newCookie);
            n++;
        }
        return n;
    }
}
