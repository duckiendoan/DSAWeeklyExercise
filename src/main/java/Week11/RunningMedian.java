package Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/find-the-running-median/problem
public class RunningMedian {
    static class Value implements Comparable<Value> {
        double val;
        double index;

        public Value(double v, double i) {
            val = v;
            index = i;
        }

        @Override
        public int compareTo(Value o) {
            if (val == o.val) return Double.compare(index, o.index);
            return Double.compare(val, o.val);
        }
    }
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> res = new ArrayList<>();
        TreeSet<Value> tree = new TreeSet<>();
        res.add(1.0 * a.get(0));
        tree.add(new Value(a.get(0), 0));

        Value prevMedian = new Value(a.get(0), 0);
        for (int i = 1; i < a.size(); i++) {
            tree.add(new Value(a.get(i), i));
            // Odd number of elements in previous array
            double newMedian;
            double newMedianIndex;
            Value higher = tree.higher(prevMedian);
            Value lower = tree.lower(prevMedian);

            if (i % 2 == 1) {
                if (a.get(i) >= prevMedian.val) {
                    newMedian = 0.5 * (prevMedian.val + higher.val);
                    newMedianIndex = 0.5 * (prevMedian.index + higher.index);
                } else {
                    newMedian = 0.5 * (prevMedian.val + lower.val);
                    newMedianIndex = 0.5 * (prevMedian.index + lower.index);
                }

            } else {
                if (a.get(i) >= prevMedian.val) {
                    newMedian = higher.val;
                    newMedianIndex = higher.index;
                } else {
                    newMedian = lower.val;
                    newMedianIndex = lower.index;
                }
            }
            res.add(newMedian);
            prevMedian = new Value(newMedian, newMedianIndex);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = runningMedian(a);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
    }
}
