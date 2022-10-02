package Week08;

import java.util.*;

// https://www.hackerrank.com/challenges/find-the-running-median/problem
public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> result = new ArrayList<>();
        result.add(1.0 * a.get(0));
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        leftQueue.add(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > leftQueue.peek())
                rightQueue.add(a.get(i));
            else
                leftQueue.add(a.get(i));
            if (i % 2 == 1) {
                normalizeQueue(leftQueue, rightQueue);

                result.add(0.5 * (leftQueue.peek() + rightQueue.peek()));
            } else {
                if (leftQueue.size() > rightQueue.size())
                    result.add(1.0 * leftQueue.peek());
                else
                    result.add(1.0 * rightQueue.peek());
            }
        }
        return result;
    }

    private static void normalizeQueue(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2) {
        int n1 = pq1.size();
        int n2 = pq2.size();

        if (n1 > n2) {
            pq2.add(pq1.poll());
        } else if (n2 > n1) {
            pq1.add(pq2.poll());
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        runningMedian(new ArrayList<>(Arrays.asList(arr)));
    }
}
